package componentdemos.tabbedpanedemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.list.ChoiceBox;
import com.webforj.component.tabbedpane.TabbedPane;
import com.webforj.component.tabbedpane.TabbedPane.Placement;
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
public class TabbedPanePlacement extends App {

  TabbedPane pane = new TabbedPane();
  ChoiceBox placements = new ChoiceBox("Placement");

  @Override
  public void run() throws WebforjException {
    Frame app = new Frame();
    app.addClassName("window");
    app.add(placements, pane);

    pane.addTab("<dwc-icon name='dashboard'></dwc-icon>      Dashboard");
    pane.addTab("<dwc-icon name='shopping-cart'></dwc-icon>  Orders");
    pane.addTab("<dwc-icon name='users'></dwc-icon>          Customers");
    pane.addTab("<dwc-icon name='box'></dwc-icon>            Products");
    pane.addTab("<dwc-icon name='files'></dwc-icon>          Documents");
    
    for(Placement placement : Placement.values()){
      placements.add(placement.toString());
    }
    placements.setStyle("width", "200px");
    placements.selectIndex(0);

    placements.onSelect( e -> {
      pane.setPlacement(Placement.valueOf(e.getSelectedItem().getText()));
    });
  }
}
