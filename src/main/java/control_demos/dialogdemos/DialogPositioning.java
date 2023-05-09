package control_demos.dialogdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.event.ButtonClickEvent;
import org.dwcj.component.dialog.Dialog;
import org.dwcj.component.flexlayout.FlexLayout;
import org.dwcj.component.label.Label;
import org.dwcj.component.numberfield.NumberField;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/dialogstyles/dialog_position_styles.css")
public class DialogPositioning extends App {

  NumberField xPos, yPos;
  Dialog dialog;

  @Override
  public void run() throws DwcjException {
    Frame p = new Frame();
    dialog = new Dialog();
    xPos = new NumberField()
      .setStyle("max-width", "25%");
    yPos = new NumberField()
      .setStyle("max-width", "25%");
    p.add(dialog);

    FlexLayout xLayout = FlexLayout.create(new Label("X Pixels: "), xPos)
    .horizontal()
    .build();

    FlexLayout yLayout = FlexLayout.create(new Label("Y Pixels :"), yPos)
    .horizontal()
    .build();

    dialog.getHeader().add(new Label("Positioning"));
    dialog.getContent().add(xLayout, yLayout); 
    dialog.getFooter().add(new Button("Set Dialog Position")
                            .onClick(this::setPosition)
                            .setStyle("width", "150px"));

    dialog.setAutoFocus(true);
    dialog.show();
    dialog.setCloseable(false);
  }

  private void setPosition(ButtonClickEvent ev) {
    dialog.setPosx(xPos.getValue().toString() + "px");
    dialog.setPosy(yPos.getValue().toString() + "px");
  }
}
