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

@InlineStyleSheet("context://css/toaststyles/toastinteractivedemo_styles.css")
public class ToastInteractiveDemo extends App {

  private static final String CLOSE_BUTTON_HTML = "<html><dwc-icon name=\"x\" "
      + "style='width: 16px; height: 16px;'></dwc-icon></html>";
  private static final String CLOSE_BUTTON_CLASS = "closebutton";
  private static final String TOAST_CONTAINER_CLASS = "toast-container";

  @Override
  public void run() throws WebforjException {
    Frame frame = new Frame();
    frame.addClassName("window");

    showWelcomeToast();
    showSuccessToast();
    showFailedToast();
  }

  private void showWelcomeToast() {
    Toast welcomeToast = new Toast();
    welcomeToast.setHtml("Welcome to our app! Learn more <a href='#' style='color: white;'>here</a>.");
    welcomeToast.setDuration(-1); 
    welcomeToast.setTheme(Theme.PRIMARY);
    welcomeToast.setPlacement(Placement.CENTER);
    welcomeToast.addClassName(TOAST_CONTAINER_CLASS);

    Button closeButton = new Button(CLOSE_BUTTON_HTML, closeEvent -> {
      welcomeToast.close();
      showWelcomeToast();
    });
    closeButton.setTheme(ButtonTheme.PRIMARY);
    closeButton.addClassName(CLOSE_BUTTON_CLASS);

    welcomeToast.add(closeButton);
    welcomeToast.open();
  }

  private void showFailedToast() {
    Toast failedToast = new Toast("Action failed.", -1, Theme.DANGER, Placement.CENTER);
    failedToast.addClassName(TOAST_CONTAINER_CLASS);

    Button retryButton = new Button("Retry");
    retryButton.addClassName("retrybutton");  

    Button closeButton = new Button(CLOSE_BUTTON_HTML, closeEvent -> {
      failedToast.close();
      showFailedToast();
    });
    closeButton.setTheme(ButtonTheme.DANGER);
    closeButton.addClassName(CLOSE_BUTTON_CLASS);

    failedToast.add(retryButton, closeButton);
    failedToast.open();
  }

  private void showSuccessToast() {
    Toast successToast = new Toast();
    successToast.setHtml("Operation completed successfully! <a href='#' style='color: white;'>View Details</a>");
    successToast.setDuration(-1);  
    successToast.setTheme(Theme.SUCCESS);
    successToast.setPlacement(Placement.CENTER);
    successToast.addClassName(TOAST_CONTAINER_CLASS);

    Button closeButton = new Button(CLOSE_BUTTON_HTML, closeEvent -> {
      successToast.close();
      showSuccessToast();
    });
    closeButton.setTheme(ButtonTheme.SUCCESS);
    closeButton.addClassName(CLOSE_BUTTON_CLASS);

    successToast.add(closeButton);
    successToast.open();
  }
}

