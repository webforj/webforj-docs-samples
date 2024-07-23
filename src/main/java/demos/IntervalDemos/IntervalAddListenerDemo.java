package demos.IntervalDemos;

import com.webforj.Interval;
import com.webforj.App;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.window.Frame;
import com.webforj.dispatcher.EventListener;
import com.webforj.exceptions.WebforjException;

import java.util.ArrayList;
import java.util.ListIterator;

public class IntervalAddListenerDemo extends App {

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();

    float delay = 1f;

    String baby = """
        <html>
            <dwc-icon name=\"baby-carriage\"></dwc-icon>
        </html>
        """;

    String kid = """
        <html>
            <dwc-icon name=\"skateboarding\"></dwc-icon>
        </html>
        """;

    String adult = """
        <html>
            <dwc-icon name=\"run\"></dwc-icon>
        </html>
        """;

    String old = """
        <html>
            <dwc-icon name=\"old\"></dwc-icon>
        </html>
        """;

    ArrayList<String> display = new ArrayList<>();

    display.add(baby);
    display.add(kid);
    display.add(adult);
    display.add(old);

    ListIterator<String> displayIterator = display.listIterator(0);

    Button displayButton = new Button();
    displayButton.setStyle("width", "70px");

    EventListener<Interval.ElapsedEvent> listener = (e -> {
      if (displayIterator.hasNext()) {
        displayButton.setText(displayIterator.next());
      }
      else {
        displayIterator.previous();
        displayIterator.previous();
        displayIterator.previous();
        displayButton.setText(display.get(0));
      }
    });

    Interval interval = new Interval(delay, listener);
    
    ArrayList<ButtonTheme> theme = new ArrayList<>();

    theme.add(ButtonTheme.OUTLINED_DEFAULT);
    theme.add(ButtonTheme.DEFAULT);

    ListIterator<ButtonTheme> themeIterator = theme.listIterator(0);

    EventListener<Interval.ElapsedEvent> themeListener = (e -> {
        if (themeIterator.hasNext()) {
          displayButton.setTheme(themeIterator.next());
        }
        else {
          themeIterator.previous();
          displayButton.setTheme(theme.get(0));
        }
      });

    interval.start();
    interval.addElapsedListener(themeListener);

    FlexLayout mainLayout = new FlexLayout(displayButton)
        .setJustifyContent(FlexJustifyContent.CENTER);

    mainLayout
        .setPadding("10px");

    window.add(mainLayout);

  }
}

