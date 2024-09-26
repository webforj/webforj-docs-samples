package com.webforj.samples.views.tabbedpane;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.list.ChoiceBox;
import com.webforj.component.tabbedpane.TabbedPane;
import com.webforj.component.tabbedpane.TabbedPane.Alignment;
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
@FrameTitle("Tabbed Pane Alignment")
public class TabbedPaneAlignmentView extends Composite<Div> {

  TabbedPane pane = new TabbedPane();
  ChoiceBox alignments = new ChoiceBox("Alignment");

  public TabbedPaneAlignmentView() {
    getBoundComponent().addClassName("window");
    getBoundComponent().add(alignments, pane);

    pane.addTab("<dwc-icon name='dashboard'></dwc-icon>      Dashboard");
    pane.addTab("<dwc-icon name='shopping-cart'></dwc-icon>  Orders");
    pane.addTab("<dwc-icon name='users'></dwc-icon>          Customers");
    pane.addTab("<dwc-icon name='box'></dwc-icon>            Products");
    pane.addTab("<dwc-icon name='files'></dwc-icon>          Documents");
    
    for(Alignment alignment : Alignment.values()){
      alignments.add(alignment.toString());
    }
    alignments.setWidth("200px");
    alignments.selectIndex(0);

    alignments.onSelect( e -> pane.setAlignment(Alignment.valueOf(e.getSelectedItem().getText())));
  }
}
