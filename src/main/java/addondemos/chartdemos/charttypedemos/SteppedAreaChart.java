package addondemos.chartdemos.charttypedemos;

import com.webforj.component.googlecharts.GoogleChart;
import com.webforj.component.html.elements.Div;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SteppedAreaChart extends Div {
  
  GoogleChart chart = new GoogleChart(GoogleChart.Type.STEPPED_AREA);

  public SteppedAreaChart() {
    Map<String, Object> options = Map.of(
        "title", "Energy Consumption",
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
        )
    );
    chart.setOptions(options);

    List<Object> data = new ArrayList<>();
    data.add(Arrays.asList("Director (Year)", "Rotten Tomatoes", "IMDB"));
    data.add(Arrays.asList("Alfred Hitchcock (1935)", 8.4, 7.9));
    data.add(Arrays.asList("Ridley Scott (1979)", 8.5, 8.4));
    data.add(Arrays.asList("Peter Jackson (2001)", 9.0, 8.8));
    data.add(Arrays.asList("Christopher Nolan (2008)", 9.0, 9.0));
    data.add(Arrays.asList("Martin Scorsese (1980)", 8.7, 8.8));
    chart.setData(data);
    
    this.addClassName("chart-div");
  }

  public GoogleChart getChart() {
    return chart;
  }
}