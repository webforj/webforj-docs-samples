package com.webforj.samples.views.slider;

import java.util.Map;
import static java.util.Map.entry;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.text.Label;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.slider.Slider;

@InlineStyleSheet("context://css/sliderstyles/inversion_styles.css")
@Route
@FrameTitle("Slider Inversion")
public class SliderInversionDemoView extends Composite<Div> {

  public SliderInversionDemoView() {
    getBoundComponent().addClassName("Frame");

    Map<Integer, String> mapMatch = Map.ofEntries(
        entry(0, "0"),
        entry(50, "50"),
        entry(100, "100"));

    Slider sl1 = new Slider().setMax(100)
        .setMin(0);
    Slider sl2 = new Slider().setMax(100)
        .setMin(0);

    getBoundComponent().add(new Label("<html><b>Original:</b></html>"), sl1,
        new Label("<html><b>Inverted:</b></html>"), sl2);

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
