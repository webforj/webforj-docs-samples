package control_demos.buttondemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.ButtonTheme;
import org.dwcj.component.field.TextField;
import org.dwcj.exceptions.DwcjAppInitializeException;

@InlineStyleSheet("context://css/buttonstyles/demo_styles.css")
public class ButtonDemo extends App {

  Button clear, submit;
  TextField firstName, lastName, email;

  @Override
  public void run() throws DwcjAppInitializeException {

    Frame window = new Frame();

    clear = new Button("Clear", e -> {
      firstName.setText("");
      lastName.setText("");
      email.setText("");
    }).setTheme(ButtonTheme.DANGER);

    submit = new Button("Submit", e -> {
      App.msgbox("Welcome to the Application!");
    }).setTheme(ButtonTheme.PRIMARY);

    firstName = new TextField("First Name", "");
    lastName = new TextField("Last Name", "");
    email = new TextField("E-mail:", "");

    Panel firstRow = new Panel().add(
      firstName, lastName
    ).addClassName("row--1");

    Panel secondRow = new Panel().add(
      email
    ).addClassName("row--2");

    Panel thirdRow = new Panel().add(
      clear, submit
    ).addClassName("row--3");

    window.add(firstRow, secondRow, thirdRow)
    .addClassName("window");
  }
}
