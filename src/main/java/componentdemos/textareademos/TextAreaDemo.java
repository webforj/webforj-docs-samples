package componentdemos.textareademos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.window.Frame;
import com.webforj.component.textarea.TextArea;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/textareastyles/text_area_styles.css")
public class TextAreaDemo extends App {

    @Override
    public void run() throws WebforjException {

        Frame window = new Frame();
        window.addClassName("Frame");
        TextArea t1 = new TextArea();
        window.add(t1);
    }
}
