package componentdemos.comboboxdemos;

import java.util.ArrayList;
import java.util.List;
import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.list.ComboBox;
import org.dwcj.component.list.ListItem;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/textcomboboxstyles/placement_styles.css")
public class TextComboBoxPlacement extends App {
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    List<ListItem> data = new ArrayList<>();
    data.add(new ListItem("Random Data1", "Random Data"));
    data.add(new ListItem("Random Data2", "Some Data"));
    data.add(new ListItem("Random Data3", "More Data"));
    data.add(new ListItem("Random Data4", "Test Data"));

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

    window.add(tcb1, tcb2, tcb3, tcb4);

    tcb1.insert(data)
        .open();

    tcb2.insert(data)
        .open();

    tcb3.insert(data)
        .open();

    tcb4.insert(data)
        .open();
  }
}
