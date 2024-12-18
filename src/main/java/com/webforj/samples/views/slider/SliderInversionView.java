package com.webforj.samples.views.slider;

import java.util.Map;
import static java.util.Map.entry;
import com.webforj.component.text.Label;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import com.webforj.component.Composite;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.slider.Slider;

@Route
@FrameTitle("Slider Inversion")
public class SliderInversionView extends Composite<FlexLayout> {
  
  FlexLayout layout = getBoundComponent();

  public SliderInversionView() {
    getBoundComponent().setDirection(FlexDirection.COLUMN)
      .setAlignment(FlexAlignment.CENTER)
      .setMargin("var(--dwc-space-l)");

    Map<Integer, String> mapMatch = Map.ofEntries(
        entry(0, "0"),
        entry(50, "50"),
        entry(100, "100"));

    Slider sl1 = new Slider().setMax(100)
        .setMin(0);
    Slider sl2 = new Slider().setMax(100)
        .setMin(0);

    getBoundComponent().add(new Label("Original:"), sl1,
        new Label("Inverted:"), sl2);

    sl1.setTicksVisible(true)
        .setMinorTickSpacing(10)
        .setLabelsVisible(true)
        .setLabels(mapMatch)
        .setWidth("400px");

    sl2.setTicksVisible(true)
        .setMinorTickSpacing(10)
        .setLabelsVisible(true)
        .setLabels(mapMatch)
        .setAttribute("inverted", "true")
        .setWidth("400px");
  }
}
