package control_demos.buttondemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.button.Button;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/buttonstyles/theme_styles.css")
public class ButtonThemes extends App {
  @Override
  public void run() throws DwcjException {
    Frame panel = new Frame();
    panel.addClassName("Frame");

    for (Button.Theme theme : Button.Theme.values()) {
      panel.add(new Button(theme.name()).setTheme(theme));
    }
  }
}
