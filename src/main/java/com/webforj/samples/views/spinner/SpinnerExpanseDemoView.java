package com.webforj.samples.views.spinner;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.Theme;
import com.webforj.component.html.elements.Div;
import com.webforj.component.spinner.Spinner;
import com.webforj.component.spinner.SpinnerExpanse;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet(/*css */"""
    .window {
      display: flex;
      flex-direction: row;
      align-items: center;
      justify-content: center;
      gap: var(--dwc-space-m);
      margin: 20px;
    }
    """)

@Route
@FrameTitle("Spinner Expanses")
public class SpinnerExpanseDemoView extends Composite<Div> {
  
  Spinner smallSpinner = new Spinner(Theme.PRIMARY, SpinnerExpanse.SMALL);
  Spinner mediumSpinner = new Spinner(Theme.PRIMARY, SpinnerExpanse.MEDIUM);
  Spinner largeSpinner = new Spinner(Theme.PRIMARY, SpinnerExpanse.LARGE);

  public SpinnerExpanseDemoView() {
    getBoundComponent().addClassName("window");
    getBoundComponent().add(smallSpinner, mediumSpinner, largeSpinner);
  }
}
