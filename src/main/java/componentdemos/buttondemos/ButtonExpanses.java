package componentdemos.buttondemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.Expanse;
import org.dwcj.component.button.Button;
import org.dwcj.component.window.Frame;
import org.dwcj.component.html.elements.Div;
import org.dwcj.exceptions.DwcjException;

/**
 * Simple program to demonstrate the various Button expanse values.
 */
@InlineStyleSheet("context://css/buttonstyles/expanse_styles.css")
public class ButtonExpanses extends App {
	
	Div container = new Div();
	
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    container.addClassName("container");
    window.addClassName("Frame");

    for (int i = Expanse.values().length - 1; i >= 0; i--) {
      Button expanseButton = new Button(Expanse.values()[i].name());
      container.add(expanseButton.setExpanse(Expanse.values()[i]));
    }
    
    window.add(container);
  }
}