package lab_work_nine;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyPanel extends JPanel {
	
	 private ReaderAndWrite reader = new ReaderAndWrite();
	
	 String drawSourceText() {
		 return reader.sourceText();
	 }
	 
	 void writeText()
	 {
		 reader.writeText();
	 }
}
