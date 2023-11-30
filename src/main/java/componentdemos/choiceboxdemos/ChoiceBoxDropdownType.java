package componentdemos.choiceboxdemos;

import java.util.ArrayList;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.list.ChoiceBox;
import org.dwcj.component.list.ListItem;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/comboboxstyles/dropdown_styles.css")
public class ChoiceBoxDropdownType extends App {

  ChoiceBox demoBox = new ChoiceBox("Department");

  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("frame");
    window.add(demoBox);

    ArrayList<ListItem> categories = new ArrayList<>();
    categories.add(new ListItem("Electronics", "Electronics"));
    categories.add(new ListItem("Health and Beauty", "Health and Beauty"));
    categories.add(new ListItem("Fashion", "Fashion"));
    categories.add(new ListItem("Kitchen", "Kitchen"));
    categories.add(new ListItem("Furniture", "Furniture"));
    categories.add(new ListItem("Pet Supplies", "Pet Supplies"));
    categories.add(new ListItem("Toys and Games", "Toys and Games"));

    demoBox.setDropdownType("demo-dropdown-type");
    demoBox.insert(categories)
        .selectIndex(0);
  }
}
