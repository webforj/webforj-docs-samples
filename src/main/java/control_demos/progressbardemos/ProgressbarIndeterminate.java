package control_demos.progressbardemos;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcException;
import org.dwcj.controls.progressbar.ProgressBar;

@InlineStyleSheet("context://css/progressbarstyles/indeterminate_styles.css")
public class ProgressbarIndeterminate extends App {

  ProgressBar pb;

  @Override
  public void run() throws DwcException {
    AppPanel panel = new AppPanel();
    pb = new ProgressBar();

    panel.addClassName("appPanel").add(pb);

    pb.setIndeterminate(true)
      .addClassName("progress__bar")
      .setText("Syncing Files");
  }
}
