package componentdemos.progressbardemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjAppInitializeException;

import org.dwcj.component.progressbar.ProgressBar;

@InlineStyleSheet("context://css/progressbarstyles/demo_styles.css")
public class ProgressbarDemo extends App {

    ProgressBar pb;

    @Override
    public void run() throws DwcjAppInitializeException {

        Frame panel = new Frame();
        panel.addClassName("Frame");
        pb = new ProgressBar();
        panel.add(pb);
        pb.addClassName("progress__bar");
        pb.setMaximum(100);
        pb.setAttribute("indeterminate", "true");
    }

}
