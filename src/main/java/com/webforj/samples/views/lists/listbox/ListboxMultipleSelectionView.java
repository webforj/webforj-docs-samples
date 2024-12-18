package com.webforj.samples.views.lists.listbox;

import com.webforj.component.Composite;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.list.ListBox;
import com.webforj.component.list.MultipleSelectableList.SelectionMode;
import com.webforj.component.optioninput.RadioButton;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route
@FrameTitle("Listbox Multiple Selection")
public class ListboxMultipleSelectionView extends Composite<FlexLayout> {

  ListBox listBox;
  SelectionMode selection = SelectionMode.SINGLE;

  public ListboxMultipleSelectionView() {
    getBoundComponent().setDirection(FlexDirection.COLUMN).setWidth(200).setMargin("20px 0 0 20px").setSpacing("20px");

    listBox = new ListBox();
    getBoundComponent().add(listBox);

    String[] departments = { "Marketing and Sales", "IT Support", "Management and Admin", "Finance and HR" };
    listBox.insert(departments);

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
