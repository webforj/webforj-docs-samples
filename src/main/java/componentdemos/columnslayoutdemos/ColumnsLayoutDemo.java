package componentdemos.columnslayoutdemos;

import com.webforj.App;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.PasswordField;
import com.webforj.component.field.TextField;
import com.webforj.component.layout.columnslayout.ColumnsLayout;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class ColumnsLayoutDemo extends App {
  TextField firstName = new TextField("First Name");
  TextField lastName = new TextField("Last Name");
  TextField email = new TextField("Email");
  PasswordField password = new PasswordField("Password");
  PasswordField confirmPassword = new PasswordField("Confirm Password");
  Button submit = new Button("Submit", ButtonTheme.PRIMARY);

  /*
   * The layout will position the components in 2 columns by default.
   */
  ColumnsLayout columnsLayout = new ColumnsLayout(firstName, lastName, email, password, confirmPassword, submit);

  @Override
  public void run() throws WebforjException {
    columnsLayout.setSpan(email, 2);
    columnsLayout.setSpan(submit, 2);
    columnsLayout.setStyle("padding", "var(--dwc-space-xl)");
    

    submit.setStyle("margin-top", "var(--dwc-space-l)");

    Frame frame = new Frame();
    frame.setMaxWidth("600px");
    frame.setStyle("margin", "0 auto");
    frame.setStyle("overflow", "auto");
    frame.setStyle("height", "100dvh");
    frame.add(columnsLayout);
  }
}