package control_demos.textcomboboxdemos;

import java.util.HashMap;
import java.util.Map;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.textcombobox.TextComboBox;
import org.dwcj.exceptions.DwcAppInitializeException;

@InlineStyleSheet("context://css/textcomboboxstyles/text_combo_styles.css")
public class TextComboBoxDemo extends App{

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.addClassName("appPanel");

        Map<Object, String> data = new HashMap<>();
        data.put("Random Data1", "Random Data");
        data.put("Random Data2", "Some Data");
        data.put("Random Data3", "More Data");
        data.put("Random Data4", "Test Data");
        
        TextComboBox tcb1 = new TextComboBox();

        panel.add(tcb1);   
        tcb1.setItems(data); 
    }
}
    