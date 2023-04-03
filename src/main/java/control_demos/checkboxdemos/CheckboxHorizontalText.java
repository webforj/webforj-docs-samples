package control_demos.checkboxdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.checkbox.CheckBox;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/checkboxstyles/text_styles.css")
public class CheckboxHorizontalText extends App {
  @Override
  public void run() throws DwcjException {
    Frame panel = new Frame();
    panel.addClassName("Frame");

    CheckBox cb1 = new CheckBox().setText("Right aligned (default)");
    CheckBox cb2 = new CheckBox().setText("Left aligned")
        .setHorizontalTextPosition(CheckBox.HorizontalTextPosition.LEFT);

    panel.add(cb1, cb2);
  }
}
