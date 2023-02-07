package control_demos.listboxdemos;

import java.util.HashMap;
import java.util.Map;

import org.dwcj.App;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.button.Button;
import org.dwcj.controls.button.events.ButtonClickEvent;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.listbox.ListBox;
import org.dwcj.exceptions.DwcAppInitializeException;


public class ListboxMultipleSelection extends App{
    
    ListBox l1;
    Boolean toggle = false;

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("grid-template-columns", "1fr 1fr");
        panel.setStyle("padding", "10px");
        panel.setStyle("gap", "50px");
        

        Map<Object, String> data = new HashMap<>();
        data.put("Random Data1", "Random Data");
        data.put("Random Data2", "Some Data");
        data.put("Random Data3", "More Data");
        data.put("Random Data4", "Test Data"); 

        // Label text = new Label("Use the button to toggle multiple selection on or off");
        l1 = new ListBox();
        panel.add(l1);

        l1.setItems(data);
        // l1.setAttribute("label", "This is a listbox:");
        // l1.setMultipleSelection(true);
        // l1.setAttribute("multi-selection", "true");
        // l1.setAttribute("multi-selection-by-click", "true");


        Button b1 = new Button ("Toggle Multiple Selection");
        panel.add(b1);
        b1.onClick(this::buttonMethod);

        l1.setStyle("grid-column", "1");
        b1.setStyle("grid-column", "2").setStyle("align-self", "center").setTheme(Button.Theme.PRIMARY);
    }

    void buttonMethod(ButtonClickEvent ev){
        this.toggle = !toggle;
        l1.setMultipleSelection(toggle);
    }
    
}