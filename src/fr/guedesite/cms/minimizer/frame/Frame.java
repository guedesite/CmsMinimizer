package fr.guedesite.cms.minimizer.frame;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import fr.guedesite.cms.utils.screen;

public class Frame {

	private final JFrame frame;
	private final Panel panel;
	
	
	public Frame() {
		this.frame = new JFrame();
		int[] dim = screen.getDimension();
		frame.setLocation((dim[0]/2) - (900/2), (dim[1] /2) - (600 / 2));
    	frame.setLayout(new BorderLayout());
		frame.setResizable(false);
		frame.setFocusable(true);
		frame.setSize(900, 600);
	
		frame.setTitle("Cms Minimizer");
		frame.setUndecorated(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		frame.setVisible(true);
		panel = new Panel(frame);
		panel.setBounds(0,0, 900, 600);
		panel.setVisible(true);
		panel.setFocusable(true);
		panel.setLayout(null);
		frame.add(panel);
	}
	
	
}
