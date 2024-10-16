package com.webforj.samples.views.lists.combobox;

import java.util.ArrayList;

import com.webforj.component.Composite;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.list.ComboBox;
import com.webforj.component.list.ListItem;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route
@FrameTitle("ComboBox Placeholders")
public class ComboBoxPlaceholderView extends Composite<FlexLayout> {

  ComboBox comboBox = new ComboBox();

  public ComboBoxPlaceholderView() {
    getBoundComponent().setMargin("20px 0 0 20px").setSpacing("20px");

    ArrayList<ListItem> categories = new ArrayList<>();
    categories.add(new ListItem("Electronics", "Electronics"));
    categories.add(new ListItem("Health and Beauty", "Health and Beauty"));
    categories.add(new ListItem("Fashion", "Fashion"));
    categories.add(new ListItem("Kitchen", "Kitchen"));
    categories.add(new ListItem("Furniture", "Furniture"));
    categories.add(new ListItem("Pet Supplies", "Pet Supplies"));
    categories.add(new ListItem("Toys and Games", "Toys and Games"));

    comboBox.setPlaceholder("Example Placeholder");
    comboBox.insert(categories);
    getBoundComponent().add(comboBox);
  }
}
