package layout_demos.container;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.choicebox.ChoiceBox;
import org.dwcj.component.choicebox.event.ChoiceBoxSelectEvent;
import org.dwcj.component.flexlayout.FlexAlignment;
import org.dwcj.component.flexlayout.FlexJustifyContent;
import org.dwcj.component.flexlayout.FlexLayout;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

import layout_demos.helper.Box;

@InlineStyleSheet("context://css/flexstyles/container_styles.css")
public class Positioning extends App {

  FlexLayout boxLayout;

  @Override
  public void run() throws DwcjException {

    Frame page = new Frame();

    FlexLayout mainLayout = FlexLayout.create()
        .horizontal()
        .build();

    this.boxLayout = FlexLayout.create()
        .horizontal()
        .build()
        .addClassName("button__container--single-row")
        .setStyle("height", "200px");

    for (int i = 1; i <= 4; i++) {
      String hue = String.valueOf((360 / 10) * i);
      Box newBox = new Box(i);
      newBox.setStyle("background", "hsla(" + String.valueOf(hue) + ", 50%, 75%, 0.25)");
      newBox.setStyle("border", "2px solid " + "hsl(" + String.valueOf(hue) + ", 50%, 35%)");
      newBox.setStyle("color", "hsl(" + String.valueOf(hue) + ", 50%, 25%)");
      boxLayout.add(newBox);
    }

    ChoiceBox horizontal = new ChoiceBox().onSelect(this::selectJustify)
        .addClassName("flex__options");
    horizontal.setAttribute("label", "Position Options");
    for (FlexJustifyContent justify : FlexJustifyContent.values()) {
      String label = justify.getValue();
      horizontal.addItem(
          "." + justify.toString()
              .toLowerCase() + "()",
          label.substring(0, 1)
              .toUpperCase()
              + label
                  .substring(1));
    }
    horizontal.selectIndex(0);

    ChoiceBox vertical = new ChoiceBox().onSelect(this::selectAlignment)
        .addClassName("flex__options");
    vertical.setAttribute("label", "Position Options");
    for (FlexAlignment justify : FlexAlignment.values()) {
      String label = justify.getValue();
      vertical.addItem(
          "." + justify.toString()
              .toLowerCase() + "()",
          label.substring(0, 1)
              .toUpperCase()
              + label
                  .substring(1));
    }
    vertical.selectIndex(0);

    FlexLayout choices = FlexLayout.create(horizontal, vertical)
        .vertical()
        .build();

    page.add(mainLayout);
    mainLayout.add(choices, boxLayout);
  }

  private void selectJustify(ChoiceBoxSelectEvent ev) {
    boxLayout.setJustifyContent(FlexJustifyContent.fromValue(ev.getControl().getSelectedItem().getValue()));
  }

  private void selectAlignment(ChoiceBoxSelectEvent ev) {
    boxLayout.setAlignment(FlexAlignment.fromValue(ev.getControl().getSelectedItem().getValue()));
  }

}
