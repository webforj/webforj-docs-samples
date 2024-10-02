package com.webforj.samples.views.element;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.element.Element;
import com.webforj.component.html.elements.Div;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet(/* css */"""
  details {
    border: 1px solid #aaa;
    border-radius: 4px;
    padding: 0.5em 0.5em 0;
  }
  
  summary {
    font-weight: bold;
    margin: -0.5em -0.5em 0;
    padding: 0.5em;
  }
  
  details[open] {
    padding: 0.5em;
  }
  
  details[open] summary {
    border-bottom: 1px solid #aaa;
    margin-bottom: 0.5em;
  }
""")
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