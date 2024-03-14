package componentdemos.comboboxdemos;

import java.util.ArrayList;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.list.ComboBox;
import com.webforj.component.list.ListItem;
import com.webforj.component.optioninput.RadioButton;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet(/*css*/"""
  .frame{
    display: flex;
    flex-direction: column;
    margin: 20px 0 0 20px;
    gap: 20px;
    width: 200px;
  }
""")
public class ComboBoxCustomValue extends App {
  
  ComboBox customValue = new ComboBox();
  RadioButton toggle = RadioButton.Switch("Toggle Custom Value");

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("frame");
    window.add(customValue, toggle);
    
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
