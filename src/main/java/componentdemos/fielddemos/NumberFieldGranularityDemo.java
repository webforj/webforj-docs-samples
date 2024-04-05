package componentdemos.fielddemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
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
public class NumberFieldGranularityDemo extends App {
  private final NumberField quantity;
  private final NumberField steps;

  public NumberFieldGranularityDemo() {
    quantity = new NumberField("Quantity:");
    steps = new NumberField("Steps:");
  }

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("window");

    steps.onModify(__ -> {
      if(steps.getValue() == null) {
        quantity.setStep(1.0);
      } else {
        quantity.setStep(steps.getValue());
      }
    });

    window.add(quantity, steps);
  }

}
