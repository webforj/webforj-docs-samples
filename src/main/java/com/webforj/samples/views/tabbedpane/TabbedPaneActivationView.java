package com.webforj.samples.views.tabbedpane;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.optioninput.RadioButton;
import com.webforj.component.tabbedpane.TabbedPane;
import com.webforj.component.tabbedpane.TabbedPane.Activation;
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
@FrameTitle("Tabbed Pane Activation")
public class TabbedPaneActivationView extends Composite<Div> {

  TabbedPane pane = new TabbedPane();
  RadioButton activation = RadioButton.Switch("Manual");

  public TabbedPaneActivationView() {
    getBoundComponent().addClassName("window");
    getBoundComponent().add(activation, pane);

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
