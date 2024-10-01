package componentdemos.loadingbusydemos;

import com.webforj.App;
import com.webforj.BusyIndicator;
import com.webforj.Interval;
import com.webforj.component.Theme;
import com.webforj.component.spinner.SpinnerExpanse;
import com.webforj.dispatcher.EventListener;
import com.webforj.exceptions.WebforjException;

public class BusySpinnerDemo extends App {

    private int state = 1;

    @Override
    public void run() throws WebforjException {

        BusyIndicator indicator = getBusyIndicator();
        indicator.setText("Displaying spinner with all themes...");

        Interval interval = new Interval(3f, new EventListener<Interval.ElapsedEvent>() {
            @Override
            public void onEvent(Interval.ElapsedEvent event) {
                switch (state) {
                    case 1:
                        indicator.getSpinner().setTheme(Theme.DEFAULT).setExpanse(SpinnerExpanse.SMALL);
                        indicator.setText("Displaying default theme, small expanse");
                        break;
                    case 2:
                        indicator.getSpinner().setTheme(Theme.DANGER).setExpanse(SpinnerExpanse.MEDIUM);
                        indicator.setText("Displaying danger theme, medium expanse");
                        break;
                    case 3:
                        indicator.getSpinner().setTheme(Theme.GRAY).setExpanse(SpinnerExpanse.LARGE);
                        indicator.setText("Displaying gray theme, large expanse");
                        break;
                    case 4:
                      indicator.getSpinner().setTheme(Theme.INFO).setExpanse(SpinnerExpanse.SMALL);
                      indicator.setText("Displaying info theme, small expanse");
                      break;
                    case 5:
                      indicator.getSpinner().setTheme(Theme.PRIMARY).setExpanse(SpinnerExpanse.MEDIUM);
                      indicator.setText("Displaying primary theme, medium expanse");
                      break;
                    case 6:
                      indicator.getSpinner().setTheme(Theme.SUCCESS).setExpanse(SpinnerExpanse.LARGE);
                      indicator.setText("Displaying success theme, large expanse");
                      break;
                    case 7:
                      indicator.getSpinner().setTheme(Theme.WARNING).setExpanse(SpinnerExpanse.SMALL);
                      indicator.setText("Displaying warning theme, small expanse");
                      break;
                    case 8:
                        indicator.getSpinner().setClockwise(false);
                        indicator.setText("Now moving counterclockwise...");
                        break;
                    case 9:
                        indicator.getSpinner().setSpeed(500);
                        indicator.setText("Going faster...");
                        break;
                    default:
                        event.getInterval().stop();
                        indicator.getSpinner().setTheme(Theme.PRIMARY);
                        indicator.setText("Demo complete!");
                }
                state++;
            }
        });

        indicator.open();
        interval.start();
    }
}
