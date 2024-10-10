package com.webforj.samples.views.loadingbusy;

import com.webforj.App;
import com.webforj.BusyIndicator;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.Theme;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.TextField;
import com.webforj.component.html.elements.Div;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;


/**
 * Demo to show BusyIndicator basics.
 */

@InlineStyleSheet(/*css */"""
    .window {
      margin: 20px;
    }
    """)

@Route
@FrameTitle("Busy Basics")
public class BusyDemoView extends Composite<Div> {
  
  FlexLayout formLayout = new FlexLayout();
  TextField nameField = new TextField("Name");
  TextField emailField = new TextField("Email");
  Button submitButton = new Button("Submit", e -> showBusyIndicator());
  BusyIndicator busyIndicator = App.getBusyIndicator();

  public BusyDemoView() {
    getBoundComponent().addClassName("window");

    formLayout.setJustifyContent(FlexJustifyContent.CENTER); 
    formLayout.setAlignment(FlexAlignment.CENTER);  
    formLayout.setDirection(FlexDirection.COLUMN);

    submitButton.setTheme(ButtonTheme.PRIMARY);

    formLayout.add(nameField, emailField, submitButton);

    getBoundComponent().add(formLayout);

    showBusyIndicator();
  }

  private void showBusyIndicator() {
        
    busyIndicator.setText("Submitting form... Please wait.")
                    .setBackdropVisible(true);
    busyIndicator.getSpinner().setTheme(Theme.PRIMARY); 

    busyIndicator.open();
  }
}
