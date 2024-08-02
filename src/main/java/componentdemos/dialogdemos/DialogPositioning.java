package componentdemos.dialogdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.button.Button;
import com.webforj.component.dialog.Dialog;
import com.webforj.component.field.NumberField;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.html.elements.Div;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/dialogstyles/dialog_position_styles.css")
public class DialogPositioning extends App {

  private NumberField xPos = new NumberField();
  private NumberField yPos = new NumberField();
  private Dialog dialog = new Dialog();
  private Button setPosition = new Button("Set Dialog Position");

  @Override
  public void run() throws WebforjException {
    Frame p = new Frame();
    xPos.setMaxWidth("25%");
    yPos.setMaxWidth("25%");
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
