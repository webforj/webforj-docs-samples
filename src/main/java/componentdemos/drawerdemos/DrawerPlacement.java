package componentdemos.drawerdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.button.Button;
import com.webforj.component.list.ComboBox;
import com.webforj.component.drawer.Drawer;
import com.webforj.component.drawer.Drawer.Placement;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/drawerstyles/styles.css")
public class DrawerPlacement extends App {

  private final Drawer drawer;
  private final ComboBox placements;
  private final Button show;

  public DrawerPlacement() {
    drawer = new Drawer();
    placements = new ComboBox();
    show = new Button("Display Drawer")
      .setEnabled(false);
  }

  @Override
  public void run() throws WebforjException {
    Frame app = new Frame();
    app.add(drawer);
    drawer.add(placements);
    drawer.open();
    drawer.addClassName("drawer");

    for (Placement placement : Drawer.Placement.values()) {
      placements.add(placement,
          placement.toString().charAt(0) + placement.toString().substring(1).toLowerCase());
    }
    placements.selectIndex(4);
    placements.onSelect(e -> drawer.setPlacement((Placement) placements.getSelectedItem().getKey()));
    drawer.onClose(e -> show.setEnabled(true));
    show.addClickListener(e -> {
      drawer.open();
      show.setEnabled(false);
    });
  }

}
