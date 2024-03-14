package componentdemos.comboboxdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.list.ComboBox;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/textcomboboxstyles/demo_styles.css")
public class ComboBoxDemo extends App {
	
	ComboBox categories = new ComboBox();

    @Override
    public void run() throws WebforjException {

        Frame window = new Frame();
        window.addClassName("frame");

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
