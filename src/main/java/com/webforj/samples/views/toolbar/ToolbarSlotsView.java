package com.webforj.samples.views.toolbar;

import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import com.webforj.component.html.elements.H1;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.html.elements.Img;
import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.field.TextField;
import com.webforj.component.field.TextField.Type;
import com.webforj.component.icons.Icon;
import com.webforj.component.icons.IconButton;
import com.webforj.component.icons.TablerIcon;
import com.webforj.component.layout.applayout.AppDrawerToggle;
import com.webforj.component.layout.applayout.AppLayout;
import com.webforj.component.layout.toolbar.Toolbar;

@Route
@FrameTitle("Toolbar Slots")
public class ToolbarSlotsView extends Composite<AppLayout> {

  AppLayout appLayout = getBoundComponent();
  Button analyzeButton = new Button("Analyze data");
  Toolbar toolbar = new Toolbar();
  AppDrawerToggle drawerToggle = new AppDrawerToggle();
  H1 title = new H1("webforJ App");
  H1 contentSlot = new H1("content");
  H1 endSlot = new H1("end");
  IconButton profile = new IconButton(TablerIcon.create("user-circle"));
  TextField textField = new TextField(TextField.Type.SEARCH);

  public ToolbarSlotsView() {

    drawerToggle.setAttribute("title", "Start slot");
    toolbar.addToStart(drawerToggle);

    toolbar.addToTitle(new H1("Title Slot"));

    textField.setTooltipText("Content slot");
    textField.setPrefixComponent(TablerIcon.create("search"));
    textField.setWidth("45vw");
    toolbar.addToContent(textField);

    profile.setAttribute("title", "End slot");
    toolbar.addToEnd(profile);

    appLayout.setDrawerHeaderVisible(true)
        .addToHeader(toolbar)
        .addToDrawerTitle(new Img("https://documentation.webforj.com/img/webforj_icon.svg"))
        .addToContent(new H1("Application Title"), new Paragraph("Content goes here"));

  }
}