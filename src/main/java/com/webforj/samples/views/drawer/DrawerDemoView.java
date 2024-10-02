package com.webforj.samples.views.drawer;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.drawer.Drawer;
import com.webforj.component.element.Element;
import com.webforj.component.html.elements.Div;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet("context://css/drawerstyles/styles.css")
@Route
@FrameTitle("Drawer Demo")
public class DrawerDemoView extends Composite<Div> {

  Drawer drawer = new Drawer();
  Element title = new Element("h3", "This is a Drawer component!");

  public DrawerDemoView() {

    getBoundComponent().add(drawer);
    drawer.open();
    drawer.add(title);
    drawer.addClassName("drawer");
  }
}
