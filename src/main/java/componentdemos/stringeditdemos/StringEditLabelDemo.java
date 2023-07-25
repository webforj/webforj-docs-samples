package componentdemos.stringeditdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.maskedtextfield.MaskedTextField;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/stringeditboxstyles/string_edit_styles.css")
public class StringEditLabelDemo extends App {
  @Override
  public void run() throws DwcjException {
    Frame panel = new Frame();
    panel.addClassName("Frame");

    panel.add(new MaskedTextField().setAttribute("label", "Example Label"));
  }
}