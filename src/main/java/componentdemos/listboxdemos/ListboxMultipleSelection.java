package componentdemos.listboxdemos;

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

  ListBox listBox;
  SelectionMode selection = SelectionMode.SINGLE;

  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("frame");

    
    listBox = new ListBox();
    window.add(listBox);

    listBox.add("Random Data1", "Marketing and Sales");
    listBox.add("Random Data2", "IT Support");
    listBox.add("Random Data3", "Management and Admin");
    listBox.add("Random Data4", "Finance and HR");
    listBox.setLabel("Select Department(s)");

    Button toggle = new Button("Toggle Multiple Selection");
    window.add(toggle);
    toggle.onClick(this::buttonMethod);
    toggle.setTheme(ButtonTheme.PRIMARY);
  }

  void buttonMethod(ButtonClickEvent ev) {
    if(this.selection.equals(SelectionMode.SINGLE)){
      listBox.setSelectionMode(SelectionMode.MULTIPLE);
      this.selection = SelectionMode.MULTIPLE;
    }
    else{
      listBox.setSelectionMode(SelectionMode.SINGLE);
      this.selection = SelectionMode.SINGLE;
    }
  }
}
