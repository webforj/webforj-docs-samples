package componentdemos.fielddemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.TextField;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

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

  public SelectedTextDemo() {
    input = new TextField(TextField.Type.TEXT)
      .setValue("Try selecting 'DANGER' to change the button.")
      .setPlaceholder("Enter themes, styles or any text, then select a portion");
    confirm = new Button("Select");
    message = new Paragraph();
    message.setVisible(false);
  }

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("window");
    window.add(input, confirm, message);

    confirm.addClickListener(e -> {
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

}
