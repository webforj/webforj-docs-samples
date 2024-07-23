package addondemos.chartdemos.charttypedemos;

import com.webforj.component.googlecharts.GoogleChart;
import com.webforj.component.html.elements.Div;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class WordtreeChart extends Div {
  GoogleChart chart = new GoogleChart(GoogleChart.Type.WORDTREE);

  public WordtreeChart() {
    chart = new GoogleChart(GoogleChart.Type.WORDTREE);

    Map<String, Object> options = Map.of(
        "title", "Word Usage Tree",
        "wordtree", Map.of(
            "format", "implicit",
            "word", "open"
        )
    );
    chart.setOptions(options);

    List<Object> data = new ArrayList<>();
    data.add(Arrays.asList("Phrases"));
    data.add(Arrays.asList("cats are better than dogs"));
    data.add(Arrays.asList("cats eat kibble"));
    data.add(Arrays.asList("cats are better than hamsters"));
    data.add(Arrays.asList("cats are awesome"));
    data.add(Arrays.asList("cats are people too"));
    data.add(Arrays.asList("cats eat mice"));
    data.add(Arrays.asList("cats meowing"));
    data.add(Arrays.asList("cats in the cradle"));
    data.add(Arrays.asList("cats eat mice"));
    data.add(Arrays.asList("cats in the cradle lyrics"));
    data.add(Arrays.asList("cats eat kibble"));
    data.add(Arrays.asList("cats for adoption"));
    data.add(Arrays.asList("cats are family"));
    data.add(Arrays.asList("cats eat mice"));
    data.add(Arrays.asList("cats are better than kittens"));
    data.add(Arrays.asList("cats are evil"));
    data.add(Arrays.asList("cats are weird"));
    data.add(Arrays.asList("cats eat mice"));
    chart.setData(data);

    this.addClassName("chart-div");
  }

  public GoogleChart getChart() {
    return chart;
  }
}