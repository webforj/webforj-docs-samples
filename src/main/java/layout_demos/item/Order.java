package layout_demos.item;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.button.Button;
import org.dwcj.component.choicebox.ChoiceBox;
import org.dwcj.component.choicebox.event.ChoiceBoxSelectEvent;
import org.dwcj.component.flexlayout.FlexDirection;
import org.dwcj.component.flexlayout.FlexLayout;
import org.dwcj.component.label.Label;
import org.dwcj.component.numberfield.NumberField;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

import layout_demos.helper.Box;

@InlineStyleSheet("context://css/flexstyles/container_styles.css")
public class Order extends App{

  FlexLayout boxLayout;
  Button orderButton;

  @Override
  public void run() throws DwcjException{
    
    Frame page = new Frame();
    
    FlexLayout mainLayout = FlexLayout.create()
    .horizontal()
    .build();
    
    this.boxLayout = FlexLayout.create()
    .horizontal()
    .build()
    .addClassName("button__container--single-row");
    
    for(int i = 1; i <= 5; i++){
      Button newButton = new Button("Order: " + i);
      boxLayout.add(newButton.setTheme(Button.Theme.PRIMARY));
      boxLayout.setItemOrder(i, newButton);
      orderButton = newButton;
    }
    orderButton.setTheme(Button.Theme.DANGER);

    NumberField order = new NumberField("5")
    .setAttribute("Label", "Order:")
    .setStyle("width", "200px");
    Button submit = new Button("Set Order")
      .onClick( e -> {
      boxLayout.setItemOrder(Integer.parseInt(order.getText()), orderButton);
      orderButton.setText("Order: " + order.getText());
      } );

      FlexLayout optionLayout = FlexLayout.create(order, submit)
      .horizontal()
      .justify().between()
      .build()
      .addClassName("flex__options");

    page.add(mainLayout);
    mainLayout.add(optionLayout, boxLayout);    
  }
}
