package componentdemos.choiceboxdemos;

import java.util.HashMap;
import java.util.Map;

import org.dwcj.App;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.component.Expanse;
import org.dwcj.component.list.ChoiceBox;
import org.dwcj.component.list.event.ListSelectEvent;
import org.dwcj.exceptions.DwcjException;

public class ComboboxDemo extends App {

    ChoiceBox cb1;
    Panel d1;

    @Override
    public void run() throws DwcjException {
        Frame window = new Frame();
        window.setStyle("display", "inline-grid");
        window.setStyle("grid-template-columns", "1fr 1fr");
        window.setStyle("padding", "10px");
        window.setStyle("gap", "50px");
        window.setStyle("height", "100%");

        cb1 = new ChoiceBox();
        d1 = new Panel();

        d1.setStyle("height", "50px").setStyle("width", "50px").setStyle("grid-column", "2").setStyle("background",
                "blue");
        d1.setStyle("align-self", "center").setStyle("justify-self", "center");

        cb1.add("Random Data1", "Green");
        cb1.add("Random Data2", "Blue");
        cb1.add("Random Data3", "Red");
        cb1.add("Random Data4", "Yellow");

        window.add(cb1, d1);

        cb1.setLabel("Choose a Color:").selectIndex(0).setStyle("grid-column", "1")
                .setExpanse(Expanse.LARGE).setStyle("width", "250px");
        cb1.onSelect(this::cbSelect);
    }

    private void cbSelect(ListSelectEvent ev) {
        d1.setStyle("background", ev.getSelectedItem().getText());
        // d1.setStyle("background", ev.getComponent().getItemAt( ((ChoiceBox) ev.getComponent()).getSelectedIndex()).toLowerCase());
    }

}
