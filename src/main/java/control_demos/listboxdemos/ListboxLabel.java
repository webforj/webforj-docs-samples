package control_demos.listboxdemos;

import java.util.HashMap;
import java.util.Map;

import org.dwcj.App;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.listbox.ListBox;
import org.dwcj.exceptions.DwcAppInitializeException;
import org.dwcj.interfaces.TextAlignable;


public class ListboxLabel extends App{

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("grid-template-columns", "1fr");
        panel.setStyle("padding", "10px");
        panel.setStyle("gap", "50px");
        
        ListBox l1 = new ListBox();

        Map<Object, String> data = new HashMap<>();
        data.put("Random Data1", "Random Data");
        data.put("Random Data2", "Some Data");
        data.put("Random Data3", "More Data");
        data.put("Random Data4", "Test Data");

        panel.add(l1);

        l1.setItems(data);
        l1.setTextAlignment(TextAlignable.Alignment.RIGHT);
        l1.setAttribute("label", "Built-in Label for a list box!");
        // l1.setMultipleSelection(true);
        // l1.setAttribute("multi-selection", "true");
        // l1.setAttribute("multi-selection-by-click", "true");


    }
    
}