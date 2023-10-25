package componentdemos.comboboxdemos;

import java.util.ArrayList;
import java.util.List;
import org.dwcj.App;
import org.dwcj.component.window.Frame;
import org.dwcj.component.button.ButtonTheme;
import org.dwcj.component.list.ChoiceBox;
import org.dwcj.component.list.ListItem;
import org.dwcj.exceptions.DwcjException;
import org.dwcj.annotation.InlineStyleSheet;

@InlineStyleSheet("context://css/comboboxstyles/theme_styles.css")
public class ComboboxThemeDemo extends App {

  private static final String THEME = "theme";

  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    List<ListItem> data = new ArrayList<>();
    data.add(new ListItem("Random Data1", "Random Data"));
    data.add(new ListItem("Random Data2", "Some Data"));
    data.add(new ListItem("Random Data3", "More Data"));
    data.add(new ListItem("Random Data4", "Test Data"));

    ChoiceBox b1 = new ChoiceBox().insert(data);
    ChoiceBox b2 = new ChoiceBox().setTheme(ButtonTheme.DANGER)
        .insert(data);
    ChoiceBox b3 = new ChoiceBox().setTheme(ButtonTheme.GRAY)
        .insert(data);
    ChoiceBox b4 = new ChoiceBox().setTheme(ButtonTheme.INFO)
        .insert(data);
    ChoiceBox b5 = new ChoiceBox().setTheme(ButtonTheme.PRIMARY)
        .insert(data);
    ChoiceBox b6 = new ChoiceBox().setTheme(ButtonTheme.SUCCESS)
        .insert(data);
    ChoiceBox b7 = new ChoiceBox().setTheme(ButtonTheme.WARNING)
        .insert(data);
    ChoiceBox b8 = new ChoiceBox().setTheme(ButtonTheme.OUTLINED_DEFAULT)
        .insert(data);
    ChoiceBox b9 = new ChoiceBox().setTheme(ButtonTheme.OUTLINED_DANGER)
        .insert(data);
    ChoiceBox b10 = new ChoiceBox().setTheme(ButtonTheme.OUTLINED_GRAY)
        .insert(data);
    ChoiceBox b11 = new ChoiceBox().setTheme(ButtonTheme.OUTLINED_INFO)
        .insert(data);
    ChoiceBox b12 = new ChoiceBox().setTheme(ButtonTheme.OUTLINED_PRIMARY)
        .insert(data);
    ChoiceBox b13 = new ChoiceBox().setTheme(ButtonTheme.OUTLINED_SUCCESS)
        .insert(data);
    ChoiceBox b14 = new ChoiceBox().setTheme(ButtonTheme.OUTLINED_WARNING)
        .insert(data);

    window.add(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14);

    b1.selectIndex(0);
    b2.selectIndex(0);
    b3.selectIndex(0);
    b4.selectIndex(0);
    b5.selectIndex(0);
    b6.selectIndex(0);
    b7.selectIndex(0);
    b8.selectIndex(0);
    b9.selectIndex(0);
    b10.selectIndex(0);
    b11.selectIndex(0);
    b12.selectIndex(0);
    b13.selectIndex(0);
    b14.selectIndex(0);
  }
}
