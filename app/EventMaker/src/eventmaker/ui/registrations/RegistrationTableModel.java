package eventmaker.ui.registrations;

import eventmaker.data.Event;
import eventmaker.data.Registration;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class RegistrationTableModel extends AbstractTableModel {
    
    private String[] columnNames = {
        "User name", "Event", "Approve state", "Payment state"
    };
    
    private ArrayList<Registration> data;

    public RegistrationTableModel(ArrayList<Registration> data) {
        this.data = data;
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Registration rec = data.get(rowIndex);
        switch (columnIndex)
        {
            case 0:
                return rec.getUser().getFullName();
            case 1:
                return rec.getEvent().toString();
            case 2:
                return rec.getApproveState();
            case 3: 
                return rec.getPaymentState();
            default:
                throw new UnsupportedOperationException("Not supported operation exception");
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
