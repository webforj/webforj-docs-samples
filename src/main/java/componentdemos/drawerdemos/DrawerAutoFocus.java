package componentdemos.drawerdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.drawer.Drawer;
import com.webforj.component.optioninput.CheckBox;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/drawerstyles/styles.css")
public class DrawerAutoFocus extends App {

  Drawer drawer = new Drawer();
  CheckBox checkbox = new CheckBox("Checkbox auto-focused");

  @Override
  public void run() throws WebforjException {

    Frame app = new Frame();
    app.add(drawer);
    drawer.open();
    drawer.add(checkbox);
    drawer.addClassName("drawer");
    drawer.setAutofocus(true);
  }
}
