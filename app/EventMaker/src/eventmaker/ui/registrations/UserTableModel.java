package eventmaker.ui.registrations;

import eventmaker.data.User;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class UserTableModel  extends AbstractTableModel {
    private String[] columnNames = {
        "Full name", "Info"
    };
    
    private ArrayList<User> data;

    public UserTableModel(ArrayList<User> data) {
        this.data = data;
    }
    
    public User getByIndex(int index) {
        return data.get(index);
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
        User rec = data.get(rowIndex);
        switch (columnIndex)
        {
            case 0:
                return rec.getFullName();
            case 1:
                return rec.getInfo();
            default:
                throw new UnsupportedOperationException("Not supported operation exception");
        }
    } 

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    
}
