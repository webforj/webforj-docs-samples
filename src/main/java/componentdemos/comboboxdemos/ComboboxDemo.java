package componentdemos.comboboxdemos;

import java.util.HashMap;
import java.util.Map;

import org.dwcj.App;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.component.choicebox.ChoiceBox;
import org.dwcj.component.choicebox.event.ChoiceBoxSelectEvent;
import org.dwcj.exceptions.DwcjAppInitializeException;

public class ComboboxDemo extends App {

    ChoiceBox cb1;
    Panel d1;

    @Override
    public void run() throws DwcjAppInitializeException {
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

        Map<Object, String> data = new HashMap<>();
        data.put("Random Data1", "Green");
        data.put("Random Data2", "Blue");
        data.put("Random Data3", "Red");
        data.put("Random Data4", "Yellow");

        cb1.setItems(data);

        window.add(cb1, d1);

        cb1.setAttribute("label", "Choose a Color:").selectIndex(0).setStyle("grid-column", "1")
                .setExpanse(ChoiceBox.Expanse.LARGE).setStyle("width", "250px");
        cb1.onSelect(this::cbSelect);

    }

    private void cbSelect(ChoiceBoxSelectEvent ev) {
        d1.setStyle("background", ev.getControl().getItemAt(ev.getControl().getSelectedIndex()).toLowerCase());
    }

}
