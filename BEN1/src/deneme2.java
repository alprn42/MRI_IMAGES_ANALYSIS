import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;

public class deneme2 {

    private JPanel gui;
    private JFileChooser fileChooser;
    FilenameFilter fileNameFilter;
    private JMenuBar menuBar;
    DefaultListModel model; 
    DefaultListModel model1;
   static BufferedImage o ;
    static String a;  
    
    
    
    deneme2() {
       
    	
    	gui = new JPanel(new GridLayout());

        JPanel imageViewContainer = new JPanel(new GridBagLayout());
        imageViewContainer.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        	}
        });
        final JLabel imageView = new JLabel();
        imageViewContainer.add(imageView);
        
        

        model = new DefaultListModel(); 
        final JList imageList = new JList(model);
        
        model1=new DefaultListModel();
        final JList list=new JList(model1);
        
        
        list.setPreferredSize(new Dimension(150, 200));
   
    	list.setFixedCellHeight(100); 
    	list.setBorder(new EmptyBorder(10,10, 10, 10));
        imageList.setPreferredSize(new Dimension(200,200));
        imageList.setCellRenderer(new IconCellRenderer());
        ListSelectionListener listener = new ListSelectionListener() {
        	
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                 o = (BufferedImage) imageList.getSelectedValue();
                if (o instanceof BufferedImage) {
                    imageView.setIcon(new ImageIcon((BufferedImage)o));

                    
                    
                }
            }

        };
        imageList.addListSelectionListener(listener);
        fileChooser = new JFileChooser();
        String[] imageTypes = ImageIO.getReaderFileSuffixes();
        FileNameExtensionFilter fnf = new FileNameExtensionFilter("Images", imageTypes);
        fileChooser.setFileFilter(fnf);
        File userHome = new File(System.getProperty("user.home"));
        fileChooser.setSelectedFile(userHome);



        fileNameFilter = new FilenameFilter() {
            @Override 
            public boolean accept(File file, String name) {
                return true;
            }
        };

        menuBar = new JMenuBar();
        
        JMenu mnAccount = new JMenu("My Account");
        menuBar.add(mnAccount);
        
        JMenuItem mnýtmLogOut = new JMenuItem("Log Out");
        mnýtmLogOut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        	
				userPanel up = new userPanel();
				up.setVisible(true);
			
        	}
        });
        mnAccount.add(mnýtmLogOut);
        JMenu menu = new JMenu("File");
        menuBar.add(menu);
        JMenuItem browse = new JMenuItem("Browse File");
        menu.add(browse);
        browse.addActionListener(new ActionListener(){
            @Override 
            public void actionPerformed(ActionEvent ae) {
                int result = fileChooser.showOpenDialog(gui);
                if (result==JFileChooser.APPROVE_OPTION) {
                    File eg = fileChooser.getSelectedFile();
                    // this will be an image, we want the parent directory
                    File dir = eg.getParentFile();
       
                   
                    try {
                        loadImages(dir);
                       
                    } catch(Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog( 
                                gui,  
                                e, 
                                "Load failure!", 
                                JOptionPane.ERROR_MESSAGE);
                    } 
                }
            }
        }); 
        
        JMenuItem mnıtmBrowseImage = new JMenuItem("Browse Image");
        mnıtmBrowseImage.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
                     int result = fileChooser.showOpenDialog(gui);
                     if (result==JFileChooser.APPROVE_OPTION) {
                         File eg = fileChooser.getSelectedFile();
                         // this will be an image, we want the parent directory
                        File dir = eg.getAbsoluteFile();
                       a = eg.getAbsolutePath();
                       System.out.println(a);
                        
                         try {
							model.addElement(ImageIO.read(dir));
							model1.addElement(dir.getName());
							
						
                         } catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                     }}}
        );

        menu.add(mnıtmBrowseImage);
        
        JMenuItem mnýtmDeletePhoto = new JMenuItem("Delete Image");
        mnýtmDeletePhoto.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	
        	
        		model.removeElement(imageList.getSelectedValue());
        		model1.removeElement(list.getSelectedValue());
        	
        	}
        });
        menu.add(mnýtmDeletePhoto);
        
        JMenuItem mnýtmGraphs = new JMenuItem("Select Area");
        mnýtmGraphs.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {


				for(int i=0; i<4; i++) {
				SelectedArea.values[i]=0;
			}
 		SelectedArea.main(imageTypes);
 	
        		
        		
        		
				
        	}
        });
        
        JMenuItem mnıtmDeleteAllPhotos = new JMenuItem("Delete All Images");
        mnıtmDeleteAllPhotos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		model.removeAllElements();
        		model1.removeAllElements();
        		
        	}
        });
        menu.add(mnıtmDeleteAllPhotos);
        menu.add(mnýtmGraphs);

        JScrollPane scrollPane = new JScrollPane(
                        imageList, 
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        gui.add(new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT, 
                scrollPane, 
                new JScrollPane(imageViewContainer)));
   
        scrollPane.setRowHeaderView(list);
  scrollPane.setPreferredSize(new Dimension (400,400));
     
        
    }

    public void loadImages(File directory) throws IOException {
        File[] imageFiles = directory.listFiles(fileNameFilter);
        String imageFiles2 = directory.getName();
        System.out.println(imageFiles2);
        BufferedImage[] images = new BufferedImage[imageFiles.length];
        String[] names = new String[imageFiles.length];
        model.removeAllElements();
        model1.removeAllElements();
        String[] eg = directory.list();
        
        for (int ii=0; ii<images.length; ii++) {
        	model1.add(ii, eg[ii]);
        	model.addElement(ImageIO.read(imageFiles[ii]));

        }
    }
   
//    public void loadNames(File directory) throws IOException {
//        File[] imageFiles = directory.listFiles(fileNameFilter);
//        String[] names = new String[imageFiles.length];
//        model.removeAllElements();
//        for (int ii=0; ii<names.length; ii++) {
//            model.addElement(names[ii]);
//        }
//    }
    public Container getGui() {
        return gui;
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public static void main(String[] args) {
    	SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                deneme2 imageList = new deneme2();

                JFrame f = new JFrame("Image Browser");
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               
                f.getContentPane().add(imageList.getGui());
            
                f.setJMenuBar(imageList.getMenuBar());
                f.setLocationByPlatform(true);
                f.pack();
                f.setSize(800,600);
                f.setVisible(true);
            }
        });
    }
    /**
     * @wbp.parser.entryPoint
     */
    public void run() {
        deneme2 imageList = new deneme2();

        JFrame f = new JFrame("Image Browser");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.getContentPane().add(imageList.getGui());
        f.setJMenuBar(imageList.getMenuBar());
        f.setLocationByPlatform(true);
        f.pack();
        f.setSize(584,475);
        f.setVisible(true);
    }

	
    
    
    
    
    
    
    
    
}

class IconCellRenderer extends DefaultListCellRenderer {

    private static final long serialVersionUID = 1L;

    private int size;
     BufferedImage icon;
       
    
    
    
    
    

    IconCellRenderer() {
        this(100);
    }

    IconCellRenderer(int size) {
        this.size = size;
        icon = new BufferedImage(size,size,BufferedImage.TYPE_INT_ARGB);
    }
    
    
    
    
   
    
    
    @Override
    public Component getListCellRendererComponent(
            JList list, 
            Object value, 
            int index, 
            boolean isSelected, 
            boolean cellHasFocus) {
        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (c instanceof JLabel && value instanceof BufferedImage) {
            JLabel l = (JLabel)c;
        
            
            
            BufferedImage i = (BufferedImage)value;
            l.setIcon(new ImageIcon(icon));
           l.setText("");
            Graphics2D g = icon.createGraphics();
            g.setColor(new Color(0,0,0,0));
            g.clearRect(0, 0, size, size);
            g.drawImage(i,0,0,size,size,this);
            g.dispose();
            
            
        
            
        }
        return c;
    }
   
    @Override 
    public Dimension getPreferredSize() {
        return new Dimension(size, size);
    }
}