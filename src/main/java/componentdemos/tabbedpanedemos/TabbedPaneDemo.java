package componentdemos.tabbedpanedemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.button.Button;
import org.dwcj.component.list.ChoiceBox;
import org.dwcj.component.tabbedpane.TabbedPane;
import org.dwcj.component.tabbedpane.TabbedPane.Activation;
import org.dwcj.component.tabbedpane.TabbedPane.Placement;
import org.dwcj.component.tabbedpane.TabbedPane.Removal;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet(/*css */"""
  .window {
    display: flex;
    flex-direction: column;
    gap: 50px;
    margin: 20px;
  }
""")
public class TabbedPaneDemo extends App {

  TabbedPane pane = new TabbedPane();
  ChoiceBox placements = new ChoiceBox("Placement");

  @Override
  public void run() throws DwcjException {
    Frame app = new Frame();
    app.addClassName("window");
    app.add(placements, pane);

    pane.addTab("<bbj-icon name='dashboard'></bbj-icon>      Dashboard")
      .setClosable(true);
    pane.addTab("<bbj-icon name='shopping-cart'></bbj-icon>  Orders");
    pane.addTab("<bbj-icon name='users'></bbj-icon>          Customers");
    pane.addTab("<bbj-icon name='box'></bbj-icon>            Products");
    pane.addTab("<bbj-icon name='files'></bbj-icon>          Documents");

    pane.setComponentFor(0, new Button("Test1"));

    pane.setRemoval(Removal.AUTO);
    
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
