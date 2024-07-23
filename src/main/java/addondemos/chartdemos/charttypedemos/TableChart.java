package addondemos.chartdemos.charttypedemos;

import com.webforj.component.googlecharts.GoogleChart;
import com.webforj.component.html.elements.Div;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TableChart extends Div {
  
  GoogleChart chart = new GoogleChart(GoogleChart.Type.TABLE);

  public TableChart() {
    Map<String, Object> options = Map.of(
        "title", "Sales Data",
        "showRowNumber", true,
        "width", "100%",
        "height", "400px",
        "cssClassNames", Map.of(
            "headerRow", "table-header-row",
            "tableRow", "table-row",
            "oddTableRow", "table-odd-row",
            "selectedTableRow", "table-selected-row",
            "hoverTableRow", "table-hover-row",
            "headerCell", "table-header-cell",
            "tableCell", "table-cell",
            "rowNumberCell", "table-row-number"
        )
    );
    chart.setOptions(options);

    List<Object> data = new ArrayList<>();
    data.add(Arrays.asList("Name", "Salary", "Full Time", "Start Date"));
    data.add(Arrays.asList("John Smith", 30000, true, "2019-01-10"));
    data.add(Arrays.asList("Jane Doe", 50000, true, "2020-05-29"));
    data.add(Arrays.asList("Emily Johnson", 45000, false, "2018-06-15"));
    data.add(Arrays.asList("Michael Brown", 55000, true, "2021-03-30"));
    chart.setData(data);

    this.addClassName("chart-div");
  }

  public GoogleChart getChart() {
    return chart;
  }
}