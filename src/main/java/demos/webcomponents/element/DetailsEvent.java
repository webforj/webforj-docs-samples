package demos.webcomponents.element;

import org.dwcj.App;
import org.dwcj.component.element.Element;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

public class DetailsEvent extends App {
  
  Element details = new Element("details");

  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.setStyle("margin", "20px");
    window.add(details);

    details.addEventListener("toggle", e -> msgbox("Details Toggled!"));
  }
}