package componentdemos.labeldemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.window.Frame;
import com.webforj.component.button.Button;
import com.webforj.component.text.Label;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/labelstyles/wrap_styles.css")
public class LabelLineWrap extends App {
  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    Label l1 = new Label(
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation"
            +
            "ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit "
            +
            "esse cillum dolore eu fugiat nulla pariatur.");
    l1.setWidth("50vw");
    l1.setStyle("border", "1px solid black");
    l1.setWrap(true);
    Button wrap = new Button("Toggle Line Wrapping");
    wrap.onClick(e -> {
        l1.setWrap(!l1.isWrap());
      });
    window.add(l1,wrap);
  }
}
