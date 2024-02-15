package componentdemos.drawerdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.Expanse;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.ButtonTheme;
import org.dwcj.component.drawer.Drawer;
import org.dwcj.component.drawer.Drawer.Placement;
import org.dwcj.component.html.elements.Div;
import org.dwcj.component.html.elements.H1;
import org.dwcj.component.html.elements.H2;
import org.dwcj.component.html.elements.H4;
import org.dwcj.component.html.elements.Img;
import org.dwcj.component.html.elements.Strong;
import org.dwcj.component.layout.applayout.AppLayout;
import org.dwcj.component.layout.applayout.AppLayout.DrawerPlacement;
import org.dwcj.component.text.Label;
import org.dwcj.component.tabbedpane.TabbedPane;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/drawerstyles/drawer_welcome.css")
public class DrawerWelcome extends App {
	
	Drawer welcomeDrawer;
	AppLayout demo = new AppLayout();

	Div header = new Div();
	Div drawer = new Div();

	@Override
	public void run() throws DwcjException {
		Frame window = new Frame();
		window.add(demo);

		// Header
		Div iconButton = new Div();
		iconButton.setHtml("<dwc-icon-button name='menu-2' data-drawer-toggle><dwc-icon-button>");

		Strong title = new Strong("DWCJ Application");
		header.add(iconButton, title);
		header.addClassName("dwc__toolbar-drawer");

		demo.addToHeader(header);
		demo.setHeaderReveal(true);

		demo.addToDrawer(drawer);
		drawer.addClassName("app-layout-drawer");
		demo.setDrawerPlacement(DrawerPlacement.LEFT);
		
		// Drawer's logo container and logo
		Div drawerLogo = new Div();
		drawerLogo.addClassName("drawer__logo")
			.add(
			new Img("https://i.ibb.co/1n4n1Nh/logo.png\" alt=\"logo\" /></div></html>"));
		drawer.add(drawerLogo);
			
		// Drawer's Menu
		TabbedPane drawerMenu = new TabbedPane();
		drawer.add(drawerMenu);

		drawerMenu.hideBody(true);
		drawerMenu.setBorderless(true);
		drawerMenu.setPlacement(TabbedPane.Placement.LEFT);

		// Adding tabs to drawer menu
		drawerMenu.addTab("<dwc-icon name='dashboard'></dwc-icon>      Dashboard");
		drawerMenu.addTab("<dwc-icon name='shopping-cart'></dwc-icon>  Orders");
		drawerMenu.addTab("<dwc-icon name='users'></dwc-icon>          Customers");
		drawerMenu.addTab("<dwc-icon name='box'></dwc-icon>            Products");
		drawerMenu.addTab("<dwc-icon name='files'></dwc-icon>          Documents");
		drawerMenu.addTab("<dwc-icon name='checklist'></dwc-icon>      Tasks");
		drawerMenu.addTab("<dwc-icon name='chart-dots-2'></dwc-icon>   Analytics");

		// Welcome Drawer

		welcomeDrawer = new Drawer();
		window.add(welcomeDrawer);
		welcomeDrawer
				.setPlacement(Placement.BOTTOM)
				.addClassName("welcome__drawer")
				.open();
		welcomeDrawer.add(new Img("""
				https://thumb9.shutterstock.com/mosaic_
				250/177370774/1312166426/stock-vector-handshake-heart-icon-stroke-outline-style
				-line-vector-isolate-on-white-background-1312166426.jpg
				"""));

		welcomeDrawer.add(new H2("Welcome to DWCJ"));
		welcomeDrawer.add(new Div("Lorem Ipsum is simply dummy text of the printing and typesetting industry"));
		welcomeDrawer.add(new Button("Get Started")
				.addClassName("welcome__drawer-content")
				.setTheme(ButtonTheme.PRIMARY)
				.setExpanse(Expanse.LARGE));

		// Content
		Button openWelcome = new Button("Open Welcome Page");
		openWelcome.onClick( e -> welcomeDrawer.open());

		demo.addToContent(
				new H1("Application Title"),
				new H4("Application Content"),
				openWelcome);
	}
}