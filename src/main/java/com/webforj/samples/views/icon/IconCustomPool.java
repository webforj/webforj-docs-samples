package com.webforj.samples.views.icon;

import com.webforj.component.icons.Icon;
import com.webforj.component.icons.IconPoolBuilder;

import com.webforj.App;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;
import com.webforj.component.tabbedpane.TabbedPane;
import com.webforj.component.tabbedpane.Tab;
import com.webforj.component.Expanse;
import com.webforj.component.tabbedpane.TabbedPane.Alignment;

public class IconCustomPool extends App {
  @Override
  public void run() throws WebforjException {
    Frame main = new Frame();

    IconPoolBuilder.fromDirectory("custom-pool", "context://icons");

    Icon webforj = new Icon("webforj", "custom-pool");
    Icon em = new Icon("em", "custom-pool");
    Icon world = new Icon("world-b", "custom-pool");
    Icon plug = new Icon("plug", "custom-pool");
    Icon rocket = new Icon("rocket", "custom-pool");

    TabbedPane pane = new TabbedPane();

    Tab home = new Tab("Home", webforj);
    Tab server = new Tab("Server Settings", em);
    Tab apps = new Tab("Apps", world);
    Tab plugins = new Tab("Plugins", plug);
    Tab launch = new Tab("Launch", rocket);

    pane.addTab(home);
    pane.addTab(server);
    pane.addTab(apps);
    pane.addTab(plugins);
    pane.addTab(launch);

    pane.setStyle("margin", "20px");
    pane.setExpanse(Expanse.XLARGE);
    pane.setAlignment(TabbedPane.Alignment.CENTER);

    main.add(pane);
  }
}