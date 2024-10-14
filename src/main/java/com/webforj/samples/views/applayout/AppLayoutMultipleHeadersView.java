package com.webforj.samples.views.applayout;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.element.Element;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.H1;
import com.webforj.component.html.elements.H3;
import com.webforj.component.html.elements.Img;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.layout.applayout.AppLayout;
import com.webforj.component.tabbedpane.TabbedPane;
import com.webforj.component.tabbedpane.TabbedPane.Placement;
import com.webforj.component.tabbedpane.event.TabSelectEvent;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet("context://css/applayout/applayout.css")
@Route
@FrameTitle("AppLayout Multiple Headers")
public class AppLayoutMultipleHeadersView extends Composite<AppLayout> {

	AppLayout demo = getBoundComponent();
	Paragraph contentLabel = new Paragraph();

	Div header = new Div();
	Div drawer = new Div();

	public AppLayoutMultipleHeadersView() {

		demo.setDrawerHeaderVisible(true);
		demo.setDrawerFooterVisible(true);

		demo.addToDrawerTitle(new Div("Menu"));
		demo.addToDrawerHeaderActions(new Element("dwc-icon-button")
				.setAttribute("name", "pin"));
		demo.addToDrawerFooter(new Paragraph("All rights reserved"));

		// Header
		header.addClassName("layout__header").add(
				new Div().setHtml("<dwc-icon-button name='menu-2' data-drawer-toggle><dwc-icon-button>"),
				new H3("DWCJ Application"));
		demo.addToHeader(header);

		// Drawer
		drawer.addClassName("app-layout-drawer");
		demo.addToDrawer(drawer);

		// Drawer's logo container and logo
		Div drawerLogo = new Div();
		drawerLogo.addClassName("drawer__logo")
				.add(new Img("https://documentation.webforj.com/img/webforj_icon.svg", "logo"));
		drawer.add(drawerLogo);

		// Drawer's Menu
		TabbedPane drawerMenu = new TabbedPane();
		drawer.add(drawerMenu);

		// Setting drawer menu's attributes
		drawerMenu.setBodyHidden(true);
		drawerMenu.setBorderless(true);
		drawerMenu.setPlacement(Placement.LEFT);

		// Adding tabs to drawer menu
		drawerMenu.addTab("<dwc-icon name='dashboard'></dwc-icon>      Dashboard");
		drawerMenu.addTab("<dwc-icon name='shopping-cart'></dwc-icon>  Orders");
		drawerMenu.addTab("<dwc-icon name='users'></dwc-icon>          Customers");
		drawerMenu.addTab("<dwc-icon name='box'></dwc-icon>            Products");
		drawerMenu.addTab("<dwc-icon name='files'></dwc-icon>          Documents");
		drawerMenu.addTab("<dwc-icon name='checklist'></dwc-icon>      Tasks");
		drawerMenu.addTab("<dwc-icon name='chart-dots-2'></dwc-icon>   Analytics");

		drawerMenu.onSelect(this::onTabChange);
		// Content
		demo.addToContent(new H1("Application Title"), this.contentLabel);

		// Adding the additional toolbar with menu items
		Div secondToolbar = new Div();
		secondToolbar.addClassName("layout__second__header");
		demo.addToHeader(secondToolbar);
		TabbedPane secondMenu = new TabbedPane();
		secondToolbar.add(secondMenu);
		secondMenu.setBodyHidden(true);
		secondMenu.setBorderless(true);

		secondMenu.addTab("<dwc-icon name='report-money'></dwc-icon> Sales");
		secondMenu.addTab("<dwc-icon name='building'></dwc-icon> Enterprise");
		secondMenu.addTab("<dwc-icon name='credit-card'></dwc-icon> Payments");
		secondMenu.addTab("<dwc-icon name='history'></dwc-icon> History");
	}

	private void onTabChange(TabSelectEvent ev) {
		String value = ev.getTab().getText().replaceAll("<[^>]*>", "").trim();
		contentLabel.setText("Content for " + value + " goes here");
	}
}
