package com.webforj.samples.views.flexlayout;

import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.NumberField;
import com.webforj.component.html.elements.Div;
import com.webforj.component.layout.flexlayout.FlexLayout;

import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

import java.util.ArrayList;
import java.util.List;

@Route
@FrameTitle("Flex Basis")
public class FlexBasisView extends Composite<Div> {

  FlexLayout boxLayout;
  List<Button> buttons;

  public FlexBasisView() {

    FlexLayout mainLayout = FlexLayout.create()
        .horizontal()
        .build();
    mainLayout.setPadding("20px");

    this.boxLayout = FlexLayout.create()
        .horizontal()
        .wrap().wrap()
        .build()
        .setPadding("20px");
    boxLayout.setStyle("border", "1px solid var(--dwc-color-default)");

    buttons = new ArrayList<>();

    for (int i = 1; i <= 5; i++) {
      Button newButton = new Button("Box " + i, ButtonTheme.OUTLINED_PRIMARY);
      buttons.add(newButton);
      boxLayout.add(buttons.get(i - 1));

      newButton.onClick(e -> {
        if (e.getComponent().getTheme() == ButtonTheme.OUTLINED_PRIMARY) {
          e.getComponent().setTheme(ButtonTheme.PRIMARY);
        } else {
          e.getComponent().setTheme(ButtonTheme.OUTLINED_PRIMARY);
        }
      });
    }

    NumberField numberField = new NumberField()
        .setLabel("Basis:")
        .setMin(75.0);

    Button basisButton = new Button("Set basis", e -> {
      if (numberField.getValue() != null) {
        for (int i = 0; i <= buttons.size() - 1; i++) {
          if (buttons.get(i).getTheme() == ButtonTheme.PRIMARY) {
            boxLayout.setItemBasis(numberField.getValue().toString() + "px", buttons.get(i));
          } else {
            boxLayout.setItemBasis("auto", buttons.get(i));
          }
        }
      }
    });

    Button reset = new Button("Reset", ButtonTheme.OUTLINED_GRAY, e -> {
      for (int i = 0; i <= buttons.size() - 1; i++) {
        buttons.get(i).setTheme(ButtonTheme.OUTLINED_PRIMARY);
        boxLayout.setItemBasis("auto", buttons.get(i));
      }
    });

    FlexLayout optionLayout = FlexLayout.create(numberField, basisButton, reset)
        .vertical()
        .build();

    getBoundComponent().add(mainLayout);
    mainLayout.add(optionLayout, boxLayout);
    mainLayout.setItemBasis("100%", boxLayout);
  }
}