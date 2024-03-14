package componentdemos.progressbardemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

import com.webforj.component.progressbar.ProgressBar;

@InlineStyleSheet("context://css/progressbarstyles/orientation_styles.css")
public class ProgressbarOrientation extends App {

  ProgressBar pb;
  ProgressBar pb2;

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    pb = new ProgressBar().addClassName("barVt");
    pb2 = new ProgressBar().addClassName("barHz");

    window.add(pb2, pb);

    pb.setAttribute("orientation", "vertical")
        .setValue(75)
        .setMaximum(100);

    pb2.setValue(75)
        .setMaximum(100);
  }
}
