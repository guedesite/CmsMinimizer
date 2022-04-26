package fr.guedesite.cms.minimizer.frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout.Alignment;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Panel extends JPanel{
	
	private final JFrame frame;
	
	public JTextField FileInput, FileOutput;
	public JLabel FileInputText, FileOutputText, ExceptionCssText, ExceptionCssJS;
	public JButton ChooseFileInput, ChooseFileOutput;
	
	public JTabbedPane ChooseOption;
	public JPanel ChooseOptionLocal, ChooseOptionFTP;
	
	public JFileChooser InputFileChooser, OutputFileChooser;
	
	public JTextArea ExceptionCss, ExceptionJS;
	
	public Panel(JFrame frame) {
		this.frame = frame;
		
		init();
	}
	
	private void init() {
		FileInputText = new JLabel();
		FileInputText.setText("INPUT");
		FileInputText.setBounds(10, 10, 40, 20);
		this.add(FileInputText);
		
		FileInput = new JTextField();
		FileInput.setBounds(50,10,250,20);
		this.add(FileInput);
		
		ChooseFileInput = new JButton();
		ChooseFileInput.setText("Choisir le dossier");
		ChooseFileInput.setBounds(300, 10, 150, 20);
		this.add(ChooseFileInput);
		
		InputFileChooser = new JFileChooser();
		InputFileChooser.setDialogTitle("Choisir le dossier INPUT");
		InputFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		ChooseFileInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int val = InputFileChooser.showOpenDialog(frame);
				if(val == JFileChooser.APPROVE_OPTION) {
					FileInput.setText(InputFileChooser.getSelectedFile().getAbsolutePath());
				}
			}
		});
		
		
		
		FileOutputText = new JLabel();
		FileOutputText.setText("OUTPUT");
		FileOutputText.setBounds(2, 40, 60, 20);
		this.add(FileOutputText);
		
		FileOutput = new JTextField();
		FileOutput.setBounds(50,40,250,20);
		this.add(FileOutput);
		
		ChooseFileOutput = new JButton();
		ChooseFileOutput.setText("Choisir le dossier");
		ChooseFileOutput.setBounds(300, 40, 150, 20);
		this.add(ChooseFileOutput);
		
		OutputFileChooser = new JFileChooser();
		OutputFileChooser.setDialogTitle("Choisir le dossier INPUT");
		OutputFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		ChooseFileOutput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int val = OutputFileChooser.showOpenDialog(frame);
				if(val == JFileChooser.APPROVE_OPTION) {
					FileOutput.setText(OutputFileChooser.getSelectedFile().getAbsolutePath());
				}
			}
		});
		
		ChooseOption = new JTabbedPane();
		ChooseOption.setBounds(0, 200, 450, 400);
		
		
		ChooseOptionLocal = new JPanel();
		ChooseOptionLocal.setBounds(0,0, 450,400);
		ChooseOptionLocal.setLayout(null);
		ChooseOptionLocal.setBackground(Color.white);
		ChooseOption.add("Option du dossier INPUT", ChooseOptionLocal);
		
		ChooseOptionFTP = new JPanel();
		ChooseOptionFTP.setBounds(0,0, 450,400);
		ChooseOptionFTP.setLayout(null);
		ChooseOptionFTP.setBackground(Color.white);
		ChooseOption.add("Option FTP", ChooseOptionFTP);
		this.add(ChooseOption);
		
		ExceptionCssText = new JLabel();
		ExceptionCssText.setText("Exception class CSS (','):");
		ExceptionCssText.setBounds(10, 5, 400, 20);
		ChooseOptionLocal.add(ExceptionCssText);
		
		ExceptionCss = new JTextArea();
		ExceptionCss.setBounds(5, 30, 435, 100);
		ExceptionCss.setText("article-pub,adsbygoogle");
		ExceptionCss.setBorder(BorderFactory.createLineBorder(Color.gray, 1, true));
		ChooseOptionLocal.add(ExceptionCss);
		
		updateFrame();
	}
	
	public void updateFrame() {
		frame.invalidate();
		frame.validate();
		frame.repaint();
	}
}
