package com.webforj.samples.views.dialog;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.dialog.Dialog;
import com.webforj.component.field.TextField;
import com.webforj.component.html.elements.Div;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet("context://css/dialogstyles/dialog_styles.css")
@Route
@FrameTitle("DIalog Auto-Focus")
public class DialogAutoFocusView extends Composite<Div> {
  
  private Dialog dialog = new Dialog();
  
  public DialogAutoFocusView() {
    getBoundComponent().add(dialog);

    dialog.addToContent(new Div("Auto Focus"));
    dialog.addToContent(new TextField().setLabel("This Box is Auto Focused"));

    dialog.open();
    dialog.setAutofocus(true);
  }
}
