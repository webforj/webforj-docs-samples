package control_demos.checkboxdemos;

import org.dwcj.App;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.checkbox.CheckBox;
import org.dwcj.exceptions.DwcAppInitializeException;


public class CheckboxExpanseDemo extends App{

    @Override
    public void run() throws DwcAppInitializeException {


        AppPanel panel = new AppPanel();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("grid-template-columns", "1fr 1fr 1fr 1fr 1fr");
        panel.setStyle("padding", "10px");
        panel.setStyle("gap", "50px");

        CheckBox cb1 = new CheckBox();
        CheckBox cb2 = new CheckBox();
        CheckBox cb3 = new CheckBox();
        CheckBox cb4 = new CheckBox();
        CheckBox cb5 = new CheckBox();

        cb1.setExpanse(CheckBox.Expanse.XSMALL);
        cb2.setExpanse(CheckBox.Expanse.SMALL);
        cb3.setExpanse(CheckBox.Expanse.MEDIUM);
        cb4.setExpanse(CheckBox.Expanse.LARGE);
        cb5.setExpanse(CheckBox.Expanse.XLARGE);


        cb1.setText("Extra Small").setStyle("grid-column", "1");
        cb2.setText("Small").setStyle("grid-column", "2");
        cb3.setText("Medium").setStyle("grid-column", "3");
        cb4.setText("Large").setStyle("grid-column", "4");
        cb5.setText("Extra Large").setStyle("grid-column", "5");

        panel.add(cb1, cb2, cb3, cb4, cb5);

    }

}
