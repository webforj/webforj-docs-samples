package componentdemos.login;

import com.webforj.App;
import com.webforj.component.login.Login;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class LoginBasic extends App {

  @Override
  public void run() throws WebforjException {
    Login login = new Login();
    login.open();

    Frame frame = new Frame();
    frame.add(login);
  }
}
