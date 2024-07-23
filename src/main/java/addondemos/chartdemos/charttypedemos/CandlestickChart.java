package addondemos.chartdemos.charttypedemos;

import com.webforj.component.googlecharts.GoogleChart;
import com.webforj.component.html.elements.Div;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CandlestickChart extends Div {

  GoogleChart chart = new GoogleChart(GoogleChart.Type.CANDLESTICK);

  public CandlestickChart() {
    Map<String, Object> options = Map.of(
        "title", "Stock Market Trends",
        "legend", "none",
        "bar", Map.of("groupWidth", "20%"),
        "candlestick", Map.of(
            "fallingColor", Map.of("strokeWidth", 0, "fill", "#a52714"),
            "risingColor", Map.of("strokeWidth", 0, "fill", "#0f9d58")
        )
    );
    chart.setOptions(options);

    List<Object> data = new ArrayList<>();
    data.add(Arrays.asList(
        Map.of("type", "string", "label", "Day"),
        Map.of("type", "number", "label", "Low"),
        Map.of("type", "number", "label", "Opening"),
        Map.of("type", "number", "label", "Closing"),
        Map.of("type", "number", "label", "High")
    ));
    data.add(Arrays.asList("Mon", 20, 28, 38, 45));
    data.add(Arrays.asList("Tue", 31, 38, 55, 66));
    data.add(Arrays.asList("Wed", 50, 55, 60, 70));
    data.add(Arrays.asList("Thu", 35, 40, 50, 55));
    data.add(Arrays.asList("Fri", 20, 22, 30, 50));
    chart.setData(data);

    this.addClassName("chart-div");
  }

  public GoogleChart getChart() {
    return chart;
  }
}
