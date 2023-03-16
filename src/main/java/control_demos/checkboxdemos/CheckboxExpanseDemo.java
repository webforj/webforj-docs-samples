package control_demos.checkboxdemos;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.checkbox.CheckBox;
import org.dwcj.exceptions.DwcAppInitializeException;

@InlineStyleSheet("context://css/checkboxstyles/expanse_styles.css")

public class CheckboxExpanseDemo extends App{

    @Override
    public void run() throws DwcAppInitializeException {


        AppPanel panel = new AppPanel();
        panel.addClassName("appPanel");

        // panel.setStyle("display", "inline-grid");
        // panel.setStyle("grid-template-columns", "1fr 1fr 1fr 1fr 1fr");
        // panel.setStyle("padding", "10px");
        // panel.setStyle("gap", "50px");

        CheckBox cb1 = new CheckBox().setExpanse(CheckBox.Expanse.XSMALL).setText("Extra Small");
        CheckBox cb2 = new CheckBox().setExpanse(CheckBox.Expanse.SMALL).setText("Small");
        CheckBox cb3 = new CheckBox().setExpanse(CheckBox.Expanse.MEDIUM).setText("Medium");
        CheckBox cb4 = new CheckBox().setExpanse(CheckBox.Expanse.LARGE).setText("Large");
        CheckBox cb5 = new CheckBox().setExpanse(CheckBox.Expanse.XLARGE).setText("Extra Large");

        panel.add(cb1, cb2, cb3, cb4, cb5);

    }

}
