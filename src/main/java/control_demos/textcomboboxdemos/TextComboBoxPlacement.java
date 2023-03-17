package control_demos.textcomboboxdemos;

import java.util.HashMap;
import java.util.Map;
import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.textcombobox.TextComboBox;
import org.dwcj.exceptions.DwcException;

@InlineStyleSheet("context://css/textcomboboxstyles/placement_styles.css")
public class TextComboBoxPlacement extends App {
  @Override
  public void run() throws DwcException {
    AppPanel panel = new AppPanel();
    panel.addClassName("appPanel");

    Map<Object, String> data = new HashMap<>();
    data.put("Random Data1", "Random Data");
    data.put("Random Data2", "Some Data");
    data.put("Random Data3", "More Data");
    data.put("Random Data4", "Test Data");

    TextComboBox tcb1 = new TextComboBox().setAttribute("placement", "left")
      .setAttribute("placeholder", "Left Menu Placement")
      .setStyle("grid-column", "1")
      .setStyle("justify-self", "end");

    TextComboBox tcb2 = new TextComboBox().setAttribute("placement", "right")
      .setAttribute("placeholder", "Right Menu Placement")
      .setStyle("grid-column", "2");

    TextComboBox tcb3 = new TextComboBox().setAttribute("placement", "top")
      .setAttribute("placeholder", "Top Menu Placement")
      .setStyle("grid-column", "1")
      .setStyle("justify-self", "end");

    TextComboBox tcb4 = new TextComboBox().setAttribute("placement", "bottom")
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