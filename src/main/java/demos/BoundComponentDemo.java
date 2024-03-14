package demos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.field.TextField;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet(/* css */"""
      .frame{
        display: flex;
        flex-direction: column;
        gap: 20px;
        margin: 20px;
        width: 50%;
      }
""")
public class BoundComponentDemo extends App {

  TextField text = new TextField("Todo Item");
  FlexLayout todoDisplay;

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("frame");

    window.add(new DefaultComposite(), new OverrideComposite());
  }

  //Uses the default constructor for the FlexLayout class
  public static class DefaultComposite extends Composite<FlexLayout> {
    
    TextField nameField;
    Button submit;
    
    DefaultComposite(){
      nameField = new TextField();
      submit = new Button("Submit");
      getBoundComponent()
        .setSpacing("3px")
        .add(nameField,submit);
    }
  }

  //Overrides initBoundComponent() to use a parameterized constructor
  public static class OverrideComposite extends Composite<FlexLayout> {
    
    TextField nameField;
    Button submit;

    @Override
    protected FlexLayout initBoundComponent() {
      nameField = new TextField();
      submit = new Button("Submit");
      return new FlexLayout(nameField, submit);
    }
  }
}