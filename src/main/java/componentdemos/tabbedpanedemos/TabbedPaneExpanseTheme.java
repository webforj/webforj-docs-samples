package componentdemos.tabbedpanedemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.Expanse;
import org.dwcj.component.Theme;
import org.dwcj.component.layout.flexlayout.FlexLayout;
import org.dwcj.component.list.ChoiceBox;
import org.dwcj.component.tabbedpane.TabbedPane;
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
public class TabbedPaneExpanseTheme extends App {

  TabbedPane pane = new TabbedPane();
  ChoiceBox themes = new ChoiceBox("Themes");
  ChoiceBox expanses = new ChoiceBox("Expanses");

  @Override
  public void run() throws DwcjException {
    Frame app = new Frame();
    app.addClassName("window");
    FlexLayout options = new FlexLayout();
    options.setSpacing("50px")
        .add(themes,expanses);
    app.add(options, pane);

    pane.addTab("<dwc-icon name='dashboard'></dwc-icon>      Dashboard");
    pane.addTab("<dwc-icon name='shopping-cart'></dwc-icon>  Orders");
    pane.addTab("<dwc-icon name='users'></dwc-icon>          Customers");
    pane.addTab("<dwc-icon name='box'></dwc-icon>            Products");
    pane.addTab("<dwc-icon name='files'></dwc-icon>          Documents");
    
    for(Theme theme : Theme.values()){
      themes.add(theme.toString());
    }
    themes.setStyle("width", "200px");
    themes.selectIndex(1);
    themes.onSelect( e -> {
      pane.setTheme(Theme.valueOf(e.getSelectedItem().getText()));
    });

    for(Expanse expanse : Expanse.values()){
      expanses.add(expanse.toString());
    }
    expanses.setStyle("width", "200px");
    expanses.selectIndex(5);
    expanses.onSelect( e -> {
      pane.setExpanse(Expanse.valueOf(e.getSelectedItem().getText()));
    });
  }
}
