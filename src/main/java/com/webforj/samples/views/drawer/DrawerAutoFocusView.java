package com.webforj.samples.views.drawer;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.drawer.Drawer;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.H2;
import com.webforj.component.optioninput.CheckBox;
import com.webforj.component.button.Button;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet("context://css/drawer/drawerAutoFocus.css")
@Route
@FrameTitle("Drawer Auto-Focus")
public class DrawerAutoFocusView extends Composite<FlexLayout> {

  public DrawerAutoFocusView() {
    getBoundComponent().setSpacing("20px").setMargin("20px");

    Drawer drawer = new Drawer();
    drawer.addClassName("drawer");
    drawer.setAutofocus(true); 

    Button openDrawerButton = new Button("Open Preferences");
    openDrawerButton.onClick(e -> drawer.open());
    getBoundComponent().add(openDrawerButton);

    Div drawerHeader = new Div(new H2("Notification Preferences"));
    drawer.add(drawerHeader);

    CheckBox emailNotifications = new CheckBox("Email Notifications");
    CheckBox smsNotifications = new CheckBox("SMS Notifications");
    CheckBox pushNotifications = new CheckBox("Push Notifications");
        
    Div drawerContent = new Div(emailNotifications, smsNotifications, pushNotifications)
        .addClassName("drawer-content");
        
    drawer.add(drawerContent);

    getBoundComponent().add(drawer);
    
    }
}