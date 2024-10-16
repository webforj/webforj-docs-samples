package com.webforj.samples.views.element;

import static com.webforj.component.optiondialog.OptionDialog.showMessageDialog;

import com.webforj.PendingResult;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.element.Element;
import com.webforj.component.html.elements.Div;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet("context://css/element/elementInput.css")
@Route
@FrameTitle("Input Function")
public class ElementInputFunctionView extends Composite<Div> {
  
  Element input = new Element("input");

  public ElementInputFunctionView() {
    getBoundComponent().setStyle("margin", "20px");
    getBoundComponent().add(input);

    input.addClassName("element--input");
    input.addEventListener("click", e -> showMessageDialog("Input click fired"));
    
    /* Clicks the input, and stores the result in a Pending result. This then displays a
    message box when it resolves. */
    PendingResult<Object> result = input.callJsFunctionAsync("click");
    result.thenAccept( e -> showMessageDialog("Will display after programmatically clicking the input."));
  }
}