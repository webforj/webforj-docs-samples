package control_demos.progressbardemos;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcException;

import org.dwcj.controls.progressbar.ProgressBar;

@InlineStyleSheet("context://css/progressbarstyles/placeholder_styles.css")
public class ProgressbarPlaceholders extends App {

  ProgressBar pb;

  @Override
  public void run() throws DwcException {
    AppPanel panel = new AppPanel();
    panel.addClassName("appPanel");

    pb = new ProgressBar();
    panel.add(pb);

    pb.addClassName("progress__bar")
      .setMaximum(100).setValue(75)
      .setText("{{x}}%  ,  {{value}}/" + pb.getMaximum().toString());
  }
}