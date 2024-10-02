package com.webforj.samples.views.spinner;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.Theme;
import com.webforj.component.button.Button;
import com.webforj.component.html.elements.Div;
import com.webforj.component.spinner.Spinner;
import com.webforj.component.spinner.SpinnerExpanse;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet(/*css */"""
    .window {
      display: flex;
      flex-direction: column;
      align-items: center;
      justify-content: center;
      gap: var(--dwc-space-m);
      margin: 20px;
    }
    .button-container {
      display: flex;
      gap: var(--dwc-space-s);
    }
    """)

@Route
@FrameTitle("Spinner Directions")
public class SpinnerDirectionDemoView extends Composite<Div> {
  
  Spinner spinner = new Spinner(Theme.PRIMARY, SpinnerExpanse.MEDIUM);

  Button clockwiseButton = new Button("Clockwise", e -> spinner.setClockwise(true));
  Button counterClockwiseButton = new Button("Counterclockwise", e -> spinner.setClockwise(false));

  public SpinnerDirectionDemoView() {
    getBoundComponent().addClassName("window");
    getBoundComponent().add(spinner, new Div(clockwiseButton, counterClockwiseButton)
                       .addClassName("button-container"));
  }
}
