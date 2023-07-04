package control_demos.textboxdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.field.Field;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/textboxstyles/text_box_styles.css")
public class TextBoxExpanses extends App {
  @Override
  public void run() throws DwcjException {
    Frame panel = new Frame();
    panel.addClassName("Frame")
        .setStyle("display", "grid");

    Field t1 = new Field().setExpanse(Field.Expanse.XSMALL)
        .setAttribute("placeholder", "XSMALL")
        .setStyle("grid-column", "1");

    Field t2 = new Field().setExpanse(Field.Expanse.SMALL)
        .setAttribute("placeholder", "SMALL")
        .setStyle("grid-column", "2");

    Field t3 = new Field().setExpanse(Field.Expanse.MEDIUM)
        .setAttribute("placeholder", "MEDIUM")
        .setStyle("grid-column", "3");

    Field t4 = new Field().setExpanse(Field.Expanse.LARGE)
        .setAttribute("placeholder", "LARGE")
        .setStyle("grid-column", "1");

    Field t5 = new Field().setExpanse(Field.Expanse.XLARGE)
        .setAttribute("placeholder", "XLARGE")
        .setStyle("grid-column", "3");

    panel.add(t1, t2, t3, t4, t5);
  }
}
