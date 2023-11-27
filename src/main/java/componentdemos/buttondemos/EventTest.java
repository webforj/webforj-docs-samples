package componentdemos.buttondemos;

import java.util.EventObject;
import org.dwcj.App;
import org.dwcj.component.button.Button;
import org.dwcj.component.window.Frame;
import org.dwcj.dispatcher.EventDispatcher;
import org.dwcj.dispatcher.ListenerRegistration;
import org.dwcj.exceptions.DwcjException;

public class EventTest extends App {

  @Override
  public void run() throws DwcjException {
    Frame f = new Frame();

    EventDispatcher dispatcher = new EventDispatcher();
    ListenerRegistration<EventObject> r1 = dispatcher.addListener(EventObject.class, (e) -> {
      msgbox("Listening 1");
    });
    dispatcher.addListener(EventObject.class, (e) -> {
      msgbox("Listening 2");
    });

    Button test = new Button("Test EventDispatcher");
    test.onClick((e) -> {
      // dispatche events
      dispatcher.dispatchEvent(new EventObject(this));
      r1.remove();
    });

    f.add(test);
  }
}