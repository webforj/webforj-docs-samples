package control_demos.comboboxdemos;

import java.util.HashMap;
import java.util.Map;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.panels.Div;
import org.dwcj.controls.combobox.ComboBox;
import org.dwcj.exceptions.DwcAppInitializeException;

@InlineStyleSheet("context://css/comboboxstyles/label_styles.css")

public class ComboboxLabelDemo extends App{

    @Override
    public void run() throws DwcAppInitializeException {


        AppPanel panel = new AppPanel();
        panel.addClassName("appPanel");

        ComboBox cb1 = new ComboBox();
        Div container = new Div().addClassName("container");
        panel.add(container);

        Map<Object, String> data = new HashMap<>();
        data.put("Random Data1", "Random Data");
        data.put("Random Data2", "Some Data");
        data.put("Random Data3", "More Data");
        data.put("Random Data4", "Test Data");

        
        container.add(cb1);
        
        cb1.setItems(data).selectIndex(0).setAttribute("label", "Example label");

    }

}
