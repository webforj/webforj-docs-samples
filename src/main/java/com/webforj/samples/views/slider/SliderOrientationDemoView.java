package com.webforj.samples.views.slider;

import java.util.Map;
import static java.util.Map.entry;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.slider.Slider;
import com.webforj.component.slider.Slider.Orientation;

@InlineStyleSheet("context://css/slider/sliderOrientationDemo.css")
@Route
@FrameTitle("Slider Orientation")
public class SliderOrientationDemoView extends Composite<Div> {
  
    public SliderOrientationDemoView() {
    getBoundComponent().addClassName("Frame");

    Map<Integer, String> mapMatch = Map.ofEntries(
        entry(0, "0"),
        entry(50, "50"),
        entry(100, "100"));

    Slider sl1 = new Slider().setMax(100)
        .setMin(0);
    Slider sl2 = new Slider().setMax(100)
        .setMin(0);

    getBoundComponent().add(sl1, sl2);

    sl1.setWidth("400px")
        .setTicksVisible(true)
        .setMinorTickSpacing(10)
        .setLabelsVisible(true)
        .setLabels(mapMatch);

    sl2.setOrientation(Orientation.VERTICAL)
        .setStyle("padding-left", "40px")
        .setTicksVisible(true)
        .setMinorTickSpacing(10)
        .setLabelsVisible(true)
        .setLabels(mapMatch);
  }
}
