package com.webforj.samples.views.drawer;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.drawer.Drawer;
import com.webforj.component.field.TextField;
import com.webforj.component.html.elements.Div;
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

  Drawer drawer = new Drawer();
  List<CheckBox> taskList = new ArrayList<>();
  Div taskContainer = new Div();

  public DrawerView() {
    getBoundComponent().addClassName("drawer-view");

    drawer.setLabel("Task Manager");
    drawer.addClassName("drawer");
    drawer.open();

    taskContainer.addClassName("task-container");

    addTask("Finish project documentation");
    addTask("Call John about the meeting");
    addTask("Prepare slides for tomorrow");

    TextField newTaskField = new TextField("New Task", "");
    newTaskField.addClassName("new-task-field");

    Button addTaskButton = new Button("Add Task", ButtonTheme.PRIMARY);
    addTaskButton.addClassName("add-task-button");
    addTaskButton.onClick(e -> {
      String taskText = newTaskField.getValue();
      if (taskText != null && !taskText.trim().isEmpty()) {
        addTask(taskText);
        newTaskField.setValue("");
      }
    });

    Button clearTasksButton = new Button("Clear Completed", ButtonTheme.DANGER);
    clearTasksButton.addClassName("clear-tasks-button");
    clearTasksButton.onClick(e -> clearCompletedTasks());

    Div footerContainer = new Div();
    footerContainer.addClassName("footer-container");
    footerContainer.add(newTaskField, addTaskButton, clearTasksButton);

    Div drawerContent = new Div();
    drawerContent.addClassName("drawer-content");
    drawerContent.add(taskContainer, footerContainer);

    drawer.add(drawerContent);

    Button openDrawerButton = new Button("Open Task Manager");
    openDrawerButton.addClassName("open-drawer-button");
    openDrawerButton.onClick(e -> drawer.open());

    getBoundComponent().add(openDrawerButton, drawer);
  }

  private void addTask(String taskText) {
    CheckBox task = new CheckBox(taskText);
    taskList.add(task);
    taskContainer.add(task);
  }

  private void clearCompletedTasks() {
    Iterator<CheckBox> iterator = taskList.iterator();
    while (iterator.hasNext()) {
      CheckBox task = iterator.next();
      if (task.isChecked()) {
        iterator.remove();
        taskContainer.remove(task);
      }
    }
  }
}