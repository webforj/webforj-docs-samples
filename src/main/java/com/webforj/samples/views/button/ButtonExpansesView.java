package com.webforj.samples.views.button;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.Expanse;
import com.webforj.component.button.Button;
import com.webforj.component.html.elements.Div;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

/**
 * Simple program to demonstrate the various Button expanse values.
 */
@InlineStyleSheet("context://css/buttonstyles/expanse_styles.css")
@Route
@FrameTitle("Button Expanses")
public class ButtonExpansesView extends Composite<Div> {
	
	Div container = new Div();
	
  public ButtonExpansesView() {
    container.addClassName("container");
    getBoundComponent().addClassName("Frame");

    for (int i = Expanse.values().length - 1; i >= 0; i--) {
      Button expanseButton = new Button(Expanse.values()[i].name());
      container.add(expanseButton.setExpanse(Expanse.values()[i]));
    }
    
    getBoundComponent().add(container);
  }
}