package pack;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.border.*;
 public class Crop 
 {
	public Crop(JPanel p, main_panel pn)
	 {
						pn.yes=new JButton("yes");
						pn.yes.setPreferredSize(new Dimension(80,30));
						pn.yes.setBackground(new Color(0,0,250));
						pn.yes.setForeground(new Color(250,250,250));
						pn.yes.setActionCommand("crop_yes");
						pn.yes.addActionListener(pn);
						pn.yes.setBorder(new LineBorder(new Color(255,255,255),0,true));
						p.add(pn.yes);
						
						pn.no=new JButton("No");
						pn.no.setPreferredSize(new Dimension(80,30));
						pn.no.setBackground(new Color(0,0,255));
						pn.no.setForeground(new Color(250,250,250));
						pn.no.setActionCommand("crop_no");
						pn.no.addActionListener(pn);
						pn.no.setBorder(new LineBorder(new Color(255,255,255),0,true));
						p.add(pn.no);
		 
	 }
	 
 }
 