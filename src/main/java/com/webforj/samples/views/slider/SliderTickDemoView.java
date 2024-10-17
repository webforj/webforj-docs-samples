package com.webforj.samples.views.slider;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.text.Label;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.slider.Slider;

@InlineStyleSheet("context://css/slider/sliderTickDemo.css")
@Route
@FrameTitle("Slider Ticks")
public class SliderTickDemoView extends Composite<Div> {
  
  public SliderTickDemoView() {
    getBoundComponent().addClassName("Frame");

    Slider sl1 = new Slider().setMax(100).setMin(0);
    Slider sl2 = new Slider().setMax(100).setMin(0);

    sl1.setWidth("500px");
    sl2.setWidth("500px");

    getBoundComponent().add(
        new Label("No Tick Snapping"), sl1,
        new Label("Tick Snapping"), sl2);

    sl1.setTicksVisible(true)
        .setMajorTickSpacing(50)
        .setMinorTickSpacing(10);

    sl2.setTicksVisible(true)
        .setMajorTickSpacing(50)
        .setMinorTickSpacing(10)
        .setSnapToTicks(true);
  }
}
