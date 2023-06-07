package control_demos.drawerdemos;

import org.dwcj.App;
import org.dwcj.component.drawer.Drawer;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

public class DrawerDemo extends App{
 
  @Override
  public void run() throws DwcjException {
  
    Frame app = new Frame();
    Drawer drawer = new Drawer();
    app.add(drawer);
    drawer.open();
  }
}
