package fr.guedesite.cms.utils;

import java.awt.Dimension;
import java.awt.Toolkit;

public class screen {

	public static int[] getDimension() {
		Dimension size  = Toolkit.getDefaultToolkit().getScreenSize();
		return new int[] {(int)size.getWidth(), (int)size.getHeight()};

	}
	
}
