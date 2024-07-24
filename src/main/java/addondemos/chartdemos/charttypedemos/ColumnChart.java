package addondemos.chartdemos.charttypedemos;

import com.webforj.component.googlecharts.GoogleChart;
import com.webforj.component.html.elements.Div;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ColumnChart extends Div {

  GoogleChart chart = new GoogleChart(GoogleChart.Type.COLUMN);

  public ColumnChart() {
    Map<String, Object> options = Map.of(
        "title", "Annual Sales",
        "hAxis", Map.of(
            "title", "Year",
            "minValue", 0,
            "textStyle", Map.of(
                "bold", true,
                "fontSize", 12
            )
        ),
        "vAxis", Map.of(
            "title", "Sales (in USD)",
            "minValue", 0,
            "textStyle", Map.of(
                "bold", true,
                "fontSize", 12
            )
        ),
        "colors", List.of("#008000", "#4285f4")
    );
    chart.setOptions(options);

    List<Object> data = new ArrayList<>();
    data.add(Arrays.asList("Year", "Sales", "Expenses"));
    data.add(Arrays.asList("2014", 1000, 400));
    data.add(Arrays.asList("2015", 1170, 460));
    data.add(Arrays.asList("2016", 660, 1120));
    data.add(Arrays.asList("2017", 1030, 540));
    chart.setData(data);

    this.addClassName("chart-div");
    add(chart);
  }

  public GoogleChart getChart() {
    return chart;
  }
}
