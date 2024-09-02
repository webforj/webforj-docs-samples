package addondemos.chartdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.NumberField;
import com.webforj.component.googlecharts.GoogleChart;
import com.webforj.component.html.elements.Div;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@InlineStyleSheet("context://css/chartstyles/redrawchart_styles.css")
public class ChartDemoRedraw extends App {

  private static final String COLOR = "color";
  private static final String TEXT_STYLE = "textStyle";
  private static final String TITLE = "title";

  private GoogleChart chart = new GoogleChart(GoogleChart.Type.COLUMN);
  private Button redrawButton = new Button("Redraw Chart");
  private FlexLayout inputGroup = new FlexLayout();

  @Override
  public void run() throws WebforjException {

    Frame window = new Frame();
    window.addClassName("window");

    Div chartContainer = new Div();
    chartContainer.addClassName("chart-container");
    chartContainer.add(chart);

    Map<String, Object> options = new HashMap<>();
    options.put(TITLE, "Social Media Following");
    options.put("colors", List.of("#006fe6"));
    options.put("backgroundColor", "transparent");
    options.put("chartArea", Map.of("width", "80%", "height", "70%"));
    options.put("hAxis", Map.of(TEXT_STYLE, Map.of(COLOR, "#333")));
    options.put("vAxis", Map.of("minValue", 0, TEXT_STYLE, Map.of(COLOR, "#333")));
    options.put("legend", Map.of("position", "bottom"));
    chart.setOptions(options);

    List<Object> data = new ArrayList<>();
    data.add(List.of("Category", "Number of Followers in Thousands"));

    inputGroup.addClassName("input-group");

    String[] categories = {"Instagram", "Twitter", "Facebook", "LinkedIn"};
    Map<String, NumberField> valueFields = new HashMap<>();

    for (String category : categories) {
      data.add(List.of(category, 100));
      NumberField valueField = new NumberField("Value for " + category);
      valueField.setPlaceholder("");
      valueField.setStep(1.0);
      valueField.addClassName("number-field");
      valueField.setText("100");
      inputGroup.add(valueField);
      valueFields.put(category, valueField);
    }
    chart.setData(data);

    redrawButton.addClassName("redraw-button");
    redrawButton.addClickListener(e -> {
      List<Object> newData = new ArrayList<>();
      newData.add(List.of("Category", "Followers"));
      boolean allValuesValid = true;
      for (String category : categories) {
        NumberField valueField = valueFields.get(category);
        String fieldValue = valueField.getText();
        Double value = null;

        if (!fieldValue.isEmpty()) {
          try {
            value = Double.parseDouble(fieldValue);
          } catch (NumberFormatException ex) {
            allValuesValid = false;
            break;
          }
        }

        newData.add(List.of(category, value != null ? value.intValue() : null));
      }

      if (allValuesValid) {
        chart.setData(newData);
        chart.redraw();
      }
    });

    inputGroup.add(redrawButton.setTheme(ButtonTheme.PRIMARY));
    window.add(chartContainer);  
    window.add(inputGroup);
  }
}


