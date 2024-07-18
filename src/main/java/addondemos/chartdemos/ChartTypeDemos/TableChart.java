package addondemos.chartdemos.ChartTypeDemos;

import com.webforj.component.googlecharts.GoogleChart;
import java.util.List;
import java.util.Map;

public class TableChart {
  private final GoogleChart chart;

  public TableChart(Map<String, Object> data, Map<String, Object> options) {
    chart = new GoogleChart(GoogleChart.Type.TABLE);
    chart.setOptions(options);
    chart.setData((List<Object>) data.get("data"));
  }

  public GoogleChart getChart() {
    return chart;
  }
}