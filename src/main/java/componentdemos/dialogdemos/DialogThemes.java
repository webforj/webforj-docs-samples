package componentdemos.dialogdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.list.ChoiceBox;
import com.webforj.component.dialog.Dialog;
import com.webforj.component.html.elements.Div;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/dialogstyles/dialog_styles.css")
public class DialogThemes extends App {

  private Dialog dialog = new Dialog();
  private ChoiceBox options = new ChoiceBox();

  @Override
  public void run() throws WebforjException {
    Frame p = new Frame();
    p.add(dialog);

    for (com.webforj.component.Theme theme : com.webforj.component.Theme.values()) {
      options.add(theme, Character.toUpperCase(theme.name().charAt(0)) + theme.name().substring(1));
    }

    options.setLabel("Select Theme")
        .setStyle("flex", "1")
        .selectIndex(1)
        .onSelect(e -> dialog.setTheme(((com.webforj.component.Theme) e.getSelectedItem().getKey())));

    dialog.addToHeader(new Div("Themes"));
    dialog.addToContent(options)
        .setStyle("display", "flex")
        .setStyle("justify-content", "center");

    dialog.open();
    dialog.setCloseable(false);
  }
}
