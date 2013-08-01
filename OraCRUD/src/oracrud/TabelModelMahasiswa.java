package oracrud;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelModelMahasiswa extends AbstractTableModel{
    private List<ListColumnMahasiswa> list;
    public TabelModelMahasiswa(List<ListColumnMahasiswa> list) {
        this.list = list;
    }

    public int getRowCount() {
        return list.size();
    }

    public int getColumnCount() {
        return 3;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).GetNim();
            case 1:
                return list.get(rowIndex).GetNama();
            case 2:
                return list.get(rowIndex).GetAlamat();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return super.getColumnName(column);
    }    
}
