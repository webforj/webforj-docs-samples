package com.webforj.samples.views.googlecharts.types;

import com.webforj.component.googlecharts.GoogleChart;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TableChart {

  private final GoogleChart chart = new GoogleChart(GoogleChart.Type.TABLE);

  public TableChart() {
    Map<String, Object> options = new HashMap<>();
    options.put("title", "Sales Data");
    options.put("showRowNumber", true);
    options.put("width", "100%");
    options.put("height", "400px");
    options.put("backgroundColor", "transparent");
    chart.setOptions(options);

    List<Object> data = new ArrayList<>();
    data.add(Arrays.asList("Name", "Salary", "Full Time", "Start Date"));
    data.add(Arrays.asList("John Smith", 30000, true, "2019-01-10"));
    data.add(Arrays.asList("Jane Doe", 50000, true, "2020-05-29"));
    data.add(Arrays.asList("Emily Johnson", 45000, false, "2018-06-15"));
    data.add(Arrays.asList("Michael Brown", 55000, true, "2021-03-30"));
    chart.setData(data);
  }

  public GoogleChart getChart() {
    return chart;
  }
}
