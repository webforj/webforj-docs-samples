package componentdemos.checkboxdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.TextPosition.Position;
import org.dwcj.component.optioninput.CheckBox;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/checkboxstyles/text_styles.css")
public class CheckboxHorizontalText extends App {
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    panel.addClassName("Frame");

    CheckBox cb1 = new CheckBox().setText("Right aligned (default)");
    CheckBox cb2 = new CheckBox().setText("Left aligned").setTextPosition(Position.LEFT);

    panel.add(cb1, cb2);
  }
}
