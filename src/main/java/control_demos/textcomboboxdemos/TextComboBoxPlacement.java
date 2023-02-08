package control_demos.textcomboboxdemos;

import java.util.HashMap;
import java.util.Map;

import org.dwcj.App;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.textcombobox.TextComboBox;
import org.dwcj.exceptions.DwcAppInitializeException;



public class TextComboBoxPlacement extends App{

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.setStyle("display", "flex");
        panel.setStyle("justify-content", "center");
        panel.setStyle("align-items", "center");
        panel.setStyle("padding", "10px");
        panel.setStyle("gap", "50px");
        panel.setStyle("height", "100%");


        Map<Object, String> data = new HashMap<>();
        data.put("Random Data1", "Random Data");
        data.put("Random Data2", "Some Data");
        data.put("Random Data3", "More Data");
        data.put("Random Data4", "Test Data");
        

        TextComboBox tcb1 = new TextComboBox().setAttribute("placement", "left").setAttribute("placeholder", "Left Menu Placement");
        TextComboBox tcb2 = new TextComboBox().setAttribute("placement", "right").setAttribute("placeholder", "Right Menu Placement");
        TextComboBox tcb3 = new TextComboBox().setAttribute("placement", "top").setAttribute("placeholder", "Top Menu Placement");
        TextComboBox tcb4 = new TextComboBox().setAttribute("placement", "bottom").setAttribute("placeholder", "Bottom Menu Placement");

        panel.add(tcb1, tcb2, tcb3, tcb4);   
        tcb1.setItems(data); 
        tcb2.setItems(data); 
        tcb3.setItems(data); 
        tcb4.setItems(data); 

    }
    
}
    