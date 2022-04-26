package fr.guedesite.cms.minimizer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import fr.guedesite.cms.minimizer.frame.Frame;

public class main {

	public static void main(String[] args) {
		new Frame();
		/*String content = null;
		try {
			content = Files.readString(Path.of("D:\\git\\bvrsport\\public\\pages\\accueil.php"));
			//content = Files.readString(Path.of("D:\\git\\bvrsport\\public\\footer.php"));
			//content = Files.readString(Path.of("D:\\git\\bvrsport\\modele\\adsense.class.php"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// content = content.replaceAll(" ", "").replaceAll("	", "").replaceAll("\n", "").replaceAll("\r", "");
		
		int phpBegin = 0;
		int phpEnd = 0;
		
		List<Part> build = new ArrayList<Part>();
		
		while(true) {
			
			phpBegin = content.indexOf("<?php", phpEnd);
			if(phpBegin < 0) {
				build.add(new Part(false, content.substring(phpEnd)));
				break;
			}
			if(phpEnd != 0) { 
				build.add(new Part(false, content.substring(phpEnd+2,phpBegin)));
			}
			
			phpEnd = content.indexOf("?>", phpBegin);
			if(phpEnd < 0) {
				build.add(new Part(true, content.substring(phpBegin)));
				break;
			}
			build.add(new Part(true, content.substring(phpBegin, phpEnd + 2)));
		}
		
		for(Part p:build) {
			if(!p.isPhp) {
				p.Text=p.Text.replaceAll("\n", "").replaceAll("\r", "").replaceAll("  ", " ").replaceAll("		", " ").replaceAll(">	<", "><");
			} else {
				p.Text=p.Text.replaceAll("\n", "").replaceAll("\r", "");
				if(p.Text.length() > 4) {
					if(p.Text.charAt(5) != ' ') {
						p.Text = "<?php "+p.Text.substring(5);
					}
				}
			}
		}
		
		StringBuilder str = new StringBuilder();
		for(Part p:build) {
			str.append(p.Text);
			
		}
		System.out.println(str.toString()); */

	}
	
	/*public static class Part {
		
		public boolean isPhp;
		public String Text;
		public Part(boolean isPhp, String Text) {
			this.isPhp = isPhp;
			this.Text = Text;
		}
	}*/

}
