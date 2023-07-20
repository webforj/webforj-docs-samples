package componentdemos.textcomboboxdemos;

import java.util.HashMap;
import java.util.Map;
import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.combobox.ComboBox;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/textcomboboxstyles/text_combo_styles.css")
public class TextComboBoxLabel extends App {
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    panel.addClassName("Frame");

    Map<Object, String> data = new HashMap<>();
    data.put("Random Data1", "Random Data");
    data.put("Random Data2", "Some Data");
    data.put("Random Data3", "More Data");
    data.put("Random Data4", "Test Data");

    ComboBox tcb1 = new ComboBox().setAttribute("label", "Example Label");

    panel.add(tcb1);
    tcb1.setItems(data);
  }
}
