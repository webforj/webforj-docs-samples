package com.webforj.samples.views.loading;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.Theme;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.icons.FeatherIcon;
import com.webforj.component.icons.Icon;
import com.webforj.component.loading.Loading;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

/**
 * Demo to show Loading basics.
 */

@Route
@FrameTitle("Loading Basics")
@InlineStyleSheet("context://css/loadingstyles/loadingdemo_styles.css")
public class LoadingDemoView extends Composite<Div> {
  
  private Div container;
  private Div card1 = new Div();
  private Div card2 = new Div();
  private Icon guideIcon = FeatherIcon.BOOK.create();
  private Icon videoIcon = FeatherIcon.YOUTUBE.create();
  private Button buyButton1 = new Button("Buy");
  private Button buyButton2 = new Button("Buy");
  private Loading loading = new Loading("Loading... Please wait.");
  
  public LoadingDemoView() {
    container = getBoundComponent();
    container.addClassName("window");

    card1.addClassName("card");
    
    guideIcon.addClassName("icon");
    
    buyButton1.setTheme(ButtonTheme.PRIMARY);
    
    card2.addClassName("card");

    videoIcon.addClassName("icon");
    
    buyButton2.setTheme(ButtonTheme.PRIMARY);

    loading.getSpinner().setTheme(Theme.PRIMARY);
    loading.addClassName("loading-overlay");

    card1.add(new Paragraph("User Guide"), guideIcon, buyButton1);
    card2.add(new Paragraph("Video Lessons"), videoIcon, buyButton2, loading);
    
    loading.open();
    
    container.add(card1, card2);
  }
}


