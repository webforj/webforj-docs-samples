package control_demos.checkboxdemos;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.checkbox.CheckBox;
import org.dwcj.exceptions.DwcAppInitializeException;

@InlineStyleSheet(value = "css/checkboxstyles/text_styles.css", local = true)


public class CheckboxHorizontalText extends App{

    @Override
    public void run() throws DwcAppInitializeException {


        AppPanel panel = new AppPanel();
        panel.addClassName("appPanel");

        CheckBox cb1 = new CheckBox().setText("Right aligned (default)");
        CheckBox cb2 = new CheckBox().setText("Left aligned").setHorizontalTextPosition(CheckBox.HorizontalTextPosition.LEFT);

        panel.add(cb1,cb2);

    }

}
