package pixelsortmkII;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
//import java.math.*;
//import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Random;
//import pixelsortmkII.Quicksort;


public class Pixelsort2 {
	public static void main(String[] args) throws IOException {
		BufferedImage c = ImageIO.read(new File("0.png"));
		Random r = new Random();
		
		
		//			########################################################	DIMENSIONS	
		int h = c.getHeight();									//	h = height
		int w = c.getWidth();									//	w = width
		/*boolean tall = false;
		boolean wide = !tall;
		int ls = w;												//	ls = long side
		int ss = h;												//	ss = short side
		if (w<h){
			ls=h;
			ss=w;
			tall = wide;
			wide = !tall;
		}*/
		//int hxw = h*w;											//	hxw = total number of pixels, heigh times width
		//int zd = ls-ss;											//	zd = siZe difference
		//			#######################################################		SORT TYPES
		final int M = 8;										//	number of options
		int method = r.nextInt(M);								//	find sorting method to be used
		//method = 9;
		char[] name = new char[26];								//	for output file so program can be run multiple times in succession
		name[0] = 'a';											//	set up name
		for (int i = 1; i<26; i++){
			name[i] = name[i-1];
			name[i]++;
		}
		int[][] img = new int[h][w];
		for(int i =0; i<h; i++){
		for(int j =0; j<w; j++){
			img[i][j] = c.getRGB(j, i);
		}
		}
		Sort_and_Reassemble x = new Sort_and_Reassemble(h,w,img);
		
		switch(method){
		case 0:
			System.out.println("Horizontal Sort");
			img = x.horzSort();
			break;
		case 1:
			System.out.println("Vertical Sort");
			img = x.vertSort();
			break;
		case 2:
			System.out.println("Hori-Vertical Sort");
			img = x.hvSort();
			break;
		case 3:
			System.out.println("Vert-Horizontal Sort");
			img = x.vhSort();
			break;
		case 4:
			System.out.println("Long Sort V");
			img = x.longSortV();
			break;
		case 5:
			System.out.println("Long Sort H");
			img = x.longSortH();
			break;
		case 6:
			System.out.println("N-Squared Sort - H");
			img = x.n2sortH();
			break;
		case 7:
			System.out.println("N-Squared Sort - V");
			img = x.n2sortV();
			break;
		case 8:
			System.out.println("adSort3");
			img = x.adSort3();
			break;
		case 9:
			System.out.println("adSort4");
			img = x.adSort4();
			break;
		
		default:
			System.out.println("No Sort");
			img = x.noSort();
			break;
		}
		
		for(int i=0; i<h; i++){
		for(int j=0; j<w; j++){
			c.setRGB(j, i, img[i][j]);
		}
		}
		ImageIO.write(c, "png", new File(method+"t.png"));
		
		System.out.println("done");
		
		
	}
}
