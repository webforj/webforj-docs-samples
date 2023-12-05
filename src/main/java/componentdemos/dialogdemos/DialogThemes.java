package componentdemos.dialogdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.list.ChoiceBox;
import org.dwcj.component.dialog.Dialog;
import org.dwcj.component.Theme;
import org.dwcj.component.text.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/dialogstyles/dialog_styles.css")
public class DialogThemes extends App {

  private Dialog dialog = new Dialog();
  private ChoiceBox options = new ChoiceBox();

  @Override
  public void run() throws DwcjException {
    Frame p = new Frame();
    p.add(dialog);

    for (org.dwcj.component.Theme theme : org.dwcj.component.Theme.values()) {
      options.add(theme, Character.toUpperCase(theme.name().charAt(0)) + theme.name().substring(1));
    }

    options.setLabel("Select Theme")
        .setStyle("width", "100px")
        .selectIndex(1)
        .onSelect(e -> dialog.setTheme(((org.dwcj.component.Theme) e.getSelectedItem().getKey())));

    dialog.addToHeader(new Label("Themes"));
    dialog.addToContent(options)
        .setStyle("display", "flex")
        .setStyle("justify-content", "center");

    dialog.open();
    dialog.setCloseable(false);
  }
}
