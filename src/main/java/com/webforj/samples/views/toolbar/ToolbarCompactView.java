package com.webforj.samples.views.toolbar;

import com.webforj.Interval;
import com.webforj.dispatcher.EventListener;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import com.webforj.component.html.elements.H1;
import com.webforj.component.html.elements.Img;
import com.webforj.component.Composite;
import com.webforj.component.Theme;
import com.webforj.component.Expanse;
import com.webforj.component.button.Button;
import com.webforj.component.progressbar.ProgressBar;
import com.webforj.component.toast.Toast;
import com.webforj.component.layout.applayout.AppDrawerToggle;
import com.webforj.component.layout.applayout.AppLayout;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.layout.toolbar.Toolbar;

@Route
@FrameTitle("Toolbar Compact")
public class ToolbarCompactView extends Composite<AppLayout> {

  AppLayout appLayout = getBoundComponent();
  Button analyzeButton = new Button("Analyze data");
  ProgressBar bar = new ProgressBar();
  Toast toast = new Toast("No data to analyze!", Theme.WARNING);
  Toolbar mainToolbar = new Toolbar();
  Toolbar progressToolbar = new Toolbar();
  int delayStart = -2;

  public ToolbarCompactView() {

    mainToolbar.addToStart(new AppDrawerToggle());
    mainToolbar.addToTitle(new H1("webforJ App"));

    bar.setHeight("clamp(3px, calc(-0.01 * 100vw + 15px), 12px)");

    progressToolbar.addToContent(bar);
    progressToolbar.setCompact(true);

    Interval interval = new Interval(0.1f, new EventListener<Interval.ElapsedEvent>() {
      @Override
      public void onEvent(Interval.ElapsedEvent event) {

        Integer progress = bar.getValue() + ++delayStart;
        bar.setValue(progress);

        if (progress >= bar.getMax()) {
          event.getInterval().stop();
          bar.setAnimated(false);
          analyzeButton.setEnabled(true);
          toast.open();
        }
      }
    });

    analyzeButton.setDisableOnClick(true);
    analyzeButton.setExpanse(Expanse.XLARGE);

    analyzeButton.onClick(e -> {
      bar.setValue(0);
      delayStart = -2;
      interval.restart();
    });

    FlexLayout flexLayout = FlexLayout.create(analyzeButton)
        .justify().center()
        .build();

    appLayout.setDrawerHeaderVisible(true)
        .addToDrawerTitle(new Img("https://documentation.webforj.com/img/webforj_icon.svg"))
        .addToHeader(mainToolbar, progressToolbar)
        .addToContent(flexLayout)
        .setDrawerOpened(false);

  }
}