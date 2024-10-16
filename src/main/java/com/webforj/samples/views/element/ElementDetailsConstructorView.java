package com.webforj.samples.views.element;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.element.Element;
import com.webforj.component.html.elements.Div;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet("context://css/element/elementDetailsConstructor.css")
@Route
@FrameTitle("Details Constructor")
public class ElementDetailsConstructorView extends Composite<Div> {
  
  Element details = new Element("details");

  public ElementDetailsConstructorView() {
    getBoundComponent().setStyle("margin", "20px");
    getBoundComponent().add(details);
    details.setHtml("<summary>Something small enough to escape casual notice.</summary>");
  }
}