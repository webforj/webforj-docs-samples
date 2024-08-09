package componentdemos.choiceboxdemos;

import java.util.ArrayList;
import java.util.List;
import com.webforj.App;
import com.webforj.component.window.Frame;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.layout.flexlayout.FlexLayoutBuilder;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.list.ChoiceBox;
import com.webforj.component.list.ListItem;
import com.webforj.exceptions.WebforjException;

public class ChoiceBoxThemeDemo extends App {

  @Override
  public void run() throws WebforjException {
    
    Frame window = new Frame();

    FlexLayout mainLayout = FlexLayout.create()
    .vertical()
    .justify().center()
    .build();

    FlexLayoutBuilder buttonLayout = FlexLayout.create()
    .justify().around();

    FlexLayout filledButtons = buttonLayout.build();
    FlexLayout outlineButtons = buttonLayout.build();

    List<ListItem> data = new ArrayList<>();
    data.add(new ListItem("Default Selection", "Theme Name"));
    data.add(new ListItem("Random Data1", "Some Data"));
    data.add(new ListItem("Random Data2", "More Data"));
    data.add(new ListItem("Random Data3", "Test Data"));

    for (ButtonTheme theme : ButtonTheme.values()) {
      if (!theme.name().contains("OUTLINE")) {
        ChoiceBox themeChoiceBox = new ChoiceBox();
        data.set(0,new ListItem("Default Selection", theme.name()));
        themeChoiceBox.insert(data)
            .selectIndex(0)
            .setMinWidth("200px");
        filledButtons.add(themeChoiceBox.setTheme(theme));
      }
    }

    for (ButtonTheme theme : ButtonTheme.values()) {
      if (theme.name().contains("OUTLINE")) {
        ChoiceBox themeChoiceBox = new ChoiceBox();
        data.set(0,new ListItem("Default Selection", theme.name()));
        themeChoiceBox.insert(data)
            .selectIndex(0)
            .setMinWidth("200px");
        outlineButtons.add(themeChoiceBox.setTheme(theme));
      }
    }

    mainLayout.setMargin("10px");
    mainLayout.add(filledButtons, outlineButtons);
    window.add(mainLayout);
    window.setStyle("overflow-x","scroll");

    }

  }