package componentdemos.choiceboxdemos;

import java.util.ArrayList;
import java.util.List;
import com.webforj.App;
import com.webforj.component.window.Frame;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.list.ChoiceBox;
import com.webforj.component.list.ListItem;
import com.webforj.exceptions.WebforjException;
import com.webforj.annotation.InlineStyleSheet;

@InlineStyleSheet("context://css/comboboxstyles/theme_styles.css")
public class ComboboxThemeDemo extends App {

  private static final String THEME = "theme";

  @Override
  public void run() throws WebforjException {
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
