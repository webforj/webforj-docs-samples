package componentdemos.fielddemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.field.PasswordField;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/fieldstyles/date_field_styles.css")
public class PasswordFieldDemo extends App {

  @Override
  public void run() throws WebforjException {

    Frame window = new Frame();
    window.addClassName("main__window");

    PasswordField passwordField = new PasswordField();
    passwordField.addClassName("date__input");
    passwordField.setLabel("Enter your Password:");
    passwordField.setPlaceholder("Password");

    window.add(passwordField);
  }
}