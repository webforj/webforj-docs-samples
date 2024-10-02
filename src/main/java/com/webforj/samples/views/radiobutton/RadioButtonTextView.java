package com.webforj.samples.views.radiobutton;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.concern.HasTextPosition.Position;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.optioninput.CheckBox;
import com.webforj.component.optioninput.RadioButton;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet("context://css/radiobuttonstyles/radiobutton_styles.css")
@Route
@FrameTitle("Radio Button Text")
public class RadioButtonTextView extends Composite<Div>{
  
  public RadioButtonTextView() {
      getBoundComponent().addClassName("frame");
      RadioButton buttonRight = new RadioButton("Right aligned (default)");
      RadioButton buttonLeft = new RadioButton("Left aligned")
      .setTextPosition(Position.LEFT);
      getBoundComponent().add(buttonRight, buttonLeft, new CheckBox("CheckBox"));
  }
}
