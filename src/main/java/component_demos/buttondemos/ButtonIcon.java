package component_demos.buttondemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.button.Button;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/buttonstyles/icon_styles.css")
public class ButtonIcon extends App {
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("window");
    Button b1 = new Button("<html><bbj-icon name=\"alien\"></bbj-icon> Icon Left</html>");
    Button b2 = new Button("<html>Icon Right <bbj-icon name=\"alien\"></bbj-icon></html>");
    Button b3 = new Button("<html><bbj-icon name=\"alien\"></bbj-icon></html>");
    window.add(b1, b2, b3);
  }
}
