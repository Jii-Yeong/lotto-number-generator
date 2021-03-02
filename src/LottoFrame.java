import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
// 3조 lotto
public class LottoFrame extends JFrame {
	int count;
	private JPanel contentPane;
	private CardLayout cards = new CardLayout();
	private SelectPanel selectPanel;
	JScrollPane scroll;
	private ResultPanel resultPanel;
	private CountPanel countPanel;
	int play = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LottoFrame frame = new LottoFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LottoFrame() {
		countPanel = new CountPanel(this);
		selectPanel = new SelectPanel(this);
		selectPanel = new SelectPanel(this);
		resultPanel = new ResultPanel(this, selectPanel.getTemp());
		countPanel = new CountPanel(this);
		scroll = new JScrollPane(resultPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 830, 530);
		getContentPane().setLayout(cards);
		getContentPane().add("Main", new MainPanel(this));
		getContentPane().add("Count", countPanel);
		getContentPane().add("Select", selectPanel); 
		getContentPane().add("Result", scroll);
	}
	
	
	
	public ResultPanel getResultPanel() {
		return resultPanel;
	}

	public void changeMainPanel() {
		cards.show(this.getContentPane(), "Main");
		countPanel.resetInput();
	}

	public void changeCountPanel() {
		cards.show(this.getContentPane(), "Count");
	}
	
	public void changeSelectPanel(int play) { 
		cards.show(this.getContentPane(), "Select");
		selectPanel.setLabelText(play);
	}
	public void changeResultPanel(int play) {
		cards.show(this.getContentPane(), "Result");
		resultPanel.setPlayTest(play);
		resultPanel.loopResult();
		System.out.println(count);
		if (count >= 1) {
			resultPanel.clearPanel();
			resultPanel.removeRandomList();
			resultPanel.randomNumber();
			resultPanel.loopResult();
		}
		++count;
	}
	
	public void setPlay(int play) {
		this.play = play;
	}

}