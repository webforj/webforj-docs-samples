package demos.webcomponents.element;

import com.webforj.App;
import com.webforj.PendingResult;
import com.webforj.component.element.Element;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class ButtonFunction extends App {
  
  Element button = new Element("button", "Button");

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.setStyle("margin", "20px");
    window.add(button);

    /* Adds a click event listener to the Button */
    button.addEventListener("click", e -> msgbox("Button clicked"));
    
    /* Clicks the button, and stores the result in a Pending result. This then displays a
    message box when it resolves. */
    PendingResult<Object> result = button.callJsFunctionAsync("click");
    result.thenAccept( e -> msgbox("Will display after programmatically clicking button."));
  }
}