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
@FrameTitle("Spinner Themes")
public class SpinnerThemeDemoView extends Composite<Div> {
  
  Spinner defaultSpinner = new Spinner(Theme.DEFAULT, SpinnerExpanse.MEDIUM);
  Spinner primarySpinner = new Spinner(Theme.PRIMARY, SpinnerExpanse.MEDIUM);
  Spinner successSpinner = new Spinner(Theme.SUCCESS, SpinnerExpanse.MEDIUM);
  Spinner dangerSpinner = new Spinner(Theme.DANGER, SpinnerExpanse.MEDIUM);
  Spinner warningSpinner = new Spinner(Theme.WARNING, SpinnerExpanse.MEDIUM);
  Spinner graySpinner = new Spinner(Theme.GRAY, SpinnerExpanse.MEDIUM);
  Spinner infoSpinner = new Spinner(Theme.INFO, SpinnerExpanse.MEDIUM);

  public SpinnerThemeDemoView() {
    getBoundComponent().addClassName("window");
    getBoundComponent().add(defaultSpinner, primarySpinner, successSpinner, dangerSpinner, 
        warningSpinner, graySpinner, infoSpinner);
  }
}
