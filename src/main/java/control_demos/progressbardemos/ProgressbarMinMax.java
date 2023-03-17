package control_demos.progressbardemos;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcException;
import org.dwcj.controls.progressbar.ProgressBar;

@InlineStyleSheet("context://css/progressbarstyles/minmax_styles.css")
public class ProgressbarMinMax extends App {

  ProgressBar pb;

  @Override
  public void run() throws DwcException {
    AppPanel panel = new AppPanel();
    panel.addClassName("appPanel");

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