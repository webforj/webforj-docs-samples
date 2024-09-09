package componentdemos.toastdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Theme;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.PasswordField;
import com.webforj.component.field.TextField;
import com.webforj.component.field.TextField.Type;
import com.webforj.component.toast.Toast;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/toaststyles/toastshowdemo_styles.css")
public class ToastShowDemo extends App {

  @Override
  public void run() throws WebforjException {
    Frame frame = new Frame();
    frame.addClassName("window");

    TextField nameField = new TextField("Enter your name:");
    nameField.addClassName("row");

    TextField emailField = new TextField("Enter your email:");
    emailField.setType(Type.EMAIL);
    emailField.addClassName("row");

    PasswordField passwordField = new PasswordField("Enter your password:");
    passwordField.addClassName("row");

    Button submitButton = new Button("Submit", e -> {
      String enteredName = nameField.getValue();
      String enteredEmail = emailField.getValue();
      String enteredPassword = passwordField.getValue();

      if (!enteredName.isEmpty() && !enteredEmail.isEmpty() && !enteredPassword.isEmpty()) {
        Toast.show("Form submitted! Welcome, " + enteredName + ".", Theme.SUCCESS);
      } else {
        Toast.show("Please fill out all fields before submitting.", Theme.DANGER);
      }
    }); 
    submitButton.setTheme(ButtonTheme.PRIMARY);
    submitButton.addClassName("button");

    frame.add(nameField, emailField, passwordField, submitButton);
    
  }
}