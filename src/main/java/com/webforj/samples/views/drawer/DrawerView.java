package com.webforj.samples.views.drawer;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.drawer.Drawer;
import com.webforj.component.field.TextField;
import com.webforj.component.html.elements.Div;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.optioninput.CheckBox;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@InlineStyleSheet("context://css/drawer/drawer.css")
@Route
@FrameTitle("Task Manager Drawer")
public class DrawerView extends Composite<FlexLayout> {

  FlexLayout layout = getBoundComponent();
  Drawer drawer = new Drawer();
  List<CheckBox> taskList = new ArrayList<>();
  FlexLayout tasks = new FlexLayout();

  public DrawerView() {
    drawer.setLabel("Task Manager");
    drawer.open();

    tasks.setDirection(FlexDirection.COLUMN).setSpacing("var(--dwc-space-s");

    addTask("Finish project documentation");
    addTask("Call John about the meeting");
    addTask("Prepare slides for tomorrow");

    Div taskContainer = new Div();
    taskContainer.setStyle("overflow-y", "auto")
      .setStyle("max-height", "60vh")
      .add(tasks);
    
    TextField newTaskField = new TextField("New Task", "");

    Button addTaskButton = new Button("Add Task", ButtonTheme.PRIMARY);
    addTaskButton.onClick(e -> {
      String taskText = newTaskField.getValue();
      if (taskText != null && !taskText.trim().isEmpty()) {
        addTask(taskText);
        newTaskField.setValue("");
      }
    });

    Button clearTasksButton = new Button("Clear Completed", ButtonTheme.DANGER);
    clearTasksButton.onClick(e -> clearCompletedTasks());

    FlexLayout footerContainer = new FlexLayout()
      .setDirection(FlexDirection.COLUMN)
      .setSpacing("var(--dwc-space-s");
    footerContainer.add(newTaskField, addTaskButton, clearTasksButton);

    FlexLayout drawerContent = new FlexLayout();
    drawerContent.setDirection(FlexDirection.COLUMN)
      .setJustifyContent(FlexJustifyContent.BETWEEN)
      .setHeight("100%")
      .add(taskContainer, footerContainer);

    drawer.add(drawerContent);

    Button openDrawerButton = new Button("Open Task Manager");
    openDrawerButton.onClick(e -> drawer.open());

    layout.setMargin("var(--dwc-space-l");
    layout.add(openDrawerButton, drawer);
  }

  private void addTask(String taskText) {
    CheckBox task = new CheckBox(taskText);

    taskList.add(task);
    tasks.add(task);
    
    task.onValueChange(event -> {
      if (task.isChecked()) {
          task.addClassName("task-completed");
      } else {
          task.removeClassName("task-completed");
      }
  });
}

  private void clearCompletedTasks() {
    Iterator<CheckBox> iterator = taskList.iterator();
    while (iterator.hasNext()) {
      CheckBox task = iterator.next();
      if (task.isChecked()) {
        iterator.remove();
        tasks.remove(task);
      }
    }
  }
}