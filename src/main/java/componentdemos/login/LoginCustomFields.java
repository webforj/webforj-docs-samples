package componentdemos.login;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.button.Button;
import com.webforj.component.field.TextField;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.login.Login;
import com.webforj.component.login.LoginI18n;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet(
  id = "login-custom-fields",
  value = "context://css/login/LoginCustomFields/style.css"
)
public class LoginCustomFields extends App {
  TextField customerId = new TextField("Customer ID");

  @Override
  public void run() throws WebforjException {
    customerId.setRequired(true);

    Frame frame = new Frame();

    Login login = new Login();
    frame.add(login);
    login.addClassName("login-form");
    login.addToBeforeForm(
        new Paragraph("Please enter your customer ID, email address and password to enter the customer portal."));
    login.addToBeforeForm(customerId);

    LoginI18n i18n = new LoginI18n();
    i18n.getError().setTitle("Incorrect Customer ID, username or password");
    i18n.getError().setMessage("""
        <ul part="list">
          <li>Customer : Tesla</li>
          <li>Username : admin</li>
          <li>Password : admin</li>
        </ul>
        """);
    login.setI18n(i18n);
    login.open();

    login.onSubmit(ev -> {
      String id = customerId.getValue();
      String username = ev.getUsername();
      String password = ev.getPassword();

      if (username.equals("admin") &&
          password.equals("admin") &&
          id.equals("Tesla")) {
        login.close();
        frame.add(new Button("Logout", e -> App.getPage().reload()));
      } else {
        login.setError(true);
        login.setEnabled(true);
      }
    });
  }
}
