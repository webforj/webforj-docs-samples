package com.webforj.samples.views.toast;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.Theme;
import com.webforj.component.button.Button;
import com.webforj.component.html.elements.Anchor;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.icons.Icon;
import com.webforj.component.icons.TablerIcon;
import com.webforj.component.toast.Toast;
import com.webforj.component.toast.Toast.Placement;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route
@FrameTitle("Toast Cookies")
@InlineStyleSheet("context://css/toaststyles/toastcookiesdemo.css")
public class ToastCookiesDemoView extends Composite<Div> {
  
  Toast cookiesToast;
  Icon cookieIcon;
  Paragraph toastText;
  Button acceptButton;
  Button necessaryButton;
  Button customizeButton;
  Div buttonContainer;

  public ToastCookiesDemoView() {
    cookiesToast = new Toast().setDuration(-1).setTheme(Theme.GRAY)
        .setPlacement(Placement.CENTER); 
    
    cookieIcon = TablerIcon.create("cookie");
    cookieIcon.setStyle("width", "100px");
    cookieIcon.setStyle("height", "100px");
    cookiesToast.add(cookieIcon);
    
    toastText = new Paragraph("We use cookies to improve your experience. "
        + "By clicking 'Accept all cookies', you agree to our ");
    toastText.add(new Anchor("#", "Cookie Policy"));
    cookiesToast.add(toastText);

    acceptButton = new Button("Accept all cookies");
    acceptButton.addClassName("acceptbutton");
    
    necessaryButton = new Button("Necessary cookies only");
    necessaryButton.addClassName("necessarybutton");

    customizeButton = new Button("Customize Settings");
    customizeButton.addClassName("customizebutton");
    
    buttonContainer = new Div();
    buttonContainer.add(acceptButton, necessaryButton);
    buttonContainer.addClassName("button-container");

    cookiesToast.add(buttonContainer, customizeButton);
    cookiesToast.open();
  }
}




