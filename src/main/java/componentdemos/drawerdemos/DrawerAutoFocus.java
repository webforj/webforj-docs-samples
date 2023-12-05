package componentdemos.drawerdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.drawer.Drawer;
import org.dwcj.component.optioninput.CheckBox;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/drawerstyles/styles.css")
public class DrawerAutoFocus extends App {

  Drawer drawer = new Drawer();
  CheckBox checkbox = new CheckBox("Checkbox auto-focused");

  @Override
  public void run() throws DwcjException {

    Frame app = new Frame();
    app.add(drawer);
    drawer.open();
    drawer.add(checkbox);
    drawer.addClassName("drawer");
    drawer.setAutoFocus(true);
  }
}
