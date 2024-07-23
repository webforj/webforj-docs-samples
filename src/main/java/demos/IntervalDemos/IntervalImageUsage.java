package demos.IntervalDemos;

import com.webforj.Interval;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.window.Frame;
import com.webforj.dispatcher.EventListener;
import com.webforj.exceptions.WebforjException;
import com.webforj.App;
import com.webforj.component.html.elements.Div;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;

import java.util.ArrayList;
import java.util.ListIterator;

@InlineStyleSheet(/* css */"""
      dwc-icon {
        font-size: 150px;
        animation-name: fade;
        animation-duration: 4s;
        animation-iteration-count: infinite;
    }
      @keyframes fade {
      0% {opacity: 0;}
      50% {opacity: 1;}
      100% {opacity: 0;}
    }
    """)

public class IntervalImageUsage extends App {

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();

    String car = "<dwc-icon name=\"car\"></dwc-icon>";
    String plane = "<dwc-icon name=\"plane\"></dwc-icon>";
    String ship = "<dwc-icon name=\"ship\"></dwc-icon>";

    Div carDiv = new Div();
    carDiv.setHtml(car);
    carDiv.setVisible(false);

    Div planeDiv = new Div();
    planeDiv.setHtml(plane);
    planeDiv.setVisible(false);

    Div shipDiv = new Div();
    shipDiv.setHtml(ship);
    shipDiv.setVisible(false);

    ArrayList<Div> display = new ArrayList<>();

    display.add(carDiv);
    display.add(planeDiv);
    display.add(shipDiv);

    ListIterator<Div> displayIterator = display.listIterator(0);

    EventListener<Interval.ElapsedEvent> listener = (e -> {
      if (displayIterator.hasNext()) {

        if (displayIterator.hasPrevious()) {
          display.get(displayIterator.previousIndex()).setVisible(false);
        }

        displayIterator.next().setVisible(true);

      } else {
        displayIterator.previous();
        displayIterator.previous();
        display.get(2).setVisible(false);
        display.get(0).setVisible(true);

      }
    });

    float delay = 4f;
    Interval interval = new Interval(delay, listener);
    interval.start();

    FlexLayout mainLayout = new FlexLayout(carDiv, planeDiv, shipDiv)
        .setJustifyContent(FlexJustifyContent.CENTER);

    window.add(mainLayout);

  }
}