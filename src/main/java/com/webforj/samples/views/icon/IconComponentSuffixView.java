package com.webforj.samples.views.icon;

import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.icons.FeatherIcon;
import com.webforj.component.icons.FontAwesomeIcon;
import com.webforj.component.icons.Icon;
import com.webforj.component.icons.TablerIcon;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route
@FrameTitle("Icon Action Buttons")
public class IconComponentSuffixView extends Composite<FlexLayout> {
  
  public IconComponentSuffixView() {
    getBoundComponent().setDirection(FlexDirection.ROW).setMargin("var(--dwc-space-l)")
    .setSpacing("var(--dwc-space-l)");
    
    Icon like = FontAwesomeIcon.create("heart");
    Button likeButton = new Button("Favorite").setSuffixComponent(like)
    .setTheme(ButtonTheme.DANGER);
        
    Icon download = TablerIcon.create("download");
    Button downloadButton = new Button("Download").setSuffixComponent(download)
    .setTheme(ButtonTheme.SUCCESS);
        
    Icon link = FeatherIcon.LINK.create();
    Button linkButton = new Button("Share").setSuffixComponent(link)
    .setTheme(ButtonTheme.DEFAULT);
    
    getBoundComponent().add(likeButton, downloadButton, linkButton);
  }
}