package control_demos.listboxdemos;

import java.util.HashMap;
import java.util.Map;

import org.dwcj.App;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.listbox.ListBox;
import org.dwcj.exceptions.DwcAppInitializeException;


public class ListboxExpanses extends App{

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("grid-template-columns", "1fr 1fr 1fr 1fr 1fr");
        panel.setStyle("padding", "10px");
        panel.setStyle("gap", "50px");
        
        ListBox l1 = new ListBox().setExpanse(ListBox.Expanse.XSMALL);
        ListBox l2 = new ListBox().setExpanse(ListBox.Expanse.SMALL);
        ListBox l3 = new ListBox().setExpanse(ListBox.Expanse.MEDIUM);
        ListBox l4 = new ListBox().setExpanse(ListBox.Expanse.LARGE);
        ListBox l5 = new ListBox().setExpanse(ListBox.Expanse.XLARGE);

        Map<Object, String> data = new HashMap<>();
        data.put("Random Data1", "Random Data");
        data.put("Random Data2", "Some Data");
        data.put("Random Data3", "More Data");
        data.put("Random Data4", "Test Data");

        panel.add(l1,l2,l3,l4,l5);

        l1.setItems(data);
        l1.setAttribute("label", "Extra Small:").setStyle("grid-column", "1");
        l2.setItems(data);
        l2.setAttribute("label", "Small:").setStyle("grid-column", "2");
        l3.setItems(data);
        l3.setAttribute("label", "Medium:").setStyle("grid-column", "3");
        l4.setItems(data);
        l4.setAttribute("label", "Large").setStyle("grid-column", "4");
        l5.setItems(data);
        l5.setAttribute("label", "Extra Large:").setStyle("grid-column", "5");
        // l1.setMultipleSelection(true);


    }
    
}