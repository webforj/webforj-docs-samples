package componentdemos.buttondemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.ButtonTheme;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

/**
 * Demo application to display icon addition to buttons.
 */
@InlineStyleSheet("context://css/buttonstyles/icon_styles.css")
public class ButtonIcon extends App {
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("window");

    Button notifications = new Button("""
      <html>
        Notifications
        <bbj-icon name='bell' slot='suffix'></bbj-icon>
      </html>
    """);

    Button settings = new Button("""
      <html>
        Settings
        <bbj-icon name='settings' slot='suffix'></bbj-icon>
      </html>
    """);

    Button search = new Button("""
      <html>
        <bbj-icon name='search'></bbj-icon>
        Search
      </html>
    """);

    Button home = new Button("""
      <html>
        <bbj-icon name='home'></bbj-icon>
      </html>
    """);

    home.setTheme(ButtonTheme.PRIMARY);
    window.add(notifications, settings, search, home);
  }
}
