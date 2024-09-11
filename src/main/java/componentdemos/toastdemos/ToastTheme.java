package componentdemos.toastdemos;

import com.webforj.App;
import com.webforj.component.Theme;
import com.webforj.component.button.Button;
import com.webforj.component.field.TextField;
import com.webforj.component.toast.Toast;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class ToastTheme extends App {
  int counter = 1;
  Frame frame;

  @Override
  public void run() throws WebforjException {
    frame = new Frame();
    frame.setStyle("padding", "1em");

    TextField nameField = new TextField("Name");
    Button submitButton = new Button("Submit", e -> this.greet(nameField.getText()));

    frame.add(nameField);
    frame.add(submitButton);
  }

  public void greet(String name){
    Toast toast = new Toast("Hello, " + name + "!", Theme.PRIMARY);
    if (name.isBlank()) {
      toast.setText("Error: Please enter a valid name.");
      toast.setTheme(Theme.DANGER);
    }
    toast.open();
  }
}
