package demos.IntervalDemos;

import com.webforj.Interval;
import com.webforj.App;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;
import com.webforj.component.field.TextField;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.optiondialog.ConfirmDialog;
import com.webforj.dispatcher.EventListener;

public class IntervalInactiveUsage extends App {

	String sampleEntry = "";

	@Override
  public void run() throws WebforjException {
    Frame window = new Frame();

    TextField sampleField = new TextField();
    sampleField.setLabel("Sample Field");

		sampleField.addValueChangeListener(e -> {
			sampleEntry = sampleField.getText();
    });

		Integer inactiveInterval = 10;
		Integer timeout = inactiveInterval*2;
		ConfirmDialog inactiveDialog = new ConfirmDialog("The TextField has been inactive for "+timeout+" seconds. Click OK to contuine.", "Interval Demo");
		inactiveDialog.setTimeout(inactiveInterval);

		EventListener<Interval.ElapsedEvent> listener = (e -> {
			if (!sampleEntry.equals("inactive")){
				// If the user hasn't changed the TextField in the Interval delay inactiveInterval, sampleEntry becomes "inactive".
				// The second Interval of inactivity will prompt the ConfirmDialog component.
				sampleEntry = "inactive";
			}
			else{
				inactiveDialog.show();
			}
		});

		Interval interval = new Interval(inactiveInterval.floatValue(), listener);
		interval.start();

    FlexLayout mainLayout = new FlexLayout(sampleField)
        .setJustifyContent(FlexJustifyContent.CENTER);

    window.add(mainLayout);

}
}