package componentdemos.stringeditdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;
import org.dwcj.component.maskedtextfield.MaskedTextField;

@InlineStyleSheet("context://css/stringeditboxstyles/string_edit_styles.css")
public class StringEditExpanse extends App {
  @Override
  public void run() throws DwcjException {
    Frame panel = new Frame();
    panel.addClassName("Frame")
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

    panel.add(s1, s2, s3, s4, s5);
  }
}
