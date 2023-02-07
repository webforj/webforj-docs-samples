package control_demos.checkboxdemos;

import org.dwcj.App;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.checkbox.CheckBox;
import org.dwcj.exceptions.DwcAppInitializeException;


public class CheckboxHorizontalText extends App{

    @Override
    public void run() throws DwcAppInitializeException {


        AppPanel panel = new AppPanel();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("grid-template-columns", "1fr");
        panel.setStyle("padding", "10px");
        panel.setStyle("gap", "50px");

        CheckBox cb1 = new CheckBox();
        CheckBox cb2 = new CheckBox();

        cb2.setHorizontalTextPosition(CheckBox.HorizontalTextPosition.LEFT);

        cb1.setText("Right aligned (default)");
        cb2.setText("Left aligned");

        panel.add(cb1,cb2);

    }

}
