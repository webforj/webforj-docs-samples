package control_demos.listboxdemos;

import java.util.HashMap;
import java.util.Map;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.listbox.ListBox;
import org.dwcj.exceptions.DwcAppInitializeException;
import org.dwcj.interfaces.TextAlignable;

@InlineStyleSheet("context://css/listboxstyles/label_styles.css")
public class ListboxLabel extends App{

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.addClassName("appPanel");
        
        ListBox l1 = new ListBox();

        Map<Object, String> data = new HashMap<>();
        data.put("Random Data1", "Random Data");
        data.put("Random Data2", "Some Data");
        data.put("Random Data3", "More Data");
        data.put("Random Data4", "Test Data");

        panel.add(l1);

        l1.setItems(data).setTextAlignment(TextAlignable.Alignment.RIGHT).setAttribute("label", "Built-in Label for a list box!");


    }
    
}