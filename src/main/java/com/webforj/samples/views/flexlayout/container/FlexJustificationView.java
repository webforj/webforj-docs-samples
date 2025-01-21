package com.webforj.samples.views.flexlayout.container;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.list.ChoiceBox;
import com.webforj.component.list.event.ListSelectEvent;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import com.webforj.samples.components.Box;

@InlineStyleSheet("context://css/flexlayout/container/flexContainerBuilder.css")
@Route
@FrameTitle("Flex Justification")
public class FlexJustificationView extends Composite<Div> {

  FlexLayout boxLayout;

  public FlexJustificationView() {

    FlexLayout mainLayout = FlexLayout.create()
        .horizontal()
        .build();

    this.boxLayout = FlexLayout.create()
        .horizontal()
        .build()
        .addClassName("button__container--single-row");

    for (int i = 1; i <= 7; i++) {
      String hue = String.valueOf((360 / 10) * i);
      Box newBox = new Box(i);
      newBox.setStyle("background", "hsla(" + String.valueOf(hue) + ", 50%, 75%, 0.25)");
      newBox.setStyle("border", "2px solid " + "hsl(" + String.valueOf(hue) + ", 50%, 35%)");
      newBox.setStyle("color", "hsl(" + String.valueOf(hue) + ", 50%, 25%)");
      boxLayout.add(newBox);
    }

    ChoiceBox justifications = new ChoiceBox();
    justifications.onSelect(this::selectJustification);
    justifications.setLabel("Justification Options");
    for (FlexJustifyContent justify : FlexJustifyContent.values()) {
      String label = justify.getValue()
          .replaceAll("^(.+?)-", "");
      justifications.add(".justify()." + justify.toString().toLowerCase().replaceAll("^(.+?)-", "") + "()",
          label.substring(0, 1).toUpperCase() + label.substring(1));
    }
    justifications.selectIndex(0);
    justifications.setStyle("margin", "20px")
                  .setStyle("width", "150px");
    getBoundComponent().add(mainLayout);
    mainLayout.add(justifications, boxLayout);
  }

  private void selectJustification(ListSelectEvent ev) {
    boxLayout.setJustifyContent(FlexJustifyContent.fromValue(ev.getSelectedItem().getText()));
  }

}
