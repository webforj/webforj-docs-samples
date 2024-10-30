package com.webforj.samples.views.toolbar;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.H1;
import com.webforj.component.html.elements.H2;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.Composite;
import com.webforj.component.Theme;
import com.webforj.component.button.Button;
import com.webforj.component.icons.IconButton;
import com.webforj.component.icons.TablerIcon;
import com.webforj.component.layout.applayout.AppLayout;
import com.webforj.component.layout.applayout.AppLayout.DrawerPlacement;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.layout.toolbar.Toolbar;

@InlineStyleSheet("context://css/toolbar/toolbarMobile.css")
@Route
@FrameTitle("Toolbar Mobile App")
public class ToolbarMobileAppView extends Composite<AppLayout> {

  AppLayout appLayout = getBoundComponent();
  Button analyzeButton = new Button("Analyze data");
  Toolbar footerToolbar = new Toolbar();
  Toolbar headerToolbar = new Toolbar();

  public ToolbarMobileAppView() {

    headerToolbar.add(new H1("webforJ App"));
    headerToolbar.setTheme(Theme.INFO);

    FlexLayout flexLayout = FlexLayout.create(new H1("Aplication Title"))
        .vertical()
        .justify().center()
        .build()
        .setMargin("50px");

    for (int i = 0; i < 5; i++) {
      Div content = new Div().addClassName("card");
      content.add(
          new H2("What is Lorem Ipsum " + i + "?"),
          new Paragraph("Lorem Ipsum is simply dummy text of the printing and typesetting " +
              "industry. Lorem Ipsum has been the industry's standard dummy text " +
              "ever since the 1500s when an unknown printer took a galley of type " +
              "and scrambled it to make a type specimen book. It has survived not " +
              "only five centuries, but also the leap into electronic " +
              "typesetting, remaining essentially unchanged. It was popularized " +
              "in the 1960s with the release of Letraset sheets containing Lorem " +
              "Ipsum passages, and more recently with desktop publishing software " +
              "like Aldus PageMaker including versions of Lorem Ipsum."));
      flexLayout.add(content);
    }

    IconButton dashboard = new IconButton(TablerIcon.create("dashboard"));
    IconButton orders = new IconButton(TablerIcon.create("shopping-cart"));
    IconButton customers = new IconButton(TablerIcon.create("users"));
    IconButton products = new IconButton(TablerIcon.create("box"));
    IconButton documents = new IconButton(TablerIcon.create("files"));

    FlexLayout iconLayout = FlexLayout.create(dashboard, orders, customers, products, documents)
        .justify().evenly()
        .build();

    footerToolbar.addToContent(iconLayout);
    footerToolbar.setTheme(Theme.INFO);

    appLayout.setDrawerHeaderVisible(true)
        .addToHeader(headerToolbar)
        .addToFooter(footerToolbar)
        .addToContent(flexLayout)
        .setDrawerPlacement(DrawerPlacement.HIDDEN);

  }
}