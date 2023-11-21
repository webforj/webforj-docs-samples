package componentdemos.textcomboboxdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.list.ComboBox;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/textcomboboxstyles/dropdown_styles.css")
public class ComboBoxDropdownType extends App {

    @Override
    public void run() throws DwcjException {
        Frame window = new Frame();
        window.addClassName("frame");

        ComboBox demoBox = new ComboBox();
        demoBox.setDropdownType("demo-dropdown-type");
        window.add(demoBox);
    }
}
