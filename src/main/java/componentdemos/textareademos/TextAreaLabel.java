package componentdemos.textareademos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.textarea.TextArea;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/textareastyles/text_area_styles.css")
public class TextAreaLabel extends App {
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    panel.addClassName("Frame");
    panel.add(new TextArea().setAttribute("label", "Example Label"));
  }
}
