package component_demos.listboxdemos;

import java.util.HashMap;
import java.util.Map;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.listbox.ListBox;
import org.dwcj.exceptions.DwcjAppInitializeException;

@InlineStyleSheet("context://css/listboxstyles/listbox_demo.css")
public class ListboxDemo extends App {

    @Override
    public void run() throws DwcjAppInitializeException {

        Frame panel = new Frame();
        panel.addClassName("Frame");
        ListBox l1 = new ListBox();

        Map<Object, String> data = new HashMap<>();
        data.put("Random Data1", "Random Data");
        data.put("Random Data2", "Some Data");
        data.put("Random Data3", "More Data");
        data.put("Random Data4", "Test Data");

        panel.add(l1);

        l1.setItems(data);
        l1.setAttribute("label", "This is a listbox:");
        l1.setAttribute("multi-selection", "'true'");

    }

}
