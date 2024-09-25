package componentdemos.spinnerdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Theme;
import com.webforj.component.spinner.Spinner;
import com.webforj.component.spinner.SpinnerExpanse;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet(/*css */"""
    .window {
      display: flex;
      flex-direction: row;
      align-items: center;
      justify-content: center;
      gap: var(--dwc-space-m);
      margin: 20px;
    }
    """)
public class SpinnerThemeDemo extends App {

  @Override
  public void run() throws WebforjException {
    Frame frame = new Frame();
    frame.addClassName("window");

    Spinner defaultSpinner = new Spinner(Theme.DEFAULT, SpinnerExpanse.MEDIUM);
    Spinner primarySpinner = new Spinner(Theme.PRIMARY, SpinnerExpanse.MEDIUM);
    Spinner successSpinner = new Spinner(Theme.SUCCESS, SpinnerExpanse.MEDIUM);
    Spinner dangerSpinner = new Spinner(Theme.DANGER, SpinnerExpanse.MEDIUM);
    Spinner warningSpinner = new Spinner(Theme.WARNING, SpinnerExpanse.MEDIUM);
    Spinner graySpinner = new Spinner(Theme.GRAY, SpinnerExpanse.MEDIUM);
    Spinner infoSpinner = new Spinner(Theme.INFO, SpinnerExpanse.MEDIUM);
    

    frame.add(defaultSpinner, primarySpinner, successSpinner, dangerSpinner, warningSpinner, graySpinner, infoSpinner);
  }
}
