package com.webforj.samples.views.lists.listbox;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.list.ListBox;
import com.webforj.component.list.MultipleSelectableList.SelectionMode;
import com.webforj.component.optioninput.RadioButton;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet(/*css*/"""
  .frame {
    display: flex;
    flex-direction: column;
    width: 200px;
    margin: 20px 0 0 20px;
    gap: 20px;
  }  
""")
@Route
@FrameTitle("Listbox Multiple Selection")
public class ListboxMultipleSelectionView extends Composite<Div> {

  ListBox listBox;
  SelectionMode selection = SelectionMode.SINGLE;

  public ListboxMultipleSelectionView() {
    getBoundComponent().addClassName("frame");

    listBox = new ListBox();
    getBoundComponent().add(listBox);

    listBox.add("Random Data1", "Marketing and Sales");
    listBox.add("Random Data2", "IT Support");
    listBox.add("Random Data3", "Management and Admin");
    listBox.add("Random Data4", "Finance and HR");
    listBox.setLabel("Select Department(s)");

    RadioButton toggle = RadioButton.Switch("Multiple Selection");
    getBoundComponent().add(toggle);
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
