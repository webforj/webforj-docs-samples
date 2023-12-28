package demos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.Composite;
import org.dwcj.component.button.Button;
import org.dwcj.component.field.TextField;
import org.dwcj.component.layout.flexlayout.FlexLayout;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

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
  public void run() throws DwcjException {
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