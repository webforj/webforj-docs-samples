package componentdemos.navigatordemos;

import com.webforj.App;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.navigator.Navigator;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class NavigatorPages extends App {

  @Override
  public void run() throws WebforjException {
    Paragraph text = new Paragraph("Navigate with the buttons below");
    Navigator nav = new Navigator(100, Navigator.Layout.PAGES);
    nav.getPaginator().setMax(5);
    nav.onChange(e -> {
      String formattedText =
          String.format("Showing %d to %d of 100", e.getStartIndex() + 1, e.getEndIndex());
      text.setText(formattedText);
    });

    Frame mainFrame = new Frame();
    mainFrame.setStyle("padding", "20px");
    mainFrame.add(text, nav);
  }
}
