package component_demos.textareademos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.textarea.TextArea;
import org.dwcj.exceptions.DwcjAppInitializeException;

@InlineStyleSheet("context://css/textareastyles/text_area_styles.css")
public class TextAreaPlaceholder extends App {
  @Override
  public void run() throws DwcjAppInitializeException {
    Frame panel = new Frame();
    panel.addClassName("Frame");

    TextArea t1 = new TextArea().setAttribute("placeholder", "Example Placeholder");
    panel.add(t1);
  }
}
