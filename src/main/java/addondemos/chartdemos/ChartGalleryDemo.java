package addondemos.chartdemos;

import addondemos.chartdemos.charttypedemos.*;
import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.googlecharts.GoogleChart;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;
import java.util.Arrays;
import java.util.List;

@InlineStyleSheet("context://css/chartstyles/chartgallery_styles.css")
public class ChartGalleryDemo extends App {

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("chart-gallery");

    for (String chartKey : getChartKeys()) {
      GoogleChart chart = createChart(chartKey);

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

  private List<String> getChartKeys() {
    return Arrays.asList("pie", "column", "bar", "line", "geo", "scatter", "histogram", "combo", 
                         "area", "stepped_area", "bubble", "org", "treemap", "table", "gauge", 
                         "candlestick", "sankey", "wordtree", "timeline", "calendar", "gantt");
  }

  private GoogleChart createChart(String chartKey) {
    switch (chartKey.toLowerCase()) {
      case "pie":
        return new PieChart().getChart();
      case "column":
        return new ColumnChart().getChart();
      case "bar":
        return new BarChart().getChart();
      case "line":
        return new LineChart().getChart();
      case "geo":
        return new GeoChart().getChart();
      case "scatter":
        return new ScatterChart().getChart();
      case "histogram":
        return new HistogramChart().getChart();
      case "combo":
        return new ComboChart().getChart();
      case "area":
        return new AreaChart().getChart();
      case "stepped_area":
        return new SteppedAreaChart().getChart();
      case "bubble":
        return new BubbleChart().getChart();
      case "org":
        return new OrgChart().getChart();
      case "treemap":
        return new TreemapChart().getChart();
      case "table":
        return new TableChart().getChart();
      case "gauge":
        return new GaugeChart().getChart();
      case "candlestick":
        return new CandlestickChart().getChart();
      case "sankey":
        return new SankeyChart().getChart();
      case "wordtree":
        return new WordtreeChart().getChart();
      case "timeline":
        return new TimelineChart().getChart();
      case "calendar":
        return new CalendarChart().getChart();
      case "gantt":
        return new GanttChart().getChart();
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
