package com.webforj.samples.views.flexlayout.item;

import java.util.ArrayList;
import java.util.HashMap;

import com.webforj.component.Composite;
import com.webforj.component.code.Code;
import com.webforj.component.event.ModifyEvent;
import com.webforj.component.field.MaskedNumberFieldSpinner;
import com.webforj.component.html.elements.Div;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.list.ChoiceBox;
import com.webforj.component.list.event.ListSelectEvent;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexContentAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.layout.flexlayout.FlexWrap;
import com.webforj.samples.components.Box;

@InlineStyleSheet("context://css/flexlayout/container/flexContainerBuilder.css")
// @Route
// @FrameTitle("Flex Item")
public class FlexItemView extends Composite<Div> {

  MaskedNumberFieldSpinner spinner = new MaskedNumberFieldSpinner();

  FlexLayout boxLayout;
  ArrayList<Box> boxes;
  float numBoxes;

  String javaCode;
  Code codeWindow;
  HashMap<String, String> codeSnippetBuilder;

  public static final String REGEX = "^(.+?)-";

  public FlexItemView() {
    getBoundComponent().addClassName("app__frame");

    FlexLayout mainLayout = FlexLayout.create()
        .horizontal()
        .build();

    boxLayout = FlexLayout.create()
        .horizontal()
        .build()
        .addClassName("button__container");

    FlexLayout flexContainerOptions = FlexLayout.create()
        .vertical()
        .build()
        .addClassName("flex__options");

    spinner.setLabel("Number of Boxes");
    spinner.onModify(this::spinnerChange);
    spinner.setText("5");

    boxes = new ArrayList<>();
    numBoxes = 0;
    for (int i = 1; i <= 5; i++) {
      addBox(i);
    }

    flexContainerOptions.add(spinner);

    mainLayout.add(flexContainerOptions, boxLayout);
    getBoundComponent().add(mainLayout);

    ChoiceBox order = new ChoiceBox();
    order.onSelect(this::selectDirection);
    order.setLabel("Order");
    for (FlexDirection justify : FlexDirection.values()) {
      String label = justify.getValue();
      order.add(
          "." + justify.toString()
              .toLowerCase() + "()",
          label.substring(0, 1)
              .toUpperCase()
              + label
                  .substring(1));
    }
    order.selectIndex(0);

    ChoiceBox alignment = new ChoiceBox();
    alignment.onSelect(this::selectJustification);
    alignment.setLabel("Align Self");
    for (FlexAlignment justify : FlexAlignment.values()) {
      String label = justify.getValue().replaceAll(REGEX, "");
      alignment.add(".justify()." + justify.toString().toLowerCase().replaceAll(REGEX, "") + "()",
          label.substring(0, 1).toUpperCase() + label.substring(1));
    }
    alignment.selectIndex(0);

    ChoiceBox basis = new ChoiceBox();
    basis.onSelect(this::selectAlignment);
    basis.setLabel("Flex Basis");
    for (FlexAlignment justify : FlexAlignment.values()) {
      String label = justify.getValue().replaceAll(REGEX, "");
      basis.add(".align()." + justify.toString().toLowerCase().replaceAll(REGEX, "") + "()",
          label.substring(0, 1).toUpperCase() + label.substring(1));
    }
    basis.selectIndex(0);

    ChoiceBox grow = new ChoiceBox();
    grow.onSelect(this::selectAlignContent);
    grow.setLabel("Flex Grow");
    for (FlexContentAlignment justify : FlexContentAlignment.values()) {
      String label = justify.getValue().replaceAll(REGEX, "");
      grow.add(".contentAlign()." + justify.toString().toLowerCase().replaceAll(REGEX, "") + "()",
          label.substring(0, 1).toUpperCase() + label.substring(1));
    }
    grow.selectIndex(0);

    ChoiceBox shrink = new ChoiceBox();
    shrink.onSelect(this::selectWrap);
    shrink.setLabel("Flex Shrink");
    for (FlexWrap justify : FlexWrap.values()) {
      String label = justify.getValue().replaceAll(REGEX, "");
      shrink.add(".wrap()." + justify.toString().toLowerCase().replaceAll(REGEX, "") + "()",
          label.substring(0, 1).toUpperCase() + label.substring(1));
    }
    shrink.selectIndex(0);

    flexContainerOptions.add(order, alignment, basis, grow, shrink);

    codeWindow = new Code();
    getBoundComponent().add(codeWindow);
    codeWindow.setLanguage("java")
        .addClassName("code__block");

    createStrings();
    updateCode();
  }

  private void createStrings() {
    codeSnippetBuilder = new HashMap<>();
    codeSnippetBuilder.put("FlexDirection", ".horizontal() \n");
    codeSnippetBuilder.put("FlexJustifyContent", "");
    codeSnippetBuilder.put("FlexAlignment", "");
    codeSnippetBuilder.put("FlexContentAlignment", "");
    codeSnippetBuilder.put("FlexWrap", "");
  }

  private void updateCode() {
    javaCode = "FlexLayout boxLayout = FlexLayout.create() \n" +
        codeSnippetBuilder.get("FlexDirection") +
        codeSnippetBuilder.get("FlexJustifyContent") +
        codeSnippetBuilder.get("FlexAlignment") +
        codeSnippetBuilder.get("FlexContentAlignment") +
        codeSnippetBuilder.get("FlexWrap");
    codeWindow.setText(javaCode);
  }

  private void spinnerChange(ModifyEvent ev) {
    if (ev.getText().isEmpty() || Integer.valueOf(ev.getText()) < 1) {
      spinner.setText("1");
    }
    if (Integer.valueOf(ev.getText()) > numBoxes) {
      addBox(Integer.valueOf(ev.getText()));
    } else if (Integer.valueOf(ev.getText()) < numBoxes) {
      removeBox(Integer.valueOf(ev.getText()));
    }
  }

  private void addBox(int newNum) {
    while (newNum > numBoxes) {
      numBoxes++;
      String hue = String.valueOf((360 / 10) * (int) numBoxes);
      Box newBox = new Box((int) numBoxes);
      newBox.setStyle("background", "hsla(" + String.valueOf(hue) + ", 50%, 75%, 0.25)");
      newBox.setStyle("border", "2px solid " + "hsl(" + String.valueOf(hue) + ", 50%, 35%)");
      newBox.setStyle("color", "hsl(" + String.valueOf(hue) + ", 50%, 25%)");
      boxes.add(newBox);
      boxLayout.add(newBox);
    }
  }

  private void removeBox(int newNum) {
    while (newNum < numBoxes) {
      boxes.get((int) numBoxes - 1).boxDestroy();
      boxes.remove((int) numBoxes - 1);
      numBoxes--;
    }
  }

  private void selectDirection(ListSelectEvent ev) {
    boxLayout.setDirection(FlexDirection.fromValue(ev.getSelectedItem().getText()));
    switch (ev.getSelectedItem().getKey().toString()) {
      case ".row-reverse()":
        codeSnippetBuilder.put("FlexDirection", ".horizontalReverse()\n");
        break;
      case ".column()":
        codeSnippetBuilder.put("FlexDirection", ".vertical()\n");
        break;
      case ".column-reverse()":
        codeSnippetBuilder.put("FlexDirection", ".verticalReverse()\n");
        break;
      default:
        codeSnippetBuilder.put("FlexDirection", ".horizontal()\n");
        break;
    }
    updateCode();
  }

  private void selectJustification(ListSelectEvent ev) {
    boxLayout.setJustifyContent(FlexJustifyContent.fromValue(ev.getSelectedItem().getText()));
    if (ev.getSelectedItem().getKey().toString().equals(".justify().start()")) {
      codeSnippetBuilder.put("FlexJustifyContent", "");
    } else {
      codeSnippetBuilder.put("FlexJustifyContent", ev.getSelectedItem().getKey().toString() + "\n");
    }
    updateCode();
  }

  private void selectAlignment(ListSelectEvent ev) {
    boxLayout.setAlignment(FlexAlignment.fromValue(ev.getSelectedItem().getText()));
    if (ev.getSelectedItem().getKey().toString().equals(".align().stretch()")) {
      codeSnippetBuilder.put("FlexAlignment", "");
    } else {
      codeSnippetBuilder.put("FlexAlignment", ev.getSelectedItem().getKey().toString() + "\n");
    }
    updateCode();
  }

  private void selectAlignContent(ListSelectEvent ev) {
    boxLayout.setAlignContent(FlexContentAlignment.fromValue(ev.getSelectedItem().getText()));
    if (ev.getSelectedItem().getKey().toString().equals(".contentAlign().normal()")) {
      codeSnippetBuilder.put("FlexContentAlignment", "");
    } else {
      codeSnippetBuilder.put("FlexContentAlignment", ev.getSelectedItem().getKey().toString() + "\n");
    }
    updateCode();
  }

  private void selectWrap(ListSelectEvent ev) {
    if (ev.getSelectedItem().getKey().toString().equals(".wrap().nowrap()")) {
      boxLayout.setWrap(FlexWrap.fromValue(ev.getSelectedItem().getText()));
      codeSnippetBuilder.put("FlexWrap", "");
    } else if (ev.getSelectedItem().getKey().toString().equals(".wrap().reverse()")) {
      boxLayout.setWrap(FlexWrap.WRAP_REVERSE);
      codeSnippetBuilder.put("FlexWrap", ev.getSelectedItem().getKey().toString() + "\n");
    } else {
      boxLayout.setWrap(FlexWrap.fromValue(ev.getSelectedItem().getText()));
      codeSnippetBuilder.put("FlexWrap", ev.getSelectedItem().getKey().toString() + "\n");
    }
    updateCode();
  }
}
