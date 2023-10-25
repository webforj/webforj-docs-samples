package componentdemos.listboxdemos;

import java.util.HashMap;
import java.util.Map;
import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.ButtonTheme;
import org.dwcj.component.button.event.ButtonClickEvent;
import org.dwcj.component.list.ListBox;
import org.dwcj.component.list.MultipleSelectableList.SelectionMode;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/listboxstyles/multiple_selection.css")
public class ListboxMultipleSelection extends App {

  ListBox l1;
  SelectionMode selection = SelectionMode.SINGLE;

  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    
    l1 = new ListBox();
    window.add(l1);

    l1.add("Random Data1", "Random Data");
    l1.add("Random Data2", "Some Data");
    l1.add("Random Data3", "More Data");
    l1.add("Random Data4", "Test Data");

    Button b1 = new Button("Toggle Multiple Selection");
    window.add(b1);
    b1.onClick(this::buttonMethod);
    b1.setStyle("grid-column", "2")
        .setStyle("align-self", "center")
        .setTheme(ButtonTheme.PRIMARY);
  }

  void buttonMethod(ButtonClickEvent ev) {
    if(this.selection.equals(SelectionMode.SINGLE)){
      l1.setSelectionMode(SelectionMode.MULTIPLE);
      this.selection = SelectionMode.MULTIPLE;
    }
    else{
      l1.setSelectionMode(SelectionMode.SINGLE);
      this.selection = SelectionMode.SINGLE;
    }
  }
}
