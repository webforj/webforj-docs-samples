package layout_demos.container;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.choicebox.ChoiceBox;
import org.dwcj.component.choicebox.event.ChoiceBoxSelectEvent;
import org.dwcj.component.layout.flexlayout.FlexJustifyContent;
import org.dwcj.component.layout.flexlayout.FlexLayout;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

import layout_demos.helper.Box;

@InlineStyleSheet("context://css/flexstyles/container_styles.css")
public class Justification extends App {

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
        .addClassName("button__container--single-row");

    for (int i = 1; i <= 7; i++) {
      String hue = String.valueOf((360 / 10) * i);
      Box newBox = new Box(i);
      newBox.setStyle("background", "hsla(" + String.valueOf(hue) + ", 50%, 75%, 0.25)");
      newBox.setStyle("border", "2px solid " + "hsl(" + String.valueOf(hue) + ", 50%, 35%)");
      newBox.setStyle("color", "hsl(" + String.valueOf(hue) + ", 50%, 25%)");
      boxLayout.add(newBox);
    }

    ChoiceBox justifications = new ChoiceBox().onSelect(this::selectJustification);
    justifications.setAttribute("label", "Justification Options");
    for (FlexJustifyContent justify : FlexJustifyContent.values()) {
      String label = justify.getValue()
          .replaceAll("^(.+?)-", "");
      justifications.addItem(".justify()." + justify.toString().toLowerCase().replaceAll("^(.+?)-", "") + "()",
          label.substring(0, 1).toUpperCase() + label.substring(1));
    }
    justifications.selectIndex(0);
    page.add(mainLayout);
    mainLayout.add(justifications, boxLayout);
  }

  private void selectJustification(ChoiceBoxSelectEvent ev) {
    boxLayout.setJustifyContent(FlexJustifyContent.fromValue(ev.getControl().getSelectedItem().getValue()));
  }

}
