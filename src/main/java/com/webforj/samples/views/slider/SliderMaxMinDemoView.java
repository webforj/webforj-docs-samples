package com.webforj.samples.views.slider;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.text.Label;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.slider.Slider;

@InlineStyleSheet("context://css/slider/sliderMaxMinDemo.css")
@Route
@FrameTitle("Slider Min/Max")
public class SliderMaxMinDemoView extends Composite<Div> {
  public SliderMaxMinDemoView() {
    getBoundComponent().addClassName("Frame");

    Slider sl1 = new Slider().setMax(10)
        .setMin(0)
        .setValue(5);

    Slider sl2 = new Slider().setMax(100)
        .setMin(0)
        .setValue(50);

    sl1.setWidth("500px");
    sl2.setWidth("500px");

    getBoundComponent().add(
        new Label("Min 0, Max 10"), sl1,
        new Label("Min 0, Max 100"), sl2);
  }
}
