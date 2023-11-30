package componentdemos.choiceboxdemos;

import java.util.ArrayList;
import java.util.List;
import org.dwcj.App;
import org.dwcj.component.window.Frame;
import org.dwcj.component.button.Button;
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

    for (ButtonTheme theme : ButtonTheme.values()) {
      if (!theme.name().contains("OUTLINE")) {
        ChoiceBox themeChoiceBox = new ChoiceBox();
        themeChoiceBox.insert(data)
            .selectIndex(0);
        window.add(themeChoiceBox.setTheme(theme));
      }
    }

    for (ButtonTheme theme : ButtonTheme.values()) {
      if (theme.name().contains("OUTLINE")) {
        ChoiceBox themeChoiceBox = new ChoiceBox();
        themeChoiceBox.insert(data)
            .selectIndex(0);
        window.add(themeChoiceBox.setTheme(theme));
      }
    }
  }
}
