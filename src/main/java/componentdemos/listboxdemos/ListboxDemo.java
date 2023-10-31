package componentdemos.listboxdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.event.ComponentEventListener;
import org.dwcj.component.list.ListBox;
import org.dwcj.component.list.MultipleSelectableList.SelectionMode;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjAppInitializeException;

@InlineStyleSheet("context://css/listboxstyles/listbox_demo.css")
public class ListboxDemo extends App {

    @Override
    public void run() throws DwcjAppInitializeException {

        Frame window = new Frame();
        window.addClassName("Frame");
        ListBox l1 = new ListBox();

        l1.add("Random Data1", "Random Data");
        l1.add("Random Data2", "Some Data");
        l1.add("Random Data3", "More Data");
        l1.add("Random Data4", "Test Data");

        window.add(l1);

        l1.setLabel("This is a listbox:");
        l1.setSelectionMode(SelectionMode.MULTIPLE);

    }

}
