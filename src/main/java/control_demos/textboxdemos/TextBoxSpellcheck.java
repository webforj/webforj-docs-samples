package control_demos.textboxdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.textfield.TextField;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/textboxstyles/text_box_styles.css")
public class TextBoxSpellcheck extends App {
  @Override
  public void run() throws DwcjException {
    Frame panel = new Frame();
    panel.addClassName("Frame");

    TextField t1 = new TextField().setAttribute("spellcheck", "true")
      .setAttribute("placeholder", "Enter misspelled text");

    panel.add(t1);
  }
}
