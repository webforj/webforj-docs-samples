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
      align-items: center;
      justify-content: center;
      margin: 20px;
    }
    """)
public class SpinnerDemo extends App {

  @Override
  public void run() throws WebforjException {
    Frame frame = new Frame();
    frame.addClassName("window");

    Spinner processingSpinner = new Spinner(Theme.PRIMARY, SpinnerExpanse.MEDIUM);

    frame.add(processingSpinner);
  }
}

