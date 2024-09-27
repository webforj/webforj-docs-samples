package componentdemos.loadingbusydemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Theme;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.window.Frame;
import com.webforj.component.loading.Loading;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/loadingbusystyles/loadingdemo_styles.css")
public class LoadingDemo extends App {

  @Override
  public void run() throws WebforjException {
    Frame frame = new Frame();

    Div card = new Div();
    card.addClassName("card");

    Paragraph content = new Paragraph("""
      The Loading component is designed to provide visual feedback during operations
      that take time, such as data fetching or complex processing. It overlays the parent
      component and can be scoped to specific areas of the application. This allows
      for a better user experience by indicating that the app is working without blocking
      the entire interface. You can customize the spinner, message, and even the
      backdrop of the Loading component to fit your application's design. This particular
      implementation shows how a loading indicator can be integrated within a card element,
      showcasing its flexibility in layout and functionality.
    """);
    content.addClassName("card-content");

    Loading loading = new Loading("Loading... Please wait.");
    loading.getSpinner().setTheme(Theme.PRIMARY);
    loading.addClassName("loading-overlay");

    card.add(new Paragraph("Loading"), content, loading);
    
    loading.open();
    
    frame.add(card);
  }
}


