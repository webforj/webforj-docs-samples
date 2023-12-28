package demos.webcomponents.element;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.element.Element;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

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
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.setStyle("margin", "20px");
    window.add(details);
    details.setHtml("<summary>Something small enough to escape casual notice.</summary>");
  }
}