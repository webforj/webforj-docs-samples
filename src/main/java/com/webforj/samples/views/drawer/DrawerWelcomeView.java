package com.webforj.samples.views.drawer;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.Expanse;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.drawer.Drawer;
import com.webforj.component.drawer.Drawer.Placement;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.H1;
import com.webforj.component.html.elements.H2;
import com.webforj.component.html.elements.H4;
import com.webforj.component.html.elements.Img;
import com.webforj.component.html.elements.Strong;
import com.webforj.component.layout.applayout.AppLayout;
import com.webforj.component.layout.applayout.AppLayout.DrawerPlacement;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.text.Label;
import com.webforj.component.tabbedpane.TabbedPane;
import com.webforj.exceptions.WebforjException;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet("context://css/drawerstyles/drawer_welcome.css")
@Route
@FrameTitle("Drawer Welcome App")
public class DrawerWelcomeView extends Composite<Div> {

	Drawer welcomeDrawer;
	AppLayout demo = new AppLayout();

	Div header = new Div();
	Div drawer = new Div();

	public DrawerWelcomeView() {
		getBoundComponent().add(demo);

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
		getBoundComponent().add(welcomeDrawer);

		welcomeDrawer
				.setPlacement(Placement.BOTTOM)
				.addClassName("welcome__drawer")
				.open();

		FlexLayout layout = FlexLayout.create(new Img("""
				https://thumb9.shutterstock.com/mosaic_
				250/177370774/1312166426/stock-vector-handshake-heart-icon-stroke-outline-style
				-line-vector-isolate-on-white-background-1312166426.jpg
				"""),
				new H2("Welcome to DWCJ"),
				new Div("Lorem Ipsum is simply dummy text of the printing and typesetting industry"),
				new Button("Get Started"))
				.vertical()
				.align().center()
				.build();
		welcomeDrawer.add(layout);
		// Content
		Button openWelcome = new Button("Open Welcome Page");
		openWelcome.onClick(e -> welcomeDrawer.open());

		demo.addToContent(
				new H1("Application Title"),
				new H4("Application Content"),
				openWelcome);
	}
}