package componentdemos.buttondemos;

import org.dwcj.App;
import org.dwcj.Environment;
import org.dwcj.Request;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.bridge.IDwcjBBjBridge;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.ButtonTheme;
import org.dwcj.component.field.TextField;
import org.dwcj.component.field.TextField.Type;
import org.dwcj.component.layout.flexlayout.FlexLayout;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;


/**
 * Simple demo application to display button functionality.
 */
@InlineStyleSheet("context://css/buttonstyles/demo_styles.css")
public class ButtonDemo extends App {

  Button clear;
  Button submit;
  TextField firstName;
  TextField lastName;
  TextField email;

  @Override
  public void run() throws DwcjException {

    Frame window = new Frame();
    window.addClassName("window");

    clear = new Button("Clear", e -> {
      firstName.setText("");
      lastName.setText("");
      email.setText("");
    });
    clear.setTheme(ButtonTheme.DEFAULT);

    submit = new Button("Submit", e -> {
      App.msgbox("Welcome to the application " + firstName.getText() + " " + lastName.getText() + "!");
    });
    submit.setTheme(ButtonTheme.PRIMARY);

    firstName = new TextField(Type.TEXT, "First Name", "Jason");
    lastName = new TextField(Type.TEXT, "Last Name", "Turner");
    email = new TextField(Type.EMAIL, "E-mail:", "turner.jason@email.com");

    FlexLayout firstRow = FlexLayout.create(firstName, lastName)
        .justify().center()
        .wrap()
        .build()
        .setSpacing("20px")
        .addClassName("row");

    FlexLayout secondRow = FlexLayout.create(email)
        .justify().center()
        .wrap()
        .build()
        .setSpacing("20px")
        .addClassName("row");

    FlexLayout thirdRow = FlexLayout.create(submit, clear)
        .justify().end()
        .wrap()
        .build()
        .setSpacing("20px")
        .addClassName("row");

    window.add(firstRow, secondRow, thirdRow);

    App.consoleLog(Request.getQueryParam("theme"));
    App.setTheme(Request.getQueryParam("theme"));
  }
}
