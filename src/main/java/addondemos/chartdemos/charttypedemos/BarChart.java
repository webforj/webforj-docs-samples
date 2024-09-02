package addondemos.chartdemos.charttypedemos;

import com.webforj.component.googlecharts.GoogleChart;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BarChart {

  private static final String TITLE = "title";

  private final GoogleChart chart = new GoogleChart(GoogleChart.Type.BAR);

  public BarChart() {

    Map<String, Object> options = new HashMap<>();
    options.put(TITLE, "Comparison of Quarterly Revenue");
    options.put("bars", "horizontal");
    options.put("hAxis", Map.of(
        TITLE, "Total Revenue",
        "minValue", 0,
        "format", "currency",
        "textStyle", Map.of(
            "bold", true,
            "fontSize", 12,
            "color", "#4d4d4d"
        )
    ));
    options.put("vAxis", Map.of(
        TITLE, "Quarter",
        "textStyle", Map.of(
            "bold", true,
            "fontSize", 12,
            "color", "#4d4d4d"
        )
    ));
    options.put("colors", Arrays.asList("#e0440e"));
    options.put("backgroundColor", "transparent");
    chart.setOptions(options);

    List<Object> data = new ArrayList<>();
    data.add(Arrays.asList("Quarter", "Revenue"));
    data.add(Arrays.asList("Q1", 10000));
    data.add(Arrays.asList("Q2", 11700));
    data.add(Arrays.asList("Q3", 6600));
    data.add(Arrays.asList("Q4", 10300));
    chart.setData(data);
  }

  public GoogleChart getChart() {
    return chart;
  }
}
