package control_demos.stringeditdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.textfield.TextField;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjAppInitializeException;



@InlineStyleSheet("context://css/TextFieldstyles/string_edit_styles.css")
public class StringEditDemo extends App{

    @Override
    public void run() throws DwcjAppInitializeException {

        Frame panel = new Frame();
        panel.addClassName("Frame");

        TextField s1 = new TextField();
        panel.add(s1);
    }

}
