package com.webforj.samples.views.combobox;

import java.util.ArrayList;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.list.ComboBox;
import com.webforj.component.list.ListItem;
import com.webforj.component.optioninput.RadioButton;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet(/*css*/"""
  .frame{
    display: flex;
    flex-direction: column;
    margin: 20px 0 0 20px;
    gap: 20px;
    width: 200px;
  }
""")
@Route
@FrameTitle("ComboBox Custom Value")
public class ComboBoxCustomValueView extends Composite<Div> {
  
  ComboBox customValue = new ComboBox();
  RadioButton toggle = RadioButton.Switch("Toggle Custom Value");

  public ComboBoxCustomValueView() {
    getBoundComponent().addClassName("frame");
    getBoundComponent().add(customValue, toggle);
    
    ArrayList<ListItem> categories = new ArrayList<>();
    categories.add(new ListItem("Electronics", "Electronics"));
    categories.add(new ListItem("Health and Beauty", "Health and Beauty"));
    categories.add(new ListItem("Fashion", "Fashion"));
    categories.add(new ListItem("Kitchen", "Kitchen"));
    categories.add(new ListItem("Furniture", "Furniture"));
    categories.add(new ListItem("Pet Supplies", "Pet Supplies"));
    categories.add(new ListItem("Toys and Games", "Toys and Games"));
    
    customValue.setDropdownType("demo-dropdown-type");
    customValue.insert(categories);
    customValue.setAllowCustomValue(false);

    toggle.onToggle( e -> {
      customValue.setAllowCustomValue(!customValue.isAllowCustomValue());
    });

  }
}
