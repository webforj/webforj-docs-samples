package addondemos.chartdemos.charttypedemos;

import com.webforj.component.googlecharts.GoogleChart;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PieChart {

  GoogleChart chart  = new GoogleChart(GoogleChart.Type.PIE);
  
  public PieChart() {
    Map<String, Object> options = Map.of(
        "title", "Social Media Distribution",
        "is3D", true,
        "pieSliceText", "percentage",
        "colors", List.of("#34a853", "#4285f4", "#fbbc05", "#ea4335", "#ff5722")
    );
    chart.setOptions(options);

    List<Object> data = new ArrayList<>();
    data.add(Arrays.asList("Task", "Hours per Day"));
    data.add(Arrays.asList("Work", 11));
    data.add(Arrays.asList("Eat", 2));
    data.add(Arrays.asList("Commute", 2));
    data.add(Arrays.asList("Watch TV", 2));
    data.add(Arrays.asList("Sleep", 7));
    chart.setData(data);
  }

  public GoogleChart getChart() {
    return chart;
  }
}