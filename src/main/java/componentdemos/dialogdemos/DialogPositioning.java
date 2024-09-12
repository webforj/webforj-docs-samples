package componentdemos.dialogdemos;

import com.webforj.App;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.dialog.Dialog;
import com.webforj.component.field.NumberField;
import com.webforj.component.html.elements.Div;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class DialogPositioning extends App {

  private NumberField xPos = new NumberField("X Pixels:");
  private NumberField yPos = new NumberField("Y Pixels:");
  private Dialog dialog = new Dialog();
  private Button setPosition = new Button("Set Dialog Position", ButtonTheme.PRIMARY);

  @Override
  public void run() throws WebforjException {
    Frame frame = new Frame();
    frame.add(dialog);

    xPos.setMin(0d);
    yPos.setMin(0d);

    setPosition.setMinHeight("60px");

    setPosition.onClick(e -> {
      if (xPos.getValue() != null) {
        dialog.setPosx(xPos.getValue().toString() + "px");
      }
      if (yPos.getValue() != null) {
        dialog.setPosy(yPos.getValue().toString() + "px");
      }
    });

    dialog.addToHeader(new Div("Positioning"));
    dialog.addToContent(xPos, yPos);
    dialog.addToFooter(setPosition);
    dialog.setAutofocus(true);
    dialog.open();
    dialog.setCloseable(false);
    dialog.setMaxWidth("200px");
  }
}
