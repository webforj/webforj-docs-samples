package componentdemos.progressbardemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.texts.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;
import org.dwcj.component.progressbar.ProgressBar;

@InlineStyleSheet("context://css/progressbarstyles/minmax_styles.css")
public class ProgressbarMinMax extends App {

  ProgressBar pb;

  @Override
  public void run() throws DwcjException {
    Frame panel = new Frame();
    panel.addClassName("Frame");

    pb = new ProgressBar();
    Label lb = new Label("Min 50, Max 200");
    panel.add(lb, pb);

    pb.setText("100/200")
        .setMinimum(50)
        .setMaximum(200)
        .setValue(100)
        .addClassName("progress__bar");
  }
}
