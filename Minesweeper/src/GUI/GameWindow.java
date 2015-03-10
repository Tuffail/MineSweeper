package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Board.MinesweeperBoard;

public class GameWindow extends JFrame {
	
	private MinesweeperBoard mineBoard;
	private JMenuBar jmb;
	private int gameDifficulty = -1;
	
	public GameWindow(MinesweeperBoard mBoard){
		mineBoard = mBoard;
		this.setLayout(new BorderLayout());
		jmb = new JMenuBar();
		JMenu setting = new JMenu("Settings");
		jmb.add(setting);
		JMenuItem easy = new JMenuItem("Easy");
		JMenuItem medium = new JMenuItem("Medium");
		JMenuItem hard = new JMenuItem("Hard");
		final JPanel gamePanel = new JPanel();
		setting.add(easy);
		setting.add(medium);
		setting.add(hard);
		this.setJMenuBar(jmb);
		
		easy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gameDifficulty = 1;
			}
		});
		
		medium.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gameDifficulty = 2;
			}
		});
		
		hard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gameDifficulty = 3;
			}
		});
		
		
		JButton jbNew  = new JButton("New");
		jbNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (gameDifficulty != -1){
					
					if (gameDifficulty == 1) mineBoard = new MinesweeperBoard(9, 9, 10);
					else if (gameDifficulty == 2) mineBoard = new MinesweeperBoard(16, 16, 40);
					else if (gameDifficulty == 3) mineBoard = new MinesweeperBoard(30, 16, 99);
					
					if (mineBoard != null){
					GameWindow.this.dispose();
					new GameWindow(mineBoard).setVisible(true);
					}
					
				}else{
					JOptionPane.showMessageDialog(getParent(), "Please select a difficuly first from the settings", "Please select difficulty", JOptionPane.ERROR_MESSAGE, null);
				}
				
			}
		});
		JPanel jpNorth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jpNorth.add(jbNew);
		
		Game game = new Game(mineBoard);
		JScrollPane jsp = new JScrollPane(game);
		gamePanel.add(jsp);
		GameWindow.this.add(jsp, BorderLayout.CENTER);
		
		this.add(jpNorth, BorderLayout.NORTH);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(270,330));
		this.pack();
	}
	
}
