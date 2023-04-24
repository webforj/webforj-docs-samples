package layout_demos.helper;

import java.util.HashMap;
import java.util.Map;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.AbstractDwcComponent;
import org.dwcj.component.flexlayout.FlexLayout;
import org.dwcj.component.label.Label;
import org.dwcj.component.window.AbstractWindow;

@InlineStyleSheet("context://css/flexstyles/box_styles.css")
public class Box extends AbstractDwcComponent{
  
  FlexLayout box;
  int num;
  boolean vis = true;

  private final Map<String, String> styles = new HashMap<>();


  @Override
  public void create(AbstractWindow p){
    box = FlexLayout.create()
    .horizontal()
    .align().center()
    .justify().center()
    .build();
    p.add(box);

    box.add(new Label("Box " + this.num)).addClassName("demo__box");
    box.setStyle("background", "light-red");
    box.setStyle("border", "red 2px solid");
    
    for (Map.Entry<String, String> entry : styles.entrySet()) {
      box.setStyle(entry.getKey(), entry.getValue());
    }
    if(!vis){
      box.setVisible(false);
    }
  }

  public Box(int num){
    this.num = num;
  }

  @Override
  public Box setStyle(String property, String value){
    styles.put(property, value);
    return this;
  }
  
  @Override
  public Box setVisible(Boolean visible){
    if(Boolean.TRUE.equals(this.getCaughtUp())){
      App.consoleLog("TEST");
    }else{
      box.setVisible(visible);
      this.vis = visible;
    }
    return this;
  }

  @Override
  public void destroy(){
    box.destroy();
  }
}
