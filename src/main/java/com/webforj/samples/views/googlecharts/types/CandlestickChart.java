package com.webforj.samples.views.googlecharts.types;

import com.webforj.component.googlecharts.GoogleChart;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CandlestickChart {

  private static final String TYPE_NUMBER = "number";
  private static final String LABEL = "label";

  private final GoogleChart   chart = new GoogleChart(GoogleChart.Type.CANDLESTICK);

  public CandlestickChart() {

    Map<String, Object> options = new HashMap<>();
    options.put("title", "Stock Market Trends");
    options.put("legend", "none");
    options.put("bar", Map.of("groupWidth", "20%"));
    options.put("candlestick", Map.of(
        "fallingColor", Map.of("fill", "#a52714"),
        "risingColor", Map.of("fill", "#0f9d58")
    ));
    options.put("backgroundColor", "transparent");
    chart.setOptions(options);

    List<Object> data = new ArrayList<>();
    data.add(Arrays.asList(
        Map.of("type", "string", LABEL, "Day"),
        Map.of("type", TYPE_NUMBER, LABEL, "Low"),
        Map.of("type", TYPE_NUMBER, LABEL, "Opening"),
        Map.of("type", TYPE_NUMBER, LABEL, "Closing"),
        Map.of("type", TYPE_NUMBER, LABEL, "High")
    ));
    data.add(Arrays.asList("Mon", 20, 28, 38, 45));
    data.add(Arrays.asList("Tue", 31, 38, 55, 66));
    data.add(Arrays.asList("Wed", 50, 55, 60, 70));
    data.add(Arrays.asList("Thu", 35, 40, 50, 55));
    data.add(Arrays.asList("Fri", 20, 22, 30, 50));
    chart.setData(data);
  }

  public GoogleChart getChart() {
    return chart;
  }
}


