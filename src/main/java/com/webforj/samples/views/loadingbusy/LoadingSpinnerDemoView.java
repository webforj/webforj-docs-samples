package com.webforj.samples.views.loadingbusy;

import com.webforj.Interval;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.Theme;
import com.webforj.component.html.elements.Div;
import com.webforj.component.loading.Loading;
import com.webforj.component.spinner.SpinnerExpanse;
import com.webforj.dispatcher.EventListener;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

/**
 * Demo to showcase the different customization options for the LoadingSpinner.
 */

@InlineStyleSheet(/*css */"""
    .card {
      border-radius: var(--dwc-border-radius-l);
      box-shadow: var(--dwc-shadow-s);
      padding: var(--dwc-space-l);
      width: 500px;
      height: 200px;
      background-color: var(--dwc-surface-2);
      margin: var(--dwc-space-xl) auto;    
    }
    """)

@Route
@FrameTitle("Loading Spinners")
public class LoadingSpinnerDemoView extends Composite<Div> {

  private int state = 1;
  
  Div parentDiv = new Div();
  Loading loading = new Loading("Displaying spinner with all themes...");
  Interval interval;
  
  public LoadingSpinnerDemoView() {
    
    parentDiv.addClassName("card");

    loading.setBackdropVisible(false);

    interval = new Interval(3f, new EventListener<Interval.ElapsedEvent>() {
      @Override
      public void onEvent(Interval.ElapsedEvent event) {
        switch (state) {
          case 1:
            loading.getSpinner().setTheme(Theme.DEFAULT).setExpanse(SpinnerExpanse.SMALL);
            loading.setText("Displaying default theme, small expanse");
            break;
          case 2:
            loading.getSpinner().setTheme(Theme.DANGER).setExpanse(SpinnerExpanse.MEDIUM);
            loading.setText("Displaying danger theme, medium expanse");
            break;
          case 3:
            loading.getSpinner().setTheme(Theme.GRAY).setExpanse(SpinnerExpanse.LARGE);
            loading.setText("Displaying gray theme, large expanse");
            break;
          case 4:
            loading.getSpinner().setTheme(Theme.INFO).setExpanse(SpinnerExpanse.SMALL);
            loading.setText("Displaying info theme, small expanse");
            break;
          case 5:
            loading.getSpinner().setTheme(Theme.PRIMARY).setExpanse(SpinnerExpanse.MEDIUM);
            loading.setText("Displaying primary theme, medium expanse");
            break;
          case 6:
            loading.getSpinner().setTheme(Theme.SUCCESS).setExpanse(SpinnerExpanse.LARGE);
            loading.setText("Displaying success theme, large expanse");
            break;
          case 7:
            loading.getSpinner().setTheme(Theme.WARNING).setExpanse(SpinnerExpanse.SMALL);
            loading.setText("Displaying warning theme, small expanse");
            break;
          case 8:
            loading.getSpinner().setClockwise(false);
            loading.setText("Now moving counterclockwise...");
            break;
          case 9:
            loading.getSpinner().setSpeed(500);
            loading.setText("Going faster...");
            break;
          default:
            event.getInterval().stop();
            loading.getSpinner().setTheme(Theme.PRIMARY);
            loading.setText("Demo complete!");
        }
        state++;
      }
    });
    
    getBoundComponent().add(parentDiv);
    parentDiv.add(loading);

    loading.open();

    interval.start();
  }
}

