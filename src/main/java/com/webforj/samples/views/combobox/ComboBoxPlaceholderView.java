package com.webforj.samples.views.combobox;

import java.util.ArrayList;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.window.Frame;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.list.ComboBox;
import com.webforj.component.list.ListItem;
import com.webforj.exceptions.WebforjException;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet(/* css */"""
  .frame{
    display: flex;
    margin: 20px 0 0 20px;
    gap: 20px;
  }
""")
@Route
@FrameTitle("ComboBox Placeholders")
public class ComboBoxPlaceholderView extends Composite<Div> {

  ComboBox comboBox = new ComboBox();

  public ComboBoxPlaceholderView() {
    getBoundComponent().addClassName("frame");

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
