package layout_demos.applayout;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.layout.applayout.AppLayout;
import org.dwcj.component.text.Label;
import org.dwcj.component.tabbedpane.TabbedPane;
import org.dwcj.component.tabbedpane.event.TabSelectEvent;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/applayoutstyles/applayout_styles.css")
public class AppLayoutFullNavbar extends App {

	AppLayout demo = new AppLayout();
	Label contentLabel = new Label();

	Panel header = new Panel();
	Panel drawer = new Panel();

	@Override
	public void run() throws DwcjException {
		Frame window = new Frame();
		window.add(demo);

		// Header
		header.addClassName("layout__header")
				.add(new Label("<html><bbj-icon-button name='menu-2' data-drawer-toggle><bbj-icon-button></html>"),
						new Label("DWCJ Application")
								.addClassName("layout__header--title"));
		demo.setHeaderOffscreen(false);
		demo.addToHeader(header);

		// Drawer
		demo.addToDrawer(drawer);
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

		drawerMenu.onSelect(this::onTabChange);

		// Content
		demo.addToContent(
				new Label("<html><h1>Application Title</h1></html>"),
				this.contentLabel);
	}

	private void onTabChange(TabSelectEvent ev) {
		String value = ev.getTitle().replaceAll("<[^>]*>", "").trim();
		contentLabel.setText("<html><p>Content for " + value + " goes here</p></html>");
	}
}
