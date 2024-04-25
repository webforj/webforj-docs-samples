package componentdemos.login;

import com.webforj.App;
import com.webforj.component.login.Login;
import com.webforj.component.login.LoginI18n;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class LoginCancelButton extends App {

  @Override
  public void run() throws WebforjException {
    Login login = new Login();

    LoginI18n i18n = new LoginI18n();
    i18n.setCancel("Cancel");
    login.setI18n(i18n);
    login.onCancel(ev -> {
      // Close the login dialog and do something else
    });
    login.open();

    Frame frame = new Frame();
    frame.add(login);
  }
}
