package View;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JPanel;

import Control.ComponentMover;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;


public class Chat {

	private JFrame frame;
	private JPanel panelButonsActionForm;
	private JPanel panelMessagens;
	private JPanel panelContatos;
	private JLabel label;
	private JLabel label_1;
	private int width;
	private int height;
	private Point location;
	private MouseEvent pressed;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat window = new Chat();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void Show() {
		try {
			Chat window = new Chat();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Create the application.
	 */
	public Chat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				resizeWindows();
			}
		});
		frame.setUndecorated(true);

		Control.ComponentResizer cr = new Control.ComponentResizer();
		cr.setSnapSize(new Dimension(10, 10));
		cr.setDragInsets( new Insets(5, 5, 5, 5) );

		cr.registerComponent(frame);
		
		
		
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panelButonsActionForm = new JPanel();
		panelButonsActionForm.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				
			}
		});
		panelButonsActionForm.setBackground(new java.awt.Color(43,50,56));
		panelButonsActionForm.setBounds(0, 0, 800, 34);

		
		
		frame.getContentPane().add(panelButonsActionForm, BorderLayout.NORTH);
		ComponentMover cm = new ComponentMover(frame, panelButonsActionForm);
		
		frame.getContentPane().add(panelButonsActionForm);
		panelButonsActionForm.setLayout(null);
		
		label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		label.setBounds(780, 0, 20, 36);
		label.setIcon(new ImageIcon("C:\\Users\\Vinicius\\Documents\\close.png"));
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		label.setCursor(cursor);
		panelButonsActionForm.add(label);
		
		label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(frame.getExtendedState() == JFrame.MAXIMIZED_BOTH) {
					frame.setExtendedState(frame.getExtendedState() | JFrame.NORMAL);
					frame.setBounds(100, 100, width, height);
				}else {
					width = frame.getWidth();
					height = frame.getHeight();
					frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				}
				
			}
		});
		label_1.setIcon(new ImageIcon("C:\\Users\\Vinicius\\Documents\\maximize.png"));
		label_1.setBounds(738, 0, 32, 36);
		panelButonsActionForm.add(label_1);
		
		panelMessagens = new JPanel();
		panelMessagens.setBounds(0, 34, 602, 566);
		frame.getContentPane().add(panelMessagens);
		panelMessagens.setLayout(null);
		
		panelContatos = new JPanel();
		panelContatos.setBackground(new java.awt.Color(60,70,78));
		panelContatos.setBounds(600, 34, 200, 566);
		frame.getContentPane().add(panelContatos);
		panelContatos.setLayout(null);
	}
	
	
 
    
	
	
	private void resizeWindows() {
		panelButonsActionForm.setBounds(0, 0, frame.getWidth(), 34);
		label.setBounds( frame.getWidth()-35, 0, 25, 36);
		
		label_1.setBounds( frame.getWidth()-36-25, 0, 32, 36);
		
		if(frame.getWidth() > 1000) {
			
			panelMessagens.setBounds(0, 34, frame.getWidth()-290, frame.getHeight()-34);
			panelContatos.setBounds(panelMessagens.getWidth(), 34, 290, frame.getHeight()-34);
			panelContatos.setVisible(true);
		}else {
			panelMessagens.setBounds(0, 34, frame.getWidth(), frame.getHeight()-34);
			panelContatos.setBounds(frame.getWidth()-290, 34, 290, frame.getHeight()-34);
			panelContatos.setVisible(false);
		}
		
	}

}
