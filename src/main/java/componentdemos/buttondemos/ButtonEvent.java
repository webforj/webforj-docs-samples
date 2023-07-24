package componentdemos.buttondemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.button.Button;
import org.dwcj.component.layout.flexlayout.FlexLayout;
import org.dwcj.component.layout.flexlayout.FlexLayoutBuilder;
import org.dwcj.component.texts.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

/**
 * Demonstration for Button events.
 */
@InlineStyleSheet("context://css/buttonstyles/event_styles.css")
public class ButtonEvent extends App {

  Integer counter;
  Label text;
  Label payload;

  @Override
  public void run() throws DwcjException {
    final Frame window = new Frame();
    window.addClassName("window");

    Button button = new Button("Click Me!");
    button.setStyle("width", "150px");
    text = new Label("Current Counter: 0");
    payload = new Label("Event payload: null");

    FlexLayout textDisplay = new FlexLayoutBuilder(text, payload)
        .vertical()
        .build()
        .setSpacing("0px");

    counter = 0;
    button.addClickListener(e -> {
      text.setText("Current Counter: " + (++counter));
      payload.setText("Event payload: " + e.getData().toString());
    });

    window.add(button, textDisplay);
  }
}
