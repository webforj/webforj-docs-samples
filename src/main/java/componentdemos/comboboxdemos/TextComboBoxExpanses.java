package componentdemos.comboboxdemos;

import java.util.ArrayList;
import java.util.List;
import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.window.Frame;
import com.webforj.component.Expanse;
import com.webforj.component.list.ComboBox;
import com.webforj.component.list.ListItem;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/textcomboboxstyles/expanse_styles.css")
public class TextComboBoxExpanses extends App {
	
	 ComboBox tcb1 = new ComboBox();
	 ComboBox tcb2 = new ComboBox();
	 ComboBox tcb3 = new ComboBox();
	 ComboBox tcb4 = new ComboBox();
	 ComboBox tcb5 = new ComboBox();
			 
  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    List<ListItem> data = new ArrayList<>();
    data.add(new ListItem("Random Data1", "Random Data"));
    data.add(new ListItem("Random Data2", "Some Data"));
    data.add(new ListItem("Random Data3", "More Data"));
    data.add(new ListItem("Random Data4", "Test Data"));

    tcb1.setExpanse(Expanse.XSMALL)
        .setPlaceholder("XSMALL");
    tcb2.setExpanse(Expanse.SMALL)
        .setPlaceholder("SMALL");
    tcb3.setExpanse(Expanse.MEDIUM)
        .setPlaceholder("MEDIUM");
    tcb4.setExpanse(Expanse.LARGE)
        .setPlaceholder("LARGE");
    tcb5.setExpanse(Expanse.XLARGE)
        .setPlaceholder("XLARGE");

    window.add(tcb1, tcb2, tcb3, tcb4, tcb5);

    tcb1.insert(data);
    tcb2.insert(data);
    tcb3.insert(data);
    tcb4.insert(data);
    tcb5.insert(data);
  }
}
