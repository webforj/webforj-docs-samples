package componentdemos.login;

import com.webforj.App;
import com.webforj.component.login.Login;
import com.webforj.component.login.LoginI18n;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class LoginInternationalization extends App {

  @Override
  public void run() throws WebforjException {
    Login login = new Login();
    LoginI18n i18n = new LoginI18n();
    i18n.setTitle("Authentifizierung");
    i18n.setUsername("Benutzername");
    i18n.setPassword("Passwort");
    i18n.setRememberMe("Angemeldet bleiben");
    i18n.setSubmit("Anmelden");
    i18n.getError().setTitle("Falscher Benutzername oder falsches Passwort");
    i18n.getError().setMessage(
        "Stellen Sie sicher, dass Sie den richtigen Benutzernamen und das richtige Passwort eingegeben haben und versuchen Sie es erneut.");

    login.setI18n(i18n);
    login.setError(true);
    login.open();

    Frame frame = new Frame();
    frame.add(login);
  }
}
