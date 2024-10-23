package com.webforj.samples.views.lists.combobox;

import java.util.ArrayList;

import com.webforj.component.Composite;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.list.ComboBox;
import com.webforj.component.list.ListItem;
import com.webforj.component.optioninput.RadioButton;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route
@FrameTitle("ComboBox Custom Value")
public class ComboBoxCustomValueView extends Composite<FlexLayout> {

  ComboBox customValue = new ComboBox("Department");
  RadioButton toggle = RadioButton.Switch("Toggle Custom Value");

  public ComboBoxCustomValueView() {
    getBoundComponent().setDirection(FlexDirection.COLUMN).setMargin("20px 0 0 20px").setSpacing("20px").setWidth(200);
    getBoundComponent().add(customValue, toggle);

    ArrayList<ListItem> categories = new ArrayList<>();
    categories.add(new ListItem("Electronics", "Electronics"));
    categories.add(new ListItem("Health and Beauty", "Health and Beauty"));
    categories.add(new ListItem("Fashion", "Fashion"));
    categories.add(new ListItem("Kitchen", "Kitchen"));
    categories.add(new ListItem("Furniture", "Furniture"));
    categories.add(new ListItem("Pet Supplies", "Pet Supplies"));
    categories.add(new ListItem("Toys and Games", "Toys and Games"));

    customValue.insert(categories);
    customValue.setAllowCustomValue(false);

    toggle.onToggle(e -> customValue.setAllowCustomValue(!customValue.isAllowCustomValue()));

  }
}
