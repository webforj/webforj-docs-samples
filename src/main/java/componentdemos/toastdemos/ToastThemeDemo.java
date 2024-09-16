package componentdemos.toastdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Theme;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.toast.Toast;
import com.webforj.component.toast.Toast.Placement;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/toaststyles/toastthemedemo_styles.css")
public class ToastThemeDemo extends App {

  @Override
  public void run() throws WebforjException {
    Frame frame = new Frame();
    frame.addClassName("window");

    showCustomToast();

    Button actionButton = new Button("Show Toast", e -> {
      showCustomToast();  
    });

    frame.add(actionButton);
  }

  private void showCustomToast() {
    Toast customToast = new Toast("This is a toast with a custom theme!", 10000, Theme.DEFAULT, Placement.CENTER);
    customToast.addClassName("custom-theme");

    Button closeButton = new Button("<html><dwc-icon name=\"x\" style='width: 16px; height: 16px;'></dwc-icon></html>", closeEvent -> customToast.close());
    closeButton.setTheme(ButtonTheme.DEFAULT); 
    closeButton.addClassName("closebutton");

    customToast.add(closeButton);
    customToast.open();  
  }
}
