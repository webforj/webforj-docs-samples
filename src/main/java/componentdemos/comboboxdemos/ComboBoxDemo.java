package componentdemos.comboboxdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.list.ComboBox;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/textcomboboxstyles/demo_styles.css")
public class ComboBoxDemo extends App {

    @Override
    public void run() throws DwcjException {

        Frame window = new Frame();
        window.addClassName("frame");

        ComboBox categories = new ComboBox();
        window.add(categories);

        categories.add("Electronics","Electronics");
        categories.add("Health and Beauty","Health and Beauty");
        categories.add("Fashion","Fashion");
        categories.add("Kitchen","Kitchen");
        categories.add("Furniture","Furniture");
        categories.add("Pet Supplies","Pet Supplies");
        categories.add("Toys and Games","Toys and Games");

        categories.setLabel("Type or Select Category");
    }
}
