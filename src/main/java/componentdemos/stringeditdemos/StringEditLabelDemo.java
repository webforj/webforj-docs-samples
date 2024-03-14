package componentdemos.stringeditdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.window.Frame;
import com.webforj.component.maskedtextfield.MaskedTextField;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/stringeditboxstyles/string_edit_styles.css")
public class StringEditLabelDemo extends App {
  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    window.add(new MaskedTextField().setAttribute("label", "Example Label"));
  }
}
