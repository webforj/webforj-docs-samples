package control_demos.comboboxdemos;

import java.util.HashMap;
import java.util.Map;

import org.dwcj.App;
import org.dwcj.controls.panels.Div;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.textbox.TextBox;
import org.dwcj.controls.combobox.ComboBox;
import org.dwcj.exceptions.DwcAppInitializeException;
import org.dwcj.annotations.InlineStyleSheet;

@InlineStyleSheet(value = "css/comboboxstyles/theme_styles.css", local = true)

public class ComboboxThemeDemo extends App {

    @Override
    public void run() throws DwcAppInitializeException {


        AppPanel panel = new AppPanel();
        panel.addClassName("appPanel");


        Map<Object, String> data = new HashMap<>();
        data.put("Random Data1", "Random Data");
        data.put("Random Data2", "Some Data");
        data.put("Random Data3", "More Data");
        data.put("Random Data4", "Test Data");


        ComboBox b1 = new ComboBox().setItems(data);
        ComboBox b2 = new ComboBox().setAttribute("theme", "danger").setItems(data);
        ComboBox b3 = new ComboBox().setAttribute("theme", "gray").setItems(data);
        ComboBox b4 = new ComboBox().setAttribute("theme", "info").setItems(data);
        ComboBox b5 = new ComboBox().setAttribute("theme", "primary").setItems(data);
        ComboBox b6 = new ComboBox().setAttribute("theme", "success").setItems(data);
        ComboBox b7 = new ComboBox().setAttribute("theme", "warning").setItems(data);
        ComboBox b8 = new ComboBox().setAttribute("theme", "outlined-default").setItems(data);
        ComboBox b9 = new ComboBox().setAttribute("theme", "outlined-danger").setItems(data);
        ComboBox b10 = new ComboBox().setAttribute("theme", "outlined-gray").setItems(data);
        ComboBox b11 = new ComboBox().setAttribute("theme", "outlined-info").setItems(data);
        ComboBox b12 = new ComboBox().setAttribute("theme", "outlined-primary").setItems(data);
        ComboBox b13 = new ComboBox().setAttribute("theme", "outlined-success").setItems(data);
        ComboBox b14 = new ComboBox().setAttribute("theme", "outlined-warning").setItems(data);
        
        
        panel.add(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14);
        
        b1.selectIndex(0);
        b2.selectIndex(0);
        b3.selectIndex(0);
        b4.selectIndex(0);
        b5.selectIndex(0);
        b6.selectIndex(0);
        b7.selectIndex(0);
        b8.selectIndex(0);
        b9.selectIndex(0);
        b10.selectIndex(0);
        b11.selectIndex(0);
        b12.selectIndex(0);
        b13.selectIndex(0);
        b14.selectIndex(0);
        

    }
        

}
