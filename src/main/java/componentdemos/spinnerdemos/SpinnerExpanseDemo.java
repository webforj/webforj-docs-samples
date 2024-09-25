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
public class SpinnerExpanseDemo extends App {

  @Override
  public void run() throws WebforjException {
    Frame frame = new Frame();
    frame.addClassName("window");

    Spinner smallSpinner = new Spinner(Theme.PRIMARY, SpinnerExpanse.SMALL);
    Spinner mediumSpinner = new Spinner(Theme.PRIMARY, SpinnerExpanse.MEDIUM);
    Spinner largeSpinner = new Spinner(Theme.PRIMARY, SpinnerExpanse.LARGE);

    frame.add(smallSpinner, mediumSpinner, largeSpinner);
  }
}
