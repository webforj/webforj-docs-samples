package componentdemos.icondemos;

import com.webforj.App;
import com.webforj.component.html.elements.Img;
import com.webforj.component.icons.FeatherIcon;
import com.webforj.component.icons.FontAwesomeIcon;
import com.webforj.component.icons.IconButton;
import com.webforj.component.icons.TablerIcon;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.tabbedpane.Tab;
import com.webforj.component.tabbedpane.TabbedPane;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class IconDemo extends App {

  TabbedPane options = new TabbedPane();
  FlexLayout header = new FlexLayout();

  IconButton language = new IconButton(TablerIcon.create("language"));
  IconButton theme = new IconButton(TablerIcon.create("sun"));
  IconButton profile = new IconButton(TablerIcon.create("user-circle"));

  @Override
  public void run() throws WebforjException {
    Frame mainFrame = new Frame();
    header.setJustifyContent(FlexJustifyContent.BETWEEN)
        .setAlignment(FlexAlignment.CENTER);
    header.setStyle("padding", "1.5em")
        .setStyle("box-shadow", "4px -5px 8px 10px lightgray");
    mainFrame.add(header);

    initLogo();
    initTabs();
    initIconButtons();
  }

  private void initLogo() {
    Img logo = new Img("https://webforj.com/wp-content/uploads/2024/04/cropped-Logo_webforJ_RGB_1-removebg-preview.png");
    header.add(logo);
    logo.setHeight(32);
    logo.setWidth(130);
  }

  private void initTabs() {
    options.addTab(new Tab("Orders", TablerIcon.create("truck-delivery")));
    options.addTab(new Tab("Locations", FeatherIcon.MAP_PIN.create()));
    options.addTab(new Tab("Users", FontAwesomeIcon.create("user", FontAwesomeIcon.Variate.REGULAR)));
    header.add(options);
  }

  private void initIconButtons() {
    FlexLayout iconButtonContainer = new FlexLayout();
    iconButtonContainer.setSpacing("1.5em");
    iconButtonContainer.add(language, theme, profile);
    header.add(iconButtonContainer);
  }
}
