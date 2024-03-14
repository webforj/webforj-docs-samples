package componentdemos.stringeditdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;
import com.webforj.component.maskedtextfield.MaskedTextField;

@InlineStyleSheet("context://css/stringeditboxstyles/string_edit_styles.css")
public class StringEditExpanse extends App {
  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("Frame")
        .setStyle("display", "flex");

    MaskedTextField s1 = new MaskedTextField().setExpanse(MaskedTextField.Expanse.XSMALL)
        .setAttribute("placeholder", "XSMALL");

    MaskedTextField s2 = new MaskedTextField().setExpanse(MaskedTextField.Expanse.SMALL)
        .setAttribute("placeholder", "SMALL");

    MaskedTextField s3 = new MaskedTextField().setExpanse(MaskedTextField.Expanse.MEDIUM)
        .setAttribute("placeholder", "MEDIUM");

    MaskedTextField s4 = new MaskedTextField().setExpanse(MaskedTextField.Expanse.LARGE)
        .setAttribute("placeholder", "LARGE");

    MaskedTextField s5 = new MaskedTextField().setExpanse(MaskedTextField.Expanse.XLARGE)
        .setAttribute("placeholder", "XLARGE");

    window.add(s1, s2, s3, s4, s5);
  }
}
