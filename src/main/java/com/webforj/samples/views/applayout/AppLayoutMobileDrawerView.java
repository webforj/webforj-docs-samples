package com.webforj.samples.views.applayout;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.element.Element;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.H1;
import com.webforj.component.html.elements.H2;
import com.webforj.component.html.elements.Img;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.html.elements.Strong;
import com.webforj.component.icons.Icon;
import com.webforj.component.icons.TablerIcon;
import com.webforj.component.layout.applayout.AppDrawerToggle;
import com.webforj.component.layout.applayout.AppLayout;
import com.webforj.component.tabbedpane.Tab;
import com.webforj.component.tabbedpane.TabbedPane;
import com.webforj.component.tabbedpane.TabbedPane.Placement;
import com.webforj.component.tabbedpane.TabbedPane.Alignment;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet("context://css/applayout/applayoutMobile.css")
@Route
@FrameTitle("AppLayout Mobile Drawer")
public class AppLayoutMobileDrawerView extends Composite<AppLayout> {

  AppLayout demo = getBoundComponent();
  Div contentLabel = new Div();
  Div header = new Div();
  Div drawer = new Div();

  public AppLayoutMobileDrawerView() {
    demo.addToDrawerHeaderActions(new Element("dwc-icon-button")
        .setAttribute("name", "pin"));
    // Header
    AppDrawerToggle toggle = new AppDrawerToggle();
    Div logo = new Div();
    logo.addClassName("dwc-logo").add(
        new Img("https://documentation.webforj.com/img/webforj_icon.svg", "logo"));
    Strong title = new Strong("DWCJ Application");

    header.add(toggle, logo, title);
    header.addClassName("drawer__dwc-toolbar");

    demo.addToHeader(header);
    demo.setHeaderReveal(true);

    // Drawer
    demo.addToDrawer(drawer);
    drawer.addClassName("app-layout-drawer");

    // Drawer's logo container and logo
    Div drawerLogo = new Div();
    drawerLogo.addClassName("drawer__logo")
        .add(new Img("https://documentation.webforj.com/img/webforj_icon.svg", "logo"));
    drawer.add(drawerLogo);

    // Drawer's Menu
    TabbedPane drawerMenu = new TabbedPane();
    drawer.add(drawerMenu);

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

    // Content
    demo.addToContent(
        new H1("Application Title"),
        this.contentLabel);
    for (int i = 0; i < 5; i++) {
      Div content = new Div().addClassName("card");
      content.add(
          new H2("What is Lorem Ipsum " + i + "?"),
          new Paragraph("Lorem Ipsum is simply dummy text of the printing and typesetting " +
              "industry. Lorem Ipsum has been the industry's standard dummy text " +
              "ever since the 1500s when an unknown printer took a galley of type " +
              "and scrambled it to make a type specimen book. It has survived not " +
              "only five centuries, but also the leap into electronic " +
              "typesetting, remaining essentially unchanged. It was popularized " +
              "in the 1960s with the release of Letraset sheets containing Lorem " +
              "Ipsum passages, and more recently with desktop publishing software " +
              "like Aldus PageMaker including versions of Lorem Ipsum."));
      demo.addToContent(content);
    }

    TabbedPane footerMenu = new TabbedPane();
    demo.addToFooter(footerMenu);
    demo.setFooterReveal(true);

    footerMenu.setBodyHidden(true);
    footerMenu.setBorderless(true);
    footerMenu.setPlacement(Placement.BOTTOM);
    footerMenu.setAlignment(Alignment.STRETCH);

    // Adding tabs to drawer menu
    footerMenu.addTab(new Tab("", TablerIcon.create("dashboard")));
    footerMenu.addTab(new Tab("", TablerIcon.create("shopping-cart")));
    footerMenu.addTab(new Tab("", TablerIcon.create("users")));
    footerMenu.addTab(new Tab("", TablerIcon.create("box")));
    footerMenu.addTab(new Tab("", TablerIcon.create("files")));
  }

}
