package componentdemos.fielddemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.field.TextField;
import org.dwcj.component.field.TextField.Type;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/fieldstyles/date_field_styles.css")
public class TextFieldDemo extends App {

  @Override
  public void run() throws DwcjException {

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