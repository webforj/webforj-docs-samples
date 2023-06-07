package control_demos.drawerdemos;

import org.dwcj.App;
import org.dwcj.component.checkbox.CheckBox;
import org.dwcj.component.drawer.Drawer;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

public class DrawerAutoFocus extends App{
 
  @Override
  public void run() throws DwcjException {
  
    Frame app = new Frame();
    Drawer drawer = new Drawer();
    app.add(drawer);
    drawer.open();
    drawer.getContent()
    .add(new CheckBox().setText("Checkbox auto-focused"))
      .setStyle("height", "100%")
      .setStyle("display", "flex")
      .setStyle("flex-wrap", "wrap")
      .setStyle("align-content", "center")
      .setStyle("justify-content", "center");
      drawer.setAutoFocus(true);
  }
}
