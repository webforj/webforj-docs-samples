package control_demos.dialogdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.event.ButtonClickEvent;
import org.dwcj.component.dialog.Dialog;
import org.dwcj.component.label.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/dialogstyles/dialog_styles.css")
public class DialogAlignments extends App {
  Button alignTop;
  Button alignMid;
  Button alignBtm;
  Dialog dialog;

  @Override
  public void run() throws DwcjException {
    Frame p = new Frame();
    dialog = new Dialog();
    p.add(dialog);

    alignTop = new Button("Align to Top").onClick(this::topAlign);
    alignMid = new Button("Align to Center").onClick(this::midAlign);
    alignBtm = new Button("Align to Bottom").onClick(this::btmAlign);

    dialog.getHeader().add(new Label("Alignments"));
    dialog.getContent().add(alignTop, alignMid, alignBtm)
      .setStyle("display","flex")
      .setStyle("justify-content", "space-around");

    dialog.show();
    dialog.setCloseable(false);
  }

  private void topAlign(ButtonClickEvent ev){
    dialog.setAlignment(Dialog.Alignment.TOP);
  }
  private void midAlign(ButtonClickEvent ev){
    dialog.setAlignment(Dialog.Alignment.CENTER);
  }
  private void btmAlign(ButtonClickEvent ev){
    dialog.setAlignment(Dialog.Alignment.BOTTOM);
  }
}
