package componentdemos.buttondemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.ButtonTheme;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.exceptions.DwcjException;

/**
 * Application to show the disabled functionality of a button.
 */
@InlineStyleSheet("context://css/buttonstyles/disable_styles.css")
public class ButtonDisable extends App {
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    Panel disabled = new Panel();
    final int THEME_NUM = 4;
    ButtonTheme[] themes = {
      ButtonTheme.DEFAULT, 
      ButtonTheme.PRIMARY, 
      ButtonTheme.SUCCESS, 
      ButtonTheme.DANGER};
    
    window.addClassName("Frame");
    window.add(disabled);
    disabled.addClassName("disabledButtons");
    
    for (int i = 0; i < 8; i++) {
      int index = i % THEME_NUM;
      Button button = new Button(themes[index].name().toUpperCase());
      disabled.add(button);
      button.setTheme(themes[index]);
      if (i >= THEME_NUM) {
        button.setEnabled(false);
        button.setText(themes[index].name().toUpperCase() + " DISABLED");
      }
    }
  }
}
