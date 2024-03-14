package componentdemos.tabbedpanedemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.optioninput.RadioButton;
import com.webforj.component.tabbedpane.TabbedPane;
import com.webforj.component.tabbedpane.TabbedPane.Activation;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet(/*css */"""
  .window {
    display: flex;
    flex-direction: column;
    gap: 50px;
    margin: 20px;
  }
""")
public class TabbedPaneActivation extends App {

  TabbedPane pane = new TabbedPane();
  RadioButton activation = RadioButton.Switch("Manual");

  @Override
  public void run() throws WebforjException {
    Frame app = new Frame();
    app.addClassName("window");
    app.add(activation, pane);

    pane.addTab("<dwc-icon name='dashboard'></dwc-icon>      Dashboard");
    pane.addTab("<dwc-icon name='shopping-cart'></dwc-icon>  Orders");
    pane.addTab("<dwc-icon name='users'></dwc-icon>          Customers");
    pane.addTab("<dwc-icon name='box'></dwc-icon>            Products");
    pane.addTab("<dwc-icon name='files'></dwc-icon>          Documents");
    
    activation.onCheck( e -> {
      activation.setText("Automatic");
      pane.setActivation(Activation.AUTO);
    });
    
    activation.onUncheck( e -> {
      activation.setText("Manual");
      pane.setActivation(Activation.MANUAL);
    });
  }
}
