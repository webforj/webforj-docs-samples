package control_demos.stringeditdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;
import org.dwcj.component.textfield.TextField;

@InlineStyleSheet("context://css/stringeditboxstyles/string_edit_styles.css")
public class StringEditExpanse extends App {
  @Override
  public void run() throws DwcjException {
    Frame panel = new Frame();
    panel.addClassName("Frame")
    .setStyle("display", "flex");

    TextField s1 = new TextField().setExpanse(TextField.Expanse.XSMALL)
      .setAttribute("placeholder", "XSMALL");

    TextField s2 = new TextField().setExpanse(TextField.Expanse.SMALL)
      .setAttribute("placeholder", "SMALL");

    TextField s3 = new TextField().setExpanse(TextField.Expanse.MEDIUM)
      .setAttribute("placeholder", "MEDIUM");

    TextField s4 = new TextField().setExpanse(TextField.Expanse.LARGE)
      .setAttribute("placeholder", "LARGE");

    TextField s5 = new TextField().setExpanse(TextField.Expanse.XLARGE)
      .setAttribute("placeholder", "XLARGE");

    panel.add(s1, s2, s3, s4, s5);
  }
}
