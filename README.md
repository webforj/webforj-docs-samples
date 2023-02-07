# HelloWorldJava
A simple HelloWorld project written in Java.


```java
package samples;

import org.dwcj.App;
import org.dwcj.controls.button.Button;
import org.dwcj.controls.button.events.ButtonClickEvent;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcAppInitializeException;

public class HelloWorldJava extends App {
    @Override
    public void run() throws DwcAppInitializeException {

        AppPanel panel = new AppPanel();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("gap", "20px");
        panel.setStyle("margin", "20px");
        panel.setStyle("padding", "20px");
        panel.setStyle("border", "1px dotted");

        panel.add(new Label("Hello World"));

        Button btn = new Button("Say Hello");
        panel.add(btn);

        btn.setTheme(Button.Theme.DANGER);
        btn.setExpanse(Button.Expanse.MEDIUM);

        btn.onClick(this::onButtonPush);
    }

    private void onButtonPush(ButtonClickEvent buttonClickEvent) {
        App.msgbox("Hello World!");
    }
}
```

The result is a modern, responsive HTML5 Web App.

![image](https://user-images.githubusercontent.com/4833070/170968208-6ff79616-ed95-40f7-aa75-d5180bf71167.png)


## How to deploy the App 

1. If not done yet, install BBj and the [BBj DWCJ Plug-In](https://github.com/BBj-Plugins/DWCJ).
2. Download the .jar file from the [releases](https://github.com/DwcJava/HelloWorldJava/releases) of this project.
3. In the DWCJ Plug-In's configure-Screen, add the .jar to the classpath.
4. Push the launch button.

## How to fetch the source code and configure

1. Clone this repository
2. Point your IDE to the home directory
3. Adjust your settings.xml or the pom.xml to point <dwcj-lib> to the copy on your disc, most likely <bbjdir>/plugins/DWCJ/lib/dwc-xxxxx.jar
4. Reload maven and build the jar
5. Go to the DWCJ Plug-In configure screen and add the jar file (or the class bin folder) to the classpath
    ![image](https://user-images.githubusercontent.com/4833070/170968004-959b47e3-fc82-4819-9894-9ca2a0c9717b.png)
6. enter samples.HelloWorldJava into the "Class" entry  
7. Click the "launch" button to see if it works


