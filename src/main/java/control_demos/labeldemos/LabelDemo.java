package control_demos.labeldemos;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.label.Label;
import org.dwcj.exceptions.DwcException;

@InlineStyleSheet("context://css/labelstyles/text_styles.css")
public class LabelDemo extends App {
  @Override
  public void run() throws DwcException {
    AppPanel panel = new AppPanel();
    panel.addClassName("appPanel");

    Label l1 = new Label("This is a Label component, which renders as static text on a webpage");
    Label l2 = new Label("Below is an example of an HTML ordered list rendered  using a Label: ");
    Label l3 = new Label("<html><ol><li>My First Item</li><li>My Second Item</li><li>My Third Item</li></ol><html>");

    panel.add(l1, l2, l3);
  }
}
