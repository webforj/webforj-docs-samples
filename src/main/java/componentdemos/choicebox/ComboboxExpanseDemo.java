package componentdemos.choicebox;

import java.util.ArrayList;
import java.util.List;
import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.component.Expanse;
import org.dwcj.component.list.ChoiceBox;
import org.dwcj.component.list.ListItem;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/comboboxstyles/expanse_styles.css")
public class ComboboxExpanseDemo extends App {
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("Frame");
    Panel container = new Panel().addClassName("container");
    window.add(container);

    List<ListItem> data = new ArrayList<>();
    data.add(new ListItem("Random Data1", "Random Data"));
    data.add(new ListItem("Random Data2", "Some Data"));
    data.add(new ListItem("Random Data3", "More Data"));
    data.add(new ListItem("Random Data4", "Test Data"));
    
    ChoiceBox cb1 = new ChoiceBox();
    cb1.setExpanse(Expanse.XSMALL)
        .insert("Extra Small")
        .insert(data)
        .selectIndex(0)
        .setStyle("grid-column", "1");

    ChoiceBox cb2 = new ChoiceBox().setExpanse(Expanse.SMALL)
        .insert("Small")
        .insert(data)
        .selectIndex(0)
        .setStyle("grid-column", "2");

    ChoiceBox cb3 = new ChoiceBox().setExpanse(Expanse.MEDIUM)
        .insert("Medium")
        .insert(data)
        .selectIndex(0)
        .setStyle("grid-column", "3");

    ChoiceBox cb4 = new ChoiceBox().setExpanse(Expanse.LARGE)
        .insert("Large")
        .insert(data)
        .selectIndex(0)
        .setStyle("grid-column", "1");

    ChoiceBox cb5 = new ChoiceBox().setExpanse(Expanse.XLARGE)
        .insert("Extra Large")
        .insert(data)
        .selectIndex(0)
        .setStyle("grid-column", "3");

    container.add(cb1, cb2, cb3, cb4, cb5);
  }
}
