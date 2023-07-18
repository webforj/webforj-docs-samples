package control_demos.buttondemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.button.Button;
import org.dwcj.component.texts.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/buttonstyles/event_styles.css")
public class ButtonEvent extends App{
  
  Integer counter;
  Label text;

  @Override
  public void run() throws DwcjException {
    Frame window = new Frame()
      .addClassName("window");
    
    Button button = new Button("Click Me!");
    text = new Label("Current Counter: 0");
    counter = 0;

    button.addClickListener(e -> {
      text.setText("Current Counter: " + (++counter));
    });
    
    window.add(button, text);
  }
}
