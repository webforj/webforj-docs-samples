package layout_demos.item;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.ButtonTheme;
import org.dwcj.component.layout.flexlayout.FlexLayout;
import org.dwcj.component.maskednumberfield.MaskedNumberField;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

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
      boxLayout.add(newButton.setTheme(ButtonTheme.PRIMARY));
      boxLayout.setItemOrder(i, newButton);
      orderButton = newButton;
    }
    orderButton.setTheme(ButtonTheme.DANGER);

    MaskedNumberField order = new MaskedNumberField("5")
    .setAttribute("Label", "Order:")
    .setStyle("width", "200px");
    Button submit = new Button("Set Order")
      .onClick( e -> {
      boxLayout.setItemOrder(Integer.parseInt(order.getText()), orderButton);
      orderButton.setText("Order: " + order.getText());
      })
      .setStyle("height", "34px");

      FlexLayout optionLayout = FlexLayout.create(order, submit)
      .horizontal()
      .justify().between()
      .align().end()
      .build()
      .addClassName("flex__options");

    page.add(mainLayout);
    mainLayout.add(optionLayout, boxLayout);    
  }
}
