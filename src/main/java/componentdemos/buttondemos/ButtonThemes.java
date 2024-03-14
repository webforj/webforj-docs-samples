package componentdemos.buttondemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

/**
 * Simple program to demonstrate the various ButtonThemes.
 */
@InlineStyleSheet("context://css/buttonstyles/theme_styles.css")
public class ButtonThemes extends App {
  @Override
  public void run() throws WebforjException {
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
