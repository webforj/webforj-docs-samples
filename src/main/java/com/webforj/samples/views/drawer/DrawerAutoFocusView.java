package com.webforj.samples.views.drawer;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.drawer.Drawer;
import com.webforj.component.html.elements.Div;
import com.webforj.component.optioninput.CheckBox;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet("context://css/drawerstyles/styles.css")
@Route
@FrameTitle("Drawer Auto-Focus")
public class DrawerAutoFocusView extends Composite<Div> {

  Drawer drawer = new Drawer();
  CheckBox checkbox = new CheckBox("Checkbox auto-focused");

  public DrawerAutoFocusView() {

    getBoundComponent().add(drawer);
    drawer.open();
    drawer.add(checkbox);
    drawer.addClassName("drawer");
    drawer.setAutofocus(true);
  }
}
