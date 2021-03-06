package lab5.prob1.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lab5.prob1.rulesets.BookRuleSet;
import lab5.prob1.rulesets.RuleException;
import lab5.prob1.rulesets.RuleSet;
import lab5.prob1.rulesets.RuleSetFactory;

public class BookWindow extends JFrame {
	private JPanel topPanel;
	private JPanel bottomPanel;
	private JButton button;
	private JTextField isbnField;
	private JTextField titleField;
	private JTextField priceField;
	private BookRuleSet bookRuleSet;
	
	private static final long serialVersionUID = 1L;
	public BookWindow() {
		initializeWindow();
		JPanel mainPanel = new JPanel();
		defineTopPanel();
		defineBottomPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		getContentPane().add(mainPanel);
		pack();
		bookRuleSet = new BookRuleSet();
	}
	private void defineTopPanel() {
		topPanel = new JPanel();
		JLabel isbnLabel = new JLabel("ISBN");
		isbnLabel.setFont(makeSmallFont(isbnLabel.getFont()));
		isbnField = new JTextField(12);
		JPanel isbnPanel = createTextPanel(isbnLabel, isbnField);
		
		
		JLabel titleLabel = new JLabel("Title");
		titleLabel.setFont(makeSmallFont(titleLabel.getFont()));
		titleField = new JTextField(12);
		JPanel titlePanel = createTextPanel(titleLabel, titleField);
		
		JLabel priceLabel = new JLabel("Price");
		priceLabel.setFont(makeSmallFont(priceLabel.getFont()));
		priceField = new JTextField(12);
		JPanel pricePanel = createTextPanel(priceLabel, priceField);
		
		
		
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		topPanel.add(isbnPanel);
		topPanel.add(titlePanel);
		topPanel.add(pricePanel);
		
	}
	
	private void defineBottomPanel() {
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		button = new JButton("Update Info");
		button.addActionListener(new ButtonListener());
		bottomPanel.add(button);
		
	}
	private static JPanel createTextPanel(JLabel lab, JTextField textField) {
		
		JPanel top = new JPanel();
		JPanel bottom = new JPanel();
		top.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		bottom.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		
		
		
		top.add(lab);
		bottom.add(textField);
		
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new BorderLayout());
		textPanel.add(top,BorderLayout.NORTH);
		textPanel.add(bottom,BorderLayout.CENTER);
		return textPanel;
	}
	private void initializeWindow() {
		setTitle("Add Book to Collection");		
		setSize(520,180);
		handleWindowClosing();
		centerFrameOnDesktop(this);
		setResizable(false);
	}
	public static Font makeSmallFont(Font f) {
        return new Font(f.getName(), f.getStyle(), (f.getSize()-2));
    }

	private void handleWindowClosing() {
        addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent w) {
                dispose();
				//other clean-up
                System.exit(0);
           }
        }); 				
	}
	private void clearFields() {
		isbnField.setText("");
		titleField.setText("");
		priceField.setText("");
	}
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt){
			RuleSet rules = RuleSetFactory.getRuleSet(BookWindow.this);
			try {
				String strISBN = isbnField.getText();
				String strTitle = titleField.getText();
				String strPrice = priceField.getText();
				
				rules.applyRules(BookWindow.this);
				StringBuilder sb = new StringBuilder();
				String n = System.getProperty("line.separator");
				
				sb.append("Book Details: " + n);
				sb.append("ISBN: " + strISBN + n);
				sb.append("Title: " + strTitle + n);
				sb.append("Price: " + strPrice);
				System.out.println(sb);
				JOptionPane.showMessageDialog(BookWindow.this, sb);
				clearFields();
			} catch (RuleException e) {
				JOptionPane.showMessageDialog(BookWindow.this, e.getMessage());
			}
		}
	}
	class BackListener implements ActionListener {
		public void actionPerformed(ActionEvent evt){
			System.out.println("1");
		}
	}
	public static void centerFrameOnDesktop(Component f) {
	        final int SHIFT_AMOUNT = 0;
	        Toolkit toolkit = Toolkit.getDefaultToolkit();
	        int height = toolkit.getScreenSize().height;
	        int width  = toolkit.getScreenSize().width;
	        int frameHeight = f.getSize().height;
	        int frameWidth  = f.getSize().width;
	        f.setLocation(((width-frameWidth)/2)-SHIFT_AMOUNT, (height-frameHeight)/3);    
	    }
	public String getIsbnValue() {
		return isbnField.getText();
	}
	public String getTitleValue() {
		return titleField.getText();
	}
	public String getPriceValue() {
		return priceField.getText();
	}
	
	public static void main(String[] args){
		BookWindow mf = new BookWindow();
		//mf.pack();
		mf.setVisible(true);
	}
}
