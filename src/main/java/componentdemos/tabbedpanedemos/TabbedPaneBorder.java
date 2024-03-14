package componentdemos.tabbedpanedemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.optioninput.RadioButton;
import com.webforj.component.tabbedpane.TabbedPane;
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
public class TabbedPaneBorder extends App {

  TabbedPane pane = new TabbedPane();
  RadioButton border = RadioButton.Switch("Hide Border");
  RadioButton active = RadioButton.Switch("Hide Active Indicator");

  @Override
  public void run() throws WebforjException {
    Frame app = new Frame();
    app.addClassName("window");
    app.add(border, active, pane);

    pane.addTab("<dwc-icon name='dashboard'></dwc-icon>      Dashboard");
    pane.addTab("<dwc-icon name='shopping-cart'></dwc-icon>  Orders");
    pane.addTab("<dwc-icon name='users'></dwc-icon>          Customers");
    pane.addTab("<dwc-icon name='box'></dwc-icon>            Products");
    pane.addTab("<dwc-icon name='files'></dwc-icon>          Documents");

    border.onToggle( e -> {
      pane.setBorderless(!pane.isBorderless());
    });
    
    active.onToggle( e -> {
      pane.setHideActiveIndicator(!pane.isHideActiveIndicator());
    });
  }
}
