package componentdemos.tabbedpanedemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.list.ChoiceBox;
import org.dwcj.component.tabbedpane.TabbedPane;
import org.dwcj.component.tabbedpane.TabbedPane.Alignment;
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
public class TabbedPaneAlignment extends App {

  TabbedPane pane = new TabbedPane();
  ChoiceBox alignments = new ChoiceBox("Alignment");

  @Override
  public void run() throws DwcjException {
    Frame app = new Frame();
    app.addClassName("window");
    app.add(alignments, pane);

    pane.addTab("<dwc-icon name='dashboard'></dwc-icon>      Dashboard");
    pane.addTab("<dwc-icon name='shopping-cart'></dwc-icon>  Orders");
    pane.addTab("<dwc-icon name='users'></dwc-icon>          Customers");
    pane.addTab("<dwc-icon name='box'></dwc-icon>            Products");
    pane.addTab("<dwc-icon name='files'></dwc-icon>          Documents");
    
    for(Alignment alignment : Alignment.values()){
      alignments.add(alignment.toString());
    }
    alignments.setStyle("width", "200px");
    alignments.selectIndex(0);

    alignments.onSelect( e -> {
      pane.setAlignment(Alignment.valueOf(e.getSelectedItem().getText()));
    });
  }
}
