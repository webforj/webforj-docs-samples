package componentdemos.dialogdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.choicebox.ChoiceBox;
import org.dwcj.component.dialog.Dialog;
import org.dwcj.component.texts.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/dialogstyles/dialog_styles.css")
public class DialogThemes extends App {
  Dialog dialog;
  ChoiceBox options;

  @Override
  public void run() throws DwcjException {
    Frame p = new Frame();
    dialog = new Dialog();
    p.add(dialog);
    options = new ChoiceBox();
    
    for (Dialog.Theme theme : Dialog.Theme.values()) {
      options.addItem(theme, Character.toUpperCase(theme.getValue().charAt(0)) + theme.getValue().substring(1));
    }
    options.setAttribute("label", "Select Theme")
        .setStyle("width", "100px")
        .selectIndex(1)
        .onSelect(e -> {
          dialog.setTheme(((Dialog.Theme) e.getKey()));
        });

    dialog.getHeader().add(new Label("Themes"));
    dialog.getContent().add(options)
        .setStyle("display", "flex")
        .setStyle("justify-content", "center");

    dialog.show();
    dialog.setCloseable(false);
  }
}
