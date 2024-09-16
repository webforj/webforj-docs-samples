package componentdemos.toastdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Theme;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.spinner.Spinner;
import com.webforj.component.toast.Toast;
import com.webforj.component.toast.Toast.Placement;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet(/*css */"""
    .window {
      display: flex;
      margin: 20px;
    }
    .closebutton {
      --dwc-button-hover-color: var(--dwc-button-color); 
      --dwc-button-hover-background: var(--dwc-button-background); 
      --dwc-button-hover-border-color: var(--dwc-button-border-color);
    }
    """)
public class ToastInteractiveDemo extends App {

  private static final String CLOSE_BUTTON_HTML = "<html><dwc-icon name=\"x\" style='width: 16px; height: 16px;'></dwc-icon></html>";
  private static final String CLOSE_BUTTON_CLASS = "closebutton";

  @Override
  public void run() throws WebforjException {
    Frame frame = new Frame();
    frame.addClassName("window");

    showWelcomeToast();
    showSuccessToast();
    showFailedToast();

    Button actionButton = new Button("Show Toasts", e -> {
      showWelcomeToast();
      showSuccessToast();
      showFailedToast();
    });

    frame.add(actionButton);
  }

  private void showWelcomeToast() {
    Toast welcomeToast = new Toast();
    welcomeToast.setHtml("Welcome to our app! Learn more <a href='#' style='color: white;' >here</a>.");
    welcomeToast.setDuration(10000);
    welcomeToast.setTheme(Theme.PRIMARY);
    welcomeToast.setPlacement(Placement.CENTER);

    Button closeButton = new Button(CLOSE_BUTTON_HTML, closeEvent -> welcomeToast.close());
    closeButton.setTheme(ButtonTheme.PRIMARY);
    closeButton.addClassName(CLOSE_BUTTON_CLASS);

    welcomeToast.add(closeButton);
    welcomeToast.open();
  }

  private void showFailedToast() {
    Toast failedToast = new Toast("Action failed.", 10000, Theme.DANGER, Placement.CENTER);

    Button retryButton = new Button("Retry", retryEvent -> {
      failedToast.close();

      Toast retryToast = new Toast("Resubmitting, please wait...", 3000, Placement.CENTER);
      retryToast.add(new Spinner());
      retryToast.open();
    });

    Button closeButton = new Button(CLOSE_BUTTON_HTML, closeEvent -> failedToast.close());
    closeButton.setTheme(ButtonTheme.DANGER);
    closeButton.addClassName(CLOSE_BUTTON_CLASS);

    failedToast.add(retryButton, closeButton);
    failedToast.open();
  }

  private void showSuccessToast() {
    Toast successToast = new Toast();
    successToast.setHtml("Operation completed successfully! <a href='#' style='color: white;'>View Details</a>");
    successToast.setDuration(10000);
    successToast.setTheme(Theme.SUCCESS);
    successToast.setPlacement(Placement.CENTER);

    Button closeButton = new Button(CLOSE_BUTTON_HTML, closeEvent -> successToast.close());
    closeButton.setTheme(ButtonTheme.SUCCESS);
    closeButton.addClassName(CLOSE_BUTTON_CLASS);

    successToast.add(closeButton);
    successToast.open();
  }
}
