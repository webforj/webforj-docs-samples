package componentdemos.progressbar;

import com.webforj.App;
import com.webforj.component.Theme;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.progressbar.ProgressBar;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class ProgressBarThemes extends App {

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    FlexLayout layout = FlexLayout.create(window).vertical().build()
        .setStyle("max-width", "320px")
        .setStyle("margin", "0 auto")
        .setStyle("padding", "20px");
    window.add(layout);

    for (Theme theme : Theme.values()) {
      ProgressBar bar = new ProgressBar();
      bar.setAnimated(true)
          .setValue(50)
          .setStriped(true)
          .setText(theme.name() + " {{x}}%");
      bar.setTheme(theme);
      layout.add(bar);
    }
  }
}
