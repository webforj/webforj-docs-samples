package com.webforj.samples.views.loadingbusy;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.Theme;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.icons.Icon;
import com.webforj.component.icons.TablerIcon;
import com.webforj.component.loading.Loading;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

/**
 * Demo to show Loading basics.
 */

@Route
@FrameTitle("Loading Basics")
@InlineStyleSheet("context://css/loadingbusystyles/loadingdemo_styles.css")
public class LoadingDemoView extends Composite<Div> {
  
  Div card1 = new Div();
  Div card2 = new Div();
  Icon guideIcon = TablerIcon.create("book");
  Icon videoIcon = TablerIcon.create("brand-youtube");
  Button buyButton1 = new Button("Buy");
  Button buyButton2 = new Button("Buy");
  Loading loading = new Loading("Loading... Please wait.");
  
  public LoadingDemoView() {
    getBoundComponent().addClassName("window");

    card1.addClassName("card");

    guideIcon.setStyle("width", "100px");
    guideIcon.setStyle("height", "100px");
    guideIcon.addClassName("card-content");
    
    buyButton1.setTheme(ButtonTheme.PRIMARY);
    
    card2.addClassName("card");

    videoIcon.setStyle("width", "100px");
    videoIcon.setStyle("height", "100px");
    videoIcon.addClassName("card-content");
    
    buyButton2.setTheme(ButtonTheme.PRIMARY);

    loading.getSpinner().setTheme(Theme.PRIMARY);
    loading.addClassName("loading-overlay");

    card1.add(new Paragraph("User Guide"), guideIcon, buyButton1);
    card2.add(new Paragraph("Video Lessons"), videoIcon, buyButton2, loading);
    
    loading.open();
    
    getBoundComponent().add(card1, card2);
  }
}


