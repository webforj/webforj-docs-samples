package componentdemos.checkboxdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.window.Frame;
import com.webforj.component.Expanse;
import com.webforj.component.optioninput.CheckBox;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/checkboxstyles/expanse_styles.css")
public class CheckboxExpanseDemo extends App {
  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    for (int i = Expanse.values().length - 1; i >= 0; i--) {
      CheckBox expanseCheckBox = new CheckBox(Expanse.values()[i].name());
      window.add(expanseCheckBox.setExpanse(Expanse.values()[i]));
    }

  }
}
