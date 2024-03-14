package layout_demos.container;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.list.ChoiceBox;
import com.webforj.component.list.event.ListSelectEvent;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

import layout_demos.helper.Box;

@InlineStyleSheet("context://css/flexstyles/container_styles.css")
public class Direction extends App {

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
        .addClassName("button__container--single-row");

    for (int i = 1; i <= 4; i++) {
      String hue = String.valueOf((360 / 10) * i);
      Box newBox = new Box(i);
      newBox.setStyle("background", "hsla(" + String.valueOf(hue) + ", 50%, 75%, 0.25)");
      newBox.setStyle("border", "2px solid " + "hsl(" + String.valueOf(hue) + ", 50%, 35%)");
      newBox.setStyle("color", "hsl(" + String.valueOf(hue) + ", 50%, 25%)");
      boxLayout.add(newBox);
    }

    ChoiceBox directions = new ChoiceBox();
    directions.onSelect(this::selectDirection);
    directions.addClassName("flex__options");
    directions.setLabel("Direction Options");
    for (FlexDirection justify : FlexDirection.values()) {
      String label = justify.getValue();
      directions.add(
          "." + justify.toString()
              .toLowerCase() + "()",
          label.substring(0, 1)
              .toUpperCase()
              + label
                  .substring(1));
    }
    directions.selectIndex(0);
    page.add(mainLayout);
    mainLayout.add(directions, boxLayout);
  }

  private void selectDirection(ListSelectEvent ev) {
    boxLayout.setDirection(FlexDirection.fromValue(ev.getSelectedItem().getText()));
  }
}
