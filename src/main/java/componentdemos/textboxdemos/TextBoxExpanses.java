package componentdemos.textboxdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.Expanse;
import org.dwcj.component.field.TextField;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/textboxstyles/text_box_styles.css")
public class TextBoxExpanses extends App {
  @Override
  public void run() throws DwcjException {
    Frame panel = new Frame();
    panel.addClassName("Frame")
        .setStyle("display", "grid");

    TextField t1 = new TextField().setExpanse(Expanse.XSMALL)
        .setAttribute("placeholder", "XSMALL")
        .setStyle("grid-column", "1");

    TextField t2 = new TextField().setExpanse(Expanse.SMALL)
        .setAttribute("placeholder", "SMALL")
        .setStyle("grid-column", "2");

    TextField t3 = new TextField().setExpanse(Expanse.MEDIUM)
        .setAttribute("placeholder", "MEDIUM")
        .setStyle("grid-column", "3");

    TextField t4 = new TextField().setExpanse(Expanse.LARGE)
        .setAttribute("placeholder", "LARGE")
        .setStyle("grid-column", "1");

    TextField t5 = new TextField().setExpanse(Expanse.XLARGE)
        .setAttribute("placeholder", "XLARGE")
        .setStyle("grid-column", "3");

    panel.add(t1, t2, t3, t4, t5);
  }
}
