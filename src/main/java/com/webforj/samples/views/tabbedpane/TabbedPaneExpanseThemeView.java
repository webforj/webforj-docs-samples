package com.webforj.samples.views.tabbedpane;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.Expanse;
import com.webforj.component.Theme;
import com.webforj.component.html.elements.Div;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.list.ChoiceBox;
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
@FrameTitle("Tabbed Pane Expanses and Themes")
public class TabbedPaneExpanseThemeView extends Composite<Div> {

  TabbedPane pane = new TabbedPane();
  ChoiceBox themes = new ChoiceBox("Themes");
  ChoiceBox expanses = new ChoiceBox("Expanses");

  public TabbedPaneExpanseThemeView() {
    getBoundComponent().addClassName("window");
    FlexLayout options = new FlexLayout();
    options.setSpacing("50px")
        .add(themes,expanses);
    getBoundComponent().add(options, pane);

    pane.addTab("<dwc-icon name='dashboard'></dwc-icon>      Dashboard");
    pane.addTab("<dwc-icon name='shopping-cart'></dwc-icon>  Orders");
    pane.addTab("<dwc-icon name='users'></dwc-icon>          Customers");
    pane.addTab("<dwc-icon name='box'></dwc-icon>            Products");
    pane.addTab("<dwc-icon name='files'></dwc-icon>          Documents");
    
    for(Theme theme : Theme.values()){
      themes.add(theme.toString());
    }
    themes.setWidth("200px");
    themes.selectIndex(1);
    themes.onSelect( e -> pane.setTheme(Theme.valueOf(e.getSelectedItem().getText())));

    for(Expanse expanse : Expanse.values()){
      expanses.add(expanse.toString());
    }
    expanses.setWidth("200px");
    expanses.selectIndex(5);
    expanses.onSelect( e -> pane.setExpanse(Expanse.valueOf(e.getSelectedItem().getText())));
  }
}
