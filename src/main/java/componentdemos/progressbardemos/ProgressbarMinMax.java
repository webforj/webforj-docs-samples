package componentdemos.progressbardemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.text.Label;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;
import com.webforj.component.progressbar.ProgressBar;

@InlineStyleSheet("context://css/progressbarstyles/minmax_styles.css")
public class ProgressbarMinMax extends App {

  ProgressBar pb;

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    pb = new ProgressBar();
    Label lb = new Label("Min 50, Max 200");
    window.add(lb, pb);

    pb.setText("100/200")
        .setMinimum(50)
        .setMaximum(200)
        .setValue(100)
        .addClassName("progress__bar");
  }
}
