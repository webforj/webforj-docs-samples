package com.webforj.samples.views.element;

import static com.webforj.component.optiondialog.OptionDialog.showMessageDialog;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.element.Element;
import com.webforj.component.element.event.ElementEventOptions;
import com.webforj.component.html.elements.Div;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet(/* css */"""
  .frame{
    display: flex;
    flex-direction: column;
    margin: 20px;
  }

  .element--label{
    display: block;
    font:
      1.5em 'Fira Sans',
      sans-serif;
    padding-bottom: 10px;
  }

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
@FrameTitle("Input Event")
public class ElementInputEventView extends Composite<Div> {
  
  Div label = new Div("Enter Text and Press Enter");
  Element input = new Element("input");

  public ElementInputEventView() {
    getBoundComponent().setStyle("margin", "20px");
    getBoundComponent().addClassName("frame");
    getBoundComponent().add(label, input);
    
    label.addClassName("element--label");
    input.addClassName("element--input");

    ElementEventOptions options = new ElementEventOptions();
    options.addData("theValue", "component.value");
    options.setFilter("event.key == 'Enter'");
    options.setCode("event.preventDefault();");

    input.addEventListener("keypress", e -> {
      showMessageDialog(e.getEventMap().get("theValue") + "");
    }, options);
  }
}