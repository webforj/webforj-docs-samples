package com.webforj.samples.views.tabbedpane;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.list.ChoiceBox;
import com.webforj.component.tabbedpane.TabbedPane;
import com.webforj.component.tabbedpane.TabbedPane.Placement;
import com.webforj.component.tabbedpane.TabbedPane.Removal;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet(/*css */"""
  .window {
    display: flex;
    flex-direction: column;
    gap: 50px;
    margin: 20px;
  }
""")
@Route
@FrameTitle("Tabbed Pane Basics")
public class TabbedPaneDemoView extends Composite<Div> {

  TabbedPane pane = new TabbedPane();
  ChoiceBox placements = new ChoiceBox("Placement");

  public TabbedPaneDemoView() {
    getBoundComponent().addClassName("window");
    getBoundComponent().add(placements, pane);

    pane.addTab("<dwc-icon name='dashboard'></dwc-icon>      Dashboard")
      .setClosable(true);
    pane.addTab("<dwc-icon name='shopping-cart'></dwc-icon>  Orders");
    pane.addTab("<dwc-icon name='users'></dwc-icon>          Customers");
    pane.addTab("<dwc-icon name='box'></dwc-icon>            Products");
    pane.addTab("<dwc-icon name='files'></dwc-icon>          Documents");

    pane.setRemoval(Removal.AUTO);
    
    for(Placement placement : Placement.values()){
      placements.add(placement.toString());
    }
    placements.setWidth("200px");
    placements.selectIndex(0);

    placements.onSelect( e -> pane.setPlacement(Placement.valueOf(e.getSelectedItem().getText())));
  }
}
