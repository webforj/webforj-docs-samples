package com.webforj.samples.views.element;

import static com.webforj.component.optiondialog.OptionDialog.showMessageDialog;

import com.webforj.PendingResult;
import com.webforj.component.Composite;
import com.webforj.component.element.Element;
import com.webforj.component.html.elements.Div;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route
@FrameTitle("Element Button Function")
public class ElementButtonFunctionView extends Composite<Div> {
  
  Element button = new Element("button", "Button");

  public ElementButtonFunctionView() {
    getBoundComponent().setStyle("margin", "20px");
    getBoundComponent().add(button);

    /* Adds a click event listener to the Button */
    button.addEventListener("click", e -> showMessageDialog("Button clicked"));
    
    /* Clicks the button, and stores the result in a Pending result. This then displays a
    message box when it resolves. */
    PendingResult<Object> result = button.callJsFunctionAsync("click");
    result.thenAccept( e -> showMessageDialog("Will display after programmatically clicking button."));
  }
}