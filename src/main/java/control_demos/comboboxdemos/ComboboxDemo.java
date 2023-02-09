package control_demos.comboboxdemos;

import java.util.HashMap;
import java.util.Map;

import org.dwcj.App;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.panels.Div;
import org.dwcj.controls.combobox.ComboBox;
import org.dwcj.controls.combobox.events.ComboBoxSelectEvent;
import org.dwcj.exceptions.DwcAppInitializeException;

public class ComboboxDemo extends App{
    
    ComboBox cb1;
    Div d1;

    @Override
    public void run() throws DwcAppInitializeException {


        AppPanel panel = new AppPanel();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("grid-template-columns", "1fr 1fr");
        panel.setStyle("padding", "10px");
        panel.setStyle("gap", "50px");
        panel.setStyle("height", "100%");

        cb1 = new ComboBox();
        d1 = new Div();

        d1.setStyle("height", "50px").setStyle("width", "50px").setStyle("grid-column", "2").setStyle("background", "blue");
        d1.setStyle("align-self", "center").setStyle("justify-self", "center");

        Map<Object, String> data = new HashMap<>();
        data.put("Random Data1", "Green");
        data.put("Random Data2", "Blue");
        data.put("Random Data3", "Red");
        data.put("Random Data4", "Yellow");

        cb1.setItems(data);

        panel.add(cb1, d1);

        cb1.setAttribute("label", "Choose a Color:").selectIndex(0).setStyle("grid-column", "1").setExpanse(ComboBox.Expanse.LARGE).setStyle("width", "250px");
        cb1.onSelect(this::cbSelect);
        

    }

    private void cbSelect(ComboBoxSelectEvent ev){
        d1.setStyle("background", ev.getControl().getItemAt(ev.getControl().getSelectedIndex()).toLowerCase());
    }

}
