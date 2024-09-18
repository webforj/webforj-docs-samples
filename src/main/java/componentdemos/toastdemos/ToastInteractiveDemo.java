package componentdemos.toastdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Theme;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.html.elements.Anchor;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.icons.Icon;
import com.webforj.component.icons.TablerIcon;
import com.webforj.component.toast.Toast;
import com.webforj.component.toast.Toast.Placement;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/toaststyles/toastinteractivedemo_styles.css")
public class ToastInteractiveDemo extends App {

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
    welcomeToast.add(new Paragraph("Welcome to our app!"), new Anchor("#", "Learn more here"));
    welcomeToast.setDuration(-1); 
    welcomeToast.setTheme(Theme.PRIMARY);
    welcomeToast.setPlacement(Placement.CENTER);

    Icon closeButton = TablerIcon.create("x");
    closeButton.addClickListener(closeEvent -> {
      welcomeToast.close();
      showWelcomeToast();
    });
    welcomeToast.add(closeButton);
    welcomeToast.open();
  }

  private void showFailedToast() {
    Toast failedToast = new Toast("Unable to save most recent changes.", -1, Theme.DANGER, Placement.CENTER);

    Button retryButton = new Button("Retry");
    retryButton.setTheme(ButtonTheme.DANGER);  

    Icon closeButton = TablerIcon.create("x");
    closeButton.addClickListener(closeEvent -> {
      failedToast.close();
      showFailedToast();
    });
    closeButton.setStyle("color", "white");
    

    failedToast.add(retryButton, closeButton);
    failedToast.open();
  }

  private void showSuccessToast() {
    Toast successToast = new Toast();
    successToast.add(new Paragraph("Operation completed successfully!"), new Anchor("#", "View Details"));
    successToast.setDuration(-1);  
    successToast.setTheme(Theme.SUCCESS);
    successToast.setPlacement(Placement.CENTER);

    Icon closeButton = TablerIcon.create("x");
    closeButton.addClickListener(closeEvent -> {
      successToast.close();
      showSuccessToast();
    });
    closeButton.setStyle("color", "black");

    successToast.add(closeButton);
    successToast.open();
  }
}

