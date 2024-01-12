package layout_demos.applayout;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.element.Element;
import org.dwcj.component.html.elements.Div;
import org.dwcj.component.html.elements.H1;
import org.dwcj.component.html.elements.H3;
import org.dwcj.component.html.elements.Img;
import org.dwcj.component.html.elements.Paragraph;
import org.dwcj.component.layout.applayout.AppLayout;
import org.dwcj.component.tabbedpane.TabbedPane;
import org.dwcj.component.tabbedpane.event.TabSelectEvent;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/applayoutstyles/applayout_styles.css")
public class AppLayoutDemo extends App {

  AppLayout demo = new AppLayout();
  Paragraph contentLabel = new Paragraph();

	Div header = new Div();
	Div drawer = new Div();

  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.add(demo);

    demo.setDrawerHeaderVisible(true);
    demo.setDrawerFooterVisible(true);

    demo.addToDrawerTitle(new Div("Menu"));
    demo.addToDrawerHeaderActions(new Element("bbj-icon-button")
        .setAttribute("name", "pin"));
    demo.addToDrawerFooter(new Paragraph("All rights reserved"));

    // Header
    header.addClassName("layout__header").add(
        new Div().setHtml("<bbj-icon-button name='menu-2' data-drawer-toggle><bbj-icon-button>"),
        new H3("DWCJ Application"));
    demo.addToHeader(header);

    // Drawer
    demo.addToDrawer(drawer);
    drawer.addClassName("app-layout-drawer");

    // Drawer's logo container and logo
    Div drawerLogo = new Div();
		drawerLogo.addClassName("drawer__logo")
			.add(new Img("https://i.ibb.co/1n4n1Nh/logo.png", "logo"));
		drawer.add(drawerLogo);

    // Drawer's Menu
    TabbedPane drawerMenu = new TabbedPane();
    drawer.add(drawerMenu);

    // Setting drawer menu's attributes
    // drawerMenu.setAttribute("nobody", "true");
    // drawerMenu.setAttribute("borderless", "true");
    // drawerMenu.setAttribute("placement", "left");

    drawerMenu.hideBody(true);
		drawerMenu.setBorderless(true);
		drawerMenu.setPlacement(TabbedPane.Placement.LEFT);

    // Adding tabs to drawer menu
    drawerMenu.addTab("<bbj-icon name='dashboard'></bbj-icon>      Dashboard");
    drawerMenu.addTab("<bbj-icon name='shopping-cart'></bbj-icon>  Orders");
    drawerMenu.addTab("<bbj-icon name='users'></bbj-icon>          Customers");
    drawerMenu.addTab("<bbj-icon name='box'></bbj-icon>            Products");
    drawerMenu.addTab("<bbj-icon name='files'></bbj-icon>          Documents");
    drawerMenu.addTab("<bbj-icon name='checklist'></bbj-icon>      Tasks");
    drawerMenu.addTab("<bbj-icon name='chart-dots-2'></bbj-icon>   Analytics");

    drawerMenu.onSelect(this::onTabChange);

    // Content
    demo.addToContent(new H1("Application Title"), this.contentLabel);
  }

  private void onTabChange(TabSelectEvent ev) {
    String value = ev.getTab().getText().replaceAll("<[^>]*>", "").trim();
    contentLabel.setText("Content for " + value + " goes here");
  }
}