package demos.webcomponents;

import org.dwcj.App;
import org.dwcj.PendingResult;
import org.dwcj.component.element.Element;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

public class ButtonFunction extends App {
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.setStyle("margin", "20px");

    /* Creates a new HTML Button element */
    Element button = new Element("button", "Button");
    window.add(button);

    /* Adds a click event listener to the Button */
    button.addEventListener("click", e -> msgbox("Button clicked programatically"));
    
    /* Clicks the button, and stores the result in a Pending result. This then displays a
    message box when it resolves. */
    PendingResult<Object> result = button.callJsFunctionAsync("click");
    result.thenAccept( e -> msgbox("Will display after clicking button."));
  }
}