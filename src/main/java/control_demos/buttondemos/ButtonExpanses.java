package control_demos.buttondemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.component.Expanse;
import org.dwcj.component.button.Button;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/buttonstyles/expanse_styles.css")
public class ButtonExpanses extends App {
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    Panel container = new Panel().addClassName("container");
    window.addClassName("Frame");

    for(int i = Expanse.values().length - 1; i >= 0; i--){
      container.add(new Button(Expanse.values()[i].name()).setExpanse(Expanse.values()[i]));
    }
    window.add(container);
  }
}