package com.webforj.samples.views.toast;

import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.list.ChoiceBox;
import com.webforj.component.list.ListItem;
import com.webforj.component.toast.Toast;
import com.webforj.component.toast.Toast.Placement;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import java.util.ArrayList;
import java.util.List;

@Route
@FrameTitle("Toast Placements")
public class ToastPlacementDemoView extends Composite<FlexLayout> {

  ChoiceBox placementChoiceBox;
  Button showToastButton;
  
  public ToastPlacementDemoView() {
    getBoundComponent().setDirection(FlexDirection.ROW).setAlignment(FlexAlignment.CENTER)
        .setJustifyContent(FlexJustifyContent.CENTER).setMargin("150px 20px")
        .setSpacing("var(--dwc-space-m)");

    placementChoiceBox = new ChoiceBox();

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

    showToastButton = new Button("Show Toast", ButtonTheme.PRIMARY, e -> {
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
    
    getBoundComponent().add(placementChoiceBox, showToastButton);
  }
}
