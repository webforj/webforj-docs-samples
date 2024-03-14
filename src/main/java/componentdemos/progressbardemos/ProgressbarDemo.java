package componentdemos.progressbardemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

import com.webforj.component.progressbar.ProgressBar;

@InlineStyleSheet("context://css/progressbarstyles/demo_styles.css")
public class ProgressbarDemo extends App {

    ProgressBar pb;

    @Override
    public void run() throws WebforjException {

        Frame window = new Frame();
        window.addClassName("Frame");
        pb = new ProgressBar();
        window.add(pb);
        pb.addClassName("progress__bar");
        pb.setMaximum(100);
        pb.setAttribute("indeterminate", "true");
    }

}
