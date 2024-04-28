package addondemos.chartdemos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.googlecharts.GoogleChart;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;
import com.webforj.utilities.Assets;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@InlineStyleSheet("context://css/chartstyles/chartgallery_styles.css")
public class ChartGalleryDemo extends App {

  @Override
  public void run() throws WebforjException {
      Frame window = new Frame();
      window.addClassName("chart-gallery");

      String dataJson = Assets.contentOf("data/chartgallery.json");
      String optionsJson = Assets.contentOf("options/chartgalleryoptions.json");

      Gson gson = new Gson();
      Map<String, Map<String, Object>> chartData = gson.fromJson(dataJson, new TypeToken<Map<String, Map<String, Object>>>(){}.getType());
      Map<String, Map<String, Object>> chartOptions = gson.fromJson(optionsJson, new TypeToken<Map<String, Map<String, Object>>>(){}.getType());

      for (Map.Entry<String, Map<String, Object>> entry : chartData.entrySet()) {
        String chartKey = entry.getKey();
        GoogleChart chart = new GoogleChart(GoogleChart.Type.valueOf(chartKey.toUpperCase()));
        Map<String, Object> data = entry.getValue();
        Map<String, Object> options = chartOptions.get(chartKey);
        if (data != null && options != null) {
            chart.setOptions(options);
            chart.setData((List<Object>) data.get("data"));
            window.add(chart);
        }
    }
      
   }
 
}