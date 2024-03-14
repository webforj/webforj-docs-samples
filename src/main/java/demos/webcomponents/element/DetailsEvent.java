package demos.webcomponents.element;

import com.webforj.App;
import com.webforj.component.element.Element;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class DetailsEvent extends App {
  
  Element details = new Element("details");

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.setStyle("margin", "20px");
    window.add(details);

    details.addEventListener("toggle", e -> msgbox("Details Toggled!"));
  }
}