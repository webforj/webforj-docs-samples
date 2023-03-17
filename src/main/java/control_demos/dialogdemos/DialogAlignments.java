package control_demos.dialogdemos;

import org.dwcj.App;
import org.dwcj.controls.button.Button;
import org.dwcj.controls.button.events.ButtonClickEvent;
import org.dwcj.controls.dialog.Dialog;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcException;

public class DialogAlignments extends App {
  Button alignTop;
  Button alignMid;
  Button alignBtm;
  Dialog dialog;

  @Override
  public void run() throws DwcException {
    AppPanel p = new AppPanel();
    dialog = new Dialog();
    p.add(dialog);

    alignTop = new Button("Align to Top").onClick(this::topAlign);
    alignMid = new Button("Align to Center").onClick(this::midAlign);
    alignBtm = new Button("Align to Bottom").onClick(this::btmAlign);

    dialog.getHeader().add(new Label("Header"));
    dialog.getContent().add(alignTop, alignMid, alignBtm)
      .setStyle("display","flex")
      .setStyle("justify-content", "space-around");
    dialog.getFooter().add(new Label("Footer"));

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
