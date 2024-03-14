package demos.webcomponents.element;

import com.webforj.App;
import com.webforj.component.element.Element;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class DetailsSlots extends App {
  
  Element details = new Element("details");
  Element secondDetails = new Element("details");
  Element summary = new Element("summary", "First Details Title");

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.setStyle("margin", "20px");
    window.add(details, secondDetails);

    /* Method 1: Setting text using setText() and add()*/
    details.add(summary); // Adds a summary element to the text already present inside the details element
    details.setText("Expanded text for the first summary."); // Sets the content inside the details element

    /* Method 2: Injecting pure HTML into the element*/
    secondDetails.setHtml("""
      <summary>Second Details Title</summary>
      Expanded text for the second summary.
    """);
  }
}