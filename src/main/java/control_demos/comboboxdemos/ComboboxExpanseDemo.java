package control_demos.comboboxdemos;

import java.util.HashMap;
import java.util.Map;
import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.component.combobox.ComboBox;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/comboboxstyles/expanse_styles.css")
public class ComboboxExpanseDemo extends App {
  @Override
  public void run() throws DwcjException {
    Frame panel = new Frame();
    panel.addClassName("Frame");
    Panel container = new Panel().addClassName("container");
    panel.add(container);

    ComboBox cb1 = new ComboBox().setExpanse(ComboBox.Expanse.XSMALL)
        .setText("Extra Small")
        .setStyle("grid-column", "1");

    ComboBox cb2 = new ComboBox().setExpanse(ComboBox.Expanse.SMALL)
        .setText("Small")
        .setStyle("grid-column", "2");

    ComboBox cb3 = new ComboBox().setExpanse(ComboBox.Expanse.MEDIUM)
        .setText("Medium")
        .setStyle("grid-column", "3");

    ComboBox cb4 = new ComboBox().setExpanse(ComboBox.Expanse.LARGE)
        .setText("Large")
        .setStyle("grid-column", "4");

    ComboBox cb5 = new ComboBox().setExpanse(ComboBox.Expanse.XLARGE)
        .setText("Extra Large")
        .setStyle("grid-column", "5");

    Map<Object, String> data = new HashMap<>();
    data.put("Random Data1", "Random Data");
    data.put("Random Data2", "Some Data");
    data.put("Random Data3", "More Data");
    data.put("Random Data4", "Test Data");
    container.add(cb1, cb2, cb3, cb4, cb5);
  }
}
