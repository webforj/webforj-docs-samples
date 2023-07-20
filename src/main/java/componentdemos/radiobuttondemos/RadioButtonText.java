package componentdemos.radiobuttondemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.TextPosition.Position;
import org.dwcj.component.optioninput.RadioButton;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/radiobuttonstyles/radiobutton_styles.css")
public class RadioButtonText extends App{
  @Override
  public void run() throws DwcjException {
      Frame panel = new Frame();
      panel.addClassName("Frame");
      RadioButton buttonRight = new RadioButton("Right aligned (default)");
      RadioButton buttonLeft = new RadioButton("Left aligned")
      .setTextPosition(Position.LEFT);
      panel.add(buttonRight, buttonLeft);
  }
}
