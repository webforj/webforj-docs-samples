package addondemos.chartdemos.charttypedemos;

import com.webforj.component.googlecharts.GoogleChart;
import com.webforj.component.html.elements.Div;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GaugeChart extends Div {
  
  GoogleChart chart = new GoogleChart(GoogleChart.Type.GAUGE);

  public GaugeChart() {
    Map<String, Object> options = Map.of(
        "title", "Performance Metrics",
        "greenFrom", 75,
        "greenTo", 100,
        "yellowFrom", 50,
        "yellowTo", 75,
        "redFrom", 0,
        "redTo", 50,
        "minorTicks", 5
    );
    chart.setOptions(options);

    List<Object> data = new ArrayList<>();
    data.add(Arrays.asList("Label", "Value"));
    data.add(Arrays.asList("Memory", 80));
    data.add(Arrays.asList("CPU", 55));
    data.add(Arrays.asList("Network", 68));
    chart.setData(data);
    
    this.addClassName("chart-div");
  }

  public GoogleChart getChart() {
    return chart;
  }
}
