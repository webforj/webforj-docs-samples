package demos.IntervalDemos;

import com.webforj.Interval;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.window.Frame;
import com.webforj.dispatcher.EventListener;
import com.webforj.exceptions.WebforjException;
import com.webforj.App;
import com.webforj.component.html.elements.Img;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;

import java.util.ArrayList;
import java.util.ListIterator;

@InlineStyleSheet(/* css */"""
      img {
        animation-name: fade;
        animation-duration: 4s;
        animation-iteration-count: infinite;
        border: 10px solid Navy;
        border-radius: 50px;
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

    String rootURL = "https://raw.githubusercontent.com/webforj/webforj-docs/website/static/img/";

    Img image1 = new Img(rootURL+"dynamic.png");
    Img image2 = new Img(rootURL+"development.png");
    Img image3 = new Img(rootURL+"performance.png");

    image1.setVisible(false);
    image2.setVisible(false);
    image3.setVisible(false);

    image1.setHeight("200px");
    image2.setHeight("200px");
    image3.setHeight("200px");

    ArrayList<Img> display = new ArrayList<>();

    display.add(image1);
    display.add(image2);
    display.add(image3);

    ListIterator<Img> displayIterator = display.listIterator(0);

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

    FlexLayout mainLayout = new FlexLayout(image1, image2, image3)
        .setJustifyContent(FlexJustifyContent.CENTER);
    
    mainLayout.setMargin("10px");

    window.add(mainLayout);

  }
}