package com.webforj.samples.views.icon;

import com.webforj.component.icons.Icon;
import com.webforj.component.icons.TablerIcon;

import com.webforj.App;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import com.webforj.component.tabbedpane.TabbedPane;
import com.webforj.component.tabbedpane.Tab;
import com.webforj.component.Composite;
import com.webforj.component.Theme;
import com.webforj.component.html.elements.Div;
import com.webforj.component.tabbedpane.TabbedPane.Alignment;

@Route
@FrameTitle("Icon Menu")
public class IconMenuView extends Composite<Div> {

  public IconMenuView() {

    Icon dashboardIcon = TablerIcon.create("dashboard");
    Icon ordersIcon = TablerIcon.create("shopping-cart");
    Icon customersIcon = TablerIcon.create("users");
    Icon productsIcon = TablerIcon.create("box");
    Icon documentsIcon = TablerIcon.create("files");

    TabbedPane pane = new TabbedPane();
    pane.setAlignment(TabbedPane.Alignment.CENTER);

    Tab dashboard = new Tab("Dashboard", dashboardIcon);
    Tab orders = new Tab("Orders", ordersIcon);
    Tab customers = new Tab("Customers", customersIcon);
    Tab products = new Tab("Products", productsIcon);
    Tab documents = new Tab("Documents", documentsIcon);

    pane.addTab(dashboard);
    pane.addTab(orders);
    pane.addTab(customers);
    pane.addTab(products);
    pane.addTab(documents);

    pane.setStyle("margin", "20px");

    getBoundComponent().add(pane);
  }
}