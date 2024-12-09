package com.webforj.samples.views.slider;

import java.util.Map;
import static java.util.Map.entry;
import com.webforj.component.Composite;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.slider.Slider;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route
@FrameTitle("Slider Label")
public class SliderLabelView extends Composite<FlexLayout> {
  
  FlexLayout layout = getBoundComponent();

  public SliderLabelView() {
    layout.setDirection(FlexDirection.COLUMN)
      .setAlignment(FlexAlignment.CENTER)
      .setMargin("var(--dwc-space-l)");

    Slider tickMatchedSlider = new Slider().setMax(100).setMin(0)
        .setTicksVisible(true)
        .setMajorTickSpacing(25)
        .setMinorTickSpacing(5)
        .setLabelsVisible(true)
        .setLabels(Map.ofEntries(
            entry(0, "0"),
            entry(25, "25"),
            entry(50, "50"),
            entry(75, "75"),
            entry(100, "100")
        ))
        .setSnapToTicks(true)
        .setWidth("300px");

    Slider customLabeledSlider = new Slider().setMax(100).setMin(0)
        .setTicksVisible(true)
        .setMajorTickSpacing(25)
        .setMinorTickSpacing(5)
        .setLabelsVisible(true)
        .setLabels(Map.ofEntries(
            entry(10, "Low"),
            entry(50, "Medium"),
            entry(90, "High")
        ))
        .setSnapToTicks(true)
        .setWidth("300px");

    layout.add(tickMatchedSlider, customLabeledSlider);
  }
}
