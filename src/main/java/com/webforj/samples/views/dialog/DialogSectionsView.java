package com.webforj.samples.views.dialog;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.dialog.Dialog;
import com.webforj.component.html.elements.Div;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet("context://css/dialogstyles/dialog_styles.css")
@Route
@FrameTitle("Dialog Sections")
public class DialogSectionsView extends Composite<Div> {

  private Dialog dialog = new Dialog();

  public DialogSectionsView() {
    getBoundComponent().add(dialog);
    dialog.addToHeader(new Div("Header"));
    dialog.addToContent(new Div("Content"));
    dialog.addToFooter(new Div("Footer"));
    dialog.setCloseable(false);
    dialog.open();
  }
}
