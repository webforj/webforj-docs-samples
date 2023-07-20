package componentdemos.textcomboboxdemos;

import java.util.HashMap;
import java.util.Map;
import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.combobox.ComboBox;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/textcomboboxstyles/placement_styles.css")
public class TextComboBoxPlacement extends App {
  @Override
  public void run() throws DwcjException {
    Frame panel = new Frame();
    panel.addClassName("Frame");

    Map<Object, String> data = new HashMap<>();
    data.put("Random Data1", "Random Data");
    data.put("Random Data2", "Some Data");
    data.put("Random Data3", "More Data");
    data.put("Random Data4", "Test Data");

    ComboBox tcb1 = new ComboBox().setAttribute("placement", "left")
        .setAttribute("placeholder", "Left Menu Placement")
        .setStyle("grid-column", "1")
        .setStyle("justify-self", "end");

    ComboBox tcb2 = new ComboBox().setAttribute("placement", "right")
        .setAttribute("placeholder", "Right Menu Placement")
        .setStyle("grid-column", "2");

    ComboBox tcb3 = new ComboBox().setAttribute("placement", "top")
        .setAttribute("placeholder", "Top Menu Placement")
        .setStyle("grid-column", "1")
        .setStyle("justify-self", "end");

    ComboBox tcb4 = new ComboBox().setAttribute("placement", "bottom")
        .setAttribute("placeholder", "Bottom Menu Placement")
        .setStyle("grid-column", "2");

    panel.add(tcb1, tcb2, tcb3, tcb4);

    tcb1.setItems(data)
        .openList();

    tcb2.setItems(data)
        .openList();

    tcb3.setItems(data)
        .openList();

    tcb4.setItems(data)
        .openList();
  }
}
