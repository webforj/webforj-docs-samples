package addondemos.chartdemos.charttypedemos;

import com.webforj.component.googlecharts.GoogleChart;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OrgChart {

  GoogleChart chart = new GoogleChart(GoogleChart.Type.ORG);

  public OrgChart() {
    Map<String, Object> options = Map.of(
        "title", "Company Organization Structure",
        "allowHtml", true,
        "size", "medium",
        "color", Map.of(
            "fill", "#b7e1cd",
            "selected", "#c2c2f0"
        )
    );
    chart.setOptions(options);

    List<Object> data = new ArrayList<>();
    data.add(Arrays.asList("Name", "Manager", "Tooltip"));
    data.add(Arrays.asList("President", "", "The President"));
    data.add(Arrays.asList("VP of Sales", "President", "VP of Sales"));
    data.add(Arrays.asList("VP of Marketing", "President", "VP of Marketing"));
    data.add(Arrays.asList("Sales Manager 1", "VP of Sales", "Sales Manager 1"));
    data.add(Arrays.asList("Sales Manager 2", "VP of Sales", "Sales Manager 2"));
    data.add(Arrays.asList("Marketing Manager 1", "VP of Marketing", "Marketing Manager 1"));
    data.add(Arrays.asList("Marketing Manager 2", "VP of Marketing", "Marketing Manager 2"));
    chart.setData(data);
  }

  public GoogleChart getChart() {
    return chart;
  }
}