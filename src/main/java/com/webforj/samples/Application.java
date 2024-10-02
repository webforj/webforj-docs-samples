package com.webforj.samples;

import com.webforj.App;
import com.webforj.annotation.AppTitle;
import com.webforj.annotation.Routify;
import com.webforj.exceptions.WebforjException;

@Routify(packages = "com.webforj.samples.views", debug = true)
@AppTitle("webforJ Samples")
public class Application extends App{
  
  @Override
  public void run() throws WebforjException {
    console().log("Test");
  }
}
