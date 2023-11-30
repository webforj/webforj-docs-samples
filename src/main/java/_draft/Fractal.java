package _draft;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.layout.applayout.AppLayout;
import org.dwcj.component.text.Label;
import org.dwcj.component.tabbedpane.TabbedPane;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/applayoutstyles/applayout_styles.css")
// @InlineStyleSheet(/*css */"""
//   .content__shape{
//     position: relative;
//     width: 150px;
//     height: 150px;
//     margin: 50px;
//   }
// .content__shape--triangle{
//   position: absolute;
//   width: 100%;
//   height: 100%;
//   opacity: 0;
//   animation: fadeInOut 12s infinite linear;
//   clip-path: polygon(50% 0%, 100% 100%, 0% 100%);
//   animation-delay: 0s;
//   background-color: red;
// }
// .content__shape--square{
//   position: absolute;
//   width: 100%;
//   height: 100%;
//   opacity: 0;
//   animation: fadeInOut 12s infinite linear;
//   clip-path: polygon(0 0, 100% 0, 100% 100%, 0 100%);
//   animation-delay: 3s;
//   background-color: blue;
// }
// .content__shape--pentagon{
//   position: absolute;
//   width: 100%;
//   height: 100%;
//   opacity: 0;
//   animation: fadeInOut 12s infinite linear;
//   clip-path: polygon(50% 0%, 100% 40%, 80% 100%, 20% 100%, 0% 40%);
//   animation-delay: 6s;
//   background-color: green;
// }
// .content__shape--hexagon{
//     position: absolute;
//   width: 100%;
//   height: 100%;
//   opacity: 0;
//   animation: fadeInOut 12s infinite linear;
//   clip-path: polygon(50% 0%, 100% 25%, 100% 75%, 50% 100%, 0% 75%, 0% 25%);
//   animation-delay: 9s;
//   background-color: yellow;
// }
//   @keyframes fadeInOut {
//     0%, 100% { opacity: 0; transform: scale(0.8) rotate(0deg); }
//     25%, 75% { opacity: 1; transform: scale(1) rotate(360deg); }
//   }
// """)
@InlineStyleSheet(/*css */"""
  .content__shape{
    display: flex;
    justify-content: center;
    align-items: center;
    position: absolute;
    height: 100%;
    width: 100%;
    background-color: #333;
  }
  .fractal {
    width: 60px;
    height: 20px;
    background-color: #67B46D;
    border-radius: 20px;
    display: block;
    position: relative; 
    animation-name: spiral;
    animation-duration: 15s;
    animation-iteration-count: infinite;
    animation-direction: alternate;
    will-change: transform; wow what a difference this makes
  }
  
  @keyframes spiral {
      from {transform: translate3d(0,10%,0) rotate(0deg) scale(0);}
      to {transform: translate3d(0,400%,0) rotate(60deg) scale(1.3);}
  }
""")
public class Fractal extends App {

    Panel contentShape = new Panel();

    @Override
    public void run() throws DwcjException {
        Frame window = new Frame();
        AppLayout demo = new AppLayout();
        window.add(demo);

        // Header
        demo.getHeader().addClassName("layout__header")
                .add(new Label("<html><bbj-icon-button name='menu-2' data-drawer-toggle><bbj-icon-button></html>"),
                        new Label("DWCJ Application")
                                .addClassName("layout__header--title"));

        // Drawer
        Panel drawer = demo.getDrawer();
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


        // Content
        contentShape.addClassName("content__shape");
        // Panel triangle = new Panel();
        // Panel square = new Panel();
        // Panel pentagon = new Panel();
        // Panel hexagon = new Panel();
        // triangle.addClassName("content__shape--triangle");
        // square.addClassName("content__shape--square");
        // pentagon.addClassName("content__shape--pentagon");
        // hexagon.addClassName("content__shape--hexagon");
        // contentShape.add(triangle,square,pentagon,hexagon);
        int i = 35;
        contentShape = addFractal(contentShape, i);
        demo.getContent().setStyle("height", "100%").add(contentShape);
    }

    private Panel addFractal(Panel panel, int i){
      App.consoleLog("TEST");
      if (i <= 0) {
        return panel;
    } else {
        Panel newPanel = new Panel().addClassName("fractal");
        panel.add(newPanel);
        addFractal(newPanel, i - 1);
        return panel;
    }
    }
}
