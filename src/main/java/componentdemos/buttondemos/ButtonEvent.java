package componentdemos.buttondemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.button.Button;
import org.dwcj.component.html.elements.Div;
import org.dwcj.component.layout.flexlayout.FlexLayout;
import org.dwcj.component.layout.flexlayout.FlexLayoutBuilder;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

/**
 * Demonstration for Button events.
 */
@InlineStyleSheet(/*css */ """
  .window{
    display: flex;
    flex-direction: row;
    gap: 15px;
    padding: 20px;
    width: 100%;
  }
""")
public class ButtonEvent extends App {

  int counter = 0;
  Div text = new Div("Current Counter: 0");
  Div payload = new Div("Event Payload: null");

  @Override
  public void run() throws DwcjException {
    final Frame window = new Frame();
    window.addClassName("window");

    Button button = new Button("Click Me!");
    button.setStyle("width", "150px");

    FlexLayout textDisplay = new FlexLayoutBuilder(text, payload)
        .vertical()
        .build()
        .setSpacing("0px");

    button.addClickListener(e -> {
      text.setText("Current Counter: " + (++counter));
      payload.setText("Event payload: " + e.getData().toString());
    });

    window.add(button, textDisplay);
  }
}
