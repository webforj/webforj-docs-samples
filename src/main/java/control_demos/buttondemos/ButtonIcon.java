package control_demos.buttondemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.button.Button;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/buttonstyles/icon_styles.css")
public class ButtonIcon extends App {
  @Override
  public void run() throws DwcjException {
    Frame panel = new Frame();
    panel.addClassName("Frame");
    Button b1 = new Button("<html><bbj-icon name=\"alien\"></bbj-icon> Icon Left</html>");
    panel.add(b1);
    Button b2 = new Button("<html>Icon Right <bbj-icon name=\"alien\"></bbj-icon></html>");
    panel.add(b2);
    Button b3 = new Button("<html><bbj-icon name=\"alien\"></bbj-icon></html>");
    panel.add(b3);
  }
}
