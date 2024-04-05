package componentdemos.fielddemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.NumberField;
import com.webforj.component.field.TextField;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

import java.util.Optional;

@InlineStyleSheet("""
  .window {
    display: flex;
    align-items: flex-end;
    margin: 20px;
    gap: 50px;
    width: 100%;
    flex-wrap: wrap;
  }
  """)
public class SelectedTextDemo extends App {
  private final TextField input;
  private final Button confirm;
  private final Paragraph message;
  private final NumberField start;
  private final NumberField end;

  public SelectedTextDemo() {
    input = new TextField(TextField.Type.TEXT)
      .setValue("Try selecting DANGER to change the button.")
      .setPlaceholder("Enter themes, styles or any text, then select a portion");
    confirm = new Button("Select");
    message = new Paragraph();
    message.setVisible(false);
    start = new NumberField()
      .setMin(0.0)
      .setMax((double) input.getText().length());
    end = new NumberField()
      .setMin(0.0)
      .setMax((double) input.getText().length());
  }

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("window");
    window.add(input, confirm, message);

    input.onModify(e -> {
      start.setMax((double) input.getText().length());
      end.setMax((double) input.getText().length());
    });

    confirm.addClickListener(e -> {
      int startIndex = getIndex(start);
      int endIndex = getIndex(end);
      input.setSelectionRange(startIndex, endIndex);
      String selection = input.getSelectedText();
      try {
        message.setVisible(false);
        ButtonTheme theme = ButtonTheme.valueOf(selection);
        confirm.setTheme(theme);
      } catch (IllegalArgumentException __) {
        message.setText("Selected: " + selection);
        message.setVisible(true);
      }
    });
  }

  private int getIndex(NumberField index) {
    Double value = index.getValue();
    return value == null ? 0 : value.intValue();
  }

}
