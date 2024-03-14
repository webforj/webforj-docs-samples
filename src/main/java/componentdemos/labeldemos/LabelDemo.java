package componentdemos.labeldemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.window.Frame;
import com.webforj.component.text.Label;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/labelstyles/text_styles.css")
public class LabelDemo extends App {
  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    Label l1 = new Label("This is a Label component, which renders as static text on a webpage");
    Label l2 = new Label("Below is an example of an HTML ordered list rendered  using a Label: ");
    Label l3 = new Label("<html><ol><li>My First Item</li><li>My Second Item</li><li>My Third Item</li></ol><html>");

    window.add(l1, l2, l3);
  }
}
