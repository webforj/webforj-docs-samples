package com.webforj.samples.views.drawer;

import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.drawer.Drawer;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.optioninput.CheckBox;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route
@FrameTitle("Drawer AutoFocus")
public class DrawerAutoFocusView extends Composite<FlexLayout> {

  FlexLayout drawerLayout = getBoundComponent();
  Drawer drawer = new Drawer();

  public DrawerAutoFocusView() {
    drawerLayout.setMargin("var(--dwc-space-m)");

    drawer.setAutofocus(true);

    CheckBox emailNotifications = new CheckBox("Email Notifications");
    CheckBox smsNotifications = new CheckBox("SMS Notifications");
    CheckBox pushNotifications = new CheckBox("Push Notifications");

    FlexLayout checkBoxContainer = new FlexLayout(emailNotifications, smsNotifications, pushNotifications)
        .setDirection(FlexDirection.COLUMN)
        .setSpacing("var(--dwc-space-s)");

    Button saveButton = new Button("Save Preferences")
        .setTheme(ButtonTheme.PRIMARY)
        .setWidth("100%");

    FlexLayout drawerContent = new FlexLayout(checkBoxContainer, saveButton)
        .setDirection(FlexDirection.COLUMN)
        .setJustifyContent(FlexJustifyContent.BETWEEN)
        .setHeight("100%");

    drawer.add(drawerContent);

    Button openDrawerButton = new Button("Open Preferences");
    openDrawerButton.onClick(e -> drawer.open());

    drawerLayout.add(openDrawerButton, drawer);

    drawer.setLabel("Notification Preferences");
    drawer.open();
  }
}