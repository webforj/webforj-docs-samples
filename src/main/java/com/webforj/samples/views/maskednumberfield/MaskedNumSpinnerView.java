package com.webforj.samples.views.maskednumberfield;

import com.webforj.component.Composite;
import com.webforj.component.field.MaskedNumberFieldSpinner;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route
@FrameTitle("Spinner Quantity Demo")
public class MaskedNumSpinnerView extends Composite<FlexLayout> {

    private final MaskedNumberFieldSpinner quantitySpinner = new MaskedNumberFieldSpinner("Item Quantity");


    public MaskedNumSpinnerView() {
      quantitySpinner.setValue(1.0);  // Default value
      quantitySpinner.setMin(1.0);   // Minimum value
      quantitySpinner.setMax(50.0);  // Maximum value
      quantitySpinner.setStep(1.0);  
      quantitySpinner.setTooltipText("Adjust quantity using the spinner.");
        // Layout setup
        FlexLayout layout = getBoundComponent();
        layout.setDirection(FlexDirection.COLUMN)
              .setJustifyContent(FlexJustifyContent.CENTER)
              .setAlignment(FlexAlignment.CENTER)
              .setSpacing("var(--dwc-space-m)")
              .setMargin("var(--dwc-space-m)");

        // Add spinner to layout
        layout.add(quantitySpinner);
    }
}