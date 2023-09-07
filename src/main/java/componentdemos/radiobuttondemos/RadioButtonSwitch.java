package componentdemos.radiobuttondemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.Expanse;
import org.dwcj.component.optioninput.RadioButton;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/checkboxstyles/text_styles.css")
public class RadioButtonSwitch extends App{
  @Override
  public void run() throws DwcjException {
      Frame window = new Frame();
      window.addClassName("Frame");
      
      RadioButton normalButton = new RadioButton("Normal RadioButton")
        .setExpanse(Expanse.XLARGE);
      RadioButton switchButton = RadioButton.Switch("Switch RadioButton")
        .setExpanse(Expanse.XLARGE);

      window.add(normalButton,switchButton);
  }
}
