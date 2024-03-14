package componentdemos.drawerdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.list.ComboBox;
import com.webforj.component.drawer.Drawer;
import com.webforj.component.drawer.Drawer.Placement;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/drawerstyles/styles.css")
public class DrawerPlacement extends App {

  Drawer drawer = new Drawer();
  ComboBox placements = new ComboBox();

  @Override
  public void run() throws WebforjException {
    Frame app = new Frame();
    app.add(drawer);
    drawer.add(placements);
    drawer.open();
    drawer.addClassName("drawer");

    for (Placement placement : Drawer.Placement.values()) {
      placements.add(placement,
          placement.toString().substring(0, 1).toUpperCase() + placement.toString().substring(1).toLowerCase());
    }
    placements.selectIndex(4);
    placements.onSelect(e -> drawer.setPlacement((Placement) placements.getSelectedItem().getKey()));
  }
}
