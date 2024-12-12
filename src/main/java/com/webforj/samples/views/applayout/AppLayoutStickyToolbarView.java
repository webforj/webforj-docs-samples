package com.webforj.samples.views.applayout;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.H1;
import com.webforj.component.html.elements.H3;
import com.webforj.component.html.elements.Img;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.icons.Icon;
import com.webforj.component.icons.TablerIcon;
import com.webforj.component.layout.applayout.AppDrawerToggle;
import com.webforj.component.layout.applayout.AppLayout;
import com.webforj.component.layout.appnav.AppNav;
import com.webforj.component.layout.appnav.AppNavItem;
import com.webforj.component.layout.toolbar.Toolbar;
import com.webforj.component.tabbedpane.Tab;
import com.webforj.component.tabbedpane.TabbedPane;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import com.webforj.samples.views.applayout.applayoutstickytoolbar.*;

@InlineStyleSheet("context://css/applayout/applayout.css")
@Route
@FrameTitle("AppLayout Sticky Toolbar")
public class AppLayoutStickyToolbarView extends Composite<AppLayout> {

  AppLayout demo = getBoundComponent();
  Paragraph contentLabel = new Paragraph();

  Toolbar header = new Toolbar();
  Div drawer = new Div();

  public AppLayoutStickyToolbarView() {

    demo.addToDrawerTitle(new Div("Menu"));

    // Header
    header.addClassName("layout__header").addToStart(
        new AppDrawerToggle()).addToTitle(
            new H3("Application"));
    header.setCompact(true);
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
    AppNav drawerMenu = new AppNav();
    drawer.add(drawerMenu);

    // Adding tabs to drawer menu
    Icon dashboardIcon = TablerIcon.create("dashboard");
    Icon ordersIcon = TablerIcon.create("shopping-cart");
    Icon customersIcon = TablerIcon.create("users");
    Icon productsIcon = TablerIcon.create("box");
    Icon documentsIcon = TablerIcon.create("files");
    Icon tasksIcon = TablerIcon.create("checklist");
    Icon analyticsIcon = TablerIcon.create("chart-dots-2");

    drawerMenu.addItem(new AppNavItem("Dashboard", DashboardView.class, dashboardIcon));
    drawerMenu.addItem(new AppNavItem("Orders", OrdersView.class, ordersIcon));
    drawerMenu.addItem(new AppNavItem("Customers", CustomersView.class, customersIcon));
    drawerMenu.addItem(new AppNavItem("Products", ProductsView.class, productsIcon));
    drawerMenu.addItem(new AppNavItem("Documents", DocumentsView.class, documentsIcon));
    drawerMenu.addItem(new AppNavItem("Tasks", TasksView.class, tasksIcon));
    drawerMenu.addItem(new AppNavItem("Analytics", AnalyticsView.class, analyticsIcon));

    // Content
    demo.addToContent(
        new H1("Application Title"),
        this.contentLabel);

    // Adding the additional toolbar with menu items
    Div secondToolbar = new Div();
    secondToolbar.addClassName("layout__second__header");
    demo.addToHeader(secondToolbar);
    TabbedPane secondMenu = new TabbedPane();
    secondToolbar.add(secondMenu);
    secondMenu.setBorderless(true);

    Icon salesIcon = TablerIcon.create("report-money");
    Icon enterpriseIcon = TablerIcon.create("building");
    Icon paymentsIcon = TablerIcon.create("credit-card");
    Icon historyIcon = TablerIcon.create("history");

    secondMenu.addTab(new Tab("Sales", salesIcon));
    secondMenu.addTab(new Tab("Enterprise", enterpriseIcon));
    secondMenu.addTab(new Tab("Payments", paymentsIcon));
    secondMenu.addTab(new Tab("History", historyIcon));

  }
}
