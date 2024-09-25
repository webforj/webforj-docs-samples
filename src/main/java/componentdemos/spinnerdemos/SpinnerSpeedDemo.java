package componentdemos.spinnerdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Theme;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.html.elements.Div;
import com.webforj.component.spinner.Spinner;
import com.webforj.component.spinner.SpinnerExpanse;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet(/*css */"""
    .window {
      display: flex;
      flex-direction: column;
      align-items: center;
      justify-content: center;
      gap: var(--dwc-space-m);
      margin: 20px;
    }
    .button-container {
      display: flex;
      gap: var(--dwc-space-s);
    }
    """)
public class SpinnerSpeedDemo extends App {

  @Override
  public void run() throws WebforjException {
    Frame frame = new Frame();
    frame.addClassName("window");

    Spinner spinner = new Spinner(Theme.PRIMARY, SpinnerExpanse.MEDIUM);

    Button slowButton = new Button("Slow", e -> setSpinnerSpeed(spinner, 1000));
    Button mediumButton = new Button("Medium", e -> setSpinnerSpeed(spinner, 500));
    Button fastButton = new Button("Fast", e -> setSpinnerSpeed(spinner, 200));
    
    Button pauseResumeButton = new Button("Pause", e ->  spinner.setPaused(true));
    pauseResumeButton.setTheme(ButtonTheme.PRIMARY);

    frame.add(spinner);
    frame.add(new Div(slowButton, mediumButton, fastButton, pauseResumeButton)
         .addClassName("button-container"));
  }

  private void setSpinnerSpeed(Spinner spinner, int speed) {
    spinner.setSpeed(speed);
    spinner.setPaused(false);
  }

}