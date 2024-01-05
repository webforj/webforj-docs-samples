package demos.webcomponents.element;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.element.Element;
import org.dwcj.component.element.event.ElementEventOptions;
import org.dwcj.component.html.elements.Div;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

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
public class InputEvent extends App {
  
  Div label = new Div("Enter Text and Press Enter");
  Element input = new Element("input");

  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.setStyle("margin", "20px");
    window.addClassName("frame");
    window.add(label, input);
    
    label.addClassName("element--label");
    input.addClassName("element--input");

    ElementEventOptions options = new ElementEventOptions();
    options.addData("theValue", "component.value");
    options.setFilter("event.key == 'Enter'");
    options.setCode("event.preventDefault();");

    input.addEventListener("keypress", e -> {
      msgbox(e.getEventMap().get("theValue") + "");
    }, options);
  }
}