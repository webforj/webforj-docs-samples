package com.webforj.samples.views.element;

import com.webforj.component.Composite;
import com.webforj.component.element.Element;
import com.webforj.component.html.elements.Div;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route
@FrameTitle("Details Slots")
public class ElementDetailsSlotsView extends Composite<Div> {
  
  Element details = new Element("details");
  Element secondDetails = new Element("details");
  Element summary = new Element("summary", "First Details Title");

  public ElementDetailsSlotsView() {
    getBoundComponent().setStyle("margin", "20px");
    getBoundComponent().add(details, secondDetails);

    /* Method 1: Setting text using setText() and add()*/
    details.add(summary); // Adds a summary element to the text already present inside the details element
    details.setText("Expanded text for the first summary."); // Sets the content inside the details element

    /* Method 2: Injecting pure HTML into the element*/
    secondDetails.setHtml("""
      <summary>Second Details Title</summary>
      Expanded text for the second summary.
    """);
  }
}