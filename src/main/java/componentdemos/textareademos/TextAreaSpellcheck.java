package componentdemos.textareademos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.field.TextArea;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/textareastyles/text_area_styles.css")
public class TextAreaSpellcheck extends App {
  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    TextArea t1 = new TextArea().setSpellCheck(true)
        .setPlaceholder("Enter misspelled text");

    window.add(t1);
  }
}
