package com.webforj.samples.views.applayout;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.element.Element;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.H1;
import com.webforj.component.html.elements.H3;
import com.webforj.component.html.elements.Img;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.icons.Icon;
import com.webforj.component.icons.TablerIcon;
import com.webforj.component.layout.applayout.AppDrawerToggle;
import com.webforj.component.layout.applayout.AppLayout;
import com.webforj.component.tabbedpane.TabbedPane.Placement;
import com.webforj.component.tabbedpane.Tab;
import com.webforj.component.tabbedpane.TabbedPane;
import com.webforj.component.tabbedpane.event.TabSelectEvent;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet("context://css/applayout/applayout.css")
@Route
@FrameTitle("AppLayout Full Navbar")
public class AppLayoutFullNavbarView extends Composite<AppLayout> {

  AppLayout demo = getBoundComponent();
  Paragraph contentLabel = new Paragraph();

  Div header = new Div();
  Div drawer = new Div();

  public AppLayoutFullNavbarView() {
    demo.setDrawerHeaderVisible(true);
    demo.setDrawerFooterVisible(true);
    demo.addToDrawerTitle(new Div("Menu"));
    demo.addToDrawerHeaderActions(new Element("dwc-icon-button")
        .setAttribute("name", "pin"));
    demo.addToDrawerFooter(new Paragraph("All rights reserved"));

    // Header
    header.addClassName("layout__header").add(
        new AppDrawerToggle(),
        new H3("DWCJ Application"));
    demo.addToHeader(header);
    demo.setHeaderOffscreen(false);

    // Drawer
    demo.addToDrawer(drawer);
    drawer.addClassName("app-layout-drawer");

    // Drawer's logo container and logo
    Div drawerLogo = new Div();
    drawerLogo.addClassName("drawer__logo")
        .add(new Img("https://documentation.webforj.com/img/webforj_icon.svg"));
    drawer.add(drawerLogo);

    // Drawer's Menu
    TabbedPane drawerMenu = new TabbedPane();
    drawer.add(drawerMenu);

    // Setting drawer menu's attributes
    drawerMenu.setBodyHidden(true);
    drawerMenu.setBorderless(true);
    drawerMenu.setPlacement(Placement.LEFT);

    // Adding tabs to drawer menu
    Icon dashboardIcon = TablerIcon.create("dashboard");
    Icon ordersIcon = TablerIcon.create("shopping-cart");
    Icon customersIcon = TablerIcon.create("users");
    Icon productsIcon = TablerIcon.create("box");
    Icon documentsIcon = TablerIcon.create("files");
    Icon tasksIcon = TablerIcon.create("checklist");
    Icon analyticsIcon = TablerIcon.create("chart-dots-2");

    drawerMenu.addTab(new Tab("Dashboard", dashboardIcon));
    drawerMenu.addTab(new Tab("Orders", ordersIcon));
    drawerMenu.addTab(new Tab("Customers", customersIcon));
		drawerMenu.addTab(new Tab("Products", productsIcon));
    drawerMenu.addTab(new Tab("Documents", documentsIcon));
    drawerMenu.addTab(new Tab("Tasks", tasksIcon));
    drawerMenu.addTab(new Tab("Analytics", analyticsIcon));


    drawerMenu.onSelect(this::onTabChange);

    // Content
    demo.addToContent(new H1("Application Title"), this.contentLabel);
  }

  private void onTabChange(TabSelectEvent ev) {
    String value = ev.getTab().getText().replaceAll("<[^>]*>", "").trim();
    contentLabel.setText("Content for " + value + " goes here");
  }
}
