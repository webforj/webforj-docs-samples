package layout_demos.applayout;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.annotation.StyleSheet;
import org.dwcj.component.applayout.AppLayout;
import org.dwcj.component.applayout.AppLayout.DrawerPlacement;
import org.dwcj.component.label.Label;
import org.dwcj.component.tabbedpane.TabbedPane;
import org.dwcj.component.tabbedpane.event.TabSelectEvent;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/applayoutstyles/applayout_mobile.css")
public class AppLayoutMobileDrawer extends App{
  
  Label contentLabel; 
  
  @Override
    public void run() throws DwcjException{
      Frame panel = new Frame();
      AppLayout demo = new AppLayout();
      panel.add(demo);

      //Header 
      demo.getHeader()
          .add(new Label("<html><bbj-icon-button name='menu-2' data-drawer-toggle><bbj-icon-button></html>"))
          .add(new Label("<html><div class=\"bbj-logo\"><img src=\"https://i.ibb.co/1n4n1Nh/logo.png\" alt=\"logo\" /></div></html>"))
          .add(new Label("<html><b>DWCJ Application</b></html>")
        )
        .addClassName("bbj-toolbar");

      demo.setHeaderReveal(true);



      demo.setDrawerPlacement(DrawerPlacement.LEFT);
      Panel drawer = demo.getDrawer();
      drawer.addClassName("app-layout-drawer");

      //Drawer's logo container and logo
      drawer.add(new Panel().addClassName("drawer__logo").add(
          new Label("<html><img src='" + "https://i.ibb.co/1n4n1Nh/logo.png" + "'</img></html>")
      ));

      //Drawer's Menu
      TabbedPane drawerMenu = new TabbedPane();
      drawer.add(drawerMenu);
      
      //Setting drawer menu's attributes
      drawerMenu.setAttribute("nobody","true");
      drawerMenu.setAttribute("borderless","true");
      drawerMenu.setAttribute("placement","left");

      //Adding tabs to drawer menu
      drawerMenu.add("<bbj-icon name='dashboard'></bbj-icon>      Dashboard")
          .add("<bbj-icon name='shopping-cart'></bbj-icon>  Orders"   )
          .add("<bbj-icon name='users'></bbj-icon>          Customers")
          .add("<bbj-icon name='box'></bbj-icon>            Products" )
          .add("<bbj-icon name='files'></bbj-icon>          Documents")
          .add("<bbj-icon name='checklist'></bbj-icon>      Tasks"    )
          .add("<bbj-icon name='chart-dots-2'></bbj-icon>   Analytics");

      //Content
      this.contentLabel = new Label();
      demo.getContent().add(
          new Label("<html><h1>Application Title</h1></html>"),
          this.contentLabel
          );
      for(int i = 0; i < 5; i++){
        demo.getContent().add(
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
            "</html>"
          )
        );
      }
      
      TabbedPane footerMenu = new TabbedPane();
      demo.getFooter().add(footerMenu);
      demo.setFooterReveal(true);
      
      //Setting drawer menu's attributes
      footerMenu.setAttribute("nobody","true");
      footerMenu.setAttribute("borderless","true");
      footerMenu.setAttribute("placement","bottom");
      footerMenu.setAttribute("alignment","stretch");
      
      //Adding tabs to drawer menu
      footerMenu.add("<bbj-icon name='dashboard'></bbj-icon>")
          .add("<bbj-icon name='shopping-cart'></bbj-icon>")
          .add("<bbj-icon name='users'></bbj-icon>" )
          .add("<bbj-icon name='box'></bbj-icon>")
          .add("<bbj-icon name='files'></bbj-icon>");
  }
    
}
