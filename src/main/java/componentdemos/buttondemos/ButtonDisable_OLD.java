package componentdemos.buttondemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.window.Frame;
import com.webforj.component.window.Panel;
import com.webforj.exceptions.WebforjException;

/**
 * Application to show the disabled functionality of a button.
 */
@InlineStyleSheet("context://css/buttonstyles/disable_styles.css")
public class ButtonDisable_OLD extends App {
  @Override
  public void run() throws WebforjException {
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
