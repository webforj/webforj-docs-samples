package componentdemos.spinnerdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Theme;
import com.webforj.component.button.Button;
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
public class SpinnerDirectionDemo extends App {

  @Override
  public void run() throws WebforjException {
    Frame frame = new Frame();
    frame.addClassName("window");

    Spinner spinner = new Spinner(Theme.PRIMARY, SpinnerExpanse.MEDIUM);
    spinner.setVisible(true);

    Button clockwiseButton = new Button("Clockwise", e -> spinner.setClockwise(true));
    Button counterClockwiseButton = new Button("Counterclockwise", e -> spinner.setClockwise(false));

    frame.add(spinner);
    frame.add(new Div(clockwiseButton, counterClockwiseButton).addClassName("button-container"));
  }
}
