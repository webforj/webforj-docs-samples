package componentdemos.dialogdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.list.ChoiceBox;
import com.webforj.component.dialog.Dialog;
import com.webforj.component.html.elements.Div;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/dialogstyles/dialog_styles.css")
public class DialogAlignments extends App {

  private Dialog dialog = new Dialog();
  private ChoiceBox options = new ChoiceBox();

  @Override
  public void run() throws WebforjException {
    Frame p = new Frame();
    p.add(dialog);
    options.add(Dialog.Alignment.TOP, "Top");
    options.add(Dialog.Alignment.CENTER, "Center");
    options.add(Dialog.Alignment.BOTTOM, "Bottom");
    options.setLabel("Select Alignment");
    options.selectIndex(1);
    options.onSelect(e -> dialog.setAlignment((Dialog.Alignment) e.getSelectedItem().getKey()));

    dialog.addToHeader(new Div("Alignments"));
    dialog.addToContent(options)
        .setStyle("display", "flex")
        .setStyle("justify-content", "center");

    dialog.open();
    dialog.setCloseable(false);
  }
}
