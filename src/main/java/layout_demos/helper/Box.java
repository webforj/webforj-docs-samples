package layout_demos.helper;

import java.util.HashMap;
import java.util.Map;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.Composite;
import org.dwcj.component.layout.flexlayout.FlexAlignment;
import org.dwcj.component.layout.flexlayout.FlexJustifyContent;
import org.dwcj.component.layout.flexlayout.FlexLayout;
import org.dwcj.component.text.Label;
import org.dwcj.component.window.Window;
import org.dwcj.concern.HasStyle;
import org.dwcj.concern.legacy.LegacyHasStyle;

@InlineStyleSheet("context://css/flexstyles/box_styles.css")
public class Box extends Composite<FlexLayout> implements HasStyle<Box> {

  int num;
  String title = "";
  boolean vis = true;
  Label display = new Label();

  private Map<String, String> styles;

  Box(){
    getBoundComponent().setAlignment(FlexAlignment.CENTER)
      .setJustifyContent(FlexJustifyContent.CENTER);

    if (title.isEmpty()) {
      title = "Box " + this.num;
    }
    display.setText(title);
    getBoundComponent().add(display);
    getBoundComponent().addClassName("demo__box");

    for (Map.Entry<String, String> entry : styles.entrySet()) {
      getBoundComponent().setStyle(entry.getKey(), entry.getValue());
    }
    if (!vis) {
      getBoundComponent().setVisible(false);
    }

  }

  public Box(int num) {
    this.num = num;
  }

  public Box(String title) {
    this.title = title;
  }

  
  public Box setVisible(Boolean visible) {
    if (Boolean.TRUE.equals(this.isAttached())) {
    } else {
      getBoundComponent().setVisible(visible);
      this.vis = visible;
    }
    return this;
  }

  public void setDisplay(String text) {
    this.title = text;
  }

  public void boxDestroy() {
    getBoundComponent().destroy();
  }

  @Override
  public String getStyle(String property) {
    return getBoundComponent().getStyle(property);
  }

  @Override
  public String getComputedStyle(String property) {
    return getBoundComponent().getComputedStyle(property);
  }

  @Override
  public Box setStyle(String property, String value) {
    getBoundComponent().setStyle(property, value);
    return this;
  }

  @Override
  public Box removeStyle(String property) {
    getBoundComponent().removeStyle(property);
    return this;
  }
}
