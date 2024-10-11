package com.webforj.samples.views.columnslayout;

import com.webforj.component.Composite;
import com.webforj.component.layout.columnslayout.ColumnsLayout;
import com.webforj.component.layout.columnslayout.ColumnsLayout.Breakpoint;
import com.webforj.component.optioninput.RadioButton;
import com.webforj.component.optioninput.RadioButtonGroup;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

import java.util.List;

@Route
@FrameTitle("Columns Layout Form")
public class ColumnsLayoutChangeColumnsView extends Composite<ColumnsLayout> {
   RadioButton agree = new RadioButton("Agree");
    RadioButton neutral = new RadioButton("Neutral");
    RadioButton disagree = new RadioButton("Disagree");

  public ColumnsLayoutChangeColumnsView() {
    RadioButtonGroup group = new RadioButtonGroup(agree, neutral, disagree);

    List<Breakpoint> breaks = List.of(
      new Breakpoint("one", 0, 1),
      new Breakpoint("three", 500, 3));

    ColumnsLayout layout = new ColumnsLayout(breaks, group, agree, neutral, disagree);

    getBoundComponent().add(layout);
    getBoundComponent().setStyle("margin", "20px");

  }
}