package componentdemos.labeldemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.button.Button;
import org.dwcj.component.texts.Label;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/labelstyles/wrap_styles.css")
public class LabelLineWrap extends App {
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    Label l1 = new Label(
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation"
            +
            "ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit "
            +
            "esse cillum dolore eu fugiat nulla pariatur.");
    l1.setStyle("width", "50vw");
    l1.setStyle("border", "1px solid black");
    l1.setWrap(true);
    Button wrap = new Button("Toggle Line Wrapping")
      .onClick(e -> {
        l1.setWrap(!l1.isWrap());
      });
    window.add(l1,wrap);
  }
}
