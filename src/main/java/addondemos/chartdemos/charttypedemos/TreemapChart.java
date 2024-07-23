package addondemos.chartdemos.charttypedemos;

import com.webforj.component.googlecharts.GoogleChart;
import com.webforj.component.html.elements.Div;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TreemapChart extends Div {
  GoogleChart chart = new GoogleChart(GoogleChart.Type.TREEMAP);

  public TreemapChart() {
    Map<String, Object> options = Map.of(
        "title", "Market Segmentation",
        "minColor", "#f00",
        "midColor", "#ddd",
        "maxColor", "#0d0",
        "headerHeight", 15,
        "fontColor", "black",
        "showScale", true
    );
    chart.setOptions(options);

    
    List<Object> data = new ArrayList<>();
    data.add(Arrays.asList("Location", "Parent", 
        "Market trade volume (size)", 
        "Market increase/decrease (color)"));
    data.add(Arrays.asList("Global", null, 0, 0)); // Allow null
    data.add(Arrays.asList("America", "Global", 0, 0));
    data.add(Arrays.asList("Europe", "Global", 0, 0));
    data.add(Arrays.asList("Asia", "Global", 0, 0));
    data.add(Arrays.asList("Australia", "Global", 0, 0));
    data.add(Arrays.asList("Africa", "Global", 0, 0));
    data.add(Arrays.asList("Brazil", "America", 11, 10));
    data.add(Arrays.asList("USA", "America", 52, 31));
    data.add(Arrays.asList("Mexico", "America", 24, 12));
    data.add(Arrays.asList("Canada", "America", 16, -23));
    data.add(Arrays.asList("France", "Europe", 42, -11));
    data.add(Arrays.asList("Germany", "Europe", 31, -2));
    data.add(Arrays.asList("Sweden", "Europe", 22, -13));
    data.add(Arrays.asList("Italy", "Europe", 17, 4));
    data.add(Arrays.asList("UK", "Europe", 21, -5));
    data.add(Arrays.asList("China", "Asia", 36, 4));
    data.add(Arrays.asList("Japan", "Asia", 20, -12));
    data.add(Arrays.asList("India", "Asia", 40, 63));
    data.add(Arrays.asList("Laos", "Asia", 4, 34));
    data.add(Arrays.asList("Australia2", "Australia", 19, 0)); 
    data.add(Arrays.asList("New Zealand", "Australia", 13, -2));
    data.add(Arrays.asList("Egypt", "Africa", 21, 0));
    data.add(Arrays.asList("South Africa", "Africa", 30, -23));
    chart.setData(data);

    this.addClassName("chart-div");
  }

  public GoogleChart getChart() {
    return chart;
  }
}