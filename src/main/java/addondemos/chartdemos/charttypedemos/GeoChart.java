package addondemos.chartdemos.charttypedemos;

import com.webforj.component.googlecharts.GoogleChart;
import com.webforj.component.html.elements.Div;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GeoChart extends Div {

  private final GoogleChart chart = new GoogleChart(GoogleChart.Type.GEO);

  public GeoChart() {
    Map<String, Object> options = Map.of(
        "title", "Geo Chart",
        "colorAxis", Map.of("colors", List.of("#4285f4", "#ab48bc"))
    );
    chart.setOptions(options);

    List<Object> data = new ArrayList<>();
    data.add(Arrays.asList("Country", "Popularity"));
    data.add(Arrays.asList("Germany", 200));
    data.add(Arrays.asList("United States", 300));
    data.add(Arrays.asList("Brazil", 400));
    data.add(Arrays.asList("Canada", 500));
    data.add(Arrays.asList("France", 600));
    chart.setData(data);

    this.addClassName("chart-div");
  }

  public GoogleChart getChart() {
    return chart;
  }
}