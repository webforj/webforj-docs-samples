package componentdemos.textboxdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.window.Frame;
import com.webforj.component.Expanse;
import com.webforj.component.field.TextField;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/textboxstyles/text_box_styles.css")
public class TextBoxExpanses extends App {
  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("Frame")
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

    window.add(t1, t2, t3, t4, t5);
  }
}
