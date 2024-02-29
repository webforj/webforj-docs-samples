package demos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.Composite;
import org.dwcj.component.Expanse;
import org.dwcj.component.event.KeypressEvent;
import org.dwcj.component.field.TextField;
import org.dwcj.component.html.elements.Div;
import org.dwcj.component.html.elements.H1;
import org.dwcj.component.layout.flexlayout.FlexAlignment;
import org.dwcj.component.layout.flexlayout.FlexLayout;
import org.dwcj.component.optioninput.RadioButton;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/compositestyles/styles.css")
public class CompositeDemo extends App {

  TextField text = new TextField();
  FlexLayout todoDisplay;
  H1 title = new H1("Todos");

  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("frame");

    text.setExpanse(Expanse.XLARGE);
    todoDisplay = FlexLayout.create(text)
    .vertical()
    .build()
    .setSpacing("5px")
    .addClassName("todo--display");
    window.add(title, todoDisplay);

    text.setPlaceholder("Add Todo item. Press Enter to save.")
        .onKeypress(e -> {
          if (e.getKeyCode().equals(KeypressEvent.Key.ENTER) && !text.getText().isEmpty()) {
            todoDisplay.add(new TodoItem(text.getText()));
            text.setText("");
          }
        });

    todoDisplay.add(new TodoItem("Groceries"),
        new TodoItem("Water Plants"),
        new TodoItem("Exercise"));
  }

  public static class TodoItem extends Composite<FlexLayout> {

    RadioButton radioButton = RadioButton.Switch();
    Div text = new Div();

    TodoItem(String todoText) {
      this.text.setText(todoText);
      getBoundComponent().setSpacing("3px")
          .setAlignment(FlexAlignment.CENTER)
          .addClassName("item__todo--display")
          .add(radioButton, text);

      radioButton.onToggle(e -> {
        if (e.isToggled()) {
          consoleLog("TEST");
          text.setStyle("text-decoration", "line-through");
        } else {
          text.setStyle("text-decoration", "unset");
        }
      });
      radioButton.onCheck( e -> {
        consoleLog("CHECKED");
      });
    }
  }
}