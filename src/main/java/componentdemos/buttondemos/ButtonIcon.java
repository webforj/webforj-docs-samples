package componentdemos.buttondemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

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
  public void run() throws WebforjException {
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
