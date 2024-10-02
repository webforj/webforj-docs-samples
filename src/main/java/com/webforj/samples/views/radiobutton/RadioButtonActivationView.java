package com.webforj.samples.views.radiobutton;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.optioninput.RadioButton;
import com.webforj.component.optioninput.RadioButton.Activation;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet("context://css/radiobuttonstyles/radiobutton_styles.css")
@Route
@FrameTitle("Radio Button Activation")
public class RadioButtonActivationView extends Composite<Div>{

  public RadioButtonActivationView() {
      getBoundComponent().addClassName("frame");

      RadioButton autoActivateOne = new RadioButton("Auto Activated");
      autoActivateOne.setActivation(Activation.AUTO)
        .focus();

      RadioButton autoActivateTwo = new RadioButton("Auto Activated");
      autoActivateTwo.setActivation(Activation.AUTO);

      RadioButton manualActivateOne = new RadioButton("Manually Activated");
      RadioButton manualActivateTwo = new RadioButton("Manually Activated");
     
      getBoundComponent().add(autoActivateOne, autoActivateTwo, manualActivateOne, manualActivateTwo);
  }
}
