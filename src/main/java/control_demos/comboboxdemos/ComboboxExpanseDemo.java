package control_demos.comboboxdemos;

import java.util.HashMap;
import java.util.Map;
import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.component.choicebox.ChoiceBox;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/comboboxstyles/expanse_styles.css")
public class ComboboxExpanseDemo extends App {
    @Override
    public void run() throws DwcjException {
        Frame panel = new Frame();
        panel.addClassName("Frame");
        Panel container = new Panel().addClassName("container");
        panel.add(container);

        ChoiceBox cb1 = new ChoiceBox().setExpanse(ChoiceBox.Expanse.XSMALL)
                .setText("Extra Small")
                .setStyle("grid-column", "1");

        ChoiceBox cb2 = new ChoiceBox().setExpanse(ChoiceBox.Expanse.SMALL)
                .setText("Small")
                .setStyle("grid-column", "2");

        ChoiceBox cb3 = new ChoiceBox().setExpanse(ChoiceBox.Expanse.MEDIUM)
                .setText("Medium")
                .setStyle("grid-column", "3");

        ChoiceBox cb4 = new ChoiceBox().setExpanse(ChoiceBox.Expanse.LARGE)
                .setText("Large")
                .setStyle("grid-column", "1");

        ChoiceBox cb5 = new ChoiceBox().setExpanse(ChoiceBox.Expanse.XLARGE)
                .setText("Extra Large")
                .setStyle("grid-column", "3");

        Map<Object, String> data = new HashMap<>();
        data.put("Random Data1", "Random Data");
        data.put("Random Data2", "Some Data");
        data.put("Random Data3", "More Data");
        data.put("Random Data4", "Test Data");
        container.add(cb1, cb2, cb3, cb4, cb5);
    }
}
