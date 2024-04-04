package componentdemos.drawerdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.button.Button;
import com.webforj.component.drawer.Drawer;
import com.webforj.component.element.Element;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/drawerstyles/styles.css")
public class DrawerDemo extends App {

  Drawer drawer = new Drawer();
  Element title = new Element("h3", "This is a Drawer component!");
  Button show;

  public DrawerDemo() {
    drawer = new Drawer();
    title = new Element("h3", "This is a Drawer component");
    show = new Button("Display Drawer")
      .setEnabled(false);
  }

  @Override
  public void run() throws WebforjException {

    Frame app = new Frame();
    app.add(drawer);
    drawer.open();
    drawer.add(title);
    drawer.addClassName("drawer");
    drawer.onClose(e -> show.setEnabled(true));
    show.addClickListener(e -> {
      drawer.open();
      show.setEnabled(false);
    });
  }
}
