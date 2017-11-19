package curs.banking;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import curs.banking.rest.CustomerResourceIntf;
import curs.banking.rest.proxy.ProxyUtils;
import curs.banking.ui.tables.CustomerTableModel;

public class Main {
	private static JComponent createCustomersTab() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		CustomerTableModel ctm = new CustomerTableModel();
		JTable ct = new JTable(ctm);
		panel.add(ct);
		JButton btn = new JButton("Refresh");
		btn.addActionListener((e) -> {
			try {
				ctm.loadRestData();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		
		}); 
		panel.add(btn);
		return panel;
	}
	
	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("Banking");
		frame.setMinimumSize(new Dimension(600, 400));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add content to the window.
		JPanel mainPanel = new JPanel(new GridLayout(1, 1));
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.add("Clienti",createCustomersTab() );
		mainPanel.add(tabbedPane);
		frame.add(mainPanel, BorderLayout.CENTER);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) throws Exception {
		//CustomerResourceIntf cr = ProxyUtils.getRestClient(CustomerResourceIntf.class);
		//System.out.println(cr.getCustomers());
		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

}
