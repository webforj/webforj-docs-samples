package componentdemos.toastdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Theme;
import com.webforj.component.button.Button;
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

    showCookiesConsentToast(); 
  }

  private void showCookiesConsentToast() {
    Toast cookiesToast = new Toast("<strong>Cookies Notice:</strong> We use cookies to "
        + "improve your experience. "
        + "By continuing to use our site, you accept our privacy policy.", 
        0, Theme.DEFAULT, Placement.BOTTOM);

    Button closeButton = new Button("<html><dwc-icon name=\"x\" "
        + "style='width: 16px; height: 16px;'></dwc-icon></html>", e -> {
      cookiesToast.close();
      showCookiesConsentToast();
    });
    closeButton.addClassName("closebutton");

    Button acceptButton = new Button("View");
    acceptButton.addClassName("viewbutton");

    cookiesToast.add(acceptButton, closeButton);
    cookiesToast.addClassName("custom-theme");
    cookiesToast.open();  
  }
}


