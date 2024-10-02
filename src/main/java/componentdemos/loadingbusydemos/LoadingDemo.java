package componentdemos.loadingbusydemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Theme;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.icons.Icon;
import com.webforj.component.icons.TablerIcon;
import com.webforj.component.loading.Loading;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

/**
 * Demo to show Loading basics.
 */

@InlineStyleSheet("context://css/loadingbusystyles/loadingdemo_styles.css")
public class LoadingDemo extends App {

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("window");

    Div card1 = new Div();
    card1.addClassName("card");

    Icon guideIcon = TablerIcon.create("book");
    guideIcon.setStyle("width", "100px");
    guideIcon.setStyle("height", "100px");
    guideIcon.addClassName("card-content");
    
    Button buyButton1 = new Button("Buy");
    buyButton1.setTheme(ButtonTheme.PRIMARY);
    
    Div card2 = new Div();
    card2.addClassName("card");

    Icon videoIcon = TablerIcon.create("brand-youtube");
    videoIcon.setStyle("width", "100px");
    videoIcon.setStyle("height", "100px");
    videoIcon.addClassName("card-content");
    
    Button buyButton2 = new Button("Buy");
    buyButton2.setTheme(ButtonTheme.PRIMARY);

    Loading loading = new Loading("Loading... Please wait.");
    loading.getSpinner().setTheme(Theme.PRIMARY);
    loading.addClassName("loading-overlay");

    card1.add(new Paragraph("User Guide"), guideIcon, buyButton1);
    card2.add(new Paragraph("Video Lessons"), videoIcon, buyButton2, loading);
    
    loading.open();
    
    window.add(card1, card2);
  }
}


