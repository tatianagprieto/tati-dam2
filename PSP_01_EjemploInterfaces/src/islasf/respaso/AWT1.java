package islasf.respaso;
import java.awt.*;

public class AWT1{
	private Frame f;
private Button b1;
private Button b2;

	public static void main(String args[]) {
		AWT1 that = new AWT1();
		that.go();
		System.out.println("Fin del programa");
	}
	public void go() {
		f = new Frame("GUI Example");
		f.setLayout(new FlowLayout());
		b1 = new Button("Press me");
		b2 = new Button("Don't press me");
		f.add(b1);
		f.add(b2);
		f.pack();
		f.setVisible(true);
	}
}