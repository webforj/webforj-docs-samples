package componentdemos.textareademos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;
import com.webforj.component.window.Panel;
import com.webforj.component.textarea.TextArea;

@InlineStyleSheet("context://css/textareastyles/text_area_styles.css")
public class TextAreaExpanse extends App {
  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("Frame")
        .setStyle("display", "flex");

    Panel wrapper = new Panel();

    TextArea t1 = new TextArea().setExpanse(TextArea.Expanse.XSMALL)
        .setAttribute("placeholder", "XSMALL");

    TextArea t2 = new TextArea().setExpanse(TextArea.Expanse.SMALL)
        .setAttribute("placeholder", "SMALL");

    TextArea t3 = new TextArea().setExpanse(TextArea.Expanse.MEDIUM)
        .setAttribute("placeholder", "MEDIUM");

    TextArea t4 = new TextArea().setExpanse(TextArea.Expanse.LARGE)
        .setAttribute("placeholder", "LARGE");

    TextArea t5 = new TextArea().setExpanse(TextArea.Expanse.XLARGE)
        .setAttribute("placeholder", "XLARGE");

    window.add(wrapper);
    wrapper.add(t1, t2, t3, t4, t5);
  }
}
