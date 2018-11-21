package Bite_Beat_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Game extends Thread {

	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image FlareImage;
	private Image judgeImage;
	private Image keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();

	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	private int gameScore = 0;
	private int gameExp = gameScore / 2;
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	
	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);		
	}
	
	public Game(int gameScore, int gameExp) {
		this.gameScore = gameScore;
		this.gameExp = gameExp;
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		for(int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if(note.getY() > 620) {
				judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
			}
			if(!note.isProceeded()) {
				noteList.remove(i);
				i--;
			}
			else {
				note.screenDraw(g);
			}
		}
		g.setColor(Color.white);
		g.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING, 
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1180, 702);		
		g.setColor(Color.LIGHT_GRAY);
//		g.setFont(new Font("Elephant", Font.BOLD, 30));
//		g.drawString("SCORE : " + gameScore, 565, 702);	
		g.drawImage(FlareImage, 320, 430, null); 
		// FlareImage 안띄워짐 ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ
		g.drawImage(judgeImage, 460, 420, null);		
		g.drawImage(keyPadSImage, 228, 585, null);
		g.drawImage(keyPadDImage, 332, 585, null);
		g.drawImage(keyPadFImage, 436, 585, null);
		g.drawImage(keyPadSpace1Image, 540, 585, null);
		g.drawImage(keyPadSpace2Image, 640, 585, null);
		g.drawImage(keyPadJImage, 744, 585, null);
		g.drawImage(keyPadKImage, 848, 585, null);
		g.drawImage(keyPadLImage, 952, 585, null);
		g.setFont(new Font("Arial", Font.PLAIN, 26));		
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270, 614);
		g.drawString("D", 374, 614);
		g.drawString("F", 478, 614);
		g.drawString("Space Bar", 580, 614);
		g.drawString("J", 784, 614);
		g.drawString("K", 889, 614);
		g.drawString("L", 993, 614);
		
	}

	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
	}
	
	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
	}

	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
	}

	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumBig1.mp3", false).start();
	}
	
	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
	}
	
	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
	}
	
	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
	}
	
	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
	}
	
	public void run() {
		dropNotes(this.titleName); // 현재 선택된 노래
	}
	
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	
		// **************  **************  **************  ************** // 
	public void dropNotes(String titleName) { 
		Beat[] beats = null;
		if(titleName.equals("NCT 127 - REGULAR") && difficulty.equals("Easy")) {
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[] {
					new Beat(startTime, "S"),
					new Beat(startTime + gap * 6, "D"),
					new Beat(startTime + gap * 9, "D"),
					new Beat(startTime + gap * 12, "D"),
					// 노트 판정하는 존나 긴 코드 짜는 부분
					// 나동빈은 거의 340
			};
		}
		else if(titleName.equals("NCT 127 - REGULAR") && difficulty.equals("Normal")) {
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[] {
					new Beat(startTime, "S"),
					new Beat(startTime + gap * 2, "D"),
					// 노트 판정하는 존나 긴 코드 짜는 부분
					// 나동빈은 거의 340
			};
		}
		else if(titleName.equals("NCT 127 - REGULAR") && difficulty.equals("Hard")) {
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[] {
					new Beat(startTime, "S"),
					new Beat(startTime + gap * 2, "D"),
					// 노트 판정하는 존나 긴 코드 짜는 부분
					// 나동빈은 거의 340
			};
		}
		// **************  **************  **************  ************** // 
		else if(titleName.equals("EXO - TEMPO") && difficulty.equals("Easy")) {
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[] {
					new Beat(startTime, "S"),
					new Beat(startTime + gap * 6, "D"),
					// 노트 판정하는 존나 긴 코드 짜는 부분
					// 나동빈은 거의 340
			};
		}
		else if(titleName.equals("EXO - TEMPO") && difficulty.equals("Normal")) {
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[] {
					new Beat(startTime, "S"),
					new Beat(startTime + gap * 2, "D"),
					// 노트 판정하는 존나 긴 코드 짜는 부분
					// 나동빈은 거의 340
			};
		}
		else if(titleName.equals("EXO - TEMPO") && difficulty.equals("Hard")) {
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[] {
					new Beat(startTime, "S"),
					new Beat(startTime + gap * 2, "D"),
					// 노트 판정하는 존나 긴 코드 짜는 부분
					// 나동빈은 거의 340
			};
		}
		
		else if(titleName.equals("TWICE - YES OR YES") && difficulty.equals("Easy")) {
			int startTime = 7000 - Main.REACH_TIME * 1000;
			int gap = 150;
			int end = 0;
			beats = new Beat[] {
					new Beat(startTime, "S"),
					new Beat(startTime + gap * 12, "L"),
					new Beat(startTime + gap * 23, "D"),
					new Beat(startTime + gap * 34, "K"),
					new Beat(startTime + gap * 47, "Space"),
					new Beat(startTime + gap * 50, "Space"),
					new Beat(startTime + gap * 53, "Space"),
					new Beat(startTime + gap * 59, "S"),
					new Beat(startTime + gap * 65, "K"),
					new Beat(startTime + gap * 71, "D"),
					new Beat(startTime + gap * 76, "L"),
					// 둘중에 하나만 골라 Yes or Yes
					new Beat(startTime + gap * 81, "S"),
					new Beat(startTime + gap * 87, "L"),
					new Beat(startTime + gap * 93, "Space"),
					new Beat(startTime + gap * 99, "Space"),
					//
					new Beat(startTime + gap * 105, "D"),
					new Beat(startTime + gap * 111, "K"),
					new Beat(startTime + gap * 116, "S"),
					new Beat(startTime + gap * 121, "L"),
					// 하나만 선택해 어서 Yes or Yes
					new Beat(startTime + gap * 128, "F"),
					new Beat(startTime + gap * 134, "J"),
					new Beat(startTime + gap * 140, "Space"),
					new Beat(startTime + gap * 146, "Space"),
					// (정연)내가 이렇게도~ 
					new Beat(startTime + gap * 152, "D"),
					new Beat(startTime + gap * 163, "K"),
					new Beat(startTime + gap * 175, "D"),
					new Beat(startTime + gap * 186, "K"),
					new Beat(startTime + gap * 198, "Space"),
					new Beat(startTime + gap * 204, "Space"),
					new Beat(startTime + gap * 210, "Space"),
					new Beat(startTime + gap * 216, "Space"),
					new Beat(startTime + gap * 222, "S"),
					new Beat(startTime + gap * 228, "L"),
					new Beat(startTime + gap * 234, "S"),
					new Beat(startTime + gap * 239, "L"),
					new Beat(startTime + gap * 242, "Space"),
					// (미나)
					new Beat(startTime + gap * 245, "F"), 
					new Beat(startTime + gap * 256, "J"),
					new Beat(startTime + gap * 268, "F"),
					new Beat(startTime + gap * 279, "J"),
					new Beat(startTime + gap * 290, "Space"),
					new Beat(startTime + gap * 296, "Space"),
					new Beat(startTime + gap * 302, "Space"),
					new Beat(startTime + gap * 308, "Space"),
					new Beat(startTime + gap * 313, "D"),
					new Beat(startTime + gap * 319, "K"),
					new Beat(startTime + gap * 325, "D"),
					new Beat(startTime + gap * 331, "K"),
					new Beat(startTime + gap * 334, "Space"),
					// 사나
					new Beat(startTime + gap * 337, "F"),
					new Beat(startTime + gap * 343, "D"),
					new Beat(startTime + gap * 349, "Space"),
					new Beat(startTime + gap * 355, "L"),
					new Beat(startTime + gap * 358, "L"),
					new Beat(startTime + gap * 361, "J"),
					new Beat(startTime + gap * 367, "K"),
					new Beat(startTime + gap * 373, "Space"), 
					// 쯔위
					new Beat(startTime + gap * 383, "S"),
					new Beat(startTime + gap * 389, "L"),
					new Beat(startTime + gap * 395, "D"),
					new Beat(startTime + gap * 401, "K"),
					new Beat(startTime + gap * 407, "F"),
					new Beat(startTime + gap * 413, "J"),
					new Beat(startTime + gap * 419, "Space"), // 완료				
					// 노트 판정하는 존나 긴 코드 짜는 부분
					// 나동빈은 거의 340
				};				
		}
			
		else if(titleName.equals("TWICE - YES OR YES") && difficulty.equals("Normal")) {
			int startTime = 7000 - Main.REACH_TIME * 1000;
			int gap = 150;
			beats = new Beat[] {
					new Beat(startTime, "S"),
					new Beat(startTime + gap * 12, "L"),
					new Beat(startTime + gap * 23, "D"),
					new Beat(startTime + gap * 34, "K"),
					new Beat(startTime + gap * 47, "Space"),
					new Beat(startTime + gap * 50, "Space"),
					new Beat(startTime + gap * 53, "Space"),
					new Beat(startTime + gap * 59, "S"),
					new Beat(startTime + gap * 59, "D"),
					new Beat(startTime + gap * 65, "K"),
					new Beat(startTime + gap * 65, "L"),
					new Beat(startTime + gap * 71, "S"),
					new Beat(startTime + gap * 71, "D"),
					new Beat(startTime + gap * 76, "K"),
					new Beat(startTime + gap * 76, "L"),
					
					// 둘중에 하나만 골라 Yes or Yes
					new Beat(startTime + gap * 81, "S"),
					new Beat(startTime + gap * 81, "L"),
					new Beat(startTime + gap * 87, "D"),
					new Beat(startTime + gap * 87, "K"),
					new Beat(startTime + gap * 93, "F"),
					new Beat(startTime + gap * 96, "J"),
					new Beat(startTime + gap * 99, "Space"),
					//
					new Beat(startTime + gap * 105, "S"),
					new Beat(startTime + gap * 105, "D"),
					new Beat(startTime + gap * 111, "K"),
					new Beat(startTime + gap * 111, "L"),
					new Beat(startTime + gap * 116, "S"),
					new Beat(startTime + gap * 116, "D"),
					new Beat(startTime + gap * 121, "K"),
					new Beat(startTime + gap * 121, "L"),
					// 하나만 선택해 어서 Yes or Yes
					new Beat(startTime + gap * 128, "S"),
					new Beat(startTime + gap * 128, "L"),
					new Beat(startTime + gap * 134, "D"),
					new Beat(startTime + gap * 134, "K"),
					new Beat(startTime + gap * 140, "F"),
					new Beat(startTime + gap * 143, "J"),
					new Beat(startTime + gap * 146, "Space"),
					// (정연)내가 이렇게도~ 
					new Beat(startTime + gap * 152, "F"),
					new Beat(startTime + gap * 157, "S"),
					new Beat(startTime + gap * 163, "J"),
					new Beat(startTime + gap * 168, "L"),
					new Beat(startTime + gap * 175, "F"),
					new Beat(startTime + gap * 175, "J"),
					new Beat(startTime + gap * 181, "D"),
					new Beat(startTime + gap * 181, "K"),
					new Beat(startTime + gap * 186, "S"),
					new Beat(startTime + gap * 186, "L"),
					new Beat(startTime + gap * 198, "Space"),
					new Beat(startTime + gap * 204, "Space"),
					new Beat(startTime + gap * 210, "Space"),
					new Beat(startTime + gap * 216, "Space"),
					new Beat(startTime + gap * 222, "D"),
					new Beat(startTime + gap * 228, "K"),
					new Beat(startTime + gap * 234, "D"),
					new Beat(startTime + gap * 239, "K"),
					new Beat(startTime + gap * 242, "F"),
					new Beat(startTime + gap * 242, "Space"),
					new Beat(startTime + gap * 242, "J"), 
					// (미나)
					new Beat(startTime + gap * 245, "F"), 
					new Beat(startTime + gap * 250, "S"),
					new Beat(startTime + gap * 256, "J"),
					new Beat(startTime + gap * 261, "L"),
					new Beat(startTime + gap * 268, "F"),
					new Beat(startTime + gap * 268, "J"),
					new Beat(startTime + gap * 274, "D"),
					new Beat(startTime + gap * 274, "K"),
					new Beat(startTime + gap * 279, "S"),
					new Beat(startTime + gap * 279, "L"),
					new Beat(startTime + gap * 290, "Space"),
					new Beat(startTime + gap * 296, "Space"),
					new Beat(startTime + gap * 302, "Space"),
					new Beat(startTime + gap * 308, "Space"),
					new Beat(startTime + gap * 313, "D"),
					new Beat(startTime + gap * 319, "K"),
					new Beat(startTime + gap * 325, "D"),
					new Beat(startTime + gap * 331, "K"),
					new Beat(startTime + gap * 334, "F"),
					new Beat(startTime + gap * 334, "Space"),
					new Beat(startTime + gap * 334, "J"), 
					// 사나
					new Beat(startTime + gap * 337, "F"),
					new Beat(startTime + gap * 340, "D"),
					new Beat(startTime + gap * 343, "J"),
					new Beat(startTime + gap * 346, "K"),
					new Beat(startTime + gap * 349, "Space"),
					new Beat(startTime + gap * 355, "S"),
					new Beat(startTime + gap * 358, "S"),
					new Beat(startTime + gap * 361, "J"),
					new Beat(startTime + gap * 364, "K"),
					new Beat(startTime + gap * 367, "F"),
					new Beat(startTime + gap * 370, "D"),
					new Beat(startTime + gap * 373, "Space"), 
					// 쯔위
					new Beat(startTime + gap * 383, "S"),
					new Beat(startTime + gap * 383, "L"),
					new Beat(startTime + gap * 389, "D"),
					new Beat(startTime + gap * 389, "K"),
					new Beat(startTime + gap * 395, "F"),
					new Beat(startTime + gap * 395, "J"),
					new Beat(startTime + gap * 401, "D"),
					new Beat(startTime + gap * 401, "K"),
					new Beat(startTime + gap * 407, "S"),
					new Beat(startTime + gap * 407, "L"),
					new Beat(startTime + gap * 413, "D"),
					new Beat(startTime + gap * 413, "K"),
					new Beat(startTime + gap * 419, "J"),
					new Beat(startTime + gap * 419, "F"),
					new Beat(startTime + gap * 419, "Space"), 
					// 나연
					new Beat(startTime + gap * 430, "S"),
					new Beat(startTime + gap * 430, "D"),
					new Beat(startTime + gap * 436, "K"),
					new Beat(startTime + gap * 436, "L"),
					new Beat(startTime + gap * 442, "F"),
					new Beat(startTime + gap * 442, "J"),
					new Beat(startTime + gap * 448, "D"),
					new Beat(startTime + gap * 448, "F"),
					//
					new Beat(startTime + gap * 453, "S"),
					new Beat(startTime + gap * 456, "L"),
					new Beat(startTime + gap * 459, "F"),
					new Beat(startTime + gap * 462, "J"),
					new Beat(startTime + gap * 465, "D"),
					new Beat(startTime + gap * 468, "K"),
					new Beat(startTime + gap * 471, "Space"),
					// 지효
					new Beat(startTime + gap * 477, "S"),
					new Beat(startTime + gap * 477, "D"),
					new Beat(startTime + gap * 483, "K"),
					new Beat(startTime + gap * 483, "L"),
					new Beat(startTime + gap * 489, "F"),
					new Beat(startTime + gap * 489, "J"),
					new Beat(startTime + gap * 495, "D"),
					new Beat(startTime + gap * 495, "F"),
					//
					new Beat(startTime + gap * 499, "S"),
					new Beat(startTime + gap * 502, "L"),
					new Beat(startTime + gap * 505, "F"),
					new Beat(startTime + gap * 508, "J"),
					new Beat(startTime + gap * 511, "D"),
					new Beat(startTime + gap * 514, "K"), 
					new Beat(startTime + gap * 517, "Space"), // 완료
					// 싫어는 싫어
					new Beat(startTime + gap * 523, "S"), 
					new Beat(startTime + gap * 526, "D"), 
					new Beat(startTime + gap * 529, "F"), 
					new Beat(startTime + gap * 534, "L"), 
					new Beat(startTime + gap * 537, "K"), 
					new Beat(startTime + gap * 540, "J"), 
					new Beat(startTime + gap * 546, "F"), 
					new Beat(startTime + gap * 549, "D"), 
					new Beat(startTime + gap * 552, "S"), 
					new Beat(startTime + gap * 558, "J"), 
					new Beat(startTime + gap * 561, "K"), 
					new Beat(startTime + gap * 564, "L"),
					//
					new Beat(startTime + gap * 569, "D"), 
					new Beat(startTime + gap * 569, "K"), 
					new Beat(startTime + gap * 572, "D"), 
					new Beat(startTime + gap * 572, "K"), 
					new Beat(startTime + gap * 575, "S"), 
					new Beat(startTime + gap * 578, "S"), 
					new Beat(startTime + gap * 581, "D"), 
					new Beat(startTime + gap * 581, "K"), 
					new Beat(startTime + gap * 584, "D"), 
					new Beat(startTime + gap * 584, "K"), 
					new Beat(startTime + gap * 588, "L"), 
					new Beat(startTime + gap * 591, "L"), 
					new Beat(startTime + gap * 594, "S"), 
					new Beat(startTime + gap * 599, "F"), 
					new Beat(startTime + gap * 604, "J"), 
					new Beat(startTime + gap * 609, "L"),
					// 둘중에 하나만 골라
					new Beat(startTime + gap * 615, "D"), 
					new Beat(startTime + gap * 618, "F"), 
					new Beat(startTime + gap * 621, "K"), 
					new Beat(startTime + gap * 624, "J"), 
					new Beat(startTime + gap * 627, "S"), 
					new Beat(startTime + gap * 630, "L"), 
					new Beat(startTime + gap * 633, "F"), 
					new Beat(startTime + gap * 633, "Space"), 
					new Beat(startTime + gap * 633, "J"), 					
					// 노트 판정하는 존나 긴 코드 짜는 부분
					// 나동빈은 거의 340
				};
			System.out.println("Game is end");
			}
			else if(titleName.equals("TWICE - YES OR YES") && difficulty.equals("Hard")) {
				int startTime = 7000 - Main.REACH_TIME * 1000;
				int gap = 125;
				beats = new Beat[] {
						new Beat(startTime, "S"),
						new Beat(startTime + gap * 2, "D"),
						// 노트 판정하는 존나 긴 코드 짜는 부분
						// 나동빈은 거의 340
				};
			}
		int i = 0;
		gameMusic.start();
		while(i<beats.length && !isInterrupted()) {
			boolean dropped = false;
			if(beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void judge(String input) {
		for(int i = 0; i<noteList.size(); i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}
	
	public void judgeEvent(String judge) {
		if(!judge.equals("None")) {
			FlareImage = new ImageIcon(Main.class.getResource("../images/blueFlare.png")).getImage();
		}
		if(judge.equals("Miss")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
		}
		else if(judge.equals("BAD")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeBad.png")).getImage();
			gameScore += 3;
		}
		else if(judge.equals("GOOD")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGood.png")).getImage();
			gameScore += 10;
		}
		else if(judge.equals("GREAT!")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGreat.png")).getImage();
			gameScore += 20;
		}
		else if(judge.equals("PERFECT!!!")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgePerfect.png")).getImage();
			gameScore += 30;
		}
	}	
	
}