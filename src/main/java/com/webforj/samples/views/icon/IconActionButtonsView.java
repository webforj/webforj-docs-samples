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
public class IconActionButtonsView extends Composite<FlexLayout> {
  
  public IconActionButtonsView() {
    getBoundComponent().setDirection(FlexDirection.ROW).setMargin("var(--dwc-space-l)")
    .setSpacing("var(--dwc-space-l)");
    
    Icon save = FontAwesomeIcon.create("save");
    Button saveButton = new Button("Save").setPrefixComponent(save)
    .setTheme(ButtonTheme.PRIMARY);
        
    Icon trash = TablerIcon.create("trash");
    Button deleteButton = new Button("Delete").setPrefixComponent(trash)
    .setTheme(ButtonTheme.DANGER);
        
    Icon edit = FeatherIcon.EDIT.create();
    Button editButton = new Button("Edit").setPrefixComponent(edit)
    .setTheme(ButtonTheme.DEFAULT);
    
    getBoundComponent().add(saveButton, deleteButton, editButton);
  }
}