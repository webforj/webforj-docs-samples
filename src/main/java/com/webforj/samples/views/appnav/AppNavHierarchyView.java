package com.webforj.samples.views.appnav;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.icons.FeatherIcon;
import com.webforj.component.layout.appnav.AppNav;
import com.webforj.component.layout.appnav.AppNavItem;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;


@Route
@FrameTitle("Hierarchical AppNav Demo")
public class AppNavHierarchyView extends Composite<Div> {

  public AppNavHierarchyView() {
    AppNav appNav = new AppNav();
    appNav.setAutoOpen(true); 

    AppNavItem dashboardItem = new AppNavItem("Dashboard", "/dashboard");
    dashboardItem.setPrefixComponent(FeatherIcon.ACTIVITY.create());

    AppNavItem ordersItem = new AppNavItem("Orders", "/orders");
    ordersItem.setPrefixComponent(FeatherIcon.SHOPPING_CART.create());

    AppNavItem newOrdersItem = new AppNavItem("New Orders", "/orders/new");
    AppNavItem pendingOrdersItem = new AppNavItem("Pending Orders", "/orders/pending");
    AppNavItem completedOrdersItem = new AppNavItem("Completed Orders", "/orders/completed");

    ordersItem.addItem(newOrdersItem);
    ordersItem.addItem(pendingOrdersItem);
    ordersItem.addItem(completedOrdersItem);

    AppNavItem settingsItem = new AppNavItem("Settings", "/settings");
    settingsItem.setPrefixComponent(FeatherIcon.SETTINGS.create());

    AppNavItem accountSettingsItem = new AppNavItem("Account Settings", "/settings/account");
    AppNavItem preferencesItem = new AppNavItem("Preferences", "/settings/preferences");

    settingsItem.addItem(accountSettingsItem);
    settingsItem.addItem(preferencesItem);

    appNav.addItem(dashboardItem);
    appNav.addItem(ordersItem);
    appNav.addItem(settingsItem);

    getBoundComponent().add(appNav);
  }
}
