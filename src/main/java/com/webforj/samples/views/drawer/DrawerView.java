package com.webforj.samples.views.drawer;

import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.drawer.Drawer;
import com.webforj.component.html.elements.Div;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.optioninput.CheckBox;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route
@FrameTitle("Drawer Demo")
public class DrawerView extends Composite<FlexLayout> {

    Drawer drawer = new Drawer();

    public DrawerView() {
        getBoundComponent().setMargin("20px");

        CheckBox emailNotifications = new CheckBox("Email Notifications");
        CheckBox smsNotifications = new CheckBox("SMS Notifications");
        CheckBox pushNotifications = new CheckBox("Push Notifications");

        Div checkBoxContainer = new Div();
        checkBoxContainer.add(emailNotifications, smsNotifications, pushNotifications);
        checkBoxContainer.setStyle("display", "flex")
          .setStyle("flex-direction", "column")
          .setStyle("gap", "10px");

        Button saveButton = new Button("Save Preferences")
            .setTheme(ButtonTheme.PRIMARY)
            .setWidth("100%");

        Div drawerContent = new Div();
        drawerContent.setStyle("display", "flex")
            .setStyle("flex-direction", "column")
            .setStyle("justify-content", "space-between")
            .setStyle("height", "100%");

        drawerContent.add(checkBoxContainer, saveButton);
        drawer.add(drawerContent);

        Button openDrawerButton = new Button("Open Preferences");
        openDrawerButton.onClick(e -> drawer.open());

        getBoundComponent().add(openDrawerButton, drawer);

        drawer.setLabel("Notification Preferences");
        drawer.open();
    }
}