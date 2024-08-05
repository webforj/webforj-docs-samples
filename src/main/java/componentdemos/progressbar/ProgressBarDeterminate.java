package componentdemos.progressbar;

import com.webforj.App;
import com.webforj.component.progressbar.ProgressBar;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class ProgressBarDeterminate extends App {

  @Override
  public void run() throws WebforjException {
    ProgressBar bar = new ProgressBar();
    bar.setIndeterminate(true)
        .setAnimated(true)
        .setStriped(true)
        .setText("Loading...");

    Frame window = new Frame();
    window.setMaxWidth("320px")
        .setStyle("margin", "0 auto")
        .setStyle("padding", "20px");
    window.add(bar);
  }
}
