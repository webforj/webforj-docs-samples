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

@InlineStyleSheet("context://css/applayoutstyles/applayout_sticky_styles.css")
public class AppLayoutStickyToolbar extends App {

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
    demo.setHeaderReveal(true);
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

    for (int i = 0; i < 10; i++) {
      demo.addToContent(
          new Label("<html>" +
              "<div class=\"card\">" +
              "<h2>What is Lorem Ipsum " + i + "?</h2>" +
              "<p>" +
              "Lorem Ipsum is simply dummy text of the printing and typesetting" +
              "industry. Lorem Ipsum has been the industry's standard dummy text" +
              "ever since the 1500s when an unknown printer took a galley of type" +
              "and scrambled it to make a type specimen book. It has survived not" +
              "only five centuries, but also the leap into electronic" +
              "typesetting, remaining essentially unchanged. It was popularized" +
              "in the 1960s with the release of Letraset sheets containing Lorem" +
              "Ipsum passages, and more recently with desktop publishing software" +
              "like Aldus PageMaker including versions of Lorem Ipsum." +
              "</p>" +
              "</div>" +
              "</html>"));
    }

    // Adding the additional toolbar with menu items
    Panel secondToolbar = new Panel()
        .addClassName("layout__second__header");
    demo.addToHeader(secondToolbar);
    TabbedPane secondMenu = new TabbedPane();
    secondToolbar.add(secondMenu);
    secondMenu.setAttribute("nobody", "true")
        .setAttribute("borderless", "true")
        .add("<bbj-icon name='report-money'></bbj-icon> Sales")
        .add("<bbj-icon name='building'></bbj-icon> Enterprise")
        .add("<bbj-icon name='credit-card'></bbj-icon> Payments")
        .add("<bbj-icon name='history'></bbj-icon> History");
  }

  private void onTabChange(TabSelectEvent ev) {
    String value = ev.getTitle().replaceAll("<[^>]*>", "").trim();
    contentLabel.setText("<html><p>Content for " + value + " goes here</p></html>");
  }
}
