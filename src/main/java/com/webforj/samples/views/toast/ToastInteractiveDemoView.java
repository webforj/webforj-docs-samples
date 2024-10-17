package com.webforj.samples.views.toast;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.Theme;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
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
@FrameTitle("Interactive Toast")
@InlineStyleSheet("context://css/toaststyles/toastinteractivedemo.css")
public class ToastInteractiveDemoView extends Composite<Div> {

  Toast welcomeToast;
  Toast failedToast;
  Toast successToast;
  
  public ToastInteractiveDemoView() {
    showWelcomeToast();
    showSuccessToast();
    showFailedToast();    
  }

  private void showWelcomeToast() {
    welcomeToast = new Toast();
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
    failedToast = new Toast("Unable to save most recent changes.", -1, 
        Theme.DANGER, Placement.CENTER);

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
    successToast = new Toast();
    successToast.add(new Paragraph("Operation completed successfully!"), 
        new Anchor("#", "View Details"));
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

