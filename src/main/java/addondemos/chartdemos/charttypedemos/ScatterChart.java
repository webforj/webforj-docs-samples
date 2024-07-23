package addondemos.chartdemos.charttypedemos;

import com.webforj.component.googlecharts.GoogleChart;
import com.webforj.component.html.elements.Div;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ScatterChart extends Div {
  
  GoogleChart chart = new GoogleChart(GoogleChart.Type.SCATTER);

  public ScatterChart() {
    Map<String, Object> options = Map.of(
        "title", "Scatter Chart",
        "hAxis", Map.of(
            "title", "Age"
        ),
        "vAxis", Map.of(
            "title", "Weight"
        ),
        "colors", Arrays.asList("#FFA500")
    );
    chart.setOptions(options);

    List<Object> data = new ArrayList<>();
    data.add(Arrays.asList("Age", "Weight"));
    data.add(Arrays.asList(8, 12));
    data.add(Arrays.asList(4, 5.5));
    data.add(Arrays.asList(11, 14));
    data.add(Arrays.asList(4, 5));
    data.add(Arrays.asList(3, 3.5));
    data.add(Arrays.asList(6.5, 7));
    chart.setData(data);
    
    this.addClassName("chart-div");
  }

  public GoogleChart getChart() {
    return chart;
  }
}