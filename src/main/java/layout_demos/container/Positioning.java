package layout_demos.container;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.list.ChoiceBox;
import com.webforj.component.list.event.ListSelectEvent;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

import layout_demos.helper.Box;

@InlineStyleSheet("context://css/flexstyles/container_styles.css")
public class Positioning extends App {

  FlexLayout boxLayout;

  @Override
  public void run() throws WebforjException {

    Frame page = new Frame();

    FlexLayout mainLayout = FlexLayout.create()
        .horizontal()
        .build();

    this.boxLayout = FlexLayout.create()
        .horizontal()
        .build()
        .addClassName("button__container--single-row")
        .setHeight("200px");

    for (int i = 1; i <= 4; i++) {
      String hue = String.valueOf((360 / 10) * i);
      Box newBox = new Box(i);
      newBox.setStyle("background", "hsla(" + String.valueOf(hue) + ", 50%, 75%, 0.25)");
      newBox.setStyle("border", "2px solid " + "hsl(" + String.valueOf(hue) + ", 50%, 35%)");
      newBox.setStyle("color", "hsl(" + String.valueOf(hue) + ", 50%, 25%)");
      boxLayout.add(newBox);
    }

    ChoiceBox horizontal = new ChoiceBox();
    horizontal.onSelect(this::selectJustify);
    horizontal.addClassName("flex__options");
    horizontal.setLabel("Position Options");
    for (FlexJustifyContent justify : FlexJustifyContent.values()) {
      String label = justify.getValue();
      horizontal.add(
          "." + justify.toString()
              .toLowerCase() + "()",
          label.substring(0, 1)
              .toUpperCase()
              + label
                  .substring(1));
    }
    horizontal.selectIndex(0);

    ChoiceBox vertical = new ChoiceBox();
    vertical.onSelect(this::selectAlignment);
    vertical.addClassName("flex__options");
    vertical.setLabel("Position Options");
    for (FlexAlignment justify : FlexAlignment.values()) {
      String label = justify.getValue();
      vertical.add(
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

  private void selectJustify(ListSelectEvent ev) {
    boxLayout.setJustifyContent(FlexJustifyContent.fromValue(ev.getSelectedItem().getText()));
  }

  private void selectAlignment(ListSelectEvent ev) {
    boxLayout.setAlignment(FlexAlignment.fromValue(ev.getSelectedItem().getText()));
  }

}
