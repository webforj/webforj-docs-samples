package com.webforj.samples.views.flexlayout.item;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.MaskedNumberField;
import com.webforj.component.html.elements.Div;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet("context://css/flexstyles/container_styles.css")
@Route
@FrameTitle("Flex Order")
public class FlexOrderView extends Composite<Div>{

  FlexLayout boxLayout;
  Button orderButton;

  public FlexOrderView() {
        
    FlexLayout mainLayout = FlexLayout.create()
    .horizontal()
    .align().start()
    .build();
    
    this.boxLayout = FlexLayout.create()
    .horizontal()
    .wrap().wrap()
    .build()
    .addClassName("button__container--single-row");
    
    for(int i = 1; i <= 5; i++){
      Button newButton = new Button("Order: " + i, ButtonTheme.PRIMARY);
      boxLayout.add(newButton);
      boxLayout.setItemOrder(i, newButton);
      orderButton = newButton;
    }
    orderButton.setTheme(ButtonTheme.DANGER);

    MaskedNumberField order = new MaskedNumberField("5")
    .setLabel("Order:")
    .setWidth("200px");
    Button submit = new Button("Set Order");
    submit.setHeight("34px")
      .onClick( e -> {
      boxLayout.setItemOrder(Integer.parseInt(order.getText()), orderButton);
      orderButton.setText("Order: " + order.getText());
      });
      

      FlexLayout optionLayout = FlexLayout.create(order, submit)
      .horizontal()
      .justify().between()
      .align().end()
      .build()
      .addClassName("flex__options");

    getBoundComponent().add(mainLayout);
    mainLayout.add(optionLayout, boxLayout);    
  }
}
