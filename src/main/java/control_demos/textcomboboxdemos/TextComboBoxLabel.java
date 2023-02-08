package control_demos.textcomboboxdemos;

import java.util.HashMap;
import java.util.Map;

import org.dwcj.App;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.textcombobox.TextComboBox;
import org.dwcj.exceptions.DwcAppInitializeException;



public class TextComboBoxLabel extends App{

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("grid-template-columns", "1fr");
        panel.setStyle("padding", "10px");
        panel.setStyle("gap", "50px");

        Map<Object, String> data = new HashMap<>();
        data.put("Random Data1", "Random Data");
        data.put("Random Data2", "Some Data");
        data.put("Random Data3", "More Data");
        data.put("Random Data4", "Test Data");
        

        TextComboBox tcb1 = new TextComboBox().setAttribute("label", "Example Label");

        panel.add(tcb1);   
        tcb1.setItems(data); 

    }
    
}
    