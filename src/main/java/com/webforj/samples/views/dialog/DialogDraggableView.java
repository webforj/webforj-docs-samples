package com.webforj.samples.views.dialog;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.dialog.Dialog;
import com.webforj.component.html.elements.Div;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet("context://css/dialogstyles/dialog_styles.css")
@Route
@FrameTitle("Dialog Dragging")
public class DialogDraggableView extends Composite<Div> {

  private Dialog dialog = new Dialog();

  public DialogDraggableView() {
    getBoundComponent().add(dialog);

    dialog.addToHeader(new Div("Snapping"));
    dialog.addToContent(new Div("This dialog will snap when dragged within 100px of the edge of the display."));
    dialog.open();

    dialog.setSnapToEdge(true);
    dialog.setSnapThreshold(100);
  }
}
