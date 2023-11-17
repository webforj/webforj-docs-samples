package componentdemos.dialogdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.list.ChoiceBox;
import org.dwcj.component.dialog.Dialog;
import org.dwcj.component.text.Label;
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
    options = new ChoiceBox();
        options.add(Dialog.Alignment.TOP, "Top");
        options.add(Dialog.Alignment.CENTER, "Center");
        options.add(Dialog.Alignment.BOTTOM, "Bottom");
        options.setLabel("Select Alignment");
        options.selectIndex(1);
        options.onSelect(e -> {
          dialog.setAlignment((Dialog.Alignment) e.getSelectedItem().getKey());
        });

    dialog.getHeader().add(new Label("Alignments"));
    dialog.getContent().add(options)
        .setStyle("display", "flex")
        .setStyle("justify-content", "center");

    dialog.show();
    dialog.setCloseable(false);
  }
}
