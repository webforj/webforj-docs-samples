package com.webforj.samples.views.slider;

import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.TextField;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.slider.Slider;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

import java.util.HashMap;
import java.util.Map;

@Route
@FrameTitle("Slider Tick and Labels Demo")
public class SliderTickView extends Composite<FlexLayout> {

  Slider slider = new Slider(0, 100, 50);
  TextField majorTickInput = new TextField("Major Tick Spacing");
  TextField minorTickInput = new TextField("Minor Tick Spacing");

  public SliderTickView() {
    FlexLayout layout = getBoundComponent();
    layout.setDirection(FlexDirection.COLUMN)
          .setJustifyContent(FlexJustifyContent.CENTER)
          .setSpacing("var(--dwc-space-m)")
          .setMargin("var(--dwc-space-m)")
          .setAlignment(FlexAlignment.CENTER);

    slider.setMin(0)
          .setMax(100)
          .setValue(0)
          .setTicksVisible(true)
          .setMajorTickSpacing(20)
          .setMinorTickSpacing(10)
          .setLabelsVisible(false)
          .setTooltipVisible(true)
          .setWidth("300px");

    majorTickInput.setPlaceholder("Enter major tick spacing (e.g., 10)")
                   .setWidth("300px");
    minorTickInput.setPlaceholder("Enter minor tick spacing (e.g., 2)")
                   .setWidth("300px");

    majorTickInput.onValueChange(event -> {
      try {
        int majorSpacing = Integer.parseInt(event.getValue());
        slider.setMajorTickSpacing(majorSpacing);
      } catch (NumberFormatException e) {
        System.out.println("Invalid input for major tick spacing.");
      }
    });

    minorTickInput.onValueChange(event -> {
      try {
        int minorSpacing = Integer.parseInt(event.getValue());
        slider.setMinorTickSpacing(minorSpacing);
      } catch (NumberFormatException e) {
        System.out.println("Invalid input for minor tick spacing.");
      }
    });

    Button toggleTicksButton = new Button("Toggle Tick Visibility").setWidth("200px")
        .setTheme(ButtonTheme.PRIMARY);
    toggleTicksButton.onClick(event -> {
      boolean currentState = slider.isTicksVisible();
      slider.setTicksVisible(!currentState);
    });

    Button toggleSnapButton = new Button("Toggle Snap to Ticks").setWidth("200px")
        .setTheme(ButtonTheme.PRIMARY);
    toggleSnapButton.onClick(event -> {
      boolean currentState = slider.isSnapToTicks();
      slider.setSnapToTicks(!currentState);
    });

    Button showLabelsButton = new Button("Show Labels").setWidth("150px")
        .setTheme(ButtonTheme.PRIMARY);
    showLabelsButton.onClick(event -> {
      if (!slider.isLabelsVisible()) {
        Map<Integer, String> labels = new HashMap<>();
        int majorSpacing = slider.getMajorTickSpacing();

        for (int i = slider.getMin(); i <= slider.getMax(); i += majorSpacing) {
          labels.put(i, String.valueOf(i));
        }

        slider.setLabels(labels);
        slider.setLabelsVisible(true);
        showLabelsButton.setText("Hide Labels");
      } else {
        slider.setLabelsVisible(false);
        showLabelsButton.setText("Show Labels");
      }
    });

    FlexLayout buttonLayout = new FlexLayout()
        .setDirection(FlexDirection.ROW)
        .setSpacing("var(--dwc-space-s)")
        .setMargin("var(--dwc-space-s)")
        .setJustifyContent(FlexJustifyContent.CENTER)
        .setAlignment(FlexAlignment.CENTER)
        .setWidth("100%");

    buttonLayout.add(toggleTicksButton, toggleSnapButton, showLabelsButton);

    layout.add(slider, majorTickInput, minorTickInput, buttonLayout);
  }
}