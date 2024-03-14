package componentdemos.comboboxdemos;

import java.util.ArrayList;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.window.Frame;
import com.webforj.component.list.ComboBox;
import com.webforj.component.list.ListItem;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/comboboxstyles/dropdown_styles.css")
public class ComboBoxDropdownType extends App {

  ComboBox comboBox = new ComboBox("Department");

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("frame");
    window.add(comboBox);

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
