package componentdemos.tabbedpanedemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.optioninput.RadioButton;
import org.dwcj.component.tabbedpane.TabbedPane;
import org.dwcj.component.tabbedpane.TabbedPane.Activation;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet(/*css */"""
  .window {
    display: flex;
    flex-direction: column;
    gap: 50px;
    width: 100%;
    margin: 20px;
  }
""")
public class TabbedPaneActivation extends App {

  TabbedPane pane = new TabbedPane();
  RadioButton activation = RadioButton.Switch("Manual");

  @Override
  public void run() throws DwcjException {
    Frame app = new Frame();
    app.addClassName("window");
    app.add(activation, pane);

    pane.addTab("<bbj-icon name='dashboard'></bbj-icon>      Dashboard");
    pane.addTab("<bbj-icon name='shopping-cart'></bbj-icon>  Orders");
    pane.addTab("<bbj-icon name='users'></bbj-icon>          Customers");
    pane.addTab("<bbj-icon name='box'></bbj-icon>            Products");
    pane.addTab("<bbj-icon name='files'></bbj-icon>          Documents");
    
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
