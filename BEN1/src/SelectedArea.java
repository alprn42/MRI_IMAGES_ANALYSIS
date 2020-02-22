import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;

public class SelectedArea extends JFrame {

	private JFrame frmSelectAreaIn;
	private JPanel selectedAreaPanel;
	static JPanel selected1;
	static Component c;
	int check=0;
	private JButton btnAddTo;
	private JButton btnAddTo_1;
	private JButton btnAddTo_2;
	static JPanel selected2;
	private JPanel selected3;
	private JPanel selected4;
	private JButton btnAnalyse;
	static BufferedImage x1;
	BufferedImage x2;
	BufferedImage x3; 
	BufferedImage x4;
	static double grey=0;
	static double values []=new double [4];
	private JButton btnColor_1;
	private JButton btnColor_2;
	private JButton btnColor_3;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel lblcoloredTypesOf;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JPanel panel_13;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectedArea window = new SelectedArea();
					window.frmSelectAreaIn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace(); 
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public SelectedArea() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frmSelectAreaIn = new JFrame();
		frmSelectAreaIn.setTitle("Select Area In Image");
		frmSelectAreaIn.setBounds(100, 100, 2000, 2000);
		frmSelectAreaIn.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frmSelectAreaIn.getContentPane().setLayout(null);
		
		deneme2 x= new deneme2();
	
		// Image Panel display image with graphics
		JPanel mainPanel = new ImagePanel( x.o, this);
		mainPanel.setBounds(10, 11, 1270, 718);
		frmSelectAreaIn.getContentPane().add(mainPanel); 
		
		JLabel lblSelectedArea = new JLabel("Selected Area");
		lblSelectedArea.setBounds(1330, 11, 221, 14);
		lblSelectedArea.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSelectedArea.setHorizontalAlignment(SwingConstants.CENTER);
		frmSelectAreaIn.getContentPane().add(lblSelectedArea);
		
		
		JButton btnAdd = new JButton("Add to 1");
		btnAdd.setBounds(1674, 49, 89, 23);
		btnAdd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {

	updateSelectedRegion1(ImagePanel.nb);
	x1=ImagePanel.nb;

//	System.out.println(x1.getRGB(0, 0));
//	System.out.println(x1.getRGB(10, 10));
//	System.out.println(x1.getWidth());
//	System.out.println(x1.getHeight());


double r=0;
double gr=0;
double b=0;
double sum=0;
final double gw=x1.getWidth();
final double gh = x1.getHeight();
double  list1[][]=new double [(int) gw][(int) gh];
//System.out.println(gh);
//System.out.println(gw);

	for(int i=0;i<gw-1;i++) {
		for(int ii= (int) (gh-1);ii>0;ii--) {
     	Color c=new Color(x1.getRGB(i, ii));
		 r=c.getRed();
			 gr=c.getGreen();
			 b=c.getBlue();
			grey=(r+gr+b)/3;
//          	 System.out.print(r+" ");
//			 System.out.print(b+" ");
//			 System.out.print(gr+" ");
//			 System.out.println();
			
			list1[i][ii]=grey;
			sum+=grey; 
			

		}
	}
	
	int x = 0;
    int y = 0;
    int x1=0;
    int y1=0;
System.out.println(getMaxValue(list1)+"asdasf");
	for(int i=10;i<gw-10;i++) {
		for(int ii=10;ii<gh-10;ii++) {
		if(list1[i][ii]==getMaxValue(list1)) {
			 x=i;
		    y=ii;
		}
		}
		}
	
	for(int i=15;i<gw-15;i++) {
		for(int ii=15;ii<gh-15;ii++) {
			System.out.println("aaaaa");
		if(list1[i][ii]>0 &&list1[i][ii]<50) {
			 x1=i;
		    y1=ii;
		}
		}
		}
	System.out.println(getMinValue(list1)+"min");
	System.out.println(x1);
	System.out.println(y1);
	System.out.println();
System.out.println(x);
System.out.println(y);
	System.out.println("-------"+sum/(gw*gh)+"----------------");
values[0]=sum/(gw*gh);
maxSelectedRegion1(selected1,x,y);
minSelectedRegion1(selected1,x1,y1);
			}
		});
		frmSelectAreaIn.getContentPane().add(btnAdd);
		
		btnAddTo = new JButton("Add to 2");
		btnAddTo.setBounds(1674, 83, 89, 23);
		btnAddTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			updateSelectedRegion2(ImagePanel.nb);
			x2=ImagePanel.nb;
			double r=0;
			double gr=0;
			double b=0;
			double sum=0;
			final int gw=x2.getWidth();
			final int gh = x2.getHeight();
			double  list1[][]=new double [(int) gw][(int) gh];
				for(int i=0;i<gw-1;i++) {
					for(int ii= gh-1;ii>0;ii--) {
			     	Color c=new Color(x2.getRGB(i, ii));
					 r=c.getRed();
						 gr=c.getGreen();
						 b=c.getBlue();
						 System.out.print(r+" ");
						 System.out.print(b+" ");
						 System.out.print(gr+" ");
						 System.out.println();
						grey=(r+gr+b)/3;
						list1[i][ii]=grey;
						sum+=grey; 
						
					}
				}
				int x = 0;
			    int y = 0;
			    int x1=0;
			    int y1=0;
			System.out.println(getMaxValue(list1)+"asdasf");
				for(int i=10;i<gw-10;i++) {
					for(int ii=10;ii<gh-10;ii++) {
					if(list1[i][ii]==getMaxValue(list1)) {
						 x=i;
					    y=ii;
					}
					}
					}
				
				for(int i=15;i<gw-15;i++) {
					for(int ii=15;ii<gh-15;ii++) {
						
					if(list1[i][ii]>0 &&list1[i][ii]<50) {
						 x1=i;
					    y1=ii;
					}
					}
					}
				System.out.println(getMinValue(list1)+"min");
				System.out.println(x1);
				System.out.println(y1);
				System.out.println();
			System.out.println(x);
			System.out.println(y);
				
			maxSelectedRegion2(selected2,x,y);
			minSelectedRegion2(selected2,x1,y1);
	
				System.out.println("-------"+sum/(gw*gh)+"----------------");
				values[1]=sum/(gw*gh);
			}
		});
		frmSelectAreaIn.getContentPane().add(btnAddTo);
		
		btnAddTo_1 = new JButton("Add to 3");
		btnAddTo_1.setBounds(1674, 117, 89, 23);
		btnAddTo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateSelectedRegion3(ImagePanel.nb);
				x3=ImagePanel.nb;
				double r=0;
				double gr=0;
				double b=0;
				double sum=0;
				final int gw=x3.getWidth();
				final int gh = x3.getHeight();
				double  list1[][]=new double [(int) gw][(int) gh];
					for(int i=0;i<gw-1;i++) {
						for(int ii= gh-1;ii>0;ii--) {
				     	Color c=new Color(x3.getRGB(i, ii));
						 r=c.getRed();
							 gr=c.getGreen();
							 b=c.getBlue();
							 System.out.print(r+" ");
							 System.out.print(b+" ");
							 System.out.print(gr+" ");
							 System.out.println();
							grey=(r+gr+b)/3;
							list1[i][ii]=grey;
							sum+=grey; 
							
						}
					}
					int x = 0;
				    int y = 0;
				    int x1=0;
				    int y1=0;
				System.out.println(getMaxValue(list1)+"asdasf");
					for(int i=10;i<gw-10;i++) {
						for(int ii=10;ii<gh-10;ii++) {
						if(list1[i][ii]==getMaxValue(list1)) {
							 x=i;
						    y=ii;
						}
						}
						}
					
					for(int i=15;i<gw-15;i++) {
						for(int ii=15;ii<gh-15;ii++) {
							
						if(list1[i][ii]>0 &&list1[i][ii]<50) {
							 x1=i;
						    y1=ii;
						}
						}
						}
					System.out.println(getMinValue(list1)+"min");
					System.out.println(x1);
					System.out.println(y1);
					System.out.println();
				System.out.println(x);
				System.out.println(y);
					
				maxSelectedRegion3(selected3,x,y);
				minSelectedRegion3(selected3,x1,y1);
					
		
					System.out.println("-------"+sum/(gw*gh)+"----------------");
					values[2]=sum/(gw*gh);
			}
		});
		frmSelectAreaIn.getContentPane().add(btnAddTo_1);
		
		btnAddTo_2 = new JButton("Add to 4");
		btnAddTo_2.setBounds(1674, 151, 89, 23);
		btnAddTo_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateSelectedRegion4(ImagePanel.nb);
				x4=ImagePanel.nb;
				double r=0;
				double gr=0;
				double b=0;
				double sum=0;
				final int gw=x4.getWidth();
				final int gh = x4.getHeight();
				double  list1[][]=new double [(int) gw][(int) gh];
					for(int i=0;i<gw-1;i++) {
						for(int ii= gh-1;ii>0;ii--) {
				     	Color c=new Color(x4.getRGB(i, ii));
						 r=c.getRed();
							 gr=c.getGreen();
							 b=c.getBlue();
							 System.out.print(r+" ");
							 System.out.print(b+" ");
							 System.out.print(gr+" ");
							 System.out.println();
							 list1[i][ii]=grey;
							grey=(r+gr+b)/3;
							sum+=grey; 
							
						}
					}
					int x = 0;
				    int y = 0;
				    int x1=0;
				    int y1=0;
				System.out.println(getMaxValue(list1)+"asdasf");
					for(int i=10;i<gw-10;i++) {
						for(int ii=10;ii<gh-10;ii++) {
						if(list1[i][ii]==getMaxValue(list1)) {
							 x=i;
						    y=ii;
						}
						}
						}
					
					for(int i=15;i<gw-15;i++) {
						for(int ii=15;ii<gh-15;ii++) {
							
						if(list1[i][ii]>0 &&list1[i][ii]<50) {
							 x1=i;
						    y1=ii;
						}
						}
						}
					System.out.println(getMinValue(list1)+"min");
					System.out.println(x1);
					System.out.println(y1);
					System.out.println();
				System.out.println(x);
				System.out.println(y);
					
				maxSelectedRegion4(selected4,x,y);
				minSelectedRegion4(selected4,x1,y1);
		
					System.out.println("-------"+sum/(gw*gh)+"----------------");
					values[3]=sum/(gw*gh);
			}
		});
		frmSelectAreaIn.getContentPane().add(btnAddTo_2);
		System.out.println(x1);
		System.out.println(values[0]);
		btnAnalyse = new JButton("Analyse");
		btnAnalyse.setForeground(Color.WHITE);
		btnAnalyse.setBackground(Color.BLACK);
		btnAnalyse.setBounds(1732, 185, 89, 23);
		btnAnalyse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		Analyze.main(null);
				

			
			}
		});
		frmSelectAreaIn.getContentPane().add(btnAnalyse);
		
		JButton btnColor = new JButton("Color 1");
		btnColor.setBounds(1783, 49, 89, 23);
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				double r = 0;
				double gr = 0;
				double b = 0;
				double sum = 0;
				final int gw1 = x1.getWidth();
				final int gh1 = x1.getHeight();

				for (int i = 0; i < gw1 - 1; i++) {
					for (int ii = gh1 - 1; ii > 0; ii--) {
						Color c = new Color(x1.getRGB(i, ii));
						r = c.getRed();
						gr = c.getGreen();
						b = c.getBlue();
						grey = (r + gr + b) / 3;
						if (grey < 86) {

							int p = x1.getRGB(i, ii);

							int a = (p >> 24) & 0xff;
							int g = (p >> 8) & 0xff;
							p = (a << 24) | (0 << 16) | (g << 8) | 0;
							x1.setRGB(i, ii, p);
							updateSelectedRegion11(x1);
						}
						if (grey > 85 && grey < 171) {
							int p = x1.getRGB(i, ii);
							int a = (p >> 24) & 0xff;
							int rr = (p >> 16) & 0xff;
							p = (a << 24) | (rr << 16) | (0 << 8) | 0;
							x1.setRGB(i, ii, p);

							updateSelectedRegion11(x1);
						}

						if (grey > 170 && grey < 260) {

							int p = x1.getRGB(i, ii);

							int a = (p >> 24) & 0xff;
							int bb = (p >> 16) & 0xff;
							p = (a << 24) | (0 << 16) | (0 << 8) | bb;

							x1.setRGB(i, ii, p);
							updateSelectedRegion11(x1);
						}
					}
				}
			}
		});
		frmSelectAreaIn.getContentPane().add(btnColor);
		
		btnColor_1 = new JButton("Color 2");
		btnColor_1.setBounds(1783, 83, 89, 23);
		btnColor_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				double r = 0;
				double gr = 0;
				double b = 0;
				double sum = 0;
				final int gw2 = x2.getWidth();
				final int gh2 = x2.getHeight();

				for (int i = 0; i < gw2 - 1; i++) {
					for (int ii = gh2 - 1; ii > 0; ii--) {
						Color c = new Color(x2.getRGB(i, ii));
						r = c.getRed();
						gr = c.getGreen();
						b = c.getBlue();
						grey = (r + gr + b) / 3;
						if (grey < 86) {

							int p = x2.getRGB(i, ii);

							int a = (p >> 24) & 0xff;
							int g = (p >> 8) & 0xff;
							p = (a << 24) | (0 << 16) | (g << 8) | 0;
							x2.setRGB(i, ii, p);
							updateSelectedRegion22(x2);
						}
						if (grey > 85 && grey < 171) {
							int p = x2.getRGB(i, ii);
							int a = (p >> 24) & 0xff;
							int rr = (p >> 16) & 0xff;
							p = (a << 24) | (rr << 16) | (0 << 8) | 0;
							x2.setRGB(i, ii, p);

							updateSelectedRegion22(x2);
						}

						if (grey > 170 && grey < 260) {

							int p = x2.getRGB(i, ii);

							int a = (p >> 24) & 0xff;
							int bb = (p >> 16) & 0xff;
							p = (a << 24) | (0 << 16) | (0 << 8) | bb;

							x2.setRGB(i, ii, p);
							updateSelectedRegion22(x2);
						}
					}
				}
				
				
				
			}
		});
		frmSelectAreaIn.getContentPane().add(btnColor_1);
		
		btnColor_2 = new JButton("Color 3");
		btnColor_2.setBounds(1783, 117, 89, 23);
		btnColor_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double r = 0;
				double gr = 0;
				double b = 0;
				double sum = 0;
				final int gw3 = x3.getWidth();
				final int gh3 = x3.getHeight();

				for (int i = 0; i < gw3 - 1; i++) {
					for (int ii = gh3 - 1; ii > 0; ii--) {
						Color c = new Color(x3.getRGB(i, ii));
						r = c.getRed();
						gr = c.getGreen();
						b = c.getBlue();
						grey = (r + gr + b) / 3;
						if (grey < 86) {

							int p = x3.getRGB(i, ii);

							int a = (p >> 24) & 0xff;
							int g = (p >> 8) & 0xff;
							p = (a << 24) | (0 << 16) | (g << 8) | 0;
							x3.setRGB(i, ii, p);
							updateSelectedRegion33(x3);
						}
						if (grey > 85 && grey < 171) {
							int p = x3.getRGB(i, ii);
							int a = (p >> 24) & 0xff;
							int rr = (p >> 16) & 0xff;
							p = (a << 24) | (rr << 16) | (0 << 8) | 0;
							x3.setRGB(i, ii, p);

							updateSelectedRegion33(x3);
						}

						if (grey > 170 && grey < 260) {

							int p = x3.getRGB(i, ii);

							int a = (p >> 24) & 0xff;
							int bb = (p >> 16) & 0xff;
							p = (a << 24) | (0 << 16) | (0 << 8) | bb;

							x3.setRGB(i, ii, p);
							updateSelectedRegion33(x3);
						}
					}
				}
				
				
				
			}
		});
		frmSelectAreaIn.getContentPane().add(btnColor_2);
		
		btnColor_3 = new JButton("Color 4");
		btnColor_3.setBounds(1783, 151, 89, 23);
		btnColor_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double r = 0;
				double gr = 0;
				double b = 0;
				double sum = 0;
				final int gw4 = x4.getWidth();
				final int gh4 = x4.getHeight();

				for (int i = 0; i < gw4 - 1; i++) {
					for (int ii = gh4 - 1; ii > 0; ii--) {
						Color c = new Color(x4.getRGB(i, ii));
						r = c.getRed();
						gr = c.getGreen();
						b = c.getBlue();
						grey = (r + gr + b) / 3;
						if (grey < 86) {

							int p = x4.getRGB(i, ii);

							int a = (p >> 24) & 0xff;
							int g = (p >> 8) & 0xff;
							p = (a << 24) | (0 << 16) | (g << 8) | 0;
							x4.setRGB(i, ii, p);
							updateSelectedRegion44(x4);
						}
						if (grey > 85 && grey < 171) {
							int p = x4.getRGB(i, ii);
							int a = (p >> 24) & 0xff;
							int rr = (p >> 16) & 0xff;
							p = (a << 24) | (rr << 16) | (0 << 8) | 0;
							x4.setRGB(i, ii, p);

							updateSelectedRegion44(x4);
						}

						if (grey > 170 && grey < 260) {

							int p = x4.getRGB(i, ii);

							int a = (p >> 24) & 0xff;
							int bb = (p >> 16) & 0xff;
							p = (a << 24) | (0 << 16) | (0 << 8) | bb;

							x4.setRGB(i, ii, p);
							updateSelectedRegion44(x4);
						}
					}
				}
				
				
				
			}
		});
		frmSelectAreaIn.getContentPane().add(btnColor_3);
		
		lblcoloredTypesOf = new JLabel("---------------          Colored Types of Selected Areas          ---------------");
		lblcoloredTypesOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblcoloredTypesOf.setBounds(889, 776, 745, 25);
		lblcoloredTypesOf.setFont(new Font("Tahoma", Font.BOLD, 18));
		frmSelectAreaIn.getContentPane().add(lblcoloredTypesOf);
		
		panel_5 = new JPanel();
		panel_5.setToolTipText("");
		panel_5.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "1", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(1306, 232, 249, 228);
		frmSelectAreaIn.getContentPane().add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		selected1 = new JPanel();
		selected1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_5.add(selected1, BorderLayout.CENTER);
		selected1.setToolTipText("");
		selected1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		Component[] components = selected1.getComponents();  
		
		panel_6 = new JPanel();
		panel_6.setToolTipText("");
		panel_6.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "3", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6.setBounds(1623, 232, 249, 228);
		frmSelectAreaIn.getContentPane().add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		selected3 = new JPanel();
		panel_6.add(selected3, BorderLayout.CENTER);
		selected3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		panel_7 = new JPanel();
		panel_7.setToolTipText("");
		panel_7.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "2", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_7.setBounds(1306, 501, 249, 228);
		frmSelectAreaIn.getContentPane().add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		selected2 = new JPanel();
		panel_7.add(selected2, BorderLayout.CENTER);
		selected2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		panel_8 = new JPanel();
		panel_8.setToolTipText("");
		panel_8.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "4", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_8.setBounds(1623, 501, 249, 228);
		frmSelectAreaIn.getContentPane().add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		selected4 = new JPanel();
		panel_8.add(selected4, BorderLayout.CENTER);
		selected4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		panel_9 = new JPanel();
		panel_9.setToolTipText("");
		panel_9.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "1", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_9.setBounds(622, 814, 249, 228);
		frmSelectAreaIn.getContentPane().add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel_9.add(panel_1, BorderLayout.CENTER);
		panel_1.setToolTipText("");
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		panel_10 = new JPanel();
		panel_10.setToolTipText("");
		panel_10.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "2", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_10.setBounds(968, 814, 249, 228);
		frmSelectAreaIn.getContentPane().add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		panel_10.add(panel_2, BorderLayout.CENTER);
		panel_2.setToolTipText("");
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		panel_11 = new JPanel();
		panel_11.setToolTipText("");
		panel_11.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "3", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_11.setBounds(1302, 814, 249, 228);
		frmSelectAreaIn.getContentPane().add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		panel_3 = new JPanel();
		panel_11.add(panel_3, BorderLayout.CENTER);
		panel_3.setToolTipText("");
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		panel_12 = new JPanel();
		panel_12.setToolTipText("");
		panel_12.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "4", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_12.setBounds(1623, 814, 249, 228);
		frmSelectAreaIn.getContentPane().add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		panel_4 = new JPanel();
		panel_12.add(panel_4, BorderLayout.CENTER);
		panel_4.setToolTipText("");
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		panel_13 = new JPanel();
		panel_13.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_13.setBounds(1306, 36, 321, 172);
		frmSelectAreaIn.getContentPane().add(panel_13);
		panel_13.setLayout(new BorderLayout(0, 0));
		
	
		
		
		// Image Panel display selected area of the image
		selectedAreaPanel = new JPanel();
		panel_13.add(selectedAreaPanel, BorderLayout.CENTER);
		selectedAreaPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel lblForGraph = new JLabel("---------------          Intensity Values          ---------------");
		lblForGraph.setHorizontalAlignment(SwingConstants.LEFT);
		lblForGraph.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblForGraph.setBounds(86, 781, 523, 14);
		frmSelectAreaIn.getContentPane().add(lblForGraph);
		
		JLabel lblBlack = new JLabel("0     --> BLACK");
		lblBlack.setHorizontalAlignment(SwingConstants.LEFT);
		lblBlack.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblBlack.setBounds(254, 839, 221, 14);
		frmSelectAreaIn.getContentPane().add(lblBlack);
		
		JLabel lblWhte = new JLabel("255 --> WHITE");
		lblWhte.setBackground(Color.BLACK);
		lblWhte.setForeground(new Color(128, 128, 128));
		lblWhte.setHorizontalAlignment(SwingConstants.LEFT);
		lblWhte.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblWhte.setBounds(254, 866, 221, 14);
		frmSelectAreaIn.getContentPane().add(lblWhte);
		
		JLabel lblForColoredTypes = new JLabel("For Colored Types:");
		lblForColoredTypes.setHorizontalAlignment(SwingConstants.LEFT);
		lblForColoredTypes.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblForColoredTypes.setBounds(254, 924, 221, 23);
		frmSelectAreaIn.getContentPane().add(lblForColoredTypes);
		
		JLabel lblGreen = new JLabel("0-85       --> GREEN");
		lblGreen.setForeground(Color.GREEN);
		lblGreen.setHorizontalAlignment(SwingConstants.LEFT);
		lblGreen.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblGreen.setBounds(254, 951, 221, 14);
		frmSelectAreaIn.getContentPane().add(lblGreen);
		
		JLabel lblRed = new JLabel("86-170   --> RED");
		lblRed.setForeground(Color.RED);
		lblRed.setHorizontalAlignment(SwingConstants.LEFT);
		lblRed.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblRed.setBounds(254, 978, 221, 14);
		frmSelectAreaIn.getContentPane().add(lblRed);
		
		JLabel lblBlue = new JLabel("171-255 --> BLUE");
		lblBlue.setForeground(Color.BLUE);
		lblBlue.setHorizontalAlignment(SwingConstants.LEFT);
		lblBlue.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblBlue.setBounds(254, 1005, 221, 14);
		frmSelectAreaIn.getContentPane().add(lblBlue);
		
	}
	  BufferedImage createImage(JPanel panel) {    
	        int w = panel.getWidth();
	        int h = panel.getHeight();
	        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	        Graphics2D g = bi.createGraphics();
	        panel.paint(g);
	        return bi;
	    }
	  public void maxSelectedRegion1(JPanel a,int x,int y) {
			Graphics g = selectedAreaPanel.getGraphics();
			g.setColor(Color.ORANGE);
	g.drawRect(x, y, 5, 5);	
		}
	  public void minSelectedRegion1(JPanel a,int x,int y) {
			Graphics g = selectedAreaPanel.getGraphics();
			g.setColor(Color.BLUE);
	g.drawRect(x, y, 5, 5);	
		}
	  public void maxSelectedRegion2(JPanel a,int x,int y) {
			Graphics g = selectedAreaPanel.getGraphics();
			g.setColor(Color.ORANGE);
	g.drawRect(x, y, 5, 5);	
		}
	  public void minSelectedRegion2(JPanel a,int x,int y) {
			Graphics g = selectedAreaPanel.getGraphics();
			g.setColor(Color.BLUE);
	g.drawRect(x, y, 5, 5);	
		}
	  public void maxSelectedRegion3(JPanel a,int x,int y) {
			Graphics g = selectedAreaPanel.getGraphics();
			g.setColor(Color.ORANGE);
	g.drawRect(x, y, 5, 5);	
		}
	  public void minSelectedRegion3(JPanel a,int x,int y) {
			Graphics g = selectedAreaPanel.getGraphics();
			g.setColor(Color.BLUE);
	g.drawRect(x, y, 5, 5);	
		}
	  public void maxSelectedRegion4(JPanel a,int x,int y) {
			Graphics g = selectedAreaPanel.getGraphics();
			g.setColor(Color.ORANGE);
	g.drawRect(x, y, 5, 5);	
		}
	  public void minSelectedRegion4(JPanel a,int x,int y) {
			Graphics g = selectedAreaPanel.getGraphics();
			g.setColor(Color.BLUE);
	g.drawRect(x, y, 5, 5);	
		}
	public void updateSelectedRegion1(BufferedImage bufferedImage) {
		Graphics g = selected1.getGraphics();
	
		g.clearRect(0, 0, 400, 400);
    	g.drawImage(bufferedImage.getScaledInstance(selected1.getWidth(),selected1.getHeight(),Image.SCALE_SMOOTH), 0, 0, null);
	}
	public void updateSelectedRegion2(BufferedImage bufferedImage) {
		Graphics g = selected2.getGraphics();
		g.clearRect(0, 0, 400, 400);
    	g.drawImage(bufferedImage.getScaledInstance(selected2.getWidth(),selected2.getHeight(),Image.SCALE_SMOOTH), 0, 0, null);
	}
	public void updateSelectedRegion3(BufferedImage bufferedImage) {
		Graphics g = selected3.getGraphics();
		g.clearRect(0, 0, 400, 400);
    	g.drawImage(bufferedImage.getScaledInstance(selected3.getWidth(),selected3.getHeight(),Image.SCALE_SMOOTH), 0, 0, null);
	}
	public void updateSelectedRegion4(BufferedImage bufferedImage) {
		Graphics g = selected4.getGraphics();
		g.clearRect(0, 0, 400, 400);
    	g.drawImage(bufferedImage.getScaledInstance(selected4.getWidth(),selected4.getHeight(),Image.SCALE_SMOOTH), 0, 0, null);
	}
	
	
	
	public void updateSelectedRegion11(BufferedImage bufferedImage) {
		Graphics g = panel_1.getGraphics();
		g.clearRect(0, 0, 400, 400);
    	g.drawImage(bufferedImage.getScaledInstance(panel_1.getWidth(),panel_1.getHeight(),Image.SCALE_SMOOTH), 0, 0, null);
	}
	public void updateSelectedRegion22(BufferedImage bufferedImage) {
		Graphics g = panel_2.getGraphics();
		g.clearRect(0, 0, 400, 400);
    	g.drawImage(bufferedImage.getScaledInstance(panel_2.getWidth(),panel_2.getHeight(),Image.SCALE_SMOOTH), 0, 0, null);
	}
	public void updateSelectedRegion33(BufferedImage bufferedImage) {
		Graphics g = panel_3.getGraphics();
		g.clearRect(0, 0, 400, 400);
    	g.drawImage(bufferedImage.getScaledInstance(panel_3.getWidth(),panel_3.getHeight(),Image.SCALE_SMOOTH), 0, 0, null);
	}
	public void updateSelectedRegion44(BufferedImage bufferedImage) {
		Graphics g = panel_4.getGraphics();
		g.clearRect(0, 0, 400, 400);
    	g.drawImage(bufferedImage.getScaledInstance(panel_4.getWidth(),panel_4.getHeight(),Image.SCALE_SMOOTH), 0, 0, null);
	}
	
	public static double getMaxValue(double[][] list1) {
        double maxValue = list1[0][0];
        for (int j = 0; j < list1.length; j++) {
            for (int i = 0; i < list1[j].length; i++) {
                if (list1[j][i] > maxValue) {
                    maxValue = list1[j][i];
                }
            }
        }
        return maxValue;
    }
	
	  public static double getMinValue(double[][] list1) {
	        double minValue = list1[0][0];
	        for (int j = 0; j < list1.length; j++) {
	            for (int i = 0; i < list1[j].length; i++) {
	                if (list1[j][i] < minValue ) {
	                    minValue = list1[j][i];
	                }
	            }
	        }
	        return minValue ;
	    }
	
	
	
	
	
	public void updateSelectedRegion(BufferedImage bufferedImage) {
		Graphics g = selectedAreaPanel.getGraphics();
		g.clearRect(0, 0, 400, 400);
    	g.drawImage(bufferedImage, 0, 0, null);
    
    	

	}

	public void run() {
		try {
			SelectedArea window = new SelectedArea();
			window.frmSelectAreaIn.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}