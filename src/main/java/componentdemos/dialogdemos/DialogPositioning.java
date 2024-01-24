package componentdemos.dialogdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.button.Button;
import org.dwcj.component.dialog.Dialog;
import org.dwcj.component.field.NumberField;
import org.dwcj.component.layout.flexlayout.FlexLayout;
import org.dwcj.component.html.elements.Div;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/dialogstyles/dialog_position_styles.css")
public class DialogPositioning extends App {

  private NumberField xPos = new NumberField();
  private NumberField yPos = new NumberField();
  private Dialog dialog = new Dialog();
  private Button setPosition = new Button("Set Dialog Position");

  @Override
  public void run() throws DwcjException {
    Frame p = new Frame();
    xPos.setStyle("max-width", "25%");
    yPos.setStyle("max-width", "25%");
    p.add(dialog);

    FlexLayout xLayout = FlexLayout.create(new Div("X Pixels: "), xPos)
        .horizontal()
        .build();

    FlexLayout yLayout = FlexLayout.create(new Div("Y Pixels : "), yPos)
        .horizontal()
        .build();

    setPosition.onClick(e -> {
          dialog.setPosx(xPos.getValue().toString() + "px");
          dialog.setPosy(yPos.getValue().toString() + "px");
        });

    dialog.addToHeader(new Div("Positioning"));
    dialog.addToContent(xLayout, yLayout);
    dialog.addToFooter(setPosition);
    dialog.setAutofocus(true);
    dialog.open();
    dialog.setCloseable(false);
  }
}
