package control_demos.comboboxdemos;

import java.util.HashMap;
import java.util.Map;

import org.dwcj.App;
import org.dwcj.controls.panels.Div;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.textbox.TextBox;
import org.dwcj.controls.combobox.ComboBox;
import org.dwcj.exceptions.DwcAppInitializeException;


public class ComboboxExpanseDemo extends App{

    @Override
    public void run() throws DwcAppInitializeException {


        AppPanel panel = new AppPanel();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("grid-template-columns", "1fr 1fr 1fr 1fr 1fr");
        panel.setStyle("padding", "10px");
        panel.setStyle("gap", "50px");

        ComboBox cb1 = new ComboBox();
        ComboBox cb2 = new ComboBox();
        ComboBox cb3 = new ComboBox();
        ComboBox cb4 = new ComboBox();
        ComboBox cb5 = new ComboBox();

        cb1.setExpanse(ComboBox.Expanse.XSMALL);
        cb2.setExpanse(ComboBox.Expanse.SMALL);
        cb3.setExpanse(ComboBox.Expanse.MEDIUM);
        cb4.setExpanse(ComboBox.Expanse.LARGE);
        cb5.setExpanse(ComboBox.Expanse.XLARGE);

        Map<Object, String> data = new HashMap<>();
        data.put("Random Data1", "Random Data");
        data.put("Random Data2", "Some Data");
        data.put("Random Data3", "More Data");
        data.put("Random Data4", "Test Data");

        
        cb1.setText("Extra Small").setStyle("grid-column", "1");
        cb2.setText("Small").setStyle("grid-column", "2");
        cb3.setText("Medium").setStyle("grid-column", "3");
        cb4.setText("Large").setStyle("grid-column", "4");
        cb5.setText("Extra Large").setStyle("grid-column", "5");

        panel.add(cb1, cb2, cb3, cb4, cb5);

    }

}
