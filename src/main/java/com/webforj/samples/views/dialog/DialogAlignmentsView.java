package com.webforj.samples.views.dialog;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.list.ChoiceBox;
import com.webforj.component.Composite;
import com.webforj.component.dialog.Dialog;
import com.webforj.component.html.elements.Div;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet("context://css/dialogstyles/dialog_styles.css")
@Route
@FrameTitle("Dialog Alignments")
public class DialogAlignmentsView extends Composite<Div> {

  private Dialog dialog = new Dialog();
  private ChoiceBox options = new ChoiceBox();

  public DialogAlignmentsView() {
    getBoundComponent().add(dialog);
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
