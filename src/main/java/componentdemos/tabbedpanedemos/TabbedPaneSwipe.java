package componentdemos.tabbedpanedemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.list.ChoiceBox;
import org.dwcj.component.tabbedpane.TabbedPane;
import org.dwcj.component.tabbedpane.TabbedPane.Placement;

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
public class TabbedPaneSwipe extends App {

  TabbedPane pane = new TabbedPane();

  @Override
  public void run() throws DwcjException {
    Frame app = new Frame();
    app.addClassName("window");
    app.add(pane);

    pane.addTab("<bbj-icon name='dashboard'></bbj-icon>      Dashboard");
    pane.addTab("<bbj-icon name='shopping-cart'></bbj-icon>  Orders");
    pane.addTab("<bbj-icon name='users'></bbj-icon>          Customers");
    pane.addTab("<bbj-icon name='box'></bbj-icon>            Products");
    pane.addTab("<bbj-icon name='files'></bbj-icon>          Documents");

    pane.setSwipeable(true);
    pane.setSwipeWithMouse(true);
  
  }
}
