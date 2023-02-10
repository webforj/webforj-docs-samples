package control_demos.comboboxdemos;

import java.util.HashMap;
import java.util.Map;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.combobox.ComboBox;
import org.dwcj.exceptions.DwcAppInitializeException;

@InlineStyleSheet(value = "css/comboboxstyles/expanse_styles.css", local = true)

public class ComboboxExpanseDemo extends App{

    @Override
    public void run() throws DwcAppInitializeException {


        AppPanel panel = new AppPanel();
        panel.addClassName("appPanel");

        ComboBox cb1 = new ComboBox().setExpanse(ComboBox.Expanse.XSMALL).setText("Extra Small").setStyle("grid-column", "1");
        ComboBox cb2 = new ComboBox().setExpanse(ComboBox.Expanse.SMALL).setText("Small").setStyle("grid-column", "2");
        ComboBox cb3 = new ComboBox().setExpanse(ComboBox.Expanse.MEDIUM).setText("Medium").setStyle("grid-column", "3");
        ComboBox cb4 = new ComboBox().setExpanse(ComboBox.Expanse.LARGE).setText("Large").setStyle("grid-column", "4");
        ComboBox cb5 = new ComboBox().setExpanse(ComboBox.Expanse.XLARGE).setText("Extra Large").setStyle("grid-column", "5");

        Map<Object, String> data = new HashMap<>();
        data.put("Random Data1", "Random Data");
        data.put("Random Data2", "Some Data");
        data.put("Random Data3", "More Data");
        data.put("Random Data4", "Test Data");

        panel.add(cb1, cb2, cb3, cb4, cb5);

    }

}
