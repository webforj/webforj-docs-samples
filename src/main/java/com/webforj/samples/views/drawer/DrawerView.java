package com.webforj.samples.views.drawer;

import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.drawer.Drawer;
import com.webforj.component.element.Element;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route
@FrameTitle("Drawer Demo")
public class DrawerView extends Composite<FlexLayout> {

  Drawer drawer = new Drawer();
  Element title = new Element("h3", "This is a Drawer component!");

  public DrawerView() {
    getBoundComponent().setMargin("20px");
    getBoundComponent().add(drawer);
    
    drawer.open();
    drawer.add(title);
    drawer.addClassName("drawer");
    
    Button openDrawerButton = new Button("Open Preferences");
    openDrawerButton.onClick(e -> drawer.open());
    getBoundComponent().add(openDrawerButton);
    
  }
}
