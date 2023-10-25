package componentdemos.textcomboboxdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.list.ComboBox;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjAppInitializeException;

@InlineStyleSheet("context://css/textcomboboxstyles/text_combo_styles.css")
public class TextComboBoxDemo extends App {

    @Override
    public void run() throws DwcjAppInitializeException {

        Frame window = new Frame();
        window.addClassName("Frame");

        ComboBox tcb1 = new ComboBox();

        tcb1.add("Random Data1", "Random Data");
        tcb1.add("Random Data2", "Some Data");
        tcb1.add("Random Data3", "More Data");
        tcb1.add("Random Data4", "Test Data");


        window.add(tcb1);
    }
}
