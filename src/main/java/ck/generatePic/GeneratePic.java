package ck.generatePic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * generate a picture according to the input text.
 * @author ck
 * @date 2015-4-29 19:56:26
 */
public class GeneratePic {
	private int height = 80;			//height of the picture
	private int width = 80;				//width of the picture 
	
	
	
	public int getHeight() {
		return height;
	}



	public void setHeight(int height) {
		this.height = height;
	}



	public int getWidth() {
		return width;
	}



	public void setWidth(int width) {
		this.width = width;
	}



	public BufferedImage generate(String text){
		Font font = new Font("Serif", Font.BOLD, 10);
		BufferedImage bi = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = (Graphics2D) bi.getGraphics();

		// 开始绘图
		g2.setBackground(Color.WHITE);
		g2.clearRect(0, 0, width, height);
		g2.setPaint(new Color(0, 0, 255));
		g2.fillRect(0, 0, 100, 10);
		g2.setPaint(new Color(253, 2, 0));
		g2.fillRect(0, 10, 100, 10);
		g2.setPaint(Color.red);

		FontRenderContext context = g2.getFontRenderContext();
		Rectangle2D bounds = font.getStringBounds(text, context);
		double x = (width - bounds.getWidth()) / 2;
		double y = (height - bounds.getHeight()) / 2;
		double ascent = -bounds.getY();
		double baseY = y + ascent;
		
		g2.drawString(text, (int)x, (int)baseY);  
		 
		return bi;	
	}
	
	public boolean savaPic(BufferedImage bi, String file) {
		try {
			return ImageIO.write(bi, "jpg", new File(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}		
	}	
}
