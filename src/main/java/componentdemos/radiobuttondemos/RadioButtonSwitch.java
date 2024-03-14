package componentdemos.radiobuttondemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Expanse;
import com.webforj.component.optioninput.RadioButton;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/radiobuttonstyles/radiobutton_styles.css")
public class RadioButtonSwitch extends App{
  @Override
  public void run() throws WebforjException {
      Frame window = new Frame();
      window.addClassName("frame");
      window.setStyle("flex-direction", "row");
      
      RadioButton normalButton = new RadioButton("Normal RadioButton")
        .setExpanse(Expanse.XLARGE);
      RadioButton switchButton = RadioButton.Switch("Switch RadioButton")
        .setExpanse(Expanse.XLARGE);

      window.add(normalButton,switchButton);
  }
}
