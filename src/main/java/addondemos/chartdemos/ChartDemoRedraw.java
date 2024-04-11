package addondemos.chartdemos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.NumberField;
import com.webforj.component.googlecharts.GoogleChart;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/chartstyles/redrawchart_styles.css")
public class ChartDemoRedraw extends App {

  GoogleChart chart = new GoogleChart(GoogleChart.Type.COLUMN);
  Button redrawButton = new Button("Redraw Chart");

  @Override
  public void run() throws WebforjException {
    
      Frame window = new Frame();
      window.addClassName("window");

      chart.setStyle("width", "600px");

      Map<String, Object> options = new HashMap<>();
      options.put("title", "Social Media Following");
      options.put("colors", List.of("#006fe6"));
      chart.setOptions(options);

      List<Object> data = new ArrayList<>();
      data.add(List.of("Category", "Following"));
      String[] categories = {"Instagram", "Twitter", "Facebook", "LinkedIn"};
      for (String category : categories) {
          data.add(List.of(category, 100));
      }
      chart.setData(data);

      FlexLayout inputGroup = new FlexLayout();
      inputGroup.addClassName("input-group");
      
      Map<String, NumberField> valueFields = new HashMap<>();
      for (String category : categories) {
          NumberField valueField = new NumberField("Value for " + category);
          valueField.setPlaceholder("");
          valueField.setStep(1.0);
          valueField.addClassName("number-field");
          inputGroup.add(valueField);
          valueFields.put(category, valueField);
      }

      redrawButton.addClassName("redraw-button");
      redrawButton.addClickListener(e -> {
        List<Object> newData = new ArrayList<>();
        newData.add(List.of("Category", "Followers"));
        boolean allValuesValid = true;

        for (Map.Entry<String, NumberField> entry : valueFields.entrySet()) {
            String category = entry.getKey();
            NumberField valueField = entry.getValue();
            Double value = null;
            try {
                value = valueField.getValue(); 
            } catch (NumberFormatException ex) {
                allValuesValid = false;
                break; 
            }

            newData.add(List.of(category, value));
        }

        if (allValuesValid) {
            chart.setData(newData);
            chart.redraw();
        } 
    });

      inputGroup.add(redrawButton.setTheme(ButtonTheme.PRIMARY));
      window.add(chart);
      window.add(inputGroup);
  }
}
