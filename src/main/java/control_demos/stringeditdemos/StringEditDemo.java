package control_demos.stringeditdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.maskedtextfield.MaskedTextField;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjAppInitializeException;

@InlineStyleSheet("context://css/stringeditboxstyles/string_edit_styles.css")
public class StringEditDemo extends App {

    @Override
    public void run() throws DwcjAppInitializeException {

        Frame panel = new Frame();
        panel.addClassName("Frame");

        MaskedTextField s1 = new MaskedTextField();
        panel.add(s1);
    }

}
