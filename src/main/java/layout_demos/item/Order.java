package layout_demos.item;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.MaskedNumberField;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/flexstyles/container_styles.css")
public class Order extends App{

  FlexLayout boxLayout;
  Button orderButton;

  @Override
  public void run() throws WebforjException{
    
    Frame page = new Frame();
    
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
      Button newButton = new Button("Order: " + i);
      boxLayout.add(newButton.setTheme(ButtonTheme.PRIMARY));
      boxLayout.setItemOrder(i, newButton);
      orderButton = newButton;
    }
    orderButton.setTheme(ButtonTheme.DANGER);

    MaskedNumberField order = new MaskedNumberField("5")
    .setLabel("Order:")
    .setStyle("width", "200px");
    Button submit = new Button("Set Order");
    submit.setStyle("height", "34px")
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

    page.add(mainLayout);
    mainLayout.add(optionLayout, boxLayout);    
  }
}
