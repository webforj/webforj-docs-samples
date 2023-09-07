package componentdemos.buttondemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.ButtonTheme;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

/**
 * Simple program to demonstrate the various ButtonThemes.
 */
@InlineStyleSheet("context://css/buttonstyles/theme_styles.css")
public class ButtonThemes extends App {
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    for (ButtonTheme theme : ButtonTheme.values()) {
      if (!theme.name().contains("OUTLINE")) {
        Button themeButton = new Button(theme.name());
        window.add(themeButton.setTheme(theme));
      }
    }

    for (ButtonTheme theme : ButtonTheme.values()) {
      if (theme.name().contains("OUTLINE")) {
        Button themeButton = new Button(theme.name());
        window.add(themeButton.setTheme(theme));
      }
    }
  }
}
