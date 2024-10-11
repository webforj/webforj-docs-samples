package com.webforj.samples.views.busyindicator;

import com.webforj.App;
import com.webforj.BusyIndicator;
import com.webforj.component.Composite;
import com.webforj.component.Theme;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.TextField;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

/**
 * Demo to show BusyIndicator basics.
 */
@Route
@FrameTitle("Busy Basics")
public class BusyDemoView extends Composite<FlexLayout> {

  private FlexLayout container;
  private TextField nameField = new TextField("Name");
  private TextField emailField = new TextField("Email");
  private Button submitButton =
      new Button("Submit", e -> showBusyIndicator());
  private BusyIndicator busyIndicator = App.getBusyIndicator();

  public BusyDemoView() {

    container = getBoundComponent();
    nameField.setWidth("350px");
    emailField.setWidth("350px");
    submitButton.setTheme(ButtonTheme.PRIMARY);

    FlexLayout form = FlexLayout.create(nameField, emailField, submitButton)
        .vertical()
        .build();

    container.add(form);
    container.setJustifyContent(FlexJustifyContent.CENTER);
    container.setStyle("margin", "var(--dwc-space-l)");

    showBusyIndicator();
  }

  private void showBusyIndicator() {
    busyIndicator.setText("Submitting form... Please wait.")
        .setBackdropVisible(true);
    busyIndicator.getSpinner().setTheme(Theme.PRIMARY);
    busyIndicator.open();
  }
}

