package componentdemos.login;

import com.webforj.App;
import com.webforj.component.button.Button;
import com.webforj.component.login.Login;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class LoginSubmission extends App {

  @Override
  public void run() throws WebforjException {
    Frame frame = new Frame();

    Login login = new Login();
    frame.add(login);

    login.open();

    login.onSubmit(ev -> {
      String username = ev.getUsername();
      String password = ev.getPassword();

      if (username.equals("admin") &&
          password.equals("admin")) {
        login.close();
        frame.add(new Button("Logout", e -> App.getPage().reload()));
      } else {
        login.setError(true);
        login.setEnabled(true);
      }
    });
  }
}
