package layout_demos.item;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.button.Button;
import org.dwcj.component.choicebox.ChoiceBox;
import org.dwcj.component.choicebox.event.ChoiceBoxSelectEvent;
import org.dwcj.component.flexlayout.FlexAlignment;
import org.dwcj.component.flexlayout.FlexContentAlignment;
import org.dwcj.component.flexlayout.FlexDirection;
import org.dwcj.component.flexlayout.FlexJustifyContent;
import org.dwcj.component.flexlayout.FlexLayout;
import org.dwcj.component.label.Label;
import org.dwcj.component.numberfield.NumberField;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

import layout_demos.helper.Box;

@InlineStyleSheet("context://css/flexstyles/container_styles.css")
public class SelfAlign extends App{

  FlexLayout boxLayout;
  Box alignBox;

  @Override
  public void run() throws DwcjException{
    
    Frame page = new Frame();
    
    FlexLayout mainLayout = FlexLayout.create()
    .horizontal()
    .build();
    
    this.boxLayout = FlexLayout.create()
    .horizontal()
    .build()
    .addClassName("button__container");
    
    for(int i = 1; i <= 5; i++){
      String hue = String.valueOf((360/10) * i);
      Box newBox = new Box("Order: " + i);
      newBox.setStyle("background", "hsla(" + String.valueOf(hue) + ", 50%, 75%, 0.25)");
      newBox.setStyle("border", "2px solid " + "hsl(" + String.valueOf(hue) + ", 50%, 35%)");
      newBox.setStyle("color", "hsl(" + String.valueOf(hue) + ", 50%, 25%)");
      boxLayout.add(newBox);
      if(i == 5){
        alignBox = newBox;
      }
    }

    ChoiceBox alignment = new ChoiceBox()
    .onSelect(this::selectAlignment)
    .addClassName("flex__options");
    alignment.setAttribute("label", "Self Alignment Options");
    for(FlexAlignment align : FlexAlignment.values()){
      String label = align.getValue();
      alignment.addItem(
        "." + align.toString()
          .toLowerCase() + "()", 
        label.substring(0, 1)
          .toUpperCase() + label
          .substring(1)
          );
        }
    alignment.selectIndex(0);
    
    alignBox.setDisplay("Set Alignment");
    boxLayout.setItemAlignment(FlexAlignment.START, alignBox);
    page.add(mainLayout);
    mainLayout.add(alignment, boxLayout);    
  }

  private void selectAlignment(ChoiceBoxSelectEvent ev){
    App.consoleError("FECK");
    alignBox.setItemAlignment(FlexAlignment.fromValue(ev.getControl().getSelectedItem().getValue()), alignBox);
  }
  
}
