package componentdemos.fielddemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.field.PasswordField;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjAppInitializeException;

@InlineStyleSheet("context://css/fieldstyles/date_field_styles.css")
public class PasswordFieldDemo extends App {

  @Override
  public void run() throws DwcjAppInitializeException {

    Frame window = new Frame();
    window.addClassName("main__window");

    PasswordField passwordField = new PasswordField();
    passwordField.addClassName("date__input");
    passwordField.setLabel("Enter your Password:");
    // passwordField.setPlaceholder("Password");

    window.add(passwordField);

  }
}

