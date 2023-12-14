package demos.webcomponents;

import org.dwcj.App;
import org.dwcj.component.element.Element;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

public class DetailsSlots extends App {
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.setStyle("margin", "20px");

    Element details = new Element("details");
    window.add(details);

    Element summary = new Element("summary", "Details Title");
    details.setHtml("Something small enough to escape casual notice."); // Sets the text to be displayed when expanded
    details.add(summary); // Sets the title of the details element
  }
}