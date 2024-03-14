package demos.webcomponents.element;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.element.Element;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet(/* css */"""
  details {
    border: 1px solid #aaa;
    border-radius: 4px;
    padding: 0.5em 0.5em 0;
  }
  
  summary {
    font-weight: bold;
    margin: -0.5em -0.5em 0;
    padding: 0.5em;
  }
  
  details[open] {
    padding: 0.5em;
  }
  
  details[open] summary {
    border-bottom: 1px solid #aaa;
    margin-bottom: 0.5em;
  }
""")
public class DetailsConstructor extends App {
  
  Element details = new Element("details");

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.setStyle("margin", "20px");
    window.add(details);
    details.setHtml("<summary>Something small enough to escape casual notice.</summary>");
  }
}