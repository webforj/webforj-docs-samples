package demos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.Composite;
import org.dwcj.component.event.KeypressEvent;
import org.dwcj.component.field.TextField;
import org.dwcj.component.html.elements.Div;
import org.dwcj.component.layout.flexlayout.FlexAlignment;
import org.dwcj.component.layout.flexlayout.FlexLayout;
import org.dwcj.component.optioninput.CheckBox;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet(/* css */"""
      .frame{
        display: flex;
        flex-direction: column;
        gap: 20px;
        margin: 20px;
      }
    """)
public class CompositeDemo extends App {

  TextField text = new TextField("Todo Item");
  FlexLayout todoDisplay;

  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("frame");

    todoDisplay = FlexLayout.create()
        .vertical()
        .build()
        .setSpacing("5px");

    window.add(text, todoDisplay);

    text.setPlaceholder("Add Todo item. Press Enter to save.")
        .setStyle("max-width", "50%")
        .onKeypress(e -> {
          if (e.getKeyCode().equals(KeypressEvent.Key.ENTER) && !text.getText().isEmpty()) {
            todoDisplay.add(new TodoItem(text.getText()));
            text.setText("");
          }
        });
  }

  public static class TodoItem extends Composite<FlexLayout> {

    CheckBox checkbox = new CheckBox();
    Div text = new Div();

    TodoItem(String todoText) {
      this.text.setText(todoText);
    }

    @Override
    protected void onDidCreate(FlexLayout container) {
      container.add(checkbox, text);
      container.setSpacing("3px")
          .setAlignment(FlexAlignment.CENTER);

      checkbox.onCheck(e -> {
        text.setStyle("text-decoration", "line-through");
      });
      checkbox.onUncheck(e -> {
        text.setStyle("text-decoration", "unset");
      });
    }
  }
}