package com.webforj.samples.views.appnav;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.icons.FeatherIcon;
import com.webforj.component.layout.appnav.AppNav;
import com.webforj.component.layout.appnav.AppNavItem;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route
@FrameTitle("Basic AppNav Demo")
public class AppNavBasicsView extends Composite<Div> {

  public AppNavBasicsView() {       
    AppNav appNav = new AppNav();

    AppNavItem homeItem = new AppNavItem("Home", "/appnavbasics");
    AppNavItem ordersItem = new AppNavItem("Orders", "/appnavbasics");
    AppNavItem customersItem = new AppNavItem("Customers", "/appnavbasics");
    AppNavItem settingsItem = new AppNavItem("Settings", "/appnavbasics");

    homeItem.setPrefixComponent(FeatherIcon.HOME.create());
    ordersItem.setPrefixComponent(FeatherIcon.SHOPPING_CART.create());
    customersItem.setPrefixComponent(FeatherIcon.USERS.create());
    settingsItem.setPrefixComponent(FeatherIcon.SETTINGS.create());

    appNav.addItem(homeItem);
    appNav.addItem(ordersItem);
    appNav.addItem(customersItem);
    appNav.addItem(settingsItem);
    
    getBoundComponent().add(appNav);
  }
}
