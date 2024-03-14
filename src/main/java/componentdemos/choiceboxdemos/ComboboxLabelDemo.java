package componentdemos.choiceboxdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.window.Frame;
import com.webforj.component.html.elements.Div;
import com.webforj.component.list.ChoiceBox;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/comboboxstyles/label_styles.css")
public class ComboboxLabelDemo extends App {
	
	 ChoiceBox cb1 = new ChoiceBox();
	 Div container = new Div();
	    
  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    container.addClassName("container");
    window.add(container);

    cb1.add("Random Data1", "Random Data");
    cb1.add("Random Data2", "Some Data");
    cb1.add("Random Data3", "More Data");
    cb1.add("Random Data4", "Test Data");

    container.add(cb1);

        cb1.selectIndex(0)
        .setLabel("Example label");
  }
}
