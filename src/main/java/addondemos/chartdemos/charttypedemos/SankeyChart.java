package addondemos.chartdemos.charttypedemos;

import com.webforj.component.googlecharts.GoogleChart;
import com.webforj.component.html.elements.Div;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SankeyChart extends Div{

  GoogleChart chart = new GoogleChart(GoogleChart.Type.SANKEY);

  public SankeyChart() {
    Map<String, Object> options = Map.of(
        "title", "Flow of Resources",
        "sankey", Map.of(
            "link", Map.of(
                "color", Map.of(
                    "fill", "#e6e6e6",
                    "fillOpacity", 0.3
                )
            )
        )
    );
    chart.setOptions(options);

    List<Object> data = new ArrayList<>();
    data.add(Arrays.asList("From", "To", "Weight"));
    data.add(Arrays.asList("Brazil", "Portugal", 5));
    data.add(Arrays.asList("Brazil", "France", 1));
    data.add(Arrays.asList("Brazil", "Spain", 1));
    data.add(Arrays.asList("Canada", "Portugal", 1));
    data.add(Arrays.asList("Canada", "France", 5));
    data.add(Arrays.asList("Canada", "England", 1));
    chart.setData(data);

    this.addClassName("chart-div");
  }

  public GoogleChart getChart() {
    return chart;
  }
}