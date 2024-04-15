package componentdemos.buttondemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.TextField;
import com.webforj.component.field.TextField.Type;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

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
  public void run() throws WebforjException {

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
        .addClassName("row", "buttons");

    window.add(firstRow, secondRow, thirdRow);
  }
}