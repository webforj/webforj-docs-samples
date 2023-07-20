package componentdemos.buttondemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.button.Button;
import org.dwcj.component.texts.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/buttonstyles/event_styles.css")
public class ButtonEvent extends App{
  
  Integer counter;
  Label text;
  Label payload;

  @Override
  public void run() throws DwcjException {
    Frame window = new Frame()
      .addClassName("window");

    Button button = new Button("Click Me!")
      .setStyle("width", "150px");
    text = new Label("<html><b>Current Counter:</b></html> 0");
    payload = new Label("<html><b>Event payload:</b></html> ");
    Panel textDisplay = new Panel()
      .add(text, payload)
      .addClassName("text--display");
    counter = 0;

    button.addClickListener(e -> {
      text.setText("<html><b>Current Counter:</b></html> " + (++counter));
      payload.setText("<html><b>Event payload:</b></html> " + e.getData().toString());
    });
    
    window.add(button, textDisplay);
  }
}
