package com.webforj.samples.views.googlecharts.types;

import com.webforj.component.googlecharts.GoogleChart;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BubbleChart {

  private static final String TITLE = "title";
  private static final String TEXT_STYLE = "textStyle";
  private static final String FONT_SIZE = "fontSize";

  private final GoogleChart chart = new GoogleChart(GoogleChart.Type.BUBBLE);

  public BubbleChart() {

    Map<String, Object> options = new HashMap<>();
    options.put(TITLE, "Investment vs. Profit");
    options.put("hAxis", Map.of(
        TITLE, "Potential Investment",
        TEXT_STYLE, Map.of(
            "bold", true,
            FONT_SIZE, 12,
            "color", "#4d4d4d"
        )
    ));
    options.put("vAxis", Map.of(
        TITLE, "Potential Profit",
        TEXT_STYLE, Map.of(
            "bold", true,
            FONT_SIZE, 12,
            "color", "#4d4d4d"
        )
    ));
    options.put("bubble", Map.of(TEXT_STYLE, Map.of(FONT_SIZE, 11)));
    options.put("colorAxis", Map.of("colors", Arrays.asList("#d4c5f9", "#495057")));
    options.put("backgroundColor", "transparent");
    chart.setOptions(options);

    List<Object> data = new ArrayList<>();
    data.add(Arrays.asList("ID", "X", "Y", "Temperature"));
    data.add(Arrays.asList("1", 80, 167, 120));
    data.add(Arrays.asList("2", 79, 136, 130));
    data.add(Arrays.asList("3", 78, 184, 50));
    data.add(Arrays.asList("4", 72, 278, 230));
    chart.setData(data);
  }

  public GoogleChart getChart() {
    return chart;
  }
}


