package componentdemos.comboboxdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.list.ChoiceBox;
import org.dwcj.exceptions.DwcjAppInitializeException;

@InlineStyleSheet("context://css/comboboxstyles/dropdown_styles.css")
public class ChoiceBoxDropdownType extends App {

    @Override
    public void run() throws DwcjAppInitializeException {
        Frame window = new Frame();
        window.addClassName("frame");

        ChoiceBox demoBox = new ChoiceBox();
        demoBox.setDropdownType("demo-dropdown-type");
        window.add(demoBox);
    }
}
