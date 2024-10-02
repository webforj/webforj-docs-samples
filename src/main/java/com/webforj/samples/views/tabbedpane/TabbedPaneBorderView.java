package com.webforj.samples.views.tabbedpane;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.optioninput.RadioButton;
import com.webforj.component.tabbedpane.TabbedPane;
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
@FrameTitle("Tabbed Pane Border")
public class TabbedPaneBorderView extends Composite<Div> {

  TabbedPane pane = new TabbedPane();
  RadioButton border = RadioButton.Switch("Hide Border");
  RadioButton active = RadioButton.Switch("Hide Active Indicator");

  public TabbedPaneBorderView() {
    getBoundComponent().addClassName("window");
    getBoundComponent().add(border, active, pane);

    pane.addTab("<dwc-icon name='dashboard'></dwc-icon>      Dashboard");
    pane.addTab("<dwc-icon name='shopping-cart'></dwc-icon>  Orders");
    pane.addTab("<dwc-icon name='users'></dwc-icon>          Customers");
    pane.addTab("<dwc-icon name='box'></dwc-icon>            Products");
    pane.addTab("<dwc-icon name='files'></dwc-icon>          Documents");

    border.onToggle( e -> pane.setBorderless(!pane.isBorderless()));
    active.onToggle( e -> pane.setHideActiveIndicator(!pane.isHideActiveIndicator()));
  }
}
