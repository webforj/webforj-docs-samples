package com.webforj.samples.views.button;

import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.icons.TablerIcon;
import com.webforj.component.icons.Icon;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

/**
 * Demo application to display icon addition to buttons.
 */
@Route
@FrameTitle("Button Icon")
public class ButtonIconView extends Composite<FlexLayout> {
  FlexLayout self = getBoundComponent();
  Button notifications;
  Button settings;
  Button search;
  Button home;
  Icon notificationsIcon;
  Icon settingsIcon;
  Icon searchIcon;
  Icon homeIcon;

  public ButtonIconView() {
    self.setSpacing("var(--dwc-space-l)").setMargin("var(--dwc-space-l)").setStyle("flex-wrap", "wrap")
        .setWidth("100%");

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

    self.add(notifications, settings, search, home);
  }
}
