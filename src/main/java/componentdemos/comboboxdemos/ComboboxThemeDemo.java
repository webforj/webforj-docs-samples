package componentdemos.comboboxdemos;

import java.util.HashMap;
import java.util.Map;
import org.dwcj.App;
import org.dwcj.component.window.Frame;
import org.dwcj.component.choicebox.ChoiceBox;
import org.dwcj.exceptions.DwcjException;
import org.dwcj.annotation.InlineStyleSheet;

@InlineStyleSheet("context://css/comboboxstyles/theme_styles.css")
public class ComboboxThemeDemo extends App {

  private static final String THEME = "theme";

  @Override
  public void run() throws DwcjException {
    Frame panel = new Frame();
    panel.addClassName("Frame");

    Map<Object, String> data = new HashMap<>();
    data.put("Random Data1", "Random Data");
    data.put("Random Data2", "Some Data");
    data.put("Random Data3", "More Data");
    data.put("Random Data4", "Test Data");

    ChoiceBox b1 = new ChoiceBox().setItems(data);
    ChoiceBox b2 = new ChoiceBox().setAttribute(THEME, "danger")
        .setItems(data);
    ChoiceBox b3 = new ChoiceBox().setAttribute(THEME, "gray")
        .setItems(data);
    ChoiceBox b4 = new ChoiceBox().setAttribute(THEME, "info")
        .setItems(data);
    ChoiceBox b5 = new ChoiceBox().setAttribute(THEME, "primary")
        .setItems(data);
    ChoiceBox b6 = new ChoiceBox().setAttribute(THEME, "success")
        .setItems(data);
    ChoiceBox b7 = new ChoiceBox().setAttribute(THEME, "warning")
        .setItems(data);
    ChoiceBox b8 = new ChoiceBox().setAttribute(THEME, "outlined-default")
        .setItems(data);
    ChoiceBox b9 = new ChoiceBox().setAttribute(THEME, "outlined-danger")
        .setItems(data);
    ChoiceBox b10 = new ChoiceBox().setAttribute(THEME, "outlined-gray")
        .setItems(data);
    ChoiceBox b11 = new ChoiceBox().setAttribute(THEME, "outlined-info")
        .setItems(data);
    ChoiceBox b12 = new ChoiceBox().setAttribute(THEME, "outlined-primary")
        .setItems(data);
    ChoiceBox b13 = new ChoiceBox().setAttribute(THEME, "outlined-success")
        .setItems(data);
    ChoiceBox b14 = new ChoiceBox().setAttribute(THEME, "outlined-warning")
        .setItems(data);

    panel.add(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14);

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
