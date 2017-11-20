package curs.banking.ui.tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;

import curs.banking.model.Customer;
import curs.banking.rest.CustomerResourceIntf;
import curs.banking.rest.proxy.ProxyUtils;

public class CustomerTableModel extends AbstractTableModel {
	private List<Customer> mData;

	private String[] mColNames = { "Name", "CNP", "Sex", "Varsta", "City" };

	public void loadRestData() throws Exception {
		new Thread(() -> {
			CustomerResourceIntf cr = ProxyUtils.getRestClient(CustomerResourceIntf.class);
			try {
				mData = new ArrayList<>(cr.getCustomers());
			} catch (Exception e) {
				e.printStackTrace();
			}
			SwingUtilities.invokeLater(() -> super.fireTableDataChanged());
		}).start();
	}

	@Override
	public int getRowCount() {
		return mData != null ? mData.size() : 0;
	}

	@Override
	public int getColumnCount() {
		return mColNames.length;
	}
	
	@Override
	public String getColumnName(int column) {
		return mColNames[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return mData.get(rowIndex).getName();
		case 1:
			return mData.get(rowIndex).getSSN();
		case 2:
			return mData.get(rowIndex).getSex();
		case 3:
			return mData.get(rowIndex).getVarsta();
		case 4:
			return mData.get(rowIndex).getAddress().getCity().getName();

		}
		return null;
	}

}
