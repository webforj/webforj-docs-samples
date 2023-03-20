package control_demos.buttondemos;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.button.Button;
import org.dwcj.exceptions.DwcException;

@InlineStyleSheet("context://css/buttonstyles/theme_styles.css")
public class ButtonThemes extends App {
  @Override
  public void run() throws DwcException {
    AppPanel panel = new AppPanel();
    panel.addClassName("appPanel");

    for(Button.Theme theme : Button.Theme.values()){
      panel.add(new Button(theme.name()).setTheme(theme));
    }
  }
}
