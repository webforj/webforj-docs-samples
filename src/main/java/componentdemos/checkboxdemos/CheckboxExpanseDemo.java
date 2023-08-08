package componentdemos.checkboxdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.Expanse;
import org.dwcj.component.optioninput.CheckBox;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/checkboxstyles/expanse_styles.css")
public class CheckboxExpanseDemo extends App {
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    for (int i = Expanse.values().length - 1; i >= 0; i--) {
      CheckBox expanseCheckBox = new CheckBox(Expanse.values()[i].name());
      window.add(expanseCheckBox.setExpanse(Expanse.values()[i]));
    }

  }
}
