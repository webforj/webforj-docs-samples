package addondemos.chartdemos.charttypedemos;

import com.webforj.component.googlecharts.GoogleChart;
import com.webforj.component.html.elements.Div;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GanttChart extends Div {
  
  GoogleChart chart = new GoogleChart(GoogleChart.Type.GANTT);

  public GanttChart() {
    Map<String, Object> options = Map.of(
        "title", "Project Schedule",
        "gantt", Map.of(
            "labelStyle", Map.of(
                "fontName", "Arial",
                "fontSize", 14,
                "color", "#757575"
            ),
            "criticalPathEnabled", true
        )
    );
    chart.setOptions(options);

    List<Object> data = new ArrayList<>();
    data.add(Arrays.asList("Task ID", "Task Name", 
        Map.of("type", "date", "label", "Start Date"), 
        Map.of("type", "date", "label", "End Date"), 
        Map.of("type", "number", "label", "Duration"), 
        Map.of("type", "number", "label", "Percent Complete"), 
        Map.of("type", "string", "label", "Dependencies")
    ));
    data.add(Arrays.asList(
        "Research", "Find Topics", "Date(2022, 0, 1)", "Date(2022, 0, 3)", null, 100, null
    ));
    data.add(Arrays.asList(
        "Write", "Draft Outline", "Date(2022, 0, 4)", "Date(2022, 0, 6)", null, 25, "Research"
    ));
    data.add(Arrays.asList(
        "Review", "Revise Draft", "Date(2022, 0, 7)", "Date(2022, 0, 9)", null, 0, "Write"
    ));
    data.add(Arrays.asList(
        "Finalize", "Complete Article", "Date(2022, 0, 10)", "Date(2022, 0, 12)", null, 0, "Review"
    ));
    chart.setData(data);
    
    this.addClassName("chart-div");
  }

  public GoogleChart getChart() {
    return chart;
  }
}