package com.webforj.samples.views.lists.combobox;

import java.util.ArrayList;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.list.ComboBox;
import com.webforj.component.list.ListItem;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet("context://css/lists/combobox/comboBoxDropDownType.css")
@Route
@FrameTitle("ComboBox Dropdown Type")
public class ComboBoxDropdownTypeView extends Composite<Div> {

  ComboBox comboBox = new ComboBox("Department");

  public ComboBoxDropdownTypeView() {
    getBoundComponent().addClassName("frame");
    getBoundComponent().add(comboBox);

    ArrayList<ListItem> categories = new ArrayList<>();
    categories.add(new ListItem("Electronics", "Electronics"));
    categories.add(new ListItem("Health and Beauty", "Health and Beauty"));
    categories.add(new ListItem("Fashion", "Fashion"));
    categories.add(new ListItem("Kitchen", "Kitchen"));
    categories.add(new ListItem("Furniture", "Furniture"));
    categories.add(new ListItem("Pet Supplies", "Pet Supplies"));
    categories.add(new ListItem("Toys and Games", "Toys and Games"));

    comboBox.setDropdownType("demo-dropdown-type");
    comboBox.insert(categories)
        .selectIndex(0);
  }
}
