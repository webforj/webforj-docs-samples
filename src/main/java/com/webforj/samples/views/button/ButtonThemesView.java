package com.webforj.samples.views.button;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.html.elements.Div;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

/**
 * Simple program to demonstrate the various ButtonThemes.
 */
@InlineStyleSheet("context://css/button/buttonThemes.css")
@Route
@FrameTitle("Button Themes")
public class ButtonThemesView extends Composite<Div> {

  public ButtonThemesView() {
    getBoundComponent().addClassName("Frame");

    Div regularRow = new Div()
        .addClassName("ButtonRow");

    Div outlinedRow = new Div()
        .addClassName("ButtonRow"); 

    for (ButtonTheme theme : ButtonTheme.values()) {
      if (!theme.name().contains("OUTLINE")) {
        Button themeButton = new Button(theme.name(), theme)
            .setWidth("200px");
        regularRow.add(themeButton);
      }
    }

    for (ButtonTheme theme : ButtonTheme.values()) {
      if (!theme.name().contains("OUTLINE")) {
        Button outlineButton = new Button("OUTLINED_" + theme.name(),
                ButtonTheme.valueOf("OUTLINED_" + theme.name()))
            .setWidth("200px");
        outlinedRow.add(outlineButton);
      }
    }

    getBoundComponent().add(regularRow,outlinedRow);
  }
}