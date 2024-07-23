package addondemos.chartdemos.charttypedemos;

import com.webforj.component.googlecharts.GoogleChart;
import com.webforj.component.html.elements.Div;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ComboChart extends Div {

  GoogleChart chart = new GoogleChart(GoogleChart.Type.COMBO);

  public ComboChart() {
    Map<String, Object> options = Map.of(
        "title", "Revenue vs. Expenses",
        "vAxes", Map.of(
            "0", Map.of("title", "Revenue", "minValue", 0),
            "1", Map.of("title", "Expenses")
        ),
        "hAxis", Map.of(
            "title", "Month",
            "textStyle", Map.of(
                "bold", true,
                "fontSize", 12,
                "color", "#4d4d4d"
            )
        ),
        "seriesType", "bars",
        "series", Map.of(
            "0", Map.of("type", "bars", "targetAxisIndex", 0),
            "1", Map.of("type", "line", "targetAxisIndex", 1, "color", "#e2431e")
        )
    );
    chart.setOptions(options);

    List<Object> data = new ArrayList<>();
    data.add(Arrays.asList("Month", "Revenue", "Expenses"));
    data.add(Arrays.asList("January", 800, 500));
    data.add(Arrays.asList("February", 900, 700));
    data.add(Arrays.asList("March", 1000, 600));
    data.add(Arrays.asList("April", 1100, 900));
    chart.setData(data);

    this.addClassName("chart-div");
  }

  public GoogleChart getChart() {
    return chart;
  }
}

