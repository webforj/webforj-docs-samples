package control_demos.textareademos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.textarea.TextArea;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/textareastyles/text_area_styles.css")
public class TextAreaSpellcheck extends App {
  @Override
  public void run() throws DwcjException {
    Frame panel = new Frame();
    panel.addClassName("Frame");

    TextArea t1 = new TextArea().setAttribute("spellcheck", "true")
        .setAttribute("placeholder", "Enter misspelled text");

    panel.add(t1);
  }
}
