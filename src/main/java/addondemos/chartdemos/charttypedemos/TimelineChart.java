package addondemos.chartdemos.charttypedemos;

import com.webforj.component.googlecharts.GoogleChart;
import com.webforj.component.html.elements.Div;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TimelineChart extends Div {

  GoogleChart chart = new GoogleChart(GoogleChart.Type.TIMELINE);

  public TimelineChart() {
    Map<String, Object> options = Map.of(
        "title", "Presidential Terms",
        "timeline", Map.of(
            "showRowLabels", false
        )
    );
    chart.setOptions(options);

    List<Object> data = new ArrayList<>();
    data.add(Arrays.asList("Term", "President", 
        Map.of("type", "date", "label", "Start"), 
        Map.of("type", "date", "label", "End")
    ));
    data.add(Arrays.asList("1", "George Washington", "Date(1789, 3, 30)", "Date(1797, 2, 4)"));
    data.add(Arrays.asList("2", "John Adams", "Date(1797, 2, 4)", "Date(1801, 2, 4)"));
    data.add(Arrays.asList("3", "Thomas Jefferson", "Date(1801, 2, 4)", "Date(1809, 2, 4)"));
    data.add(Arrays.asList("4", "James Madison", "Date(1809, 2, 4)", "Date(1817, 2, 4)"));
    data.add(Arrays.asList("5", "James Monroe", "Date(1817, 2, 4)", "Date(1825, 2, 4)"));
    chart.setData(data);

    this.addClassName("chart-div");
  }

  public GoogleChart getChart() {
    return chart;
  }
}