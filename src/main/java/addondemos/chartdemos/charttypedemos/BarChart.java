package addondemos.chartdemos.charttypedemos;

import com.webforj.component.googlecharts.GoogleChart;
import com.webforj.component.html.elements.Div;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BarChart extends Div {

  GoogleChart chart = new GoogleChart(GoogleChart.Type.BAR);

  public BarChart() {
    Map<String, Object> options = Map.of(
        "title", "Comparison of Quarterly Revenue",
        "bars", "horizontal",
        "hAxis", Map.of(
            "title", "Total Revenue",
            "minValue", 0,
            "format", "currency",
            "textStyle", Map.of(
                "bold", true,
                "fontSize", 12,
                "color", "#4d4d4d"
            )
        ),
        "vAxis", Map.of(
            "title", "Quarter",
            "textStyle", Map.of(
                "bold", true,
                "fontSize", 12,
                "color", "#4d4d4d"
            )
        ),
        "colors", List.of("#e0440e")
    );
    chart.setOptions(options);

    List<Object> data = new ArrayList<>();
    data.add(Arrays.asList("Quarter", "Revenue"));
    data.add(Arrays.asList("Q1", 10000));
    data.add(Arrays.asList("Q2", 11700));
    data.add(Arrays.asList("Q3", 6600));
    data.add(Arrays.asList("Q4", 10300));
    chart.setData(data);

    this.addClassName("chart-div");
  }

  public GoogleChart getChart() {
    return chart;
  }
}
