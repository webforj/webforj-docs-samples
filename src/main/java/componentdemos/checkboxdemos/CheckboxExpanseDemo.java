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
    panel.addClassName("Frame");

    CheckBox cb1 = new CheckBox()
        .setExpanse(Expanse.XSMALL)
        .setText("Extra Small");

    CheckBox cb2 = new CheckBox()
        .setExpanse(Expanse.SMALL)
        .setText("Small");

    CheckBox cb3 = new CheckBox()
        .setExpanse(Expanse.MEDIUM)
        .setText("Medium");

    CheckBox cb4 = new CheckBox()
        .setExpanse(Expanse.LARGE)
        .setText("Large");

    CheckBox cb5 = new CheckBox()
        .setExpanse(Expanse.XLARGE)
        .setText("Extra Large");

    panel.add(cb1, cb2, cb3, cb4, cb5);
  }
}
