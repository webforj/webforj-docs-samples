package control_demos.radiobuttondemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.Expanse;
import org.dwcj.component.radiobutton.RadioButton;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/checkboxstyles/text_styles.css")
public class RadioButtonSwitch extends App{
  @Override
  public void run() throws DwcjException {
      Frame panel = new Frame();
      panel.addClassName("Frame");
      
      RadioButton normalButton = new RadioButton("Normal RadioButton")
        .setExpanse(Expanse.XLARGE);
      RadioButton switchButton = new RadioButton("Switch RadioButton")
        .setAttribute("switch", "true")
        .setExpanse(Expanse.XLARGE);

      panel.add(normalButton,switchButton);
  }
}
