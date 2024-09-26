package com.webforj.samples.views.drawer;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.list.ComboBox;
import com.webforj.component.Composite;
import com.webforj.component.drawer.Drawer;
import com.webforj.component.drawer.Drawer.Placement;
import com.webforj.component.html.elements.Div;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet("context://css/drawerstyles/styles.css")
@Route
@FrameTitle("Drawer Placement")
public class DrawerPlacementView extends Composite<Div> {

  Drawer drawer = new Drawer();
  ComboBox placements = new ComboBox();

  public DrawerPlacementView() {
    getBoundComponent().add(drawer);
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
