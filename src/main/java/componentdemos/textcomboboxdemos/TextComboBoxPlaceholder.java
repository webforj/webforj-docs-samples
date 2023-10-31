package componentdemos.textcomboboxdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.list.ComboBox;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/textcomboboxstyles/text_combo_styles.css")
public class TextComboBoxPlaceholder extends App {
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("frame");

    ComboBox tcb1 = new ComboBox();
    tcb1.setPlaceholder("Example Placeholder");

    tcb1.add("Random Data1", "Random Data");
    tcb1.add("Random Data2", "Some Data");
    tcb1.add("Random Data3", "More Data");
    tcb1.add("Random Data4", "Test Data");

    // ListenerRegistration<ListClickEvent> test = tcb1.addClickListener(e -> {
    //   App.consoleLog("TEST");
    // });
    // tcb1.removeClickListener(test.getListener());

    window.add(tcb1);
  }
}
