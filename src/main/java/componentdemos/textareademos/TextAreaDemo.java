package componentdemos.textareademos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.textarea.TextArea;
import org.dwcj.exceptions.DwcjAppInitializeException;

@InlineStyleSheet("context://css/textareastyles/text_area_styles.css")
public class TextAreaDemo extends App {

    @Override
    public void run() throws DwcjAppInitializeException {

        Frame window = new Frame();
        window.addClassName("Frame");
        TextArea t1 = new TextArea();
        window.add(t1);
    }
}
