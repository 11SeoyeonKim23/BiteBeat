package Bite_Beat_1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {
	
	private Player player; // Player 자료형은 javazoom 라이브러리에 속해있음
	private boolean isLoop; // 곡이 무한반복인지 한번반복인지
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../music/" + name).toURI());
			fis = new FileInputStream(file); // file의 위치를 가져옴
			bis = new BufferedInputStream(fis); // 해당 file을 버퍼에 담아서 읽을 수 있게 함
			player = new Player(bis); // 해당 file을 담을 수 있게 함
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int getTime() {
		// 현재 실행되고 있는 음악이 어떤 위치에 실행되고 있는지 알려줌
		// 예를 들어 지금 0:10 가 틀어지고 있으면 10000을 반환
		if (player == null)
			return 0;
		return player.getPosition(); // 노트가 떨어진 시간을 분석
	}
	
	public void close() { // 언제든지 게임을 종료시킬 수 있는 함수. (뒤로가기 버튼같은 것)
		isLoop = false; // 화면이 꺼지면 음악도 동시에 종료, 즉 게임을 실행시키고 있는 동안에는 계속 실행됨
		player.close();
		this.interrupt();
	}
	
	@Override
	public void run() {
		try {
		// do-while문으로 실행시킴으로써 먼저 한 번 실행을 시킴
			do {
				player.play(); 
				fis = new FileInputStream(file); // file의 위치를 가져옴
				bis = new BufferedInputStream(fis); // 해당 file을 버퍼에 담아서 읽을 수 있게 함
				player = new Player(bis); // 해당 file을 담을 수 있게 함
			} while (isLoop); // isLoop는 boolean 값. true면 또 실행(반복), false면 중지
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
