package layout_demos.item;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.ButtonTheme;
import org.dwcj.component.choicebox.ChoiceBox;
import org.dwcj.component.layout.flexlayout.FlexAlignment;
import org.dwcj.component.layout.flexlayout.FlexLayout;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/flexstyles/container_styles.css")
public class SelfAlign extends App{

  FlexLayout boxLayout;
  Button alignButton;

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
      Button newButton = new Button("Button " + i);
      boxLayout.add(newButton.setTheme(ButtonTheme.PRIMARY));
      boxLayout.setItemOrder(i, newButton);
      alignButton = newButton;
    }
    alignButton.setTheme(ButtonTheme.DANGER).setText("Align Me!");

    ChoiceBox alignment = new ChoiceBox()
    .onSelect( e -> {
      boxLayout.setItemAlignment(FlexAlignment.fromValue(e.getControl().getSelectedItem().getValue()), alignButton);
    })
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
    
    boxLayout.setItemAlignment(FlexAlignment.START, alignButton);
    page.add(mainLayout);
    mainLayout.add(alignment, boxLayout);    
  }
}
