package componentdemos.listboxdemos;

import java.util.HashMap;
import java.util.Map;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.concern.HasHorizontalAlignment;
import com.webforj.component.window.Frame;
import com.webforj.component.list.ListBox;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/listboxstyles/label_styles.css")
public class ListboxLabel extends App {
  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    ListBox l1 = new ListBox();

    l1.add("Random Data1", "Random Data");
    l1.add("Random Data2", "Some Data");
    l1.add("Random Data3", "More Data");
    l1.add("Random Data4", "Test Data");

    window.add(l1);

    l1.setHorizontalAlignment(HasHorizontalAlignment.Alignment.RIGHT)
        .setLabel("Built-in Label for a list box!");
  }
}
