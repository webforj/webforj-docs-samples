package component_demos.radiobuttondemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.TextPosition.Position;
import org.dwcj.component.optioninput.RadioButton;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/checkboxstyles/text_styles.css")
public class RadioButtonActivation extends App{
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
