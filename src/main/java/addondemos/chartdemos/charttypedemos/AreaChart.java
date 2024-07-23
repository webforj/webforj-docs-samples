package addondemos.chartdemos.charttypedemos;

import com.webforj.component.googlecharts.GoogleChart;
import com.webforj.component.html.elements.Div;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AreaChart extends Div {

  GoogleChart chart = new GoogleChart(GoogleChart.Type.AREA);

  public AreaChart() {
    Map<String, Object> options = Map.of(
        "title", "Market Trends",
        "colors", List.of("#34a853", "#4285f4", "#fbbc05", "#ea4335"),
        "hAxis", Map.of(
            "title", "Year",
            "textStyle", Map.of(
                "bold", true,
                "fontSize", 12,
                "color", "#4d4d4d"
            )
        ),
        "vAxis", Map.of(
            "title", "Value",
            "textStyle", Map.of(
                "bold", true,
                "fontSize", 12,
                "color", "#4d4d4d"
            )
        ),
        "isStacked", true
    );
    chart.setOptions(options);

    List<Object> data = new ArrayList<>();
    data.add(Arrays.asList("Year", "Sales", "Expenses"));
    data.add(Arrays.asList("2013", 1000, 400));
    data.add(Arrays.asList("2014", 1170, 460));
    data.add(Arrays.asList("2015", 660, 600)); 
    data.add(Arrays.asList("2016", 1030, 540));
    chart.setData(data);

    this.addClassName("chart-div");
  }

  public GoogleChart getChart() {
    return chart;
  }
}
