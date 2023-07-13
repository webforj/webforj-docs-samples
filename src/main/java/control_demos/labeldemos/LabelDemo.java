package control_demos.labeldemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.texts.Label;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/labelstyles/text_styles.css")
public class LabelDemo extends App {
  @Override
  public void run() throws DwcjException {
    Frame panel = new Frame();
    panel.addClassName("Frame");

    Label l1 = new Label("This is a Label component, which renders as static text on a webpage");
    Label l2 = new Label("Below is an example of an HTML ordered list rendered  using a Label: ");
    Label l3 = new Label("<html><ol><li>My First Item</li><li>My Second Item</li><li>My Third Item</li></ol><html>");

    panel.add(l1, l2, l3);
  }
}
