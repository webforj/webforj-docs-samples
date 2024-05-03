package addondemos.chartdemos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.webforj.App;
import com.webforj.component.googlecharts.GoogleChart;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;
import com.webforj.utilities.Assets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChartDemo extends App {
  
  GoogleChart chart = new GoogleChart(GoogleChart.Type.GEO);

    @Override
  public void run() throws WebforjException {      
      Frame window = new Frame();      
     
      chart.setStyle("width", "100%");
        
      Map<String, Object> options = new Gson().fromJson(Assets.contentOf("options/subscribers-chart.json"), new TypeToken<Map<String, Object>>(){}.getType());
      options.put("legend", "none");
      chart.setOptions(options);
       
      List<Object> data = new ArrayList<>();

      List<String> cols = new ArrayList<>();
      cols.add("Country");
      cols.add("Revenue");
      data.add(cols);

      String[] countries = new String[] { "Germany", "United States", "Brazil", "Canada", "France", "RU", "Australia", "South Africa", "China", "Egypt" };

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


