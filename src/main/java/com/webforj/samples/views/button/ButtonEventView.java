package com.webforj.samples.views.button;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.html.elements.Div;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.layout.flexlayout.FlexLayoutBuilder;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

/**
 * Demonstration for Button events.
 */
@InlineStyleSheet(/*css */ """
  .window{
    display: flex;
    flex-direction: row;
    gap: 15px;
    padding: 20px;
    width: 100%;
  }
""")
@Route
@FrameTitle("Button Event")
public class ButtonEventView extends Composite<Div> {

  int counter = 0;
  Div text = new Div("Current Counter: 0");
  Div payload = new Div("Event Payload: null");

  public ButtonEventView() {
    getBoundComponent().addClassName("window");

    Button button = new Button("Click Me!");
    button.setWidth("150px");

    FlexLayout textDisplay = new FlexLayoutBuilder(text, payload)
        .vertical()
        .build()
        .setSpacing("0px");

    button.addClickListener(e -> {
      text.setText("Current Counter: " + (++counter));
      payload.setText("Event payload: " + e.getData().toString());
    });

    getBoundComponent().add(button, textDisplay);
  }
}
