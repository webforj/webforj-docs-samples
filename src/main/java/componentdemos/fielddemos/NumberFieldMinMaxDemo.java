package componentdemos.fielddemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.button.Button;
import com.webforj.component.field.NumberField;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("""
  .window {
    display: flex;
    align-items: flex-end;
    margin: 20px;
    gap: 50px;
    width: 100%;
    flex-wrap: wrap;
  }
  """)
public class NumberFieldMinMaxDemo extends App {
  private final NumberField amount;
  private final Button order;

  public NumberFieldMinMaxDemo() {
    amount = new NumberField("Amount:")
      .setMin(1.0)
      .setMax(10.0)
      .setValue(1.0);
    order = new Button("Purchase");
  }

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("window");

    amount.onModify(__ -> {
      int value = 1;
      if(amount.getValue() != null) {
        value = amount.getValue().intValue();
      }
      order.setEnabled(amount.getMin().intValue() <= value && amount.getMax().intValue() >= value);
    });
    amount.setTooltipText("10 remaining");

    window.add(amount, order);
  }

}
