import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO; 
import java.util.*;
import java.awt.geom.*;
import javax.swing.event.*;
import java.awt.font.*;
import javax.swing.border.*;

import composite.*;
import image.*;
import math.*;
import vecmath.*;
import pack.*;


class photo_editor2 extends JFrame  implements ActionListener
{
		JMenuBar mbar;
		JMenu more;
		JMenuItem dark,light;
		JButton save,select,canvas,adjust,filters,crop,text_watermark,image_watermark,zoom_in,zoom_out;
		File image,path;
		 BufferedImage  image2; 
		
		main_panel panel;
		Dark dark_ob;
		Light ob;
		
		photo_editor2(String s)
		{
			super(s);
			panel=new main_panel(this);
			panel.setVisible(true);
			add(panel);
			
//*************************************************
//***********************************************
	mbar=new JMenuBar();
//	mbar.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
	mbar.setBackground(new Color(0,0,0));
	mbar.setBorder(new LineBorder(new Color(0,0,0),0,true));
	
				ImageIcon SAVE=new ImageIcon("save.png");
				save=new JButton(SAVE);
				save.setPreferredSize(new Dimension(50,50));
				save.setActionCommand("save");
				save.addActionListener(this);
				save.setToolTipText("Save");
				save.setMnemonic(KeyEvent.VK_S);
				save.setText("Save");
				save.setVerticalTextPosition(AbstractButton.BOTTOM);
				save.setHorizontalTextPosition(AbstractButton.CENTER);
				save.setBorder(new LineBorder(new Color(255,255,255),0,true));
				
			
			ImageIcon SELECT=new ImageIcon("select.png");
				select=new JButton(SELECT);
				select.setPreferredSize(new Dimension(50,50));
				select.setActionCommand("select");
				select.addActionListener(this);
				select.setToolTipText("Select");
				select.setText("Select");
				select.setVerticalTextPosition(AbstractButton.BOTTOM);
				select.setHorizontalTextPosition(AbstractButton.CENTER);
				select.setBorder(new LineBorder(new Color(255,255,255),0,true));
				
				
			ImageIcon CANVAS=new ImageIcon("canvas.png");
				canvas=new JButton(CANVAS);
				canvas.setPreferredSize(new Dimension(50,50));
				canvas.setActionCommand("canvas");
				canvas.addActionListener(this);
				canvas.setToolTipText("Canvas");
				canvas.setText("Canvas");
				canvas.setVerticalTextPosition(AbstractButton.BOTTOM);
				canvas.setHorizontalTextPosition(AbstractButton.CENTER);
				canvas.setBorder(new LineBorder(new Color(255,255,255),0,true));
				
			
				
				adjust=new JButton("adjust");
				adjust.setPreferredSize(new Dimension(50,50));
				adjust.setBackground(new Color(255,0,0));
				adjust.setActionCommand("adjust");
				adjust.addActionListener(this);
				adjust.setToolTipText("adjust");
				
				ImageIcon FILTERS=new ImageIcon("filter.png");
				filters=new JButton(FILTERS);
				filters.setPreferredSize(new Dimension(50,50));
				filters.setActionCommand("filters");
				filters.addActionListener(this);
				filters.setToolTipText("Filters");
				filters.setMnemonic(KeyEvent.VK_F);
				filters.setText("Filters");
				filters.setVerticalTextPosition(AbstractButton.BOTTOM);
				filters.setHorizontalTextPosition(AbstractButton.CENTER);
				filters.setBorder(new LineBorder(new Color(255,255,255),0,true));
				
				ImageIcon CROP=new ImageIcon("crop.png");
				crop=new JButton(CROP);
				crop.setPreferredSize(new Dimension(50,50));
				crop.setActionCommand("crop");
				crop.addActionListener(this);
				crop.setToolTipText("Crop");
				crop.setMnemonic(KeyEvent.VK_C);
				crop.setText("Crop");
				crop.setVerticalTextPosition(AbstractButton.BOTTOM);
				crop.setHorizontalTextPosition(AbstractButton.CENTER);
				crop.setBorder(new LineBorder(new Color(255,255,255),0,true));
				
				ImageIcon TEXT=new ImageIcon("text.png");
				text_watermark=new JButton(TEXT);
				text_watermark.setPreferredSize(new Dimension(50,50));
				text_watermark.setActionCommand("text_watermark");
				text_watermark.addActionListener(this);
				text_watermark.setToolTipText("Text WaterMark");
				text_watermark.setText("Text");
				text_watermark.setVerticalTextPosition(AbstractButton.BOTTOM);
				text_watermark.setHorizontalTextPosition(AbstractButton.CENTER);
				text_watermark.setBorder(new LineBorder(new Color(255,255,255),0,true));
				
				ImageIcon IMAGE_WATERMARK=new ImageIcon("image_watermark.png");
				image_watermark=new JButton(IMAGE_WATERMARK);
				image_watermark.setPreferredSize(new Dimension(50,50));
				image_watermark.setActionCommand("image_watermark");
				image_watermark.addActionListener(this);
				image_watermark.setToolTipText("Image WaterMark");
				image_watermark.setText("Image");
				image_watermark.setVerticalTextPosition(AbstractButton.BOTTOM);
				image_watermark.setHorizontalTextPosition(AbstractButton.CENTER);
				image_watermark.setBorder(new LineBorder(new Color(255,255,255),0,true));
				
				
				
				ImageIcon ZOOM_IN=new ImageIcon("zoom_in.png");
				zoom_in=new JButton(ZOOM_IN);
				zoom_in.setPreferredSize(new Dimension(50,50));
				zoom_in.setActionCommand("zoom_in");
				zoom_in.addActionListener(this);
				zoom_in.setToolTipText("Zoom In");
				zoom_in.setText("Zoom in");
				zoom_in.setVerticalTextPosition(AbstractButton.BOTTOM);
				zoom_in.setHorizontalTextPosition(AbstractButton.CENTER);
				zoom_in.setBorder(new LineBorder(new Color(255,255,255),0,true));
				
				ImageIcon ZOOM_OUT=new ImageIcon("zoom_out.png");
				zoom_out=new JButton(ZOOM_OUT);
				zoom_out.setPreferredSize(new Dimension(50,50));
				zoom_out.setActionCommand("zoom_out");
				zoom_out.addActionListener(this);
				zoom_out.setToolTipText("Zoom out");
				zoom_out.setText("Zoom out");
				zoom_out.setVerticalTextPosition(AbstractButton.BOTTOM);
				zoom_out.setHorizontalTextPosition(AbstractButton.CENTER);
				zoom_out.setBorder(new LineBorder(new Color(255,255,255),0,true));
				
				ImageIcon MORE=new ImageIcon("more2.png");
				more=new JMenu("More");
				more.setIcon(MORE);
				more.setPreferredSize(new Dimension(50,50));
				more.setToolTipText("More");
				more.setVerticalTextPosition(AbstractButton.BOTTOM);
				more.setHorizontalTextPosition(AbstractButton.CENTER);
				more.setBorder(new LineBorder(new Color(255,255,255),0,true));
				
				dark=new JMenuItem("Dark Mode");
				dark.setPreferredSize(new Dimension(100,50));
				dark.setActionCommand("dark_mode");
				dark.addActionListener(this);
				dark.setVerticalTextPosition(AbstractButton.BOTTOM);
				dark.setHorizontalTextPosition(AbstractButton.CENTER);
				dark.setBorder(new LineBorder(new Color(255,255,255),0,true));
				
				light=new JMenuItem("Light Mode");
				light.setPreferredSize(new Dimension(100,50));
				light.setActionCommand("light_mode");
				light.addActionListener(this);
				light.setVerticalTextPosition(AbstractButton.BOTTOM);
				light.setHorizontalTextPosition(AbstractButton.CENTER);
				light.setBorder(new LineBorder(new Color(255,255,255),0,true));
				
		
							mbar.add(Box.createRigidArea(new Dimension(400,0)));
				mbar.add(save);
				mbar.add(Box.createRigidArea(new Dimension(20,0)));
				mbar.add(select);			
				mbar.add(Box.createRigidArea(new Dimension(20,0)));
				mbar.add(canvas);
				mbar.add(Box.createRigidArea(new Dimension(20,0)));
				//mbar.add(adjust);
				mbar.add(filters);
				mbar.add(Box.createRigidArea(new Dimension(20,0)));
				mbar.add(crop);
				mbar.add(Box.createRigidArea(new Dimension(20,0)));
				mbar.add(text_watermark);
			mbar.add(Box.createRigidArea(new Dimension(20,0)));
				mbar.add(image_watermark);
				
				mbar.add(Box.createHorizontalGlue());
		
				mbar.add(zoom_in);
				mbar.add(Box.createRigidArea(new Dimension(20,0)));
				mbar.add(zoom_out);
				mbar.add(Box.createRigidArea(new Dimension(20,0)));
				mbar.add(more);
				mbar.add(Box.createRigidArea(new Dimension(50,0)));
				more.add(dark);
				more.add(light);
				mbar.revalidate();
				setJMenuBar(mbar);
		
		
			 ob=new Light();
			ob.light_menubar(this);
			

		}
		
//*******************************************************************************************
//*******************************************************************************************
//*******************************************************************************************
				
		public void actionPerformed(ActionEvent action_performed_eve)
	{

			String s=action_performed_eve.getActionCommand();
			if(s.equals("save"))
			{
				panel.saveimage();
			}
			
			if(s.equals("select")|| s.equals("canvas") || s.equals("filters") || s.equals("crop") || s.equals("text_watermark") ||  s.equals("image_watermark") ||  s.equals("zoom_in") || s.equals("zoom_out") )
			{
				panel.select_section(s);
				
			}

			
		
			if( s.equals("dark_mode") )
			{
				
				dark_ob=new Dark();
				dark_ob.dark_menubar(this);
				dark_ob.dark_panel(panel);
				
			}
			if( s.equals("light_mode") )
			{
				
				ob.light_menubar(this);
				ob.light_panel(panel);
				
			}
			
	}
	
//**************************************************************************************************
//***************************************************************************************************
	
	
	
//**************************************************************************************************
//***************************************************************************************************
		public static void main(String ss[])
		{
			
			ImageIcon icon=new ImageIcon("mk.png");
			photo_editor2 l=new photo_editor2("editor");
			
			//l.setIconImage(icon.getImage());
			l.setExtendedState(JFrame.MAXIMIZED_BOTH);
			l.setVisible(true);
			l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


			SwingUtilities.invokeLater(new Runnable(){
			public void run()
			{
					System.out.println("created GUI on EDT"+SwingUtilities.isEventDispatchThread());
			}
		});

}
}

 //********************************************************************************************************************************
 //**************CLASS FOR JPANEL
 
 class main_panel extends JPanel implements ActionListener,ItemListener, MouseListener, MouseMotionListener
 {
			photo_editor2 ob;
			JPanel img_sec,edit_sec,canvas_sec,filter_sec,crop_sec,text_sec,text_sec2,image_sec;
			
			JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25,b26,b27,b28,b29,b30,b31,b32,b33,b34,b35;
			JButton yes,no,text_yes,text_no,text_apply,image_yes,image_no,vertical,horizontal,rotate,change;
			JTextField wm_text,wm_font,image_width,image_height;
			JLabel text_lab,fsize_lab,fstyle_lab,image_width_lab,image_height_lab,opacity;
			JButton color_button;
			Color color=new Color(0,0,0);
			
			 String font_style[]={"8514oem","Arial","calibri","Comic Sans MS","Courier","Courier New","Fixedsys","Gabriola","Impact","Ink Free","Marlett","Modern","MV Boli","Palatino Linotype","Roman","Script","Segoe Print","Segoe Script","Segoe UI","Small Fonts","Symbol","Terminal","Times New Roman","Webdings","Wingdings"};
			JComboBox combox;
			String font_name,watermark_text;
			int s_x,s_y,w_x,w_y,image_watermark_true=0,text_watermark_true=0,font_size,width,height;
			File file,watermark_image_filechooser;
		 BufferedImage  image,image2,watermark_image,watermark_image2; 
		float img_opacity;
	 
	 Rectangle2D left_top_rect,right_bottom_rect,rectangle,text_rectangle;
	 Point2D left_top_pt,right_bottom_pt;
	 int R_resizer=0,R_rect=0,R_w,R_h,R_x,R_y,rect=0,R_move=0,text_x=100,text_y=100,text_xx,text_yy,text_rectangle_drawn=1;
	 filterss fff;
	 JScrollPane jsp;
	 JSlider js;
			
	 main_panel(photo_editor2 ph)
	 {
		 
		 ob=ph;
		 
			 fff=new filterss();
			addMouseMotionListener(this);
			addMouseListener(this);
		
		  
			Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
			int screen_width=(int)size.getWidth();
			int screen_height=(int)size.getHeight();
			setLayout(new FlowLayout(FlowLayout.TRAILING,0,0));
		
		
			img_sec=new JPanel() {
			
								public void paintComponent(Graphics g)
								{
									Graphics2D gg = ( Graphics2D ) g;
									Font ff=new Font("Times New Roman", Font.ITALIC, 20);
									gg.setFont(ff); 
									gg.drawString("Developer Contact:- thappamkkumar@gmail.com, 6005819576",20,25);	
									
									if(image!=null)
									{
										super.paintComponent(g);
										
										g.drawImage(image,s_x,s_y,width,height,ob);
									}	
									
									if(image_watermark_true==1)
										{
											g.drawImage(watermark_image,w_x,w_y,watermark_image.getWidth(),watermark_image.getHeight(),ob);
											rect=1;
										R_x=w_x;
										R_y=w_y;
										R_w=watermark_image.getWidth();
										R_h=watermark_image.getHeight();
									
										}
										
										if(text_watermark_true==1)
										{
											font_size=Integer.parseInt(wm_font.getText());
										watermark_text = wm_text.getText();
										//g.drawImage(image, 0, 0, null);
										Font f=new Font(font_name, Font.ITALIC, font_size);
										gg.setFont(f);
										gg.setColor(color);
										
									
										FontRenderContext frc= new FontRenderContext(new AffineTransform(),true,true);
									
										text_xx=(int)f.getStringBounds(watermark_text,frc).getWidth();
										text_yy=(int)f.getStringBounds(watermark_text,frc).getHeight();
										
										
										gg.setStroke(new BasicStroke(5));
										text_rectangle.setFrame(text_x-120,text_y,text_xx,text_yy);
										
										//gg.draw(text_rectangle);
										gg.drawString(watermark_text,(int)(text_rectangle.getMinX()),(int)(text_rectangle.getMinY()+text_rectangle.getHeight()/2+14 ));
										//text_rectangle_drawn=1;
										}
										
										
									if(rect==1)
										{
											 
												
											rectangless(gg);
											if(R_resizer==1)
												{
													int SIZE=10;
													left_top_rect=new Rectangle2D.Double();
													left_top_rect.setFrame(left_top_pt.getX()-SIZE/2,left_top_pt.getY()-SIZE/2,SIZE,SIZE);
													right_bottom_rect=new Rectangle2D.Double();
													right_bottom_rect.setFrame(right_bottom_pt.getX()-SIZE/2,right_bottom_pt.getY()-SIZE/2,SIZE,SIZE);
													gg.setStroke(new BasicStroke(2));
													gg.setColor(new Color(250,250,250));
													gg.fill(left_top_rect);
													gg.fill(right_bottom_rect);
													
													gg.setColor(new Color(0,0,0));
													gg.draw(left_top_rect);
													gg.draw(right_bottom_rect);
												}
												
											}
								}		
			};
			img_sec.setBackground(new Color(80,80,80));
			img_sec.setPreferredSize(new Dimension(screen_width-280,screen_height));
			
		
		//******************************************************************************************
		//								EDIT SECTION 
			edit_sec=new JPanel();		
			CardLayout card=new CardLayout(0,0);
			edit_sec.setLayout(card);
			edit_sec.setBackground(new Color(0,0,0));
			edit_sec.setPreferredSize(new Dimension(280,screen_height));
		
		  add(img_sec);
		  add(edit_sec);
		  
		  canvas_sec=new JPanel();
		  canvas_sec.setLayout(new FlowLayout(FlowLayout.CENTER,10,50));
			Canvas_button vg=new Canvas_button(canvas_sec,this);
		 
		 
		  filter_sec=new JPanel();
		  filter_sec.setPreferredSize(new Dimension(250,1800));
		  Filter_button ff=new Filter_button();
		  ff.filter_button(this);
		 ff.add_filter(filter_sec,this);
			filter_sec.setLayout(new GridLayout(15,2));
			jsp=new JScrollPane(filter_sec);
			jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		  
		 
		 crop_sec=new JPanel();
		 crop_sec.setLayout(new FlowLayout(FlowLayout.CENTER,20,70));
		 Crop cr=new Crop(crop_sec,this);
		 
		  text_sec=new JPanel();
		  text_sec.setLayout(new FlowLayout(FlowLayout.CENTER,20,50));
		  Text_button tt=new Text_button(text_sec,this);
		  
		   text_sec2=new JPanel();
		  text_sec2.setLayout(new FlowLayout(FlowLayout.CENTER,20,50));
		  Text_button2 tt2=new Text_button2(text_sec2,this);
		  
		  image_sec=new JPanel();
		  image_sec.setLayout(new FlowLayout(FlowLayout.CENTER,20,70));
		 opacity=new JLabel("<html><font size='5'>Opacity</font></html>");
		  js=new JSlider(JSlider.HORIZONTAL,0,10,0); 
			js.setBackground(new Color(250,250,250));
			js.setPreferredSize(new Dimension(150,25));
			image_sec.add(opacity);
			image_sec.add(js);
			js.addChangeListener(new ChangeListener(){
			 public void stateChanged(ChangeEvent e)
			{
								img_opacity=(float)js.getValue();				
				}
		 });
		  Image_button bb=new Image_button(image_sec,this);
		  
		  
		  edit_sec.add(canvas_sec,"canvas");
 		  edit_sec.add(jsp,"filters");
		  edit_sec.add(crop_sec,"crop");
		  edit_sec.add(text_sec,"text_watermark");
		  edit_sec.add(text_sec2,"text_watermark2");
		  edit_sec.add(image_sec,"image_watermark");




//*************************************************************************************************************
//												ADDING COLOR FOR PANELS

				Light ob=new Light();
				ob.light_panel(this);
			
	 }	
	 
	 
	 
	 
	 
	 //*****************************************************************METHOD FOR SELECTING SECTON FROM EDIT SECTION 
	 
					void select_section(String s)
						{
							CardLayout cl = (CardLayout) (edit_sec.getLayout());
							if( s.equals("select"))
								{
												s_x=10;
												s_y=10;
										image_chooser();	
										
										if(image!=null)
											{
												if(image.getHeight()>=600)
												{
												image=change(image,image.getWidth(),600);
												
												}
												if(image.getWidth()>=1000)
												{
												image=change(image,1000,image.getHeight());
												
												}
												
												width=image.getWidth();
												height=image.getHeight();
												image_width.setText(String.valueOf(width));
												image_height.setText(String.valueOf(height));
				
												image2=image;
												repaint();
											}
									
								}

							if( s.equals("canvas"))
								{
									if(image!=null)
									{
										width=image.getWidth();
										height=image.getHeight();
										repaint();
									}
									
			  						cl.show(edit_sec,"canvas");
									
								}

							if( s.equals("filters") )
								{
									if(image!=null)
									{
										width=image.getWidth();
										height=image.getHeight();
										repaint();
									}
									cl.show(edit_sec,"filters");
				
								}
			
							if( s.equals("crop") )
								{
									if(image!=null)
									{
										width=image.getWidth();
										height=image.getHeight();
										repaint();
									}
									if(image!=null)
									{
									cl.show(edit_sec,"crop");
									rect=1;
									R_x=s_x;
									R_y=s_y;
									R_w=image.getWidth();
									R_h=image.getHeight();
									}
									image2=image;
									
									repaint();
				
								}
							if( s.equals("text_watermark") )
								{
										cl.show(edit_sec,"text_watermark");
									
									text_watermark_true=1;
									text_rectangle=new Rectangle2D.Double();
										
								
									
				
								}
			
							if( s.equals("image_watermark") )
								{
									js.setValue(0);
									if(image!=null)
									{
										width=image.getWidth();
										height=image.getHeight();
										repaint();
									}
									
										JFileChooser filechooser=new JFileChooser();
										filechooser.addChoosableFileFilter(new ImageFilter());
										filechooser.setAcceptAllFileFilterUsed(false);
				
										int option=filechooser.showOpenDialog(this);
										if(option==JFileChooser.APPROVE_OPTION)
											{
												watermark_image_filechooser=filechooser.getSelectedFile();
					
										try { 
												watermark_image = ImageIO.read(watermark_image_filechooser); 
												}
									catch (Exception e) 
												{
														System.out.println("error"+e);
												} 

								}
						
					
									w_x=s_x+50;
									w_y=s_y+50;
									watermark_image=change(watermark_image,100,100);
									watermark_image2=watermark_image;
									image_watermark_true=1;
									repaint();
						
									cl.show(edit_sec,"image_watermark");
				
								}
								
								if( s.equals("zoom_in") )
									{
										width=width+90;
										height=height+50;	
										repaint();
									}
								if( s.equals("zoom_out") )
									{
									if(width>=100 && height>=100)
										{
											width=width-90;
											height=height-50;
											repaint();
										}
									
									}
								
							
						}
						
						
	
	 //************************************************************************************************
	//					METHOD FOR ITEMSTATECHANGED
	
			public void itemStateChanged(ItemEvent ev)
				{
					if(ev.getSource()==combox)
					{
					font_name=(String)combox.getSelectedItem();
					}
				}
	 
	 //*************************************************************************************************************************
	 //							ACTIONlISTENER
	 
	 
		public void actionPerformed(ActionEvent action_performed_eve)
	{
			CardLayout cl = (CardLayout) (edit_sec.getLayout());
			String s=action_performed_eve.getActionCommand();
							if( s.equals("crop_yes") )
								{
									cl.show(edit_sec,"canvas");
								
									//int cx=(int)rectangle.getX()10,cy=(int)rectangle.getY()10,cw=(int)rectangle.getWidth(),ch=(int)rectangle.getHeight();
									//check above line if something wrong happen with image after crop. 
									//beause i change this line.
									//above line is previous line and next line is updated.
									int cx=(int)rectangle.getX()-10,cy=(int)rectangle.getY()-10,cw=(int)rectangle.getWidth(),ch=(int)rectangle.getHeight();
									rectangle=null;
									try{
											//Robot robot=new Robot();
											//image=robot.createScreenCapture(new Rectangle(cx+20,cy+90,cw-10,ch-8));
											CropFilter ob=new CropFilter(cx,cy,cw,ch);
											image=ob.filter(image,null);
											image2=image;
										}
									catch(Exception e)
										{
											System.out.println(e);
										}
										if(image!=null)
									{
										width=image.getWidth();
										height=image.getHeight();
										repaint();
									}
									rect=0;
									repaint();
								}
								if(s.equals("crop_no"))
								{
									cl.show(edit_sec,"canvas");
									rect=0;
									repaint();
								}
								
								if(s.equals("vertical_mirrror"))
								{
									if(image!=null)
									{
										width=image.getWidth();
										height=image.getHeight();
										repaint();
									}
									vertical_mirrror();
								}
								if(s.equals("horizontal_mirror"))
								{
									if(image!=null)
									{
										width=image.getWidth();
										height=image.getHeight();
										repaint();
									}
								horizontal_mirror();
								}
								if(s.equals("rotate"))
									{
										if(image!=null)
									{
										width=image.getWidth();
										height=image.getHeight();
										repaint();
									}
									if(image!=null)
										{
											BufferedImage resizedImage = new BufferedImage(image.getHeight(),image.getWidth(),BufferedImage.TYPE_INT_RGB);
											Graphics2D g = resizedImage.createGraphics();
											g.rotate(Math.toRadians(90),image.getWidth()/2,image.getHeight()/2);
											int d=image.getWidth()/2-image.getHeight()/2;
											g.drawImage(image,null,d,d);
											g.dispose();
											image=resizedImage;
											image2=image;
											repaint();
										}
									}
									
								if(s.equals("change"))
									{
										if(image!=null)
										{
											int w=Integer.parseInt(image_width.getText());
											int h=Integer.parseInt(image_height.getText());
											image=change(image,w,h);
											image2=image;
											width=image.getWidth();
											height=image.getHeight();
										image_width.setText(String.valueOf(width));
											image_height.setText(String.valueOf(height));
				
											repaint();
										}
									}
									
									if(s.equals("image_yes"))
									{
										
										if(watermark_image!=null)
											{
												//text_rectangle_drawn=0;
												image_watermark_true=0;
												rect=0;
											
												// initializes necessary graphic properties
												Graphics2D g2d = (Graphics2D) image.getGraphics();
												float f=img_opacity/10;
												AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, f);
												g2d.setComposite(alphaChannel);
 
												g2d.drawImage(watermark_image, w_x-10,w_y-10,watermark_image.getWidth(),watermark_image.getHeight(),null);
								
												g2d.dispose();
												image2=image;
												repaint();
												cl.show(edit_sec,"canvas");
											}
									}
									if(s.equals("image_no"))
									{
										image_watermark_true=0;
										//text_rectangle_drawn=0;
										rect=0;
										cl.show(edit_sec,"canvas");
									}
									
									if(s.equals("text_yes"))
									{
										
										repaint();
										cl.show(edit_sec,"text_watermark2");
										
									}
									if(s.equals("text_no"))
									{
										text_x=100;
										text_y=100;
										text_watermark_true=0;
										cl.show(edit_sec,"canvas");
									}
									if(s.equals("text_apply"))
									{
										text_watermark_true=0;
										font_size=Integer.parseInt(wm_font.getText());
										watermark_text = wm_text.getText();
										
										Graphics graphics = image.getGraphics();

										graphics.setFont(new Font(font_name, Font.ITALIC, font_size));
										graphics.setColor(color);
										repaint();
										graphics.drawString(watermark_text,(int)(text_rectangle.getMinX()),(int)(text_rectangle.getMinY()+text_rectangle.getHeight()/2+14 ));
									
										graphics.dispose();
						
										image2=image;
										repaint();
										text_x=100;
										text_y=100;
										cl.show(edit_sec,"canvas");
									}
									
									
									if(s.equals("color"))
									{
										color=color=JColorChooser.showDialog( ob, "Choose a color", color );
										color_button.setBackground(color);
									}
									
									if(s.equals("BW") || s.equals("GREYSCALE") || s.equals("GRIDING") || s.equals("MOSAIC") || s.equals("NEGATIVE") || s.equals("REDIMAGE") || s.equals("SEPIA") || s.equals("orignal") || s.equals("WAVEFILTER") || s.equals("UNSHARP") || s.equals("TRITONE") || s.equals("THRESHHOLD") || s.equals("STAMP") || s.equals("SPARKLE") || s.equals("POSTERIZE") || s.equals("NOISE") || s.equals("MIRROR") || s.equals("MASK") || s.equals("MARBLETEX") || s.equals("MARBLE") || s.equals("MAPCOLORS") || s.equals("JAVALN") ||  s.equals("KALEIDOSCOPE") || s.equals("INVERT") || s.equals("GRAY") || s.equals("GLOW") || s.equals("FLIP") || s.equals("FLARE") || s.equals("FBM") || s.equals("DITHER") || s.equals("DISPLACE")  || s.equals("DIFFUSE") || s.equals("aa") || s.equals("COLORHALFTONE") || s.equals("CHROME") || s.equals("CHECK") || s.equals("saturation") || s.equals("brightness") || s.equals("contrast"))
									{		
											if(image != null)
											{
												BufferedImage img=new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_INT_RGB);
												Graphics g=img.getGraphics();
												g.drawImage(image2,0,0,null);
												g.dispose();
												image=fff.ImageFilter(s,img,0);
												
												repaint(); 
											}
									}
			
	}


//*****************************MOUSE************************************
//************************************************************************
public void mouseClicked(MouseEvent me) {} 
 
public void mouseEntered(MouseEvent me) {} 
 
public void mouseExited(MouseEvent me) {} 
 
public void mouseMoved(MouseEvent me){}
public void mousePressed(MouseEvent me){

	
		if(R_resizer==1)
			{
				
				if(left_top_rect.contains(me.getX(),me.getY()))
					{
						R_rect=1;
					}
				if(right_bottom_rect.contains(me.getX(),me.getY()))
					{
						R_rect=2;
					}
			}

		if(image_watermark_true ==1)
			{
				int xx=me.getX();
				int yx=me.getY();
			
				if(rectangle.contains(xx,yx))
				{
					R_move=1;
				}
			}
	if(text_watermark_true ==1)
		{
			
			text_x=me.getX();
			text_y=me.getY();
					
					if(text_rectangle_drawn==1)
					{
						if(text_rectangle.contains(text_x,text_y))
							{
								R_move=1;
								
							}
					}
	}
	
}
public void mouseReleased(MouseEvent me) {
	 
	R_rect=0;
	R_move=0;
	repaint();
} 
public void mouseDragged(MouseEvent me) {
	
	if(text_watermark_true ==1)
		{
			
			text_x=me.getX();
			text_y=me.getY();
	repaint();
	}
	
	if(image_watermark_true !=1)
	{
		if(R_resizer==1)
			{
				if(R_rect==2)
				{
					int x,y;
					right_bottom_pt=new Point2D.Double(me.getX(),me.getY());
					x=(int)Math.abs(R_x-right_bottom_pt.getX());
					y=(int)Math.abs(R_y-right_bottom_pt.getY());
					if(x<=image.getWidth())
					{
						R_w=x;
						
					}
					else{
						R_w=image.getWidth();
						
					}
					
					if(y<= image.getHeight())
					{
						
						R_h=y;
					}
					else{
						
						R_h=image.getHeight();
					}
					img_sec.repaint();
				}
				if(R_rect==1)
				{
			int x,y;
					left_top_pt=new Point2D.Double(me.getX(),me.getY());
					x=me.getX();
					y=me.getY();
					if(x>=s_x)
					{
						R_x=x;
					}
					else{
						R_x=s_x;
					}
					if(y>=s_y)
					{
						R_y=y;
					}
					else{
						R_y=s_y;
					}
					R_w=(int)Math.abs(R_x-right_bottom_pt.getX());
					R_h=(int)Math.abs(R_y-right_bottom_pt.getY());
				img_sec.repaint();
				}
			}
	}
	
				if(image_watermark_true ==1)
						{
								change_watermark_image(me.getX(),me.getY());
						}
 
 
 
 }

  //************************************************************************************
				//****method for changing width height of watermark image
					
 
void change_watermark_image(int X,int Y)  
	{	 
							if(R_rect==2)
							{
								int x,y;
									right_bottom_pt=new Point2D.Double(X,Y);
									x=(int)Math.abs(watermark_image.getMinX() - right_bottom_pt.getX());
									y=(int)Math.abs(watermark_image.getMinX() -right_bottom_pt.getY());
									//watermark_image=change(watermark_image,x,y);
									ScaleFilter ob=new ScaleFilter(x/2,y/2);
									watermark_image=ob.filter(watermark_image2,null);
									img_sec.repaint();
							}
							
							if(R_rect==1)
							{
			
									left_top_pt=new Point2D.Double(X,Y);
									w_x=X;
									w_y=Y;
					
									int x2=(int)Math.abs(w_x-right_bottom_pt.getX());
									int y2=(int)Math.abs(w_y-right_bottom_pt.getY());
									ScaleFilter ob=new ScaleFilter(x2,y2);
									watermark_image=ob.filter(watermark_image2,null);
									img_sec.repaint();
						}
						if(R_move==1)
						{
							
									w_x=X;
									w_y=Y;
									repaint();
						}
					}
 
 
	
 //************************************************************************************************
 //****************METHOD FOR VERTICAL AND HORIZONTAL FLIP OF  IMAGE ******************************************************************



void vertical_mirrror()
		{
			
			if(image!=null)
			{
				int width=image.getWidth(),height=image.getHeight();
				BufferedImage res=new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
				for(int j=0; j<height; j++)
				{
					for(int i=0,w2=width-1; i<width; i++,w2--)
					{
						
						int p=image.getRGB(i,j);
						res.setRGB(w2,j,p);
					}
				}
				
				image=res;
				image2=image;
				repaint();
			}
		}
		
		void horizontal_mirror()
		{
			if(image!=null)
			{
					int width=image.getWidth(),height=image.getHeight();
					BufferedImage res=new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
						
						for(int r=0,h2=height-1; r<height; h2--,r++)
						{
								for(int c=0; c<width; c++)
							{
								
								int p=image.getRGB(c,r);
								res.setRGB(c,h2,p);
							}
						}	
				
				
				image=res;
				image2=image;
				repaint();
			}
		}
		
		
 //************************************************************************************************
 //****************METHOD FOR SAVE AN  IMAGE ******************************************************************


	public void saveimage()
		{

				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Save Title");
				int returnVal = fileChooser.showSaveDialog(ob);
				
				if(returnVal == fileChooser.APPROVE_OPTION)
				{
					File file = fileChooser.getSelectedFile();
					
					
					String snapshotLocation = file.getAbsolutePath();
					
				       File imageFile = new File(file.getAbsolutePath()+".png");
				   
				    
					
				
			
				try{
			ImageIO.write(image,"png", new File(file.getAbsolutePath()+".png"));
			}
			catch(IOException e)
			{
				System.out.println("Error: " + e);
			}
		fileChooser.disable();
			}
				
			}
	
	
 //************************************************************************************************
 //****************METHOD FOR DRAW RACTANGLE FOR CROP IMAGE ******************************************************************

		void rectangless(Graphics2D gg)
		{
			
		
		
			gg.setColor(new Color(0,0,0));
				gg.setStroke(new BasicStroke(5));
			rectangle=new Rectangle2D.Double();
			//if(R_x>=s_x && R_y>=s_y && R_w<=w && R_h<=ih)
			rectangle.setFrame(R_x,R_y,R_w,R_h);
			gg.draw(rectangle);
			
					draw_knob();
				
		}
void draw_knob()
{
	left_top_pt=new Point2D.Double(rectangle.getX(),rectangle.getY());
	right_bottom_pt=new Point2D.Double(rectangle.getX()+rectangle.getWidth(),rectangle.getY()+rectangle.getHeight());

			R_resizer=1; 
		
	repaint();
}

 //************************************************************************************************
 //****************************METHOD FOR CHANGING THE DIMENSION OF IMAGE********************************************************************
		
		BufferedImage change(BufferedImage  img,int w,int h)
		{
				BufferedImage resizedImage = new BufferedImage(w,h, BufferedImage.TYPE_INT_RGB);
				
				
					 //System.out.println("hbghgh");
					//Graphics2D graphics2D = resizedImage.createGraphics();
					//graphics2D.drawImage(img, 0, 0,w,h, null);
					//graphics2D.dispose();
					ScaleFilter ob=new ScaleFilter(w,h);
					resizedImage=ob.filter(img,null);
					
					
				
				return resizedImage;
		}
		
		
	 //*************************************************************************************************************************
	 //							METHOD FOR CHOOSING AN IMAGE
	 

	void image_chooser()
	{
		
		JFileChooser filechooser=new JFileChooser();
				filechooser.addChoosableFileFilter(new ImageFilter());
				filechooser.setAcceptAllFileFilterUsed(false);
				
				int option=filechooser.showOpenDialog(this);
				if(option==JFileChooser.APPROVE_OPTION)
				{
					file=filechooser.getSelectedFile();
					
					 try { 
							image = ImageIO.read(file); 
							
					
					 }
					 catch (Exception e) {
						 System.out.println("error"+e);
					 } 

				}
				
	}
				
				
 }	 
 
 
 
 //***********************************************************************************************************
 //							CLASS  FOR IMAGE CANVAS BUTTON
 
 
 class Canvas_button
 {
		Canvas_button(JPanel p, main_panel pn)
	 {
					p.add(Box.createRigidArea(new Dimension(80,0)));
						ImageIcon ROTATE=new ImageIcon("rotate.png");
						pn.rotate=new JButton(ROTATE);
						pn.rotate.setPreferredSize(new Dimension(60,60));
						pn.rotate.setActionCommand("rotate");
						pn.rotate.addActionListener(pn);
						pn.rotate.setBorder(new LineBorder(new Color(255,255,255),0,true));
						p.add(pn.rotate);
						p.add(Box.createRigidArea(new Dimension(100,0)));
						
						p.add(Box.createRigidArea(new Dimension(40,0)));
						ImageIcon VERTICAL=new ImageIcon("vertical.png");
						pn.vertical=new JButton(VERTICAL);
						pn.vertical.setPreferredSize(new Dimension(60,60));
						pn.vertical.setActionCommand("vertical_mirrror");
						pn.vertical.addActionListener(pn);
						pn.vertical.setBorder(new LineBorder(new Color(255,255,255),0,true));
						p.add(pn.vertical);
						p.add(Box.createRigidArea(new Dimension(20,0)));
						
						
						ImageIcon HORIZONTAL=new ImageIcon("horizontal.png");
						pn.horizontal=new JButton(HORIZONTAL);
						pn.horizontal.setPreferredSize(new Dimension(60,60));
						//pn.horizontal.setBackground(new Color(0,0,255));
						//pn.horizontal.setForeground(new Color(250,250,250));
						pn.horizontal.setActionCommand("horizontal_mirror");
						pn.horizontal.addActionListener(pn);
						pn.horizontal.setBorder(new LineBorder(new Color(255,255,255),0,true));
						p.add(pn.horizontal);
						p.add(Box.createRigidArea(new Dimension(50,0)));
						
						pn.image_width_lab=new JLabel("<html><font size='4' >Width</font></html>");
						pn.image_width=new JTextField("");
						pn.image_width.setPreferredSize(new Dimension(50,30));
						
								
						pn.image_height_lab=new JLabel("<html><font size='4'>Height</font></html>");
						pn.image_height=new JTextField("");
						pn.image_height.setPreferredSize(new Dimension(50,30));
						
						pn.change=new JButton("Change");
						pn.change.setPreferredSize(new Dimension(80,30));
						pn.change.setActionCommand("change");
						pn.change.addActionListener(pn);
						pn.change.setBorder(new LineBorder(new Color(255,255,255),0,true));
						pn.change.setBackground(new Color(0,0,250));
						pn.change.setForeground(new Color(250,250,250));
						
						
						p.add(pn.image_width_lab);
						p.add(pn.image_width);
						p.add(pn.image_height_lab);
						p.add(pn.image_height);
						p.add(pn.change);
								
	 }
	 
 }
 
 
 //***********************************************************************************************************
 //							CLASS  FOR IMAGE WATERMARK BUTTON
 
 
 class Image_button
 {
		Image_button(JPanel p, main_panel pn)
	 {
						
						pn.image_yes=new JButton("yes");
						pn.image_yes.setPreferredSize(new Dimension(80,30));
						pn.image_yes.setBackground(new Color(0,0,250));
						pn.image_yes.setForeground(new Color(250,250,250));
						pn.image_yes.setActionCommand("image_yes");
						pn.image_yes.addActionListener(pn);
						pn.image_yes.setBorder(new LineBorder(new Color(255,255,255),0,true));
						p.add(pn.image_yes);
						
						pn.image_no=new JButton("No");
						pn.image_no.setPreferredSize(new Dimension(80,30));
						pn.image_no.setBackground(new Color(0,0,255));
						pn.image_no.setForeground(new Color(250,250,250));
						pn.image_no.setActionCommand("image_no");
						pn.image_no.addActionListener(pn);
						pn.image_no.setBorder(new LineBorder(new Color(255,255,255),0,true));
						p.add(pn.image_no);
	 }
	 
 }
 
 //**********************************************************************************************************
 //										CLASS FOR BUTTON OF TEXT WATERMARK
 
 class Text_button
 {
	 Text_button(JPanel p, main_panel pn)
	 {
								pn.text_lab=new JLabel("<html><font size='5' >Text</font></html>");
									
								
								pn.wm_text=new JTextField("");
								pn.wm_text.setPreferredSize(new Dimension(180,30));
								
								
								pn.fsize_lab=new JLabel("<html><font size='5'>Font Size</font></html>");
									
								pn.wm_font=new JTextField("");
								pn.wm_font.setPreferredSize(new Dimension(50,30));
								
								
								pn.color_button=new JButton("Color");
								pn.color_button.setPreferredSize(new Dimension(80,30));
								pn.color_button.setActionCommand("color");
								pn.color_button.addActionListener(pn);
								
						
								pn.fstyle_lab=new JLabel("<html><font size='5' >Font Style</font></html>");
									
								pn.combox=new JComboBox(pn.font_style);
								pn.combox.setPreferredSize(new Dimension(150,30));
								pn.combox.setBackground(new Color(255,255,255));
								pn.combox.addItemListener(pn);
								
								pn.text_yes=new JButton("Ok");
								pn.text_yes.setPreferredSize(new Dimension(80,30));
								pn.text_yes.setActionCommand("text_yes");
								pn.text_yes.addActionListener(pn);
								pn.text_yes.setBorder(new LineBorder(new Color(255,255,255),0,true));
								pn.text_yes.setBackground(new Color(0,0,250));
								pn.text_yes.setForeground(new Color(250,250,250));
						
						
								pn.text_no=new JButton("Cancel");
								pn.text_no.setPreferredSize(new Dimension(80,30));
								pn.text_no.setActionCommand("text_no");
								pn.text_no.addActionListener(pn);
								pn.text_no.setBorder(new LineBorder(new Color(255,255,255),0,true));
								pn.text_no.setBackground(new Color(0,0,250));
								pn.text_no.setForeground(new Color(250,250,250));
						
									
								
								p.add(pn.text_lab);
								p.add(pn.wm_text);
								p.add(pn.fsize_lab);
								p.add(pn.wm_font);
								p.add(pn.color_button);
								p.add(pn.fstyle_lab);
								p.add(pn.combox);
								p.add(pn.text_yes);
								p.add(pn.text_no);
			
	 }
	 
 }
 
 
 class Text_button2
 {
	 Text_button2(JPanel p, main_panel pn)
	 {
								pn.text_apply=new JButton("Apply");
								pn.text_apply.setPreferredSize(new Dimension(80,30));
								pn.text_apply.setActionCommand("text_apply");
								pn.text_apply.addActionListener(pn);
								pn.text_apply.setBorder(new LineBorder(new Color(255,255,255),0,true));
								pn.text_apply.setBackground(new Color(0,0,250));
								pn.text_apply.setForeground(new Color(250,250,250));
						
						p.add(pn.text_apply);
	 }	 
 }
		 
 
 //*****************************************************************************************************
 //											CLASS FOR BUTTON OF FILTERS
 
 class Filter_button
 {
		
	void filter_button(main_panel pn)
	{	
			Icon BW=new ImageIcon("icon/BW.png");
			pn.b1=new JButton(BW);
				pn.b1.setPreferredSize(new Dimension(100,120));
				pn.b1.setBackground(new Color(255,255,255));
				pn.b1.setActionCommand("BW");
				pn.b1.addActionListener(pn);
				pn.b1.setBorder(new LineBorder(new Color(255,255,255),3,true));
				
				Icon GREYSCALE=new ImageIcon("icon/GREYSCALE.png");
				pn.b2=new JButton(GREYSCALE);
				pn.b2.setPreferredSize(new Dimension(100,120));
				pn.b2.setBackground(new Color(255,255,255));
				pn.b2.setActionCommand("GREYSCALE");
				pn.b2.addActionListener(pn);
				pn.b2.setBorder(new LineBorder(new Color(255,255,255),3,true));
				
					Icon GRIDING=new ImageIcon("icon/GRIDING.png");
				pn.b3=new JButton(GRIDING);
				pn.b3.setPreferredSize(new Dimension(100,120));
				pn.b3.setBackground(new Color(255,255,255));
				pn.b3.setActionCommand("GRIDING");
				pn.b3.addActionListener(pn);
				pn.b3.setBorder(new LineBorder(new Color(255,255,255),3,true));
				
					Icon MOSAIC=new ImageIcon("icon/MOSAIC.png");
				pn.b4=new JButton(MOSAIC);
				pn.b4.setPreferredSize(new Dimension(100,120));
				pn.b4.setBackground(new Color(255,255,255));
				pn.b4.setActionCommand("MOSAIC");
				pn.b4.addActionListener(pn);
				pn.b4.setBorder(new LineBorder(new Color(255,255,255),3,true));
				
					Icon NEGATIVE=new ImageIcon("icon/NEGATIVE.png");
				pn.b5=new JButton(NEGATIVE);
				pn.b5.setPreferredSize(new Dimension(100,120));
				pn.b5.setBackground(new Color(255,255,255));
				pn.b5.setActionCommand("NEGATIVE");
				pn.b5.addActionListener(pn);
				pn.b5.setBorder(new LineBorder(new Color(255,255,255),3,true));
				
					Icon REDIMAGE=new ImageIcon("icon/REDIMAGE.png");
				pn.b6=new JButton(REDIMAGE);
				pn.b6.setPreferredSize(new Dimension(100,120));
				pn.b6.setBackground(new Color(255,255,255));
				pn.b6.setActionCommand("REDIMAGE");
				pn.b6.addActionListener(pn);
				pn.b6.setBorder(new LineBorder(new Color(255,255,255),3,true));
				
					Icon SEPIA=new ImageIcon("icon/SEPIA.png");
				pn.b7=new JButton(SEPIA);
				pn.b7.setPreferredSize(new Dimension(100,120));
				pn.b7.setBackground(new Color(255,255,255));
			   pn.b7.setActionCommand("SEPIA");
				pn.b7.addActionListener(pn);
				pn.b7.setBorder(new LineBorder(new Color(255,255,255),3,true));
				
					Icon WAVEFILTER=new ImageIcon("icon/WAVEFILTER.png");
				pn.b8=new JButton(WAVEFILTER);
				pn.b8.setPreferredSize(new Dimension(100,120));
				pn.b8.setBackground(new Color(255,255,255));
				pn.b8.setActionCommand("WAVEFILTER");
				pn.b8.addActionListener(pn);
				pn.b8.setBorder(new LineBorder(new Color(255,255,255),3,true));
				
				Icon UNSHARP=new ImageIcon("icon/UNSHARP.png");
				pn.b9=new JButton(UNSHARP);
				pn.b9.setPreferredSize(new Dimension(100,120));
				pn.b9.setBackground(new Color(255,255,255));
				pn.b9.setActionCommand("UNSHARP");
				pn.b9.addActionListener(pn);
				pn.b9.setBorder(new LineBorder(new Color(255,255,255),3,true));
				
				Icon TRITONE=new ImageIcon("icon/TRITONE.png");
				pn.b10=new JButton(TRITONE);
				pn.b10.setPreferredSize(new Dimension(100,120));
				pn.b10.setBackground(new Color(255,255,255));
				pn.b10.setActionCommand("TRITONE");
				pn.b10.addActionListener(pn);
				pn.b10.setBorder(new LineBorder(new Color(255,255,255),3,true));
				
				Icon THRESHHOLD=new ImageIcon("icon/THRESHHOLD.png");
				pn.b11=new JButton(THRESHHOLD);
				pn.b11.setPreferredSize(new Dimension(100,120));
				pn.b11.setBackground(new Color(255,255,255));
				pn.b11.setActionCommand("THRESHHOLD");
				pn.b11.addActionListener(pn);
				pn.b11.setBorder(new LineBorder(new Color(255,255,255),3,true));
				
					Icon STAMP=new ImageIcon("icon/STAMP.png");
				pn.b12=new JButton(STAMP);
				pn.b12.setPreferredSize(new Dimension(100,120));
				pn.b12.setBackground(new Color(255,255,255));
				pn.b12.setActionCommand("STAMP");
				pn.b12.addActionListener(pn);
				pn.b12.setBorder(new LineBorder(new Color(255,255,255),3,true));
			
				Icon SPARKLE=new ImageIcon("icon/SPARKLE.png");
				pn.b13=new JButton(SPARKLE);
				pn.b13.setPreferredSize(new Dimension(100,120));
				pn.b13.setBackground(new Color(255,255,255));
				pn.b13.setActionCommand("SPARKLE");
				pn.b13.addActionListener(pn);
				pn.b13.setBorder(new LineBorder(new Color(255,255,255),3,true));
			
					Icon POSTERIZE=new ImageIcon("icon/POSTERIZE.png");
				pn.b14=new JButton(POSTERIZE);
				pn.b14.setPreferredSize(new Dimension(100,120));
				pn.b14.setBackground(new Color(255,255,255));
				pn.b14.setActionCommand("POSTERIZE");
				pn.b14.addActionListener(pn);
				pn.b14.setBorder(new LineBorder(new Color(255,255,255),3,true));
				
					Icon NOISE=new ImageIcon("icon/NOISE.png");
				pn.b15=new JButton(NOISE);
				pn.b15.setPreferredSize(new Dimension(100,120));
				pn.b15.setBackground(new Color(255,255,255));
				pn.b15.setActionCommand("NOISE");
				pn.b15.addActionListener(pn);
				pn.b15.setBorder(new LineBorder(new Color(255,255,255),3,true));
				
					Icon MIRROR=new ImageIcon("icon/MIRROR.png");
				pn.b16=new JButton(MIRROR);
				pn.b16.setPreferredSize(new Dimension(100,120));
				pn.b16.setBackground(new Color(255,255,255));
				pn.b16.setActionCommand("MIRROR");
				pn.b16.addActionListener(pn);
				pn.b16.setBorder(new LineBorder(new Color(255,255,255),3,true));
					
					Icon MASK=new ImageIcon("icon/MASK.png");
				pn.b17=new JButton(MASK);
				pn.b17.setPreferredSize(new Dimension(100,120));
				pn.b17.setBackground(new Color(255,255,255));
				pn.b17.setActionCommand("MASK");
				pn.b17.addActionListener(pn);
				pn.b17.setBorder(new LineBorder(new Color(255,255,255),3,true));
				
				Icon MARBLETEX=new ImageIcon("icon/MARBLETEX.png");
				pn.b18=new JButton(MARBLETEX);
				pn.b18.setPreferredSize(new Dimension(100,120));
				pn.b18.setBackground(new Color(255,255,255));
				pn.b18.setActionCommand("MARBLETEX");
				pn.b18.addActionListener(pn);
				pn.b18.setBorder(new LineBorder(new Color(255,255,255),3,true));
	
					Icon MARBLE=new ImageIcon("icon/MARBLE.png");
				pn.b19=new JButton(MARBLE);
				pn.b19.setPreferredSize(new Dimension(100,120));
				pn.b19.setBackground(new Color(255,255,255));
				pn.b19.setActionCommand("MARBLE");
				pn.b19.addActionListener(pn);
				pn.b19.setBorder(new LineBorder(new Color(255,255,255),3,true));
				
					Icon MAPCOLORS=new ImageIcon("icon/MAPCOLORS.png");
				pn.b20=new JButton(MAPCOLORS);
				pn.b20.setPreferredSize(new Dimension(100,120));
				pn.b20.setBackground(new Color(255,255,255));
				pn.b20.setActionCommand("MAPCOLORS");
				pn.b20.addActionListener(pn);
				pn.b20.setBorder(new LineBorder(new Color(255,255,255),3,true));
				
				Icon JAVALN=new ImageIcon("icon/JAVALN.png");
				pn.b21=new JButton(JAVALN);
				pn.b21.setPreferredSize(new Dimension(100,120));
				pn.b21.setBackground(new Color(255,255,255));
				pn.b21.setActionCommand("JAVALN");
				pn.b21.addActionListener(pn);
				pn.b21.setBorder(new LineBorder(new Color(255,255,255),3,true));

					Icon KALEIDOSCOPE=new ImageIcon("icon/KALEIDOSCOPE.png");
				pn.b22=new JButton(KALEIDOSCOPE);
				pn.b22.setPreferredSize(new Dimension(100,120));
				pn.b22.setBackground(new Color(255,255,255));
				pn.b22.setActionCommand("KALEIDOSCOPE");
				pn.b22.addActionListener(pn);
				pn.b22.setBorder(new LineBorder(new Color(255,255,255),3,true));
				
					Icon INVERT=new ImageIcon("icon/INVERT.png");
				pn.b23=new JButton(INVERT);
				pn.b23.setPreferredSize(new Dimension(100,120));
				pn.b23.setBackground(new Color(255,255,255));
				pn.b23.setActionCommand("INVERT");
				pn.b23.addActionListener(pn);
				pn.b23.setBorder(new LineBorder(new Color(255,255,255),3,true));

					Icon GRAY=new ImageIcon("icon/GRAY.png");
				pn.b24=new JButton(GRAY);
				pn.b24.setPreferredSize(new Dimension(100,120));
				pn.b24.setBackground(new Color(255,255,255));
				pn.b24.setActionCommand("GRAY");
				pn.b24.addActionListener(pn);
				pn.b24.setBorder(new LineBorder(new Color(255,255,255),3,true));

					Icon GLOW=new ImageIcon("icon/GLOW.png");
				pn.b25=new JButton(GLOW);
				pn.b25.setPreferredSize(new Dimension(100,120));
				pn.b25.setBackground(new Color(255,255,255));
				pn.b25.setActionCommand("GLOW");
				pn.b25.addActionListener(pn);
				pn.b25.setBorder(new LineBorder(new Color(255,255,255),3,true));
				
					Icon FLIP=new ImageIcon("icon/FLIP.png");
				pn.b26=new JButton(FLIP);
				pn.b26.setPreferredSize(new Dimension(100,120));
				pn.b26.setBackground(new Color(255,255,255));
				pn.b26.setActionCommand("FLIP");
				pn.b26.addActionListener(pn);
					pn.b26.setBorder(new LineBorder(new Color(255,255,255),3,true));

					Icon FLARE=new ImageIcon("icon/FLARE.png");
			pn.b27=new JButton(FLARE);
				pn.b27.setPreferredSize(new Dimension(100,120));
				pn.b27.setBackground(new Color(255,255,255));
				pn.b27.setActionCommand("FLARE");
				pn.b27.addActionListener(pn);
			pn.b27.setBorder(new LineBorder(new Color(255,255,255),3,true));
					
				pn.b28=new JButton("FBM");
				pn.b28.setPreferredSize(new Dimension(100,120));
				pn.b28.setBackground(new Color(255,255,255));
				pn.b28.setActionCommand("FBM");
				pn.b28.addActionListener(pn);
				pn.b28.setBorder(new LineBorder(new Color(255,255,255),3,true));

					Icon DITHER=new ImageIcon("icon/DITHER.png");
				pn.b29=new JButton(DITHER);
			pn.b29.setPreferredSize(new Dimension(100,120));
				pn.b29.setBackground(new Color(255,255,255));
				pn.b29.setActionCommand("DITHER");
				pn.b29.addActionListener(pn);
				pn.b29.setBorder(new LineBorder(new Color(255,255,255),3,true));

					Icon DISPLACE=new ImageIcon("icon/DISPLACE.png");
				pn.b30=new JButton(DISPLACE);
				pn.b30.setPreferredSize(new Dimension(100,120));
				pn.b30.setBackground(new Color(255,255,255));
				pn.b30.setActionCommand("DISPLACE");
				pn.b30.addActionListener(pn);
				pn.b30.setBorder(new LineBorder(new Color(255,255,255),3,true));

					Icon DIFFUSE=new ImageIcon("icon/DIFFUSE.png");
				pn.b31=new JButton(DIFFUSE);
				pn.b31.setPreferredSize(new Dimension(100,120));
				pn.b31.setBackground(new Color(255,255,255));
				pn.b31.setActionCommand("DIFFUSE");
				pn.b31.addActionListener(pn);
				pn.b31.setBorder(new LineBorder(new Color(255,255,255),3,true));
		
			Icon COLORHALFTONE=new ImageIcon("icon/COLORHALFTONE.png");
				pn.b32=new JButton(COLORHALFTONE);
				pn.b32.setPreferredSize(new Dimension(100,120));
				pn.b32.setBackground(new Color(255,255,255));
				pn.b32.setActionCommand("COLORHALFTONE");
				pn.b32.addActionListener(pn);
				
					Icon CHROME=new ImageIcon("icon/CHROME.png");
				pn.b33=new JButton(CHROME);
				pn.b33.setPreferredSize(new Dimension(100,120));
				pn.b33.setBackground(new Color(255,255,255));
				pn.b33.setActionCommand("CHROME");
				pn.b33.addActionListener(pn);
				pn.b33.setBorder(new LineBorder(new Color(255,255,255),3,true));

					Icon CHECK=new ImageIcon("icon/CHECK.png");
				pn.b34=new JButton(CHECK);
				pn.b34.setPreferredSize(new Dimension(100,120));
				pn.b34.setBackground(new Color(255,255,255));
				pn.b34.setActionCommand("CHECK");
				pn.b34.addActionListener(pn);
				pn.b34.setBorder(new LineBorder(new Color(255,255,255),3,true));
				
	}
	
	
void add_filter(JPanel sec3,main_panel pn)
	 {
				sec3.add(pn.b1);
				sec3.add(pn.b2);
				sec3.add(pn.b3);
				sec3.add(pn.b4);
				sec3.add(pn.b5);
				sec3.add(pn.b6);
				sec3.add(pn.b7);
				sec3.add(pn.b8);
				sec3.add(pn.b9);
				sec3.add(pn.b10);
				sec3.add(pn.b11);
				sec3.add(pn.b12);
				//sec3.add(b13);
				sec3.add(pn.b14);
				sec3.add(pn.b15);
				sec3.add(pn.b16);
				sec3.add(pn.b17);
				sec3.add(pn.b18);
				sec3.add(pn.b19);
				sec3.add(pn.b20);
				sec3.add(pn.b21);
				//sec3.add(b22);
				//sec3.add(pn.b23);
				sec3.add(pn.b24);
				sec3.add(pn.b25);
				//sec3.add(b26);
				//sec3.add(b27);
				//sec3.add(b28);
				sec3.add(pn.b29);
				sec3.add(pn.b30);
				sec3.add(pn.b31);
				sec3.add(pn.b32);
				sec3.add(pn.b33);
				sec3.add(pn.b34);
				//sec3.add(b35);
	 }
	 
 }
 
 
 //*************************************************************************************************************
 //      					CLASS FOR CROP
 
 class Crop 
 {
	 Crop(JPanel p, main_panel pn)
	 {
						pn.yes=new JButton("Yes");
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
 
 
 
 //*************************************************************************************************************
 //      				CLASS FOR CHANGING MODE
class Light
{
		void light_menubar (photo_editor2 ph)
		{
			
				ph.mbar.setBackground(new Color(255,255,255));
				ph.save.setBackground(new Color(255,255,255));
				ph.select.setBackground(new Color(255,255,255));
				ph.canvas.setBackground(new Color(255,255,255));
				ph.filters.setBackground(new Color(255,255,255));
				ph.crop.setBackground(new Color(255,255,255));
				ph.text_watermark.setBackground(new Color(255,255,255));
				ph.image_watermark.setBackground(new Color(255,255,255));
				ph.zoom_in.setBackground(new Color(255,255,255));
				ph.zoom_out.setBackground(new Color(255,255,255));
				ph.more.setBackground(new Color(255,255,255));
				ph.dark.setBackground(new Color(255,255,255));
				ph.light.setBackground(new Color(255,255,255));
				
				
				ph.save.setForeground(new Color(0,0,0));
				ph.select.setForeground(new Color(0,0,0));
				ph.canvas.setForeground(new Color(0,0,0));
				ph.filters.setForeground(new Color(0,0,0));
				ph.crop.setForeground(new Color(0,0,0));
				ph.text_watermark.setForeground(new Color(0,0,0));
				ph.image_watermark.setForeground(new Color(0,0,0));
				ph.zoom_in.setForeground(new Color(0,0,0));
				ph.zoom_out.setForeground(new Color(0,0,0));
				ph.more.setForeground(new Color(0,0,0));
				ph.dark.setForeground(new Color(0,0,0));
				ph.light.setForeground(new Color(0,0,0));
		}
		
		void light_panel (main_panel panel)
		{
			
				
				panel.img_sec.setBackground(new Color(230,230,230));
				panel.canvas_sec.setBackground(new Color(255,255,255));
				panel.filter_sec.setBackground(new Color(255,255,255));
				panel.crop_sec.setBackground(new Color(255,255,255));
				panel.text_sec.setBackground(new Color(255,255,255));
				panel.text_sec2.setBackground(new Color(255,255,255));
				panel.image_sec.setBackground(new Color(255,255,255));
				panel.wm_text.setBorder(new LineBorder(new Color(0,0,0),2,true));
				panel.wm_font.setBorder(new LineBorder(new Color(0,0,0),2,true));
				panel.combox.setBorder(new LineBorder(new Color(0,0,0),2,true));
				panel.rotate.setBackground(new Color(255,255,255));
				panel.vertical.setBackground(new Color(255,255,255));
				panel.horizontal.setBackground(new Color(255,255,255));
				panel.image_width.setBorder(new LineBorder(new Color(0,0,0),2,true));
				panel.image_height.setBorder(new LineBorder(new Color(0,0,0),2,true));
						panel.js.setBackground(new Color(255,255,255));
				panel.js.setBorder(new LineBorder(new Color(0,0,0),2,true));
				
				
				
				
				
				panel.canvas_sec.setForeground(new Color(0,0,0));
				panel.filter_sec.setForeground(new Color(0,0,0));
				panel.crop_sec.setForeground(new Color(0,0,0));
				panel.text_sec.setForeground(new Color(0,0,0));
				panel.text_sec2.setForeground(new Color(0,0,0));
				panel.image_sec.setForeground(new Color(0,0,0));
				panel.fsize_lab.setForeground(new Color(0,0,0));
				panel.fstyle_lab.setForeground(new Color(0,0,0));
				panel.text_lab.setForeground(new Color(0,0,0));
				panel.rotate.setBackground(new Color(255,255,255));
				panel.vertical.setBackground(new Color(255,255,255));
				panel.horizontal.setBackground(new Color(255,255,255));
				panel.image_width_lab.setForeground(new Color(0,0,0));
				panel.image_height_lab.setForeground(new Color(0,0,0));
				panel.opacity.setForeground(new Color(0,0,0));
				
				
				
		}
}


class Dark
{
		void dark_menubar(photo_editor2 ph)
		{
				ph.mbar.setBackground(new Color(0,0,0));
				ph.save.setBackground(new Color(0,0,0));
				ph.select.setBackground(new Color(0,0,0));
				ph.canvas.setBackground(new Color(0,0,0));
				ph.filters.setBackground(new Color(0,0,0));
				ph.crop.setBackground(new Color(0,0,0));
				ph.text_watermark.setBackground(new Color(0,0,0));
				ph.image_watermark.setBackground(new Color(0,0,0));
				ph.zoom_in.setBackground(new Color(0,0,0));
				ph.zoom_out.setBackground(new Color(0,0,0));
				ph.more.setBackground(new Color(0,0,0));
				ph.dark.setBackground(new Color(0,0,0));
				ph.light.setBackground(new Color(0,0,0));
				
				
				ph.save.setForeground(new Color(255,255,255));
				ph.select.setForeground(new Color(255,255,255));
				ph.canvas.setForeground(new Color(255,255,255));
				ph.filters.setForeground(new Color(255,255,255));
				ph.crop.setForeground(new Color(255,255,255));
				ph.text_watermark.setForeground(new Color(255,255,255));
				ph.image_watermark.setForeground(new Color(255,255,255));
				ph.zoom_in.setForeground(new Color(255,255,255));
				ph.zoom_out.setForeground(new Color(255,255,255));
				ph.more.setForeground(new Color(255,255,255));
				ph.dark.setForeground(new Color(255,255,255));
				ph.light.setForeground(new Color(255,255,255));
		}
		
		void dark_panel (main_panel panel)
		{
			
				panel.img_sec.setBackground(new Color(80,80,80));
				
				panel.canvas_sec.setBackground(new Color(0,0,0));
				panel.filter_sec.setBackground(new Color(0,0,0));
				panel.crop_sec.setBackground(new Color(0,0,0));
				panel.text_sec.setBackground(new Color(0,0,0));
				panel.text_sec2.setBackground(new Color(0,0,0));
				panel.image_sec.setBackground(new Color(0,0,0));
				panel.wm_text.setBorder(new LineBorder(new Color(255,255,255),2,true));
				panel.wm_font.setBorder(new LineBorder(new Color(255,255,255),2,true));
				panel.combox.setBorder(new LineBorder(new Color(255,255,255),2,true));
				panel.rotate.setBackground(new Color(0,0,0));
				panel.vertical.setBackground(new Color(0,0,0));
				panel.horizontal.setBackground(new Color(0,0,0));
				panel.image_width.setBorder(new LineBorder(new Color(255,255,255),2,true));
				panel.image_height.setBorder(new LineBorder(new Color(255,255,255),2,true));
				panel.js.setBackground(new Color(0,0,0));
				panel.js.setBorder(new LineBorder(new Color(255,255,255),2,true));
				
				
				
				panel.canvas_sec.setForeground(new Color(255,255,255));
				panel.filter_sec.setForeground(new Color(255,255,255));
				panel.crop_sec.setForeground(new Color(255,255,255));
				panel.text_sec.setForeground(new Color(255,255,255));
				panel.text_sec2.setForeground(new Color(255,255,255));
				panel.image_sec.setForeground(new Color(255,255,255));
				panel.fsize_lab.setForeground(new Color(255,255,255));
				panel.fstyle_lab.setForeground(new Color(255,255,255));
				panel.text_lab.setForeground(new Color(255,255,255));
				panel.rotate.setForeground(new Color(255,255,255));
				panel.vertical.setForeground(new Color(255,255,255));
				panel.horizontal.setForeground(new Color(255,255,255));
				panel.image_width_lab.setForeground(new Color(255,255,255));
				panel.image_height_lab.setForeground(new Color(255,255,255));
				panel.opacity.setForeground(new Color(255,255,255));
				
				
							
		}
}


 	 //************************************************************************************************
	 //************************************************************************************************
	 //************************************************************************************************
	 //************************************************************************************************

class ImageFilter extends FileFilter
{
	
	
	public final static String JPEG="jpeg";
	public final static String JPG="jpg";
	public final static String GIF="gif";
	public final static String PNG="png";


@Override
	public boolean accept(File f)
	{
		if(f.isDirectory())
		{  return true; }
	
	
	
String extension = getExtension(f);	
	if(extension != null)
	{
		if(extension.equals(JPG) || extension.equals(JPEG) || extension.equals(GIF) || extension.equals(PNG))
		{
			return true;
		}	
		else
		{
			return false;
		}
	}
	else
	{
		return false;
	}
	}

public String getDescription()
{
	return "Image only";
}

String getExtension(File f)
{
	String ext = null;
	String s= f.getName();
	int i =s.lastIndexOf('.');
	
	if(i>0 && i<s.length()-1)
	{
		ext= s.substring(i+1).toLowerCase();
	}
	return ext;
}

}




class filterss
{
	
	BufferedImage ImageFilter(String str, BufferedImage f_image,int amount)
	{
		int width = f_image.getWidth();
				int height = f_image.getHeight();
				
			if(str.equals("BW"))
		{
			 
			for (int y = 0; y < height; y++)
			{
				for (int x = 0; x < width; x++)
					{
						int p = f_image.getRGB(x,y);
						int a = (p>>24) & 0xff;
						int r = (p>>16) & 0xff;
						int g = (p>>8) & 0xff;
						int b = p & 0xff;
						int avg = (r+g+b);
       
						if(avg>=383)
						{ p = (a<<24) | (avg<<16) | (avg<<8) | avg;
						f_image.setRGB(x,y,Color.WHITE.getRGB());
						}
						else
						{ p = (a<<24) | (avg<<16) | (avg<<8) | avg;
							f_image.setRGB(x,y,0);
						}
					}
			}
		
		}
		if( str.equals("GREYSCALE") )
		{
			
			for (int y = 0; y < height; y++)
			{
				for (int x = 0; x < width; x++)
				{
					int p = f_image.getRGB(x,y);
					int a = (p>>24) & 0xff;
					int r = (p>>16) & 0xff;
					int g = (p>>8) & 0xff;
					int b = p & 0xff;
					int avg = (r+g+b)/3;
					p = (a<<24) | (avg<<16) | (avg<<8) | avg;
					f_image.setRGB( x,y, p);
				}
			}	
			
		}
		if(str.equals("GRIDING"))
		{
				
				Graphics buff=f_image.getGraphics();
				for (int y = 0; y < height; y=y+10)
				{
					for (int x = 0; x < width;x= x+10)
					{
						int p = f_image.getRGB(x,y);
						Color c = new Color(p);
						int r=c.getRed(); int g=c.getGreen(); int b=c.getBlue();
						Color nc = new Color(r,g,b);
						buff.setColor(nc);
						//Enlarge the number of pixels
						buff.fillOval(x,y,8,8);

					}
				}
				
		}
		if(str.equals("MOSAIC"))
		{
			
			Graphics buff=f_image.getGraphics();
			for (int y = 0; y < height; y=y+10)
			{
				for (int x = 0; x < width;x= x+10)
				{
				int p = f_image.getRGB(x,y);
				Color color = new Color(p);
				buff.setColor(color);
				f_image.setRGB(x,y,p);
				buff.fillRect(x,y,10,10);
   
				}
			}
			
		}
		
		if(str.equals("NEGATIVE"))
		{
			
			for (int y = 0; y < height; y++)
			{
				for (int x = 0; x < width; x++)
				{
					int p = f_image.getRGB(x,y);
					int a = (p>>24) & 0xff;
					int r = (p>>16) & 0xff;
					int g = (p>>8) & 0xff;
					int b = p & 0xff;

					r = 255 - r;
					g = 255 - g;
					b = 255 - b;

					p = (a<<24) | (r<<16) | (g<<8) | b;
					f_image.setRGB(x, y, p);
				}
			}
		
		}
		
		if( str.equals("REDIMAGE") )
		{
				
				for (int y = 0; y < height; y++)
				{
					for (int x = 0; x < width; x++)
					{
						int p = f_image.getRGB(x,y);
						int a = (p>>24) & 0xff;
						int r = (p>>16) & 0xff;
						p = (a<<24) | (r<<16) | (0<<8) | 0;
						f_image.setRGB(x, y, p);
						
					}
				}
				
		}
		
		if(str.equals("SEPIA"))
		{
			
				//converting to sepia
				for(int y = 0; y < height; y++)
				{
					for(int x = 0; x < width; x++)
					{
						int p = f_image.getRGB(x,y);
						int a = (p>>24) & 0xff;
						int R = (p>>16) & 0xff;
						int G = (p>>8) & 0xff;
						int B = p & 0xff;

						int newR = (int)(0.393*R + 0.769*G + 0.189*B);
						int newG = (int)(0.349*R + 0.686*G + 0.168*B);
						int newB = (int)(0.272*R + 0.534*G + 0.131*B);
						if (newR > 255)
						R = 255;
						else
						R = newR;

						if (newG > 255)
						G = 255;
						else
						G = newG;

						if (newB > 255)
						B = 255;
						else
						B = newB;

						p = (a<<24) | (R<<16) | (G<<8) | B;
						f_image.setRGB(x, y, p);
					}
				}
				
		}
		
		
		
		if(str.equals("WAVEFILTER"))
		{
			
				
			WeaveFilter WF= new WeaveFilter();
			
			for(int y = 0; y < height; y++)
				{
				for(int x = 0; x < width; x++)
					{
						int p = f_image.getRGB(x,y);
						p=WF.filterRGB(x,y,p);
						f_image.setRGB(x, y, p);
					}
				}
	
	
		}
		if(str.equals("UNSHARP"))
		{
			UnsharpFilter US=new UnsharpFilter();
			f_image=US.filter(f_image,new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB));
	
			
		}
		if(str.equals("TRITONE"))
		{
			TritoneFilter TT=new TritoneFilter();
			f_image=TT.filter(f_image,new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB));
	
		}
		if(str.equals("THRESHHOLD"))
		{
			ThresholdFilter TH = new ThresholdFilter();
			for(int y = 0; y < height; y++)
				{
				for(int x = 0; x < width; x++)
					{
						int p = f_image.getRGB(x,y);
						p=TH.filterRGB(x,y,p);
						f_image.setRGB(x, y, p);
					}
				}
		}
		if(str.equals("STAMP"))
		{
			StampFilter SP=new StampFilter();
			f_image=SP.filter(f_image,new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB));
	
		}
		if(str.equals("SPARKLE"))
		{
			SparkleFilter sp= new SparkleFilter();
			sp.setDimensions(width, height);
			for(int y = 0; y < height; y++)
				{
				for(int x = 0; x < width; x++)
					{
						int p = f_image.getRGB(x,y);
						p=sp.filterRGB(x,y,p);
						f_image.setRGB(x, y, p);
					}
				}
			
		}
		if(str.equals("POSTERIZE"))
		{
			PosterizeFilter pp =new PosterizeFilter();
			for(int y = 0; y < height; y++)
				{
				for(int x = 0; x < width; x++)
					{
						int p = f_image.getRGB(x,y);
						p=pp.filterRGB(x,y,p);
						f_image.setRGB(x, y, p);
					}
				}
		}
		if(str.equals("NOISE"))
		{
			NoiseFilter nn=new NoiseFilter();
			for(int y = 0; y < height; y++)
				{
				for(int x = 0; x < width; x++)
					{
						int p = f_image.getRGB(x,y);
						p=nn.filterRGB(x,y,p);
						f_image.setRGB(x, y, p);
					}
				}
			
		}
		if(str.equals("MIRROR"))
		{
			MirrorFilter mm=new MirrorFilter();
			f_image=mm.filter(f_image,new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB));
	
			
		}
		if(str.equals("MASK"))
		{
			MaskFilter mm=new MaskFilter();
			for(int y = 0; y < height; y++)
				{
				for(int x = 0; x < width; x++)
					{
						int p = f_image.getRGB(x,y);
						p=mm.filterRGB(x,y,p);
						f_image.setRGB(x, y, p);
					}
				}
			
		}
		if(str.equals("MARBLETEX"))
		{
			MarbleTexFilter mt=new MarbleTexFilter();
			for(int y = 0; y < height; y++)
				{
				for(int x = 0; x < width; x++)
					{
						int p = f_image.getRGB(x,y);
						p=mt.filterRGB(x,y,p);
						f_image.setRGB(x, y, p);
					}
				}
			
		}
		if(str.equals("MARBLE"))
		{
			MarbleFilter m=new MarbleFilter();
			f_image=m.filter(f_image,null);
		m.setAmount(10);
			
		}
		if(str.equals("MAPCOLORS"))
		{
			MapColorsFilter mc=new MapColorsFilter();
			for(int y = 0; y < height; y++)
				{
				for(int x = 0; x < width; x++)
					{
						int p = f_image.getRGB(x,y);
						p=mc.filterRGB(x,y,p);
						f_image.setRGB(x, y, p);
					}
				}
		}
		if(str.equals("JAVALN"))
		{JavaLnFFilter mc=new JavaLnFFilter();
			for(int y = 0; y < height; y++)
				{
				for(int x = 0; x < width; x++)
					{
						int p = f_image.getRGB(x,y);
						p=mc.filterRGB(x,y,p);
						f_image.setRGB(x, y, p);
					}
				}
		}
		if(str.equals("KALEIDOSCOPE"))
		{
			KaleidoscopeFilter kd=new KaleidoscopeFilter();
			f_image=kd.filter(f_image,null);
	
		}
		if(str.equals("INVERT"))
		{
			InvertFilter in=new InvertFilter();
			for(int y = 0; y < height; y++)
				{
				for(int x = 0; x < width; x++)
					{
						int p = f_image.getRGB(x,y);
						p=in.filterRGB(x,y,p);
						f_image.setRGB(x, y, p);
					}
				}
			
		}
		if(str.equals("GRAY"))
		{
			GrayFilters gf=new GrayFilters();
			for(int y = 0; y < height; y++)
				{
				for(int x = 0; x < width; x++)
					{
						int p = f_image.getRGB(x,y);
						p=gf.filterRGB(x,y,p);
						f_image.setRGB(x, y, p);
					}
				}
			
			
		}
		if(str.equals("GLOW"))
		{
			GlowFilter gf=new GlowFilter();
			f_image=gf.filter(f_image,null);
		}
		if(str.equals("FLIP"))
		{
			FlipFilter ff=new FlipFilter();
			f_image=ff.filter(f_image,null);
		}
		if(str.equals("FLARE"))
		{
			FlareFilter ff=new FlareFilter();
			ff.setDimensions(width,height);
				for(int y = 0; y < height; y++)
				{
				for(int x = 0; x < width; x++)
					{
						int p = f_image.getRGB(x,y);
						p=ff.filterRGB(x,y,p);
						f_image.setRGB(x, y, p);
					}
				}
			
		}
		if(str.equals("FBM"))
		{
			FBMFilter fb=new FBMFilter();
				f_image=fb.filter(f_image,new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB));
	
		}
		
		if(str.equals("DITHER"))
		{
			DitherFilter  fb=new DitherFilter( );
			for(int y = 0; y < height; y++)
				{
				for(int x = 0; x < width; x++)
					{
						int p = f_image.getRGB(x,y);
						p=fb.filterRGB(x,y,p);
						f_image.setRGB(x, y, p);
					}
				}
	
		}
		
		if(str.equals("DISPLACE"))
		{
			DisplaceFilter  fb=new DisplaceFilter( );
			f_image=fb.filter(f_image,null);
		}
		
			if(str.equals("DIFFUSE"))
		{
			DiffuseFilter fb=new DiffuseFilter( );
			f_image=fb.filter(f_image,null);
		}
	
			if(str.equals("COLORHALFTONE"))
		{
			
			ColorHalftoneFilter fb=new ColorHalftoneFilter();
			//f_image=fb.filter(f_image,new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB));
	f_image=fb.filter(f_image,null);
		}
		
		if(str.equals("CHROME"))
		{
			
			ChromeFilter  fb=new ChromeFilter ();
			//f_image=fb.filter(f_image,new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB));
	f_image=fb.filter(f_image,null);
		}
		
		if(str.equals("CHECK"))
		{
			
			CheckFilter fb=new CheckFilter();
			for (int y = 0; y < height; y=y+10)
			{
				for (int x = 0; x < width;x= x+10)
				{
				int p = f_image.getRGB(x,y);
						p=fb.filterRGB(x,y,p);
						f_image.setRGB(x, y, p);
				}
			}
		} 
		if(str.equals("aa"))
		{
			
				ChannelMixFilter fb=new ChannelMixFilter();
				fb.setBlueGreen(0X03458220);
				fb.setRedBlue(0Xf00542ff);
				fb.setGreenRed(0X45362756);
				fb.setIntoB(150);
				fb.setIntoR(150);
				fb.setIntoG(292);
				
			for (int y = 0; y < height; y=y+10)
			{
				for (int x = 0; x < width;x= x+10)
				{
				int p = f_image.getRGB(x,y);
						p=fb.filterRGB(x,y,p);
						f_image.setRGB(x, y, p);
				}
			}
		}
		
		if(str.equals("saturation"))
		{
			
				
					SaturationFilter ob=new SaturationFilter(amount);
			for(int y = 0; y < height; y++)
				{
				for(int x = 0; x < width; x++)
					{
				int p = f_image.getRGB(x,y);
						p=ob.filterRGB(x,y,p);
						f_image.setRGB(x, y, p);
				}
			}
		}
		if(str.equals("brightness"))
		{
			
				
					RescaleOp br=new RescaleOp(amount,0,null);
					f_image=br.filter(f_image,null);
		}
		
		if(str.equals("contrast"))
		{
			RescaleOp br=new RescaleOp(amount,20.0f,null);
					f_image=br.filter(f_image,null);
				
					
		}
		
	

		return f_image;
		
	}
	
		

}
 