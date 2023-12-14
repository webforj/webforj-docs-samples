package demos.webcomponents;

import org.dwcj.App;
import org.dwcj.component.element.Element;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

public class ButtonFunction extends App {
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.setStyle("margin", "20px");

    Element button = new Element("button", "Button");
    button.addEventListener("click", e -> msgbox("Button Clicked Programatically"));
    window.add(button);

    button.callJsFunctionAsync("click");
  }
}