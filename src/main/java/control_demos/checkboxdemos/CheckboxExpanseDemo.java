package control_demos.checkboxdemos;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.checkbox.CheckBox;
import org.dwcj.exceptions.DwcException;

@InlineStyleSheet("context://css/checkboxstyles/expanse_styles.css")
public class CheckboxExpanseDemo extends App {
  @Override
  public void run() throws DwcException {
    AppPanel panel = new AppPanel();
    panel.addClassName("appPanel");

    CheckBox cb1 = new CheckBox()
      .setExpanse(CheckBox.Expanse.XSMALL)
      .setText("Extra Small");

    CheckBox cb2 = new CheckBox()
      .setExpanse(CheckBox.Expanse.SMALL)
      .setText("Small");

    CheckBox cb3 = new CheckBox()
      .setExpanse(CheckBox.Expanse.MEDIUM)
      .setText("Medium");

    CheckBox cb4 = new CheckBox()
      .setExpanse(CheckBox.Expanse.LARGE)
      .setText("Large");

    CheckBox cb5 = new CheckBox()
      .setExpanse(CheckBox.Expanse.XLARGE)
      .setText("Extra Large");

    panel.add(cb1, cb2, cb3, cb4, cb5);
  }
}
