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
@InlineStyleSheet(/*css */"""
  .window {
    display: flex;
    margin: 20px;
    gap: 50px;
    width: 100%;
    flex-wrap: wrap;
  }
""")
public class ButtonIcon extends App {

  Button notifications;
  Button settings;
  Button search;
  Button home;

  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("window");

    notifications = new Button("""
      <html>
        Notifications
        <dwc-icon name='bell' slot='suffix'></dwc-icon>
      </html>
    """);

    settings = new Button("""
      <html>
        Settings
        <dwc-icon name='settings' slot='suffix'></dwc-icon>
      </html>
    """);

    search = new Button("""
      <html>
        <dwc-icon name='search'></dwc-icon>
        Search
      </html>
    """);

    home = new Button("""
      <html>
        <dwc-icon name='home'></dwc-icon>
      </html>
    """);

    home.setTheme(ButtonTheme.PRIMARY);
    window.add(notifications, settings, search, home);
  }
}
