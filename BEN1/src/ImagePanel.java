import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException; 

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private BufferedImage image;
    private Shape shape = null;
    Point startDrag, endDrag;
	static BufferedImage nb;
	public ImagePanel( BufferedImage a, SelectedArea selectedArea) throws IOException {
		final SelectedArea mf = selectedArea;
		image = a;
	
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				startDrag = new Point(e.getX(), e.getY());
				endDrag = startDrag;
				repaint();
			}

			
			
			
			public void mouseReleased(MouseEvent e) {
				if(endDrag!=null && startDrag!=null) {
					try {
						shape = makeRectangle(startDrag.x, startDrag.y, e.getX(),
								e.getY());
						BufferedImage resized = resize(image, 720, 1200);
					 nb= resized.getSubimage(startDrag.x, startDrag.y, e.getX()-startDrag.x, e.getY()-startDrag.y);
						mf.updateSelectedRegion(resized.getSubimage(startDrag.x, startDrag.y, e.getX()-startDrag.x, e.getY()-startDrag.y));	
						
						startDrag = null;
						endDrag = null;
						repaint();
					} catch (Exception e1) {
						e1.printStackTrace();
					}	
				}
			}
		});

		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				endDrag = new Point(e.getX(), e.getY());
				repaint();
			}	
		});
		
	}

	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		BufferedImage resized = resize(image, 720, 1200);
		g2.drawImage(resized, 0, 0, null);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		 
		g2.setStroke(new BasicStroke(2));
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
				0.50f));

		if (shape != null) {
			g2.setPaint(Color.BLACK);
			g2.draw(shape);
			g2.setPaint(Color.YELLOW);
			g2.fill(shape);
		}
		
		if (startDrag != null && endDrag != null) {
			g2.setPaint(Color.LIGHT_GRAY);
			Shape r = makeRectangle(startDrag.x, startDrag.y, endDrag.x,
					endDrag.y);
			g2.draw(r);
		}
		
	}
	  private static BufferedImage resize(BufferedImage img, int height, int width) {
	        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	        Graphics2D g2d = resized.createGraphics();
	        g2d.drawImage(tmp, 0, 0, null);
	        g2d.dispose();
	        return resized;
	    }

	private Rectangle2D.Float makeRectangle(int x1, int y1, int x2, int y2) {
		return new Rectangle2D.Float(Math.min(x1, x2), Math.min(y1, y2),
				Math.abs(x1 - x2), Math.abs(y1 - y2));
	}
	
}