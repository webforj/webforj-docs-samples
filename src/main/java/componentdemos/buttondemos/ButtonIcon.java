package componentdemos.buttondemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;
import com.webforj.component.icons.TablerIcon;
import com.webforj.component.icons.Icon;

/**
 * Demo application to display icon addition to buttons.
 */

@InlineStyleSheet(/* css */"""
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

  Icon notificationsIcon;
  Icon settingsIcon;
  Icon searchIcon;
  Icon homeIcon;

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("window");
    window.setWidth("100%");

    notificationsIcon = TablerIcon.create("bell");
    notifications = new Button("Notifications");
    notifications.setSuffixComponent(notificationsIcon);

    settingsIcon = TablerIcon.create("settings");
    settings = new Button("Settings");
    settings.setIcon(settingsIcon);

    searchIcon = TablerIcon.create("search");
    search = new Button("Search");
    search.setPrefixComponent(searchIcon);

    homeIcon = TablerIcon.create("home");
    home = new Button(homeIcon);
    home.setTheme(ButtonTheme.PRIMARY);

    window.add(notifications, settings, search, home);
  }
}
