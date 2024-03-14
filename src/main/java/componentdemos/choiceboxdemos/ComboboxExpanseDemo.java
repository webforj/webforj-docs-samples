package componentdemos.choiceboxdemos;

import java.util.ArrayList;
import java.util.List;
import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.window.Frame;
import com.webforj.component.html.elements.Div;
import com.webforj.component.Expanse;
import com.webforj.component.list.ChoiceBox;
import com.webforj.component.list.ListItem;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/comboboxstyles/expanse_styles.css")
public class ComboboxExpanseDemo extends App {
	
	Div container = new Div();
	ChoiceBox cb1 = new ChoiceBox();
	ChoiceBox cb2 = new ChoiceBox();
	ChoiceBox cb3 = new ChoiceBox();
	ChoiceBox cb4 = new ChoiceBox();
	ChoiceBox cb5 = new ChoiceBox();
	
  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("Frame");
    container.addClassName("container");
    window.add(container);
 
    List<ListItem> data = new ArrayList<>();
    data.add(new ListItem("Random Data1", "Random Data"));
    data.add(new ListItem("Random Data2", "Some Data"));
    data.add(new ListItem("Random Data3", "More Data"));
    data.add(new ListItem("Random Data4", "Test Data"));
    
    cb1.setExpanse(Expanse.XSMALL)
        .insert("Extra Small")
        .insert(data)
        .selectIndex(0)
        .setStyle("grid-column", "1");

    cb2.setExpanse(Expanse.SMALL)
        .insert("Small")
        .insert(data)
        .selectIndex(0)
        .setStyle("grid-column", "2");

    cb3.setExpanse(Expanse.MEDIUM)
        .insert("Medium")
        .insert(data)
        .selectIndex(0)
        .setStyle("grid-column", "3");

    cb4.setExpanse(Expanse.LARGE)
        .insert("Large")
        .insert(data)
        .selectIndex(0)
        .setStyle("grid-column", "1");

    cb5.setExpanse(Expanse.XLARGE)
        .insert("Extra Large")
        .insert(data)
        .selectIndex(0)
        .setStyle("grid-column", "3");

    container.add(cb1, cb2, cb3, cb4, cb5);
  }
}
