package componentdemos.buttondemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.button.Button;
import com.webforj.component.html.elements.Div;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.layout.flexlayout.FlexLayoutBuilder;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

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
  public void run() throws WebforjException {
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
