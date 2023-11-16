package layout_demos.item;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.ButtonTheme;
import org.dwcj.component.list.ChoiceBox;
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
    .wrap().wrap()
    .build()
    .addClassName("button__container");
    
    for(int i = 1; i <= 5; i++){
      Button newButton = new Button("Button " + i);
      boxLayout.add(newButton.setTheme(ButtonTheme.PRIMARY));
      boxLayout.setItemOrder(i, newButton);
      alignButton = newButton;
    }
    alignButton.setTheme(ButtonTheme.DANGER).setText("Align Me!");

    ChoiceBox alignment = new ChoiceBox();
    alignment.onSelect( e -> {
      boxLayout.setItemAlignment(FlexAlignment.fromValue(e.getSelectedItem().getText()), alignButton);
    });
    alignment.addClassName("flex__options");
    
    alignment.setLabel( "Self Alignment Options");
    for(FlexAlignment align : FlexAlignment.values()){
      String label = align.getValue();
      alignment.add(
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
