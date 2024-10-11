package com.webforj.samples.views.button;

import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.layout.flexlayout.FlexLayout;
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

  public ButtonIconView() {
    self.setSpacing("var(--dwc-space-l)").setMargin("var(--dwc-space-l)").setStyle("flex-wrap", "wrap")
        .setWidth("100%");

    notifications = new Button();
    notifications.setHtml("Notifications <dwc-icon name='bell'></dwc-icon>");

    settings = new Button();
    settings.setHtml("Settings <dwc-icon name='settings'></dwc-icon>");

    search = new Button();
    search.setHtml("<dwc-icon name='search'></dwc-icon></dwc-icon> Search");

    home = new Button("home", ButtonTheme.PRIMARY);
    home.setHtml("<dwc-icon name='home'></dwc-icon>");

    self.add(notifications, settings, search, home);
  }
}
