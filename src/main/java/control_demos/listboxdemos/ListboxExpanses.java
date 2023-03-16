package control_demos.listboxdemos;

import java.util.HashMap;
import java.util.Map;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.listbox.ListBox;
import org.dwcj.exceptions.DwcAppInitializeException;

@InlineStyleSheet("context://css/listboxstyles/expanse_styles.css")
public class ListboxExpanses extends App{

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.addClassName("appPanel");
        
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

        l1.setItems(data).setAttribute("label", "Extra Small:");
        l2.setItems(data).setAttribute("label", "Small:");
        l3.setItems(data).setAttribute("label", "Medium:");
        l4.setItems(data).setAttribute("label", "Large");
        l5.setItems(data).setAttribute("label", "Extra Large:");


    }
    
}