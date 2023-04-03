package control_demos.textboxdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.textfield.TextField;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/textboxstyles/text_box_styles.css")
public class TextBoxExpanses extends App {
  @Override
  public void run() throws DwcjException {
    Frame panel = new Frame();
    panel.addClassName("Frame");

    TextField t1 = new TextField().setExpanse(TextField.Expanse.XSMALL)
      .setAttribute("placeholder", "XSMALL");

    TextField t2 = new TextField().setExpanse(TextField.Expanse.SMALL)
      .setAttribute("placeholder", "SMALL");

    TextField t3 = new TextField().setExpanse(TextField.Expanse.MEDIUM)
      .setAttribute("placeholder", "MEDIUM");

    TextField t4 = new TextField().setExpanse(TextField.Expanse.LARGE)
      .setAttribute("placeholder", "LARGE");

    TextField t5 = new TextField().setExpanse(TextField.Expanse.XLARGE)
      .setAttribute("placeholder", "XLARGE");

    panel.add(t1, t2, t3, t4, t5);
  }
}
