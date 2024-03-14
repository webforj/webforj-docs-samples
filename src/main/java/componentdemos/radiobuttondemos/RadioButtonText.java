package componentdemos.radiobuttondemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.concern.HasTextPosition.Position;
import com.webforj.component.optioninput.CheckBox;
import com.webforj.component.optioninput.RadioButton;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/radiobuttonstyles/radiobutton_styles.css")
public class RadioButtonText extends App{
  @Override
  public void run() throws WebforjException {
      Frame window = new Frame();
      window.addClassName("frame");
      RadioButton buttonRight = new RadioButton("Right aligned (default)");
      RadioButton buttonLeft = new RadioButton("Left aligned")
      .setTextPosition(Position.LEFT);
      window.add(buttonRight, buttonLeft, new CheckBox("CheckBox"));
  }
}
