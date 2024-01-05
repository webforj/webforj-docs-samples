package demos.webcomponents.element;

import org.dwcj.App;
import org.dwcj.PendingResult;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.element.Element;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

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
public class InputFunction extends App {
  
  Element input = new Element("input");

  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.setStyle("margin", "20px");
    window.add(input);

    input.addClassName("element--input");
    input.addEventListener("click", e -> msgbox("Input click fired"));
    
    /* Clicks the input, and stores the result in a Pending result. This then displays a
    message box when it resolves. */
    PendingResult<Object> result = input.callJsFunctionAsync("click");
    result.thenAccept( e -> msgbox("Will display after programmatically clicking the input."));
  }
}