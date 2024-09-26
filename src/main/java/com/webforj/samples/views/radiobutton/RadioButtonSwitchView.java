package com.webforj.samples.views.radiobutton;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.Expanse;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.optioninput.RadioButton;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet("context://css/radiobuttonstyles/radiobutton_styles.css")
@Route
@FrameTitle("Radio Button Switch")
public class RadioButtonSwitchView extends Composite<FlexLayout>{
  
  public RadioButtonSwitchView() {
      getBoundComponent().addClassName("frame");
      
      RadioButton normalButton = new RadioButton("Normal RadioButton")
        .setExpanse(Expanse.XLARGE);
      RadioButton switchButton = RadioButton.Switch("Switch RadioButton")
        .setExpanse(Expanse.XLARGE);

      getBoundComponent().add(normalButton,switchButton);
  }
}
