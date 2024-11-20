package com.webforj.samples.views.checkbox;

import com.webforj.component.Composite;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.optioninput.CheckBox;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route
@FrameTitle("Checkbox Event")
public class CheckboxEventView extends Composite<FlexLayout> {
  CheckBox checkbox = new CheckBox("Please check to accept the Terms and Conditions");

  public CheckboxEventView() {
    getBoundComponent().setDirection(FlexDirection.ROW).setSpacing("var(--dwc-space-l)").setMargin("var(--dwc-space-s)");
    getBoundComponent().add(checkbox);

    checkbox.onCheck(e -> checkbox.setText("You have accepted the Terms and Conditions"));
    checkbox.onUncheck(e -> checkbox.setText("Please check to accept the Terms and Conditions"));
  }
}
