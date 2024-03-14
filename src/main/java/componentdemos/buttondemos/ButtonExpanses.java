package componentdemos.buttondemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Expanse;
import com.webforj.component.button.Button;
import com.webforj.component.window.Frame;
import com.webforj.component.html.elements.Div;
import com.webforj.exceptions.WebforjException;

/**
 * Simple program to demonstrate the various Button expanse values.
 */
@InlineStyleSheet("context://css/buttonstyles/expanse_styles.css")
public class ButtonExpanses extends App {
	
	Div container = new Div();
	
  @Override
  public void run() throws WebforjException {
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