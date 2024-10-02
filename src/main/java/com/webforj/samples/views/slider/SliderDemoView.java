package com.webforj.samples.views.slider;

import java.util.Map;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import com.webforj.component.Composite;
import com.webforj.component.Theme;
import com.webforj.component.html.elements.Div;
import com.webforj.component.slider.Slider;

@InlineStyleSheet("context://css/sliderstyles/demo_styles.css")
@Route
@FrameTitle("Slider Demo")
public class SliderDemoView extends Composite<Div> {

  Slider slider = new Slider();

  public SliderDemoView() {

    slider.setLabels(Map.of(0, "Off", 30, "Small", 50, "Medium", 80, "Large", 100, "X-Large"));
    slider.setLabelsVisible(true);
    slider.setTicksVisible(true);
    slider.setMajorTickSpacing(10);
    slider.setMinorTickSpacing(2);
    slider.setAllowMajorLabelsOverlap(true);
    slider.setTooltipText("'Current Value:' + x");
    slider.setTooltipVisibleOnSlideOnly(true);
    slider.setFilled(true);
    slider.setTheme(Theme.WARNING);
    slider.setSize(600, 150);
    slider.onValueChange((x) -> {
      App.console().log("Value changed to: " + x.getValue());
    });
    
    getBoundComponent().add(slider);
    getBoundComponent().setStyle("display", "flex");
    getBoundComponent().setStyle("justify-content", "center");
    getBoundComponent().setStyle("margin-top", "20px");
  }

}
