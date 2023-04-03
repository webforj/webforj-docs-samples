package control_demos.textcomboboxdemos;

import java.util.HashMap;
import java.util.Map;
import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.combobox.ComboBox;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/textcomboboxstyles/expanse_styles.css")
public class TextComboBoxExpanses extends App {
  @Override
  public void run() throws DwcjException {
    Frame panel = new Frame();
    panel.addClassName("Frame");

    Map<Object, String> data = new HashMap<>();
    data.put("Random Data1", "Random Data");
    data.put("Random Data2", "Some Data");
    data.put("Random Data3", "More Data");
    data.put("Random Data4", "Test Data");

    ComboBox tcb1 = new ComboBox().setExpanse(ComboBox.Expanse.XSMALL)
      .setAttribute("placeholder", "XSMALL");

    ComboBox tcb2 = new ComboBox().setExpanse(ComboBox.Expanse.SMALL)
      .setAttribute("placeholder", "SMALL");

    ComboBox tcb3 = new ComboBox().setExpanse(ComboBox.Expanse.MEDIUM)
      .setAttribute("placeholder", "MEDIUM");

    ComboBox tcb4 = new ComboBox().setExpanse(ComboBox.Expanse.LARGE)
      .setAttribute("placeholder", "LARGE");

    ComboBox tcb5 = new ComboBox().setExpanse(ComboBox.Expanse.XLARGE)
      .setAttribute("placeholder", "XLARGE");

    panel.add(tcb1, tcb2, tcb3, tcb4, tcb5);

    tcb1.setItems(data);
    tcb2.setItems(data);
    tcb3.setItems(data);
    tcb4.setItems(data);
    tcb5.setItems(data);
  }

}
