package componentdemos.drawerdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.drawer.Drawer;
import org.dwcj.component.element.Element;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/drawerstyles/styles.css")
public class DrawerDemo extends App {

  Drawer drawer = new Drawer();
  Element title = new Element("h3", "This is a Drawer component!");

  @Override
  public void run() throws DwcjException {

    Frame app = new Frame();
    app.add(drawer);
    drawer.open();
    drawer.add(title);
    drawer.addClassName("drawer");
  }
}
