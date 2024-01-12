package layout_demos.applayout;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.element.Element;
import org.dwcj.component.html.elements.Div;
import org.dwcj.component.html.elements.H1;
import org.dwcj.component.html.elements.H2;
import org.dwcj.component.html.elements.H3;
import org.dwcj.component.html.elements.Img;
import org.dwcj.component.html.elements.Paragraph;
import org.dwcj.component.layout.applayout.AppLayout;
import org.dwcj.component.text.Label;
import org.dwcj.component.tabbedpane.TabbedPane;
import org.dwcj.component.tabbedpane.event.TabSelectEvent;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/applayoutstyles/applayout_sticky_styles.css")
public class AppLayoutStickyToolbar extends App {

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
    demo.setHeaderReveal(true);

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
demo.addToContent(
        new H1("Application Title"),
        this.contentLabel);
        for (int i = 0; i < 10; i++) {
          Div content = new Div().addClassName("card");
          content.add(
                new H2("What is Lorem Ipsum " + i + "?"),
                new Paragraph("Lorem Ipsum is simply dummy text of the printing and typesetting" +
                  "industry. Lorem Ipsum has been the industry's standard dummy text" +
                  "ever since the 1500s when an unknown printer took a galley of type" +
                  "and scrambled it to make a type specimen book. It has survived not" +
                  "only five centuries, but also the leap into electronic" +
                  "typesetting, remaining essentially unchanged. It was popularized" +
                  "in the 1960s with the release of Letraset sheets containing Lorem" +
                  "Ipsum passages, and more recently with desktop publishing software" +
                  "like Aldus PageMaker including versions of Lorem Ipsum.")
          );
          demo.addToContent(content);
    }

    // Adding the additional toolbar with menu items
		Div secondToolbar = new Div();
    secondToolbar.addClassName("layout__second__header");
    demo.addToHeader(secondToolbar);
    TabbedPane secondMenu = new TabbedPane();
		secondToolbar.add(secondMenu);
		secondMenu.hideBody(true);
		secondMenu.setBorderless(true);
        secondMenu.addTab("<bbj-icon name='report-money'></bbj-icon> Sales");
        secondMenu.addTab("<bbj-icon name='building'></bbj-icon> Enterprise");
        secondMenu.addTab("<bbj-icon name='credit-card'></bbj-icon> Payments");
        secondMenu.addTab("<bbj-icon name='history'></bbj-icon> History");
  }

  private void onTabChange(TabSelectEvent ev) {
    // String value = ev.getTitle().replaceAll("<[^>]*>", "").trim();
    // contentLabel.setText("<html><p>Content for " + value + " goes here</p></html>");
  }
}
