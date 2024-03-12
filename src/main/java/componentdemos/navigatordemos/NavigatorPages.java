package componentdemos.navigatordemos;

import org.dwcj.App;
import org.dwcj.component.html.elements.Paragraph;
import org.dwcj.component.navigator.Navigator;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

public class NavigatorPages extends App {

  @Override
  public void run() throws DwcjException {
    Paragraph text = new Paragraph("Navigate with the buttons below");
    Navigator nav = new Navigator(100, Navigator.Layout.PAGES);
    nav.getPaginator().setMax(5);
    nav.onChange(e -> {
      String fromattedText =
          String.format("Showing %d to %d of 100", e.getStartIndex(), e.getEndIndex());
      text.setText(fromattedText);
    });

    Frame mainFrame = new Frame();
    mainFrame.add(text, nav);
  }
}
