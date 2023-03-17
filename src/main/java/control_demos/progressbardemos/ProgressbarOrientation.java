package control_demos.progressbardemos;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcException;

import org.dwcj.controls.progressbar.ProgressBar;

@InlineStyleSheet("context://css/progressbarstyles/orientation_styles.css")
public class ProgressbarOrientation extends App {

  ProgressBar pb;
  ProgressBar pb2;

  @Override
  public void run() throws DwcException {
    AppPanel panel = new AppPanel();
    panel.addClassName("appPanel");

    pb = new ProgressBar().addClassName("barVt");
    pb2 = new ProgressBar().addClassName("barHz");

    panel.add(pb2, pb);

    pb.setAttribute("orientation", "vertical")
      .setValue(75)
      .setMaximum(100);

    pb2.setValue(75)
      .setMaximum(100);
  }
}