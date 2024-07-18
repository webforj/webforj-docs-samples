package addondemos.chartdemos.ChartTypeDemos;

import com.webforj.component.googlecharts.GoogleChart;
import java.util.List;
import java.util.Map;

public class AreaChart {
  private final GoogleChart chart;

  public AreaChart(Map<String, Object> data, Map<String, Object> options) {
    chart = new GoogleChart(GoogleChart.Type.AREA);
    chart.setOptions(options);
    chart.setData((List<Object>) data.get("data"));
  }

  public GoogleChart getChart() {
    return chart;
  }
}