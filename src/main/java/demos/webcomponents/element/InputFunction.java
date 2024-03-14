package demos.webcomponents.element;

import com.webforj.App;
import com.webforj.PendingResult;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.element.Element;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

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
  public void run() throws WebforjException {
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