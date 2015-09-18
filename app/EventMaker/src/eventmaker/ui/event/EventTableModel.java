package eventmaker.ui.event;

import eventmaker.data.Event;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class EventTableModel extends AbstractTableModel {

    private String[] columnNames = {
        "Name", "Category", "Date", "Description", "Approve rule", "Payment rule", "Availability", "Cost", "Company"
    };
    
    private ArrayList<Event> data;

    public EventTableModel(ArrayList<Event> data) {
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
        Event rec = data.get(rowIndex);
        switch (columnIndex)
        {
            case 0:
                return rec.getName();
            case 1:
                return rec.getCategory();
            case 2:
                return rec.getEventDate();
            case 3: 
                return rec.getDescription();
            case 4:
                return rec.getApproveRule();
            case 5:
                return rec.getPaymentRule();
            case 6:
                return rec.getAvailability();
            case 7:
                return rec.getCost();
            case 8:
                return rec.getCompany(); 
            default:
                throw new UnsupportedOperationException("Not supported operation exception");
        }
    } 

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    
}
