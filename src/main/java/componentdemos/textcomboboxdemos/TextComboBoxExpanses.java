package componentdemos.textcomboboxdemos;

import java.util.ArrayList;
import java.util.List;
import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.Expanse;
import org.dwcj.component.list.ComboBox;
import org.dwcj.component.list.ListItem;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/textcomboboxstyles/expanse_styles.css")
public class TextComboBoxExpanses extends App {
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    List<ListItem> data = new ArrayList<>();
    data.add(new ListItem("Random Data1", "Random Data"));
    data.add(new ListItem("Random Data2", "Some Data"));
    data.add(new ListItem("Random Data3", "More Data"));
    data.add(new ListItem("Random Data4", "Test Data"));

    ComboBox tcb1 = new ComboBox().setExpanse(Expanse.XSMALL)
        .setAttribute("placeholder", "XSMALL");

    ComboBox tcb2 = new ComboBox().setExpanse(Expanse.SMALL)
        .setAttribute("placeholder", "SMALL");

    ComboBox tcb3 = new ComboBox().setExpanse(Expanse.MEDIUM)
        .setAttribute("placeholder", "MEDIUM");

    ComboBox tcb4 = new ComboBox().setExpanse(Expanse.LARGE)
        .setAttribute("placeholder", "LARGE");

    ComboBox tcb5 = new ComboBox().setExpanse(Expanse.XLARGE)
        .setAttribute("placeholder", "XLARGE");

    window.add(tcb1, tcb2, tcb3, tcb4, tcb5);

    tcb1.insert(data);
    tcb2.insert(data);
    tcb3.insert(data);
    tcb4.insert(data);
    tcb5.insert(data);
  }

}
