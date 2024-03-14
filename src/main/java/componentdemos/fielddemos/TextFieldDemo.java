package componentdemos.fielddemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.field.TextField;
import com.webforj.component.field.TextField.Type;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/fieldstyles/date_field_styles.css")
public class TextFieldDemo extends App {

  @Override
  public void run() throws WebforjException {

    Frame window = new Frame();
    window.addClassName("main__window");

    TextField emailField = new TextField()
        .setType(Type.EMAIL);
    TextField searchField = new TextField()
        .setType(Type.SEARCH);
    TextField telField = new TextField()
        .setType(Type.TEL);
    TextField textField = new TextField()
        .setType(Type.TEXT);
    TextField urlField = new TextField()
        .setType(Type.URL);

    window.add(emailField, searchField, telField, textField, urlField);
  }
}