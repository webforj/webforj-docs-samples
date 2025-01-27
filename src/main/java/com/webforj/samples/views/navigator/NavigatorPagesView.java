package com.webforj.samples.views.navigator;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.navigator.Navigator;
import com.webforj.component.navigator.Navigator.Layout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route
@FrameTitle("Navigator Pagination")
public class NavigatorPagesView extends Composite<Div> {

  public NavigatorPagesView() {
    Paragraph text = new Paragraph("Navigate with the buttons below");
    Navigator nav = new Navigator(100, Layout.PAGES);
    nav.getPaginator().setMax(5);
    nav.onChange(e -> {
      String fromattedText =
          String.format("Showing %d to %d of 100", e.getStartIndex() + 1, e.getEndIndex() + 1);
      text.setText(fromattedText);
    });

    getBoundComponent().setStyle("padding", "20px");
    getBoundComponent().add(text, nav);
  }
}
