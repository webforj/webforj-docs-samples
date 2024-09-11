package componentdemos.columnslayoutdemos;

import com.webforj.App;
import com.webforj.component.field.PasswordField;
import com.webforj.component.field.TextField;
import com.webforj.component.layout.columnslayout.ColumnsLayout;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

import java.util.List;

public class ColumnsLayoutSpanColumn extends App {
  TextField firstName = new TextField("First Name");
  TextField lastName = new TextField("Last Name");
  TextField email = new TextField("Email");
  PasswordField password = new PasswordField("Password");
  PasswordField confirmPassword = new PasswordField("Confirm Password");
  /**
   * The layout will position the components in 3 columns by default.
   * on medium screens, it will span 2 the email field 2 columns.
   */
  ColumnsLayout columnsLayout = new ColumnsLayout(
      List.of(
        new ColumnsLayout.Breakpoint("default", 0 , 1),
        new ColumnsLayout.Breakpoint("small", "20em", 1),
        new ColumnsLayout.Breakpoint("medium", "40em", 2),
        new ColumnsLayout.Breakpoint("large", "60em", 3)
      ),
      firstName, lastName, email, password, confirmPassword
  );

  @Override
  public void run() throws WebforjException {
    columnsLayout.setSpan(email, "medium", 2);
    columnsLayout.setColumn(confirmPassword, "medium", 1);
    
    Frame frame = new Frame();
    frame.setMaxWidth("60em");
    frame.setStyle("margin", "20px auto");
    frame.add(columnsLayout);
  }
}