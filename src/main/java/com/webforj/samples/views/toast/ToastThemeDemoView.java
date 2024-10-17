package com.webforj.samples.views.toast;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.Theme;
import com.webforj.component.button.Button;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.toast.Toast;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route
@FrameTitle("Toast Themes")
@InlineStyleSheet("context://css/toaststyles/toastthemedemo.css")
public class ToastThemeDemoView extends Composite<FlexLayout> {
  
  Toast updateToast;
  Button laterButton;
  Button updateButton;

  public ToastThemeDemoView() {
    getBoundComponent().setMargin("var(--dwc-space-l)");
    
    updateToast = new Toast("The application has a new update available", -1, Theme.DEFAULT);
    updateToast.addClassName("custom-theme");
    
    laterButton = new Button("Later");
    laterButton.addClassName("laterButton");
    
    updateButton = new Button("Update Now");  
    updateButton.addClassName("updateButton");
    
    updateToast.add(laterButton, updateButton);
    updateToast.open();
  }

}
