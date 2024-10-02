package com.webforj.samples.views.googlecharts.types;

import com.webforj.component.googlecharts.GoogleChart;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class ScatterChart {

  private static final String TITLE = "title";

  private final GoogleChart chart = new GoogleChart(GoogleChart.Type.SCATTER);

  public ScatterChart() {
    Map<String, Object> options = new HashMap<>();
    options.put(TITLE, "Scatter Chart");
    options.put("hAxis", Map.of(TITLE, "Age"));
    options.put("vAxis", Map.of(TITLE, "Weight"));
    options.put("colors", List.of("#FFA500"));
    options.put("backgroundColor", "transparent");
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
  }

  public GoogleChart getChart() {
    return chart;
  }
}
