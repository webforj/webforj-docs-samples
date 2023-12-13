package componentdemos.checkboxdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.optioninput.CheckBox;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/checkboxstyles/text_styles.css")
public class CheckboxEventDemo extends App {

  CheckBox checkbox;

  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("Frame");
    checkbox = new CheckBox()
        .setText("Please check to accept Terms and Conditions");
    window.add(checkbox);

    checkbox.onCheck(e -> checkbox.setText("You have accepted the Terms and Conditions"));

    checkbox.onUncheck(e -> checkbox.setText("Please check to accept the Terms and Conditions"));

  }

}
