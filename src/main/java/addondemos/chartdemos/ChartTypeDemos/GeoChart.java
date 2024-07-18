package addondemos.chartdemos.ChartTypeDemos;

import com.webforj.component.googlecharts.GoogleChart;
import java.util.List;
import java.util.Map;

public class GeoChart {
  private final GoogleChart chart;

  public GeoChart(Map<String, Object> data, Map<String, Object> options) {
    chart = new GoogleChart(GoogleChart.Type.GEO);
    chart.setOptions(options);
    chart.setData((List<Object>) data.get("data"));
  }

  public GoogleChart getChart() {
    return chart;
  }
}