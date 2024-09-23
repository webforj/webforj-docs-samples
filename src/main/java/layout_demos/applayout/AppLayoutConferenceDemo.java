package layout_demos.applayout;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.element.Element;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.H1;
import com.webforj.component.html.elements.H2;
import com.webforj.component.html.elements.Img;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.html.elements.Strong;
import com.webforj.component.layout.applayout.AppLayout;
import com.webforj.component.tabbedpane.TabbedPane;
import com.webforj.component.tabbedpane.TabbedPane.Placement;
import com.webforj.component.tabbedpane.event.TabSelectEvent;
import com.webforj.component.tabbedpane.TabbedPane.Alignment;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/applayoutstyles/applayout_mobile.css")
public class AppLayoutConferenceDemo extends App {

  AppLayout demo = new AppLayout();
  Div contentLabel = new Div();
  Div header = new Div();
	Div drawer = new Div();

  H1 appTitle = new H1("Application Title");

  TabbedPane drawerMenu = new TabbedPane();
  TabbedPane footerMenu = new TabbedPane();

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.add(demo);
		demo.addToDrawerHeaderActions(new Element("dwc-icon-button")
				.setAttribute("name", "pin"));

    // Header
		Div toggle = new Div().setHtml("<dwc-icon-button name='menu-2' data-drawer-toggle><dwc-icon-button>");
    Div logo = new Div();
		logo.addClassName("dwc-logo").add(
			new Img("https://documentation.webforj.com/img/webforj_icon.svg", "logo")
		);
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
		drawerMenu.addTab("<dwc-icon name='dashboard'></dwc-icon>      Dashboard");
		drawerMenu.addTab("<dwc-icon name='shopping-cart'></dwc-icon>  Orders");
		drawerMenu.addTab("<dwc-icon name='users'></dwc-icon>          Customers");
		drawerMenu.addTab("<dwc-icon name='box'></dwc-icon>            Products");
		drawerMenu.addTab("<dwc-icon name='files'></dwc-icon>          Documents");
    drawerMenu.addSelectListener(this::changeTitle);

    // Content
    demo.addToContent(
        appTitle,
        this.contentLabel);
        for (int i = 0; i < 5; i++) {
          Div content = new Div().addClassName("card");
          content.add(
                new H2("What is webforJ?"),
                new Paragraph("""
                    webforJ is a powerful Java UI framework designed for building business-critical web applications entirely in Java. It provides a comprehensive API, design system, and a rich library of UI components, allowing developers to create modern, secure, and high-performance web applications without needing to rely on additional web development languages or frameworks.
                    """)
          );
          demo.addToContent(content);
    }

    demo.addToFooter(footerMenu);
    demo.setFooterReveal(true);

    footerMenu.setBodyHidden(true);
    footerMenu.setBorderless(true);
    footerMenu.setPlacement(Placement.BOTTOM);
    footerMenu.setAlignment(Alignment.STRETCH);

    // Adding tabs to drawer menu
    footerMenu.addTab("<dwc-icon name='dashboard'></dwc-icon>");
    footerMenu.addTab("<dwc-icon name='shopping-cart'></dwc-icon>");
    footerMenu.addTab("<dwc-icon name='users'></dwc-icon>");
    footerMenu.addTab("<dwc-icon name='box'></dwc-icon>");
    footerMenu.addTab("<dwc-icon name='files'></dwc-icon>");
    footerMenu.addSelectListener(this::changeTitle);
  }

  private void changeTitle(TabSelectEvent e){
    if(e.getComponent().getComponentId() == footerMenu.getComponentId()){
      drawerMenu.select(e.getTabIndex());
    } else{
      footerMenu.select(e.getTabIndex());
    }
    String value = drawerMenu.getSelected().getText().replaceAll("<[^>]*>", "").trim();
    appTitle.setText(value + " Page");
  }

}
