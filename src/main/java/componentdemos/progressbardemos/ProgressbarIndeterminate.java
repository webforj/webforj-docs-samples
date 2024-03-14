package componentdemos.progressbardemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;
import com.webforj.component.progressbar.ProgressBar;

@InlineStyleSheet("context://css/progressbarstyles/indeterminate_styles.css")
public class ProgressbarIndeterminate extends App {

  ProgressBar pb;

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    pb = new ProgressBar();

    window.addClassName("Frame").add(pb);

    pb.setIndeterminate(true)
        .addClassName("progress__bar")
        .setText("Syncing Files");
  }
}
