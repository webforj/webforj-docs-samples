package componentdemos.toastdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Theme;
import com.webforj.component.button.Button;
import com.webforj.component.html.elements.Anchor;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.icons.Icon;
import com.webforj.component.icons.TablerIcon;
import com.webforj.component.toast.Toast;
import com.webforj.component.toast.Toast.Placement;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/toaststyles/toastcookiesdemo_styles.css")
public class ToastCookiesDemo extends App {

  @Override
  public void run() throws WebforjException {
    Frame frame = new Frame();
    frame.addClassName("window");

    showCookiesConsentToast(); 
  }

  private void showCookiesConsentToast() {
    Toast cookiesToast = new Toast();
    cookiesToast.setDuration(-1);
    cookiesToast.setTheme(Theme.DEFAULT);
    cookiesToast.setPlacement(Placement.CENTER); 
    cookiesToast.addClassName("custom-theme");
    
    Icon cookieIcon = TablerIcon.create("cookie");
    cookieIcon.setStyle("width", "100px");
    cookieIcon.setStyle("height", "100px");
    cookiesToast.add(cookieIcon);
    
    Paragraph toastText = new Paragraph("We use cookies to improve your experience. "
        + "By clicking 'Accept all cookies', you agree to our ");
    toastText.add(new Anchor("#", "Cookie Policy"));
    cookiesToast.add(toastText);

    Button acceptButton = new Button("Accept all cookies", e -> {
      cookiesToast.close();
      showCookiesConsentToast();
    });
    acceptButton.addClassName("acceptbutton");
    
    Button necessaryButton = new Button("Necessary cookies only", e -> {
      cookiesToast.close();
      showCookiesConsentToast();
    });
    necessaryButton.addClassName("necessarybutton");

    Button customizeButton = new Button("Customize Settings", e -> {
      cookiesToast.close();
      showCookiesConsentToast();
    });
    customizeButton.addClassName("customizebutton");
    
    Div buttonContainer = new Div();
    buttonContainer.add(acceptButton, necessaryButton);
    buttonContainer.addClassName("button-container");

    cookiesToast.add(buttonContainer, customizeButton);
    cookiesToast.open();
  }
}




