package componentdemos.navigatordemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.layout.flexlayout.FlexLayout;
import org.dwcj.component.list.ChoiceBox;
import org.dwcj.component.navigator.Navigator;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet(/* css */"""
    .layout {
      max-width: 400px;
      margin: 0 auto;
    }""")
public class NavigautorLayout extends App {
  private Navigator nav = new Navigator(100);
  private ChoiceBox navLayout = new ChoiceBox();
  private FlexLayout layout = FlexLayout.create(navLayout, nav).vertical().build();

  @Override
  public void run() throws DwcjException {
    
    layout.addClassName("layout");
    nav.getPaginator().setMax(5);
    nav.addClassName("nav");
    
    navLayout.insert("NONE", "PAGES", "PREVIEW", "QUICK_JUMP");
    navLayout.selectIndex(2);
    navLayout.onSelect(ev -> {
      String selected = ev.getSelectedItem().getText();
      switch (selected) {
        case "NONE":
        nav.setLayout(Navigator.Layout.NONE);
        break;
        case "PAGES":
        nav.setLayout(Navigator.Layout.PAGES);
        break;
        case "PREVIEW":
        nav.setLayout(Navigator.Layout.PREVIEW);
        break;
        case "QUICK_JUMP":
        nav.setLayout(Navigator.Layout.QUICK_JUMP);
        break;
        default:
        break;
      }
    });
    
    Frame mainFrame = new Frame();
    mainFrame.add(layout);
  }
}
