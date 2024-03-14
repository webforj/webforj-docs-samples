package componentdemos.textareademos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.window.Frame;
import com.webforj.component.textarea.TextArea;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/textareastyles/text_area_styles.css")
public class TextAreaLabel extends App {
  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("Frame");
    window.add(new TextArea().setAttribute("label", "Example Label"));
  }
}
