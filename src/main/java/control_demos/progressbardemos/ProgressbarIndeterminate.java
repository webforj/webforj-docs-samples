package control_demos.progressbardemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;
import org.dwcj.component.progressbar.ProgressBar;

@InlineStyleSheet("context://css/progressbarstyles/indeterminate_styles.css")
public class ProgressbarIndeterminate extends App {

  ProgressBar pb;

  @Override
  public void run() throws DwcjException {
    Frame panel = new Frame();
    pb = new ProgressBar();

    panel.addClassName("Frame").add(pb);

    pb.setIndeterminate(true)
        .addClassName("progress__bar")
        .setText("Syncing Files");
  }
}
