package com.webforj.samples.views.slider;

import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.slider.Slider;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import java.util.Map;

import static java.util.Map.entry;

@Route
@FrameTitle("Slider Label Types")
public class SliderLabelView extends Composite<FlexLayout> {

  Slider slider = new Slider()
      .setMax(100)
      .setMin(0)
      .setTicksVisible(true)
      .setMajorTickSpacing(50)
      .setMinorTickSpacing(10)
      .setSnapToTicks(true)
      .setWidth("300px");

  private boolean isTickValueLabels = true;

  public SliderLabelView() {
    FlexLayout layout = getBoundComponent();
    layout.setDirection(FlexDirection.COLUMN)
          .setAlignment(FlexAlignment.CENTER)
          .setMargin("var(--dwc-space-l)");

    slider.setLabelsVisible(true)
          .setLabels(Map.ofEntries(
              entry(0, "0"),
              entry(50, "50"),
              entry(100, "100")
          ));

    Button toggleLabelsButton = new Button("Show Non-Tick Labels").setTheme(ButtonTheme.PRIMARY);
    toggleLabelsButton.onClick(event -> toggleLabels(toggleLabelsButton));

    layout.add(slider, toggleLabelsButton);
  }

  private void toggleLabels(Button button) {
    if (isTickValueLabels) {
      slider.setLabels(Map.ofEntries(
          entry(15, "15"),
          entry(35, "35"),
          entry(65, "65"),
          entry(85, "85")
      ));
      button.setText("Show Tick Labels");
    } else {
      slider.setLabels(Map.ofEntries(
          entry(0, "0"),
          entry(25, "25"),
          entry(50, "50"),
          entry(75, "75"),
          entry(100, "100")
      ));
      button.setText("Show Non-Tick Labels");
    }
    isTickValueLabels = !isTickValueLabels;
  }
}
