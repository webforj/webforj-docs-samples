package componentdemos.stringeditdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.maskedtextfield.MaskedTextField;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/stringeditboxstyles/string_edit_styles.css")
public class StringEditPlaceholder extends App {
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    window.add(
        new MaskedTextField().setAttribute("placeholder", "Example Placeholder")
            .setExpanse(MaskedTextField.Expanse.LARGE));
  }
}
