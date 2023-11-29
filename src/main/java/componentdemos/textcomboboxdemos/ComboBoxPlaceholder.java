package componentdemos.textcomboboxdemos;

import java.util.ArrayList;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.list.ComboBox;
import org.dwcj.component.list.ListItem;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet(/* css */"""
    .frame{
      display: flex;
      margin: 20px 0 0 20px;
      gap: 20px;
    }
    """)
public class ComboBoxPlaceholder extends App {

  ComboBox comboBox = new ComboBox();

  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("frame");

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
    window.add(comboBox);
  }
}
