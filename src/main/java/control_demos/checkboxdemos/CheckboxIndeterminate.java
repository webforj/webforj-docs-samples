package control_demos.checkboxdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.optioninput.CheckBox;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/checkboxstyles/text_styles.css")
public class CheckboxIndeterminate extends App {
  @Override
  public void run() throws DwcjException {
    Frame panel = new Frame();
    panel.addClassName("Frame");

    CheckBox cb1 = new CheckBox().setText("Checked").setChecked(true);
    CheckBox cb2 = new CheckBox().setText("Unchecked").setChecked(false);
    CheckBox cb3 = new CheckBox().setText("Indeterminate").setIndeterminate(true);

    panel.add(cb1, cb2, cb3);
  }
}
