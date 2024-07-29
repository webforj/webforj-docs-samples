package addondemos.chartdemos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.googlecharts.GoogleChart;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;
import com.webforj.utilities.Assets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@InlineStyleSheet("context://css/chartstyles/chartdemo_styles.css")
public class ChartDemo extends App {

  GoogleChart chart = new GoogleChart(GoogleChart.Type.GEO);

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("chart-frame");

    Map<String, Object> options = new Gson().fromJson(
        Assets.contentOf("options/subscribers-chart.json"),
        new TypeToken<Map<String, Object>>() {}.getType()
    );
    options.put("title", "Revenue by Country");
    options.put("colors", List.of("#1b9e77", "#d95f02", "#7570b3"));
    options.put("backgroundColor", "#f9f9f9");
    options.put("chartArea", Map.of("width", "80%", "height", "70%"));
    options.put("hAxis", Map.of("textStyle", Map.of("color", "#333")));
    options.put("vAxis", Map.of("minValue", 0, "textStyle", Map.of("color", "#333")));
    options.put("legend", Map.of("position", "bottom"));
    chart.setOptions(options);

    List<Object> data = new ArrayList<>();
    List<String> cols = new ArrayList<>();
    cols.add("Country");
    cols.add("Revenue");
    data.add(cols);

    String[] countries = new String[] { 
      "Germany", "United States", "Brazil", "Canada", 
      "France", "RU", "Australia", "South Africa", 
      "China", "Egypt" 
    };

    for (String country : countries) {
      List<Object> row = new ArrayList<>();
      row.add(country);
      row.add(Math.random() * 10000);
      data.add(row);
    }

    chart.setData(data);
    window.add(chart);
  }
}


