package ss.week7.mandel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Drawing the mandelbrot set is a time consuming process.
 * The program is meant to illustrate the use of a thread for this proces
 * so the GUI buttons are still responsive to user actions.
 * @author: Martin Kalin
 */

/**
 * .2 The call canvas.draw() creates a new thread which will run parallel.
 * .3 The Menu will only close once the drawing of the mandel has been finished. This is because
 * the call no longer creates a new thread so the action of closing the menu has to wait untill the
 * drawing is finished.
 */
@SuppressWarnings("serial")
public class MandelSet {
	
	
	public MandelSet() {
		win = new JFrame("Mandelbrot Set");
		Container c = win.getContentPane();
		c.setBackground(Color.white);
		c.setLayout(new BorderLayout());
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenuItem draw = new JMenuItem("Draw", 'D');
		draw.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				canvas.draw();
			}
		});
		JMenuItem exit = new JMenuItem("Exit", 'E');
		exit.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu.add(draw);
		menu.add(exit);
		menuBar.add(menu);
		canvas = new MandelPanel();
		win.setJMenuBar(menuBar);
		c.add(canvas, BorderLayout.CENTER);
		win.setSize(400, 400);
		win.setVisible(true);
	}

	private JFrame win;
	private MandelPanel canvas;

	public static void main(String[] args) {
		new MandelSet();
	}
}
