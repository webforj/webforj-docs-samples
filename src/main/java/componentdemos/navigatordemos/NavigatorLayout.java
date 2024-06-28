package componentdemos.navigatordemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.list.ChoiceBox;
import com.webforj.component.navigator.Navigator;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet(/* css */"""
    .layout {
      max-width: 400px;
    }""")
public class NavigatorLayout extends App {
  private Navigator nav = new Navigator(100);
  private ChoiceBox navLayout = new ChoiceBox();
  private FlexLayout layout = FlexLayout.create(navLayout, nav).vertical().build();

  @Override
  public void run() throws WebforjException {
    
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
    mainFrame.setStyle("padding", "20px");
    mainFrame.add(layout);
  }
}
