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
    window.setWidth("100%");

    notifications = new Button();
    notifications.setHtml("Notifications <dwc-icon name='bell'></dwc-icon>");

    settings = new Button();
    settings.setHtml("Settings <dwc-icon name='settings'></dwc-icon>");

    search = new Button();
    search.setHtml("<dwc-icon name='search'></dwc-icon></dwc-icon> Search");

    home = new Button("home",ButtonTheme.PRIMARY);
    home.setHtml("<dwc-icon name='home'></dwc-icon>");

    window.add(notifications, settings, search, home);
  }
}
