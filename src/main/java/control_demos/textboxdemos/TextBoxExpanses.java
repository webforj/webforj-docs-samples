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
    panel.addClassName("Frame")
        .setStyle("display", "grid");

    TextField t1 = new TextField().setExpanse(TextField.Expanse.XSMALL)
        .setAttribute("placeholder", "XSMALL")
        .setStyle("grid-column", "1");

    TextField t2 = new TextField().setExpanse(TextField.Expanse.SMALL)
        .setAttribute("placeholder", "SMALL")
        .setStyle("grid-column", "2");

    TextField t3 = new TextField().setExpanse(TextField.Expanse.MEDIUM)
        .setAttribute("placeholder", "MEDIUM")
        .setStyle("grid-column", "3");

    TextField t4 = new TextField().setExpanse(TextField.Expanse.LARGE)
        .setAttribute("placeholder", "LARGE")
        .setStyle("grid-column", "1");

    TextField t5 = new TextField().setExpanse(TextField.Expanse.XLARGE)
        .setAttribute("placeholder", "XLARGE")
        .setStyle("grid-column", "3");

    panel.add(t1, t2, t3, t4, t5);
  }
}
