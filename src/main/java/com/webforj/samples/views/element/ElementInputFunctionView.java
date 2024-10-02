package com.webforj.samples.views.element;

import static com.webforj.component.optiondialog.OptionDialog.showMessageDialog;

import com.webforj.PendingResult;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.element.Element;
import com.webforj.component.html.elements.Div;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet(/* css */"""
  .element--input{
    display: block;
    margin: 0;
    padding: 1em 1.5em;
    width: 50%;
    font-size: 1.75em;
    border: 1px solid rgba(0, 0, 0, 0.12);
    border-radius: 0.4rem;
    transition: box-shadow 300ms;
  }

  .element--input:focus {
    outline: none;
    box-shadow: 0.2rem 0.8rem 1.6rem rgba(0, 0, 0, 0.12);
  }
""")
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