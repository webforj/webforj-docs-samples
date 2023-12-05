package layout_demos.applayout;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.layout.applayout.AppLayout;
import org.dwcj.component.layout.applayout.AppLayout.DrawerPlacement;
import org.dwcj.component.text.Label;
import org.dwcj.component.tabbedpane.TabbedPane;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/applayoutstyles/applayout_mobile.css")
public class AppLayoutMobile extends App {

  AppLayout demo = new AppLayout();
  Label contentLabel = new Label();

  Panel header = new Panel();

  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.add(demo);

    // Header
    header.add(new Label(
        "<html><div class=\"bbj-logo\"><img src=\"https://i.ibb.co/1n4n1Nh/logo.png\" alt=\"logo\" /></div></html>"))
        .add(new Label("<html><b>DWCJ Application</b></html>"))
        .addClassName("bbj-toolbar");

    demo.addToHeader(header);
    demo.setHeaderReveal(true);
    demo.setDrawerPlacement(DrawerPlacement.HIDDEN);

    // Content
    demo.addToContent(
        new Label("<html><h1>Application Title</h1></html>"),
        this.contentLabel);
    for (int i = 0; i < 5; i++) {
      demo.addToContent().add(
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

    TabbedPane footerMenu = new TabbedPane();
    demo.addToFooter(footerMenu);
    demo.setFooterReveal(true);

    // Setting drawer menu's attributes
    footerMenu.setAttribute("nobody", "true");
    footerMenu.setAttribute("borderless", "true");
    footerMenu.setAttribute("placement", "bottom");
    footerMenu.setAttribute("alignment", "stretch");

    // Adding tabs to drawer menu
    footerMenu.add("<bbj-icon name='dashboard'></bbj-icon>")
        .add("<bbj-icon name='shopping-cart'></bbj-icon>")
        .add("<bbj-icon name='users'></bbj-icon>")
        .add("<bbj-icon name='box'></bbj-icon>")
        .add("<bbj-icon name='files'></bbj-icon>");
  }

}
