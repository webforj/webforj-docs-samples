package componentdemos.textcomboboxdemos;

import java.util.ArrayList;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.list.ComboBox;
import org.dwcj.component.list.ListItem;
import org.dwcj.component.optioninput.RadioButton;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/textcomboboxstyles/demo_styles.css")
public class ComboBoxCustomValue extends App {
  
  ComboBox customValue = new ComboBox();
  RadioButton toggle = RadioButton.Switch("Toggle Custom Value");

  @Override
  public void run() throws DwcjException {
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
      consoleLog(customValue.isAllowCustomValue()+"");
    });

  }
}
