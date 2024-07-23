package addondemos.chartdemos.charttypedemos;

import com.webforj.component.googlecharts.GoogleChart;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LineChart {

  GoogleChart chart = new GoogleChart(GoogleChart.Type.LINE);

  public LineChart() {
    Map<String, Object> options = Map.of(
        "title", "Annual Growth",
        "hAxis", Map.of(
            "title", "Year",
            "textStyle", Map.of(
                "bold", true,
                "fontSize", 12,
                "color", "#4d4d4d"
            )
        )
    );
    chart.setOptions(options);

    List<Object> data = new ArrayList<>();
    data.add(Arrays.asList("Year", "Sales", "Expenses"));
    data.add(Arrays.asList("2004", 1000, 400));
    data.add(Arrays.asList("2005", 1170, 460));
    data.add(Arrays.asList("2006", 660, 1120));
    data.add(Arrays.asList("2007", 1030, 540));
    chart.setData(data);
  }

  public GoogleChart getChart() {
    return chart;
  }
}