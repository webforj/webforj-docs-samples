package control_demos.textcomboboxdemos;

import java.util.HashMap;
import java.util.Map;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.combobox.ComboBox;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjAppInitializeException;

@InlineStyleSheet("context://css/textcomboboxstyles/text_combo_styles.css")
public class TextComboBoxDemo extends App {

    @Override
    public void run() throws DwcjAppInitializeException {

        Frame panel = new Frame();
        panel.addClassName("Frame");

        Map<Object, String> data = new HashMap<>();
        data.put("Random Data1", "Random Data");
        data.put("Random Data2", "Some Data");
        data.put("Random Data3", "More Data");
        data.put("Random Data4", "Test Data");

        ComboBox tcb1 = new ComboBox();

        panel.add(tcb1);
        tcb1.setItems(data);
    }
}
