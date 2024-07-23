package addondemos.chartdemos.charttypedemos;

import com.webforj.component.googlecharts.GoogleChart;
import com.webforj.component.html.elements.Div;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CalendarChart extends Div {

  GoogleChart chart = new GoogleChart(GoogleChart.Type.CALENDAR);

  public CalendarChart() {
    Map<String, Object> options = Map.of(
        "title", "Attendance Calendar",
        "calendar", Map.of(
            "cellColor", Map.of(
                "stroke", "#fff",
                "strokeOpacity", 0.5,
                "strokeWidth", 1,
                "fill", "#76a7fa"
            ),
            "focusedCellColor", Map.of(
                "stroke", "#fff",
                "strokeOpacity", 0.5,
                "strokeWidth", 1,
                "fill", "#4285f4"
            )
        )
    );
    chart.setOptions(options);

    List<Object> data = new ArrayList<>();
    data.add(Arrays.asList(
        Map.of("type", "date", "label", "Date"),
        Map.of("type", "number", "label", "Attendance")
    ));
    data.add(Arrays.asList("Date(2022, 0, 1)", 300));
    data.add(Arrays.asList("Date(2022, 0, 4)", 600));
    data.add(Arrays.asList("Date(2022, 0, 5)", 200));
    data.add(Arrays.asList("Date(2022, 0, 7)", 300));
    data.add(Arrays.asList("Date(2022, 0, 8)", 400));
    data.add(Arrays.asList("Date(2022, 0, 11)", 200));
    data.add(Arrays.asList("Date(2022, 0, 14)", 400));
    data.add(Arrays.asList("Date(2022, 0, 18)", 300));
    data.add(Arrays.asList("Date(2022, 0, 19)", 400));
    data.add(Arrays.asList("Date(2022, 0, 21)", 600));
    data.add(Arrays.asList("Date(2022, 0, 22)", 200));
    data.add(Arrays.asList("Date(2022, 0, 26)", 600));
    data.add(Arrays.asList("Date(2022, 0, 29)", 300));
    data.add(Arrays.asList("Date(2022, 0, 31)", 500));
    chart.setData(data);

    this.addClassName("chart-div");
  }

  public GoogleChart getChart() {
    return chart;
  }
}
