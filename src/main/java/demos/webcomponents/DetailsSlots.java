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

    Element summary = new Element("summary", "First Details Title");
    details.setText("Expanded text for the first summary."); // Sets the content inside the details element
    details.add(summary); // Adds a summary element to the text already present inside the details element

    Element secondDetails = new Element("details");
    window.add(secondDetails);

    secondDetails.setHtml("""
      <summary>Second Details Title</summary>
      Expanded text for the second summary.
    """);
  }
}