package componentdemos.listboxdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.window.Frame;
import com.webforj.component.list.ListBox;
import com.webforj.component.list.MultipleSelectableList.SelectionMode;
import com.webforj.component.optioninput.RadioButton;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet(/*css*/"""
  .frame {
    display: flex;
    flex-direction: column;
    width: 200px;
    margin: 20px 0 0 20px;
    gap: 20px;
  }  
""")
public class ListboxMultipleSelection extends App {

  ListBox listBox;
  SelectionMode selection = SelectionMode.SINGLE;

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("frame");

    listBox = new ListBox();
    window.add(listBox);

    listBox.add("Random Data1", "Marketing and Sales");
    listBox.add("Random Data2", "IT Support");
    listBox.add("Random Data3", "Management and Admin");
    listBox.add("Random Data4", "Finance and HR");
    listBox.setLabel("Select Department(s)");

    RadioButton toggle = RadioButton.Switch("Multiple Selection");
    window.add(toggle);
    toggle.onToggle(e -> {
      if (this.selection.equals(SelectionMode.SINGLE)) {
        listBox.setSelectionMode(SelectionMode.MULTIPLE);
        this.selection = SelectionMode.MULTIPLE;
      } else {
        listBox.setSelectionMode(SelectionMode.SINGLE);
        this.selection = SelectionMode.SINGLE;
      }
    });
  }
}
