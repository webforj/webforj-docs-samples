package componentdemos.toastdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.list.ChoiceBox;
import com.webforj.component.list.ListItem;
import com.webforj.component.toast.Toast;
import com.webforj.component.toast.Toast.Placement;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;
import java.util.ArrayList;
import java.util.List;

@InlineStyleSheet(/*css */"""
    .window {
      display: flex;
      flex-direction: row;
      align-items: center;
      justify-content: center;
      margin: 150px 20px;
      gap: var(--dwc-space-m);
    }
    """)
public class ToastPlacementDemo extends App {

  @Override
  public void run() throws WebforjException {
    Frame frame = new Frame();
    frame.addClassName("window");

    final ChoiceBox placementChoiceBox = new ChoiceBox();

    List<ListItem> placementOptions = new ArrayList<>();
    placementOptions.add(new ListItem("TOP"));
    placementOptions.add(new ListItem("TOP_LEFT"));
    placementOptions.add(new ListItem("TOP_RIGHT"));
    placementOptions.add(new ListItem("CENTER"));
    placementOptions.add(new ListItem("BOTTOM"));
    placementOptions.add(new ListItem("BOTTOM_LEFT"));
    placementOptions.add(new ListItem("BOTTOM_RIGHT"));

    placementChoiceBox.insert(placementOptions);
    placementChoiceBox.selectIndex(4); 
    placementChoiceBox.setMinWidth(160);

    Button showToastButton = new Button("Show Toast", e -> {
      String selectedValue = placementChoiceBox.getText();

      Placement selectedPlacement;
      switch (selectedValue) {
        case "TOP_LEFT":
          selectedPlacement = Placement.TOP_LEFT;
          break;
        case "TOP_RIGHT":
          selectedPlacement = Placement.TOP_RIGHT;
          break;
        case "CENTER":
          selectedPlacement = Placement.CENTER;
          break;
        case "BOTTOM":
          selectedPlacement = Placement.BOTTOM;
          break;
        case "BOTTOM_LEFT":
          selectedPlacement = Placement.BOTTOM_LEFT;
          break;
        case "BOTTOM_RIGHT":
          selectedPlacement = Placement.BOTTOM_RIGHT;
          break;
        case "TOP":
        default:
          selectedPlacement = Placement.TOP;
          break;
      }
     
      Toast.show("This is a toast notification", selectedPlacement);
    });
    showToastButton.setTheme(ButtonTheme.PRIMARY);
    
    frame.add(placementChoiceBox);
    frame.add(showToastButton);
  }
}
