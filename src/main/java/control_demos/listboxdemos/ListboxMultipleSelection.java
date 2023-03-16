package control_demos.listboxdemos;

import java.util.HashMap;
import java.util.Map;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.button.Button;
import org.dwcj.controls.button.events.ButtonClickEvent;
import org.dwcj.controls.listbox.ListBox;
import org.dwcj.exceptions.DwcAppInitializeException;

@InlineStyleSheet("context://css/listboxstyles/multiple_selection.css")
public class ListboxMultipleSelection extends App{
    
    ListBox l1;
    Boolean toggle = false;

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.addClassName("appPanel");      
        Map<Object, String> data = new HashMap<>();
        data.put("Random Data1", "Random Data");
        data.put("Random Data2", "Some Data");
        data.put("Random Data3", "More Data");
        data.put("Random Data4", "Test Data"); 
        l1 = new ListBox();
        panel.add(l1);
        l1.setItems(data);
        Button b1 = new Button ("Toggle Multiple Selection");
        panel.add(b1);
        b1.onClick(this::buttonMethod);
        b1.setStyle("grid-column", "2").setStyle("align-self", "center").setTheme(Button.Theme.PRIMARY);
    }

    void buttonMethod(ButtonClickEvent ev){
        this.toggle = !toggle;
        l1.setMultipleSelection(toggle);
    }
    
}