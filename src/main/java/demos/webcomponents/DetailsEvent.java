package demos.webcomponents;

import org.dwcj.App;
import org.dwcj.component.element.Element;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

public class DetailsEvent extends App {
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.setStyle("margin", "20px");

    Element details = new Element("details");
    details.addEventListener("toggle", e -> msgbox("Details Toggled!"));
    window.add(details);
  }
  
}