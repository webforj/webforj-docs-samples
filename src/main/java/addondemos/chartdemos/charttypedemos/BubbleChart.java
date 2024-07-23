package addondemos.chartdemos.charttypedemos;

import com.webforj.component.googlecharts.GoogleChart;
import com.webforj.component.html.elements.Div;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BubbleChart extends Div {

  GoogleChart chart = new GoogleChart(GoogleChart.Type.BUBBLE);

  public BubbleChart() {
    Map<String, Object> options = Map.of(
        "title", "Investment vs. Profit",
        "hAxis", Map.of(
            "title", "Potential Investment",
            "textStyle", Map.of(
                "bold", true,
                "fontSize", 12,
                "color", "#4d4d4d"
            )
        ),
        "vAxis", Map.of(
            "title", "Potential Profit",
            "textStyle", Map.of(
                "bold", true,
                "fontSize", 12,
                "color", "#4d4d4d"
            )
        ),
        "bubble", Map.of("textStyle", Map.of("fontSize", 11)),
        "colorAxis", Map.of("colors", List.of("#d4c5f9", "#495057"))
    );
    chart.setOptions(options);

    List<Object> data = new ArrayList<>();
    data.add(Arrays.asList("ID", "X", "Y", "Temperature"));
    data.add(Arrays.asList("1", 80, 167, 120));
    data.add(Arrays.asList("2", 79, 136, 130));
    data.add(Arrays.asList("3", 78, 184, 50));
    data.add(Arrays.asList("4", 72, 278, 230));
    chart.setData(data);

    this.addClassName("chart-div");
  }

  public GoogleChart getChart() {
    return chart;
  }
}
