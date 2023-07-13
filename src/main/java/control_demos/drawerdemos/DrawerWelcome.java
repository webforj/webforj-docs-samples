package control_demos.drawerdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.Expanse;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.ButtonTheme;
import org.dwcj.component.drawer.Drawer;
import org.dwcj.component.drawer.Drawer.Placement;
import org.dwcj.component.layout.applayout.AppLayout;
import org.dwcj.component.layout.applayout.AppLayout.DrawerPlacement;
import org.dwcj.component.texts.Label;
import org.dwcj.component.tabbedpane.TabbedPane;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/drawerstyles/drawer_welcome.css")
public class DrawerWelcome extends App {

  Drawer welcomeDrawer;

  @Override
  public void run() throws DwcjException {
    Frame panel = new Frame();
    AppLayout demo = new AppLayout();
    panel.add(demo);

    // Header
    demo.getHeader()
        .add(new Label("<html><bbj-icon-button name='menu-2' data-drawer-toggle><bbj-icon-button></html>"))
        .add(new Label(
            "<html><div class=\"bbj-logo\"><img src=\"https://i.ibb.co/1n4n1Nh/logo.png\" alt=\"logo\" /></div></html>"))
        .add(new Label("<html><b>DWCJ Application</b></html>"))
        .addClassName("bbj__toolbar-drawer");

    demo.setHeaderReveal(true);

    demo.setDrawerPlacement(DrawerPlacement.LEFT);
    Panel drawer = demo.getDrawer();
    drawer.addClassName("app-layout-drawer");

    // Drawer's logo container and logo
    drawer.add(new Panel().addClassName("drawer__logo").add(
        new Label("<html><img src='" + "https://i.ibb.co/1n4n1Nh/logo.png" + "'</img></html>")));

    // Drawer's Menu
    TabbedPane drawerMenu = new TabbedPane();
    drawer.add(drawerMenu);

    // Setting drawer menu's attributes
    drawerMenu.setAttribute("nobody", "true");
    drawerMenu.setAttribute("borderless", "true");
    drawerMenu.setAttribute("placement", "left");

    // Adding tabs to drawer menu
    drawerMenu.add("<bbj-icon name='dashboard'></bbj-icon>      Dashboard")
        .add("<bbj-icon name='shopping-cart'></bbj-icon>  Orders")
        .add("<bbj-icon name='users'></bbj-icon>          Customers")
        .add("<bbj-icon name='box'></bbj-icon>            Products")
        .add("<bbj-icon name='files'></bbj-icon>          Documents")
        .add("<bbj-icon name='checklist'></bbj-icon>      Tasks")
        .add("<bbj-icon name='chart-dots-2'></bbj-icon>   Analytics");

    // Welcome Drawer

    welcomeDrawer = new Drawer();
    panel.add(welcomeDrawer);
    welcomeDrawer
        .setPlacement(Placement.BOTTOM)
        .addClassName("welcome__drawer")
        .open();
    welcomeDrawer.getContent()
        .add(new Label(
            "<html><img src='https://thumb9.shutterstock.com/mosaic_250/177370774/1312166426/stock-vector-handshake-heart-icon-stroke-outline-style-line-vector-isolate-on-white-background-1312166426.jpg'></img></html>"))
        .add(new Label("<html><h2>Welcome to DWC</h2></html>"))
        .add(
            new Label("<html><p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p></html>"))
        .add(new Button("Get Started")
            .setTheme(ButtonTheme.PRIMARY)
            .setExpanse(Expanse.LARGE))
        .addClassName("welcome__drawer-content");

    // Content
    demo.getContent().add(
        new Label("<html><h1>Application Title</h1></html>"),
        new Label("<html><h4>Application Content</h4></html>"),
        new Button("Open Welcome Page")
            .onClick(e -> {
              welcomeDrawer.open();
            }));
  }

}
