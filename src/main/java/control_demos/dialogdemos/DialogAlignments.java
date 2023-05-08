package control_demos.dialogdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.choicebox.ChoiceBox;
import org.dwcj.component.dialog.Dialog;
import org.dwcj.component.label.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/dialogstyles/dialog_styles.css")
public class DialogAlignments extends App {
  Dialog dialog;
  ChoiceBox options;

  @Override
  public void run() throws DwcjException {
    Frame p = new Frame();
    dialog = new Dialog();
    p.add(dialog);
    options = new ChoiceBox()
      .addItem(Dialog.Alignment.TOP, "Top")
      .addItem(Dialog.Alignment.CENTER, "Center")
      .addItem(Dialog.Alignment.BOTTOM, "Bottom")
      .setAttribute("label", "Select Alignment")
      .selectIndex(1)
      .onSelect( e -> {
        dialog.setAlignment((Dialog.Alignment) e.getKey());
      });

    dialog.getHeader().add(new Label("Alignments"));
    dialog.getContent().add(options)
    .setStyle("display", "flex")
    .setStyle("justify-content", "center");

    dialog.show();
    dialog.setCloseable(false);
  }
}
