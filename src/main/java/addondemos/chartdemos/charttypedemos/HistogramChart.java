package addondemos.chartdemos.charttypedemos;

import com.webforj.component.googlecharts.GoogleChart;
import com.webforj.component.html.elements.Div; // Import Div
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class HistogramChart extends Div {

  GoogleChart chart = new GoogleChart(GoogleChart.Type.HISTOGRAM);

  public HistogramChart() {
    Map<String, Object> options = Map.of(
        "title", "Distribution of Weight",
        "legend", Map.of("position", "none"),
        "hAxis", Map.of(
            "title", "Weight",
            "minValue", 0,
            "textStyle", Map.of(
                "bold", true,
                "fontSize", 12,
                "color", "#4d4d4d"
            )
        ),
        "vAxis", Map.of(
            "title", "Frequency",
            "minValue", 0,
            "textStyle", Map.of(
                "bold", true,
                "fontSize", 12,
                "color", "#4d4d4d"
            )
        ),
        "colors", List.of("#4285f4")
    );
    chart.setOptions(options);

    List<Object> data = new ArrayList<>();
    data.add(Arrays.asList("Age"));
    data.add(Arrays.asList(18));
    data.add(Arrays.asList(20));
    data.add(Arrays.asList(22));
    data.add(Arrays.asList(24));
    data.add(Arrays.asList(26));
    data.add(Arrays.asList(28));
    data.add(Arrays.asList(30));
    chart.setData(data);

    this.addClassName("chart-div"); // Add CSS class name
  }

  public GoogleChart getChart() {
    return chart;
  }
}