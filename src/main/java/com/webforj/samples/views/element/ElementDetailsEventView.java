package com.webforj.samples.views.element;

import static com.webforj.component.optiondialog.OptionDialog.showMessageDialog;

import com.webforj.component.Composite;
import com.webforj.component.element.Element;
import com.webforj.component.html.elements.Div;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route
@FrameTitle("Details Event")
public class ElementDetailsEventView extends Composite<Div> {
  
  Element details = new Element("details");

  public ElementDetailsEventView() {
    getBoundComponent().setStyle("margin", "20px");
    getBoundComponent().add(details);

    details.addEventListener("toggle", e -> showMessageDialog("Details Toggled!"));
  }
}