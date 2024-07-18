package addondemos.chartdemos;

import addondemos.chartdemos.ChartTypeDemos.AreaChart;
import addondemos.chartdemos.ChartTypeDemos.BarChart;
import addondemos.chartdemos.ChartTypeDemos.BubbleChart;
import addondemos.chartdemos.ChartTypeDemos.CalendarChart;
import addondemos.chartdemos.ChartTypeDemos.CandlestickChart;
import addondemos.chartdemos.ChartTypeDemos.ColumnChart;
import addondemos.chartdemos.ChartTypeDemos.ComboChart;
import addondemos.chartdemos.ChartTypeDemos.GanttChart;
import addondemos.chartdemos.ChartTypeDemos.GaugeChart;
import addondemos.chartdemos.ChartTypeDemos.GeoChart;
import addondemos.chartdemos.ChartTypeDemos.HistogramChart;
import addondemos.chartdemos.ChartTypeDemos.LineChart;
import addondemos.chartdemos.ChartTypeDemos.OrgChart;
import addondemos.chartdemos.ChartTypeDemos.PieChart;
import addondemos.chartdemos.ChartTypeDemos.SankeyChart;
import addondemos.chartdemos.ChartTypeDemos.ScatterChart;
import addondemos.chartdemos.ChartTypeDemos.SteppedAreaChart;
import addondemos.chartdemos.ChartTypeDemos.TableChart;
import addondemos.chartdemos.ChartTypeDemos.TimelineChart;
import addondemos.chartdemos.ChartTypeDemos.TreemapChart;
import addondemos.chartdemos.ChartTypeDemos.WordtreeChart;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.googlecharts.GoogleChart;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;
import com.webforj.utilities.Assets;
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
    Map<String, Map<String, Object>> chartData = gson.fromJson(dataJson, 
      new TypeToken<Map<String, Map<String, Object>>>(){}.getType());
    Map<String, Map<String, Object>> chartOptions = gson.fromJson(optionsJson, 
      new TypeToken<Map<String, Map<String, Object>>>(){}.getType());

    for (Map.Entry<String, Map<String, Object>> entry : chartData.entrySet()) {
      String chartKey = entry.getKey();
      GoogleChart chart = createChart(chartKey, entry.getValue(), chartOptions.get(chartKey));

      if (chart != null) {
        Div chartDiv = new Div();
        chartDiv.addClassName("chart-div");

        Paragraph chartName = new Paragraph();
        String formattedTitle = formatTitle(chartKey);
        chartName.setText(formattedTitle);
        chartName.addClassName("chartname");
        chartDiv.add(chartName);

        chartDiv.add(chart);
        window.add(chartDiv);
      }
    }
  }

  private GoogleChart createChart(String chartKey, Map<String, Object> data, Map<String, Object> options) {
    if (data == null || options == null) {
      return null;
    }

    switch (chartKey.toLowerCase()) {
      case "pie":
        return new PieChart(data, options).getChart();
      case "column":
        return new ColumnChart(data, options).getChart();
      case "bar":
        return new BarChart(data, options).getChart();
      case "line":
        return new LineChart(data, options).getChart();
      case "geo":
        return new GeoChart(data, options).getChart();
      case "scatter":
        return new ScatterChart(data, options).getChart();
      case "histogram":
        return new HistogramChart(data, options).getChart();
      case "combo":
        return new ComboChart(data, options).getChart();
      case "area":
        return new AreaChart(data, options).getChart();
      case "stepped_area":
        return new SteppedAreaChart(data, options).getChart();
      case "bubble":
        return new BubbleChart(data, options).getChart();
      case "org":
        return new OrgChart(data, options).getChart();
      case "treemap":
        return new TreemapChart(data, options).getChart();
      case "table":
        return new TableChart(data, options).getChart();
      case "gauge":
        return new GaugeChart(data, options).getChart();
      case "candlestick":
        return new CandlestickChart(data, options).getChart();
      case "sankey":
        return new SankeyChart(data, options).getChart();
      case "wordtree":
        return new WordtreeChart(data, options).getChart();
      case "timeline":
        return new TimelineChart(data, options).getChart();
      case "calendar":
        return new CalendarChart(data, options).getChart();
      case "gantt":
        return new GanttChart(data, options).getChart();
      default:
        return null;
    }
  }

  private String formatTitle(String title) {
    if (title == null || title.isEmpty()) {
      return title;
    }
    String[] words = title.replace("_", " ").split("\\s+");
    StringBuilder formattedTitle = new StringBuilder();

    for (String word : words) {
      if (word.length() > 0) {
        formattedTitle.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1).toLowerCase())
                      .append(" ");
      }
    }
    return formattedTitle.toString().trim() + " Chart";
  }
}
