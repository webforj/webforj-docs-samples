package control_demos.comboboxdemos;

import java.util.HashMap;
import java.util.Map;

import org.dwcj.App;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.combobox.ComboBox;
import org.dwcj.exceptions.DwcAppInitializeException;


public class ComboboxLabelDemo extends App{

    @Override
    public void run() throws DwcAppInitializeException {


        AppPanel panel = new AppPanel();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("grid-template-columns", "1fr");
        panel.setStyle("padding", "10px");
        panel.setStyle("gap", "50px");

        ComboBox cb1 = new ComboBox();

        Map<Object, String> data = new HashMap<>();
        data.put("Random Data1", "Random Data");
        data.put("Random Data2", "Some Data");
        data.put("Random Data3", "More Data");
        data.put("Random Data4", "Test Data");

        
        panel.add(cb1);
        
        cb1.setItems(data);
        cb1.selectIndex(0);
        cb1.setAttribute("label", "Example label");

    }

}
