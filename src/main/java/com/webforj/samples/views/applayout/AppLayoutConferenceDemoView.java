
package com.webforj.samples.views.applayout;

import java.util.ArrayList;
import java.util.Arrays;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.element.Element;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.H1;
import com.webforj.component.html.elements.H2;
import com.webforj.component.html.elements.Img;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.html.elements.Strong;
import com.webforj.component.layout.applayout.AppDrawerToggle;
import com.webforj.component.layout.applayout.AppLayout;
import com.webforj.component.icons.Icon;
import com.webforj.component.icons.TablerIcon;
import com.webforj.component.tabbedpane.TabbedPane;
import com.webforj.component.tabbedpane.Tab;
import com.webforj.component.tabbedpane.TabbedPane.Placement;
import com.webforj.component.tabbedpane.event.TabSelectEvent;
import com.webforj.component.tabbedpane.TabbedPane.Alignment;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet("context://css/applayout/applayoutMobile.css")
@Route
@FrameTitle("AppLayout Conference Demo")
public class AppLayoutConferenceDemoView extends Composite<AppLayout> {

  AppLayout demo = getBoundComponent();
  Div contentLabel = new Div();
  Div header = new Div();
  Div drawer = new Div();

  ArrayList<String> titles = new ArrayList<>(Arrays.asList("Contacts", "Tasks", "Inbox", "Security", "Projects"));

  H1 appTitle = new H1("Application Title");

  TabbedPane drawerMenu = new TabbedPane();
  TabbedPane footerMenu = new TabbedPane();

  public AppLayoutConferenceDemoView() {
    demo.addToDrawerHeaderActions(new Element("dwc-icon-button")
        .setAttribute("name", "pin"));

    // Header
    AppDrawerToggle toggle = new AppDrawerToggle();
    Div logo = new Div();
    logo.addClassName("dwc-logo").add(
        new Img("https://documentation.webforj.com/img/webforj_icon.svg", "logo"));
    Strong title = new Strong("webforJ Application");

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

    drawerMenu.addTab(new Tab("Dashboard", dashboardIcon));
    drawerMenu.addTab(new Tab("Orders", ordersIcon));
    drawerMenu.addTab(new Tab("Customers", customersIcon));
		drawerMenu.addTab(new Tab("Products", productsIcon));
    drawerMenu.addTab(new Tab("Documents", documentsIcon));

    // Content
    demo.addToContent(
        appTitle,
        this.contentLabel);
    for (int i = 0; i < 5; i++) {
      Div content = new Div().addClassName("card");
      content.add(
          new H2("What is webforJ?"),
          new Paragraph(
              """
                  webforJ is a powerful Java UI framework designed for building business-critical web applications entirely in Java. It provides a comprehensive API, design system, and a rich library of UI components, allowing developers to create modern, secure, and high-performance web applications without needing to rely on additional web development languages or frameworks.
                  """));
      demo.addToContent(content);
    }

    demo.addToFooter(footerMenu);
    demo.setFooterReveal(true);

    footerMenu.setBodyHidden(true);
    footerMenu.setBorderless(true);
    footerMenu.setPlacement(Placement.BOTTOM);
    footerMenu.setAlignment(Alignment.STRETCH);

    // Adding tabs to drawer menu
    footerMenu.addTab(new Tab("", TablerIcon.create("address-book")));
    footerMenu.addTab(new Tab("", TablerIcon.create("clipboard")));
    footerMenu.addTab(new Tab("", TablerIcon.create("mail")));
    footerMenu.addTab(new Tab("", TablerIcon.create("lock")));
    footerMenu.addTab(new Tab("", TablerIcon.create("briefcase-2")));
    footerMenu.addSelectListener(this::changeTitle);
  }

  private void changeTitle(TabSelectEvent e) {
    appTitle.setText(titles.get(e.getTabIndex()));
  }

}

