import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ToDoListManager extends JFrame {

    public ToDoListManager() {
        super("To-Do List Manager");

        TaskTableModel model = new TaskTableModel();
        JTable table = new JTable(model);

        table.setRowHeight(25);

        table.getColumnModel().getColumn(1).setCellRenderer(new StatusRenderer());
        table.getColumnModel().getColumn(1).setCellEditor(new StatusEditor());

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(2, 1, 5, 5));

        JButton addBtn = new JButton("Dodaj");
        JButton removeBtn = new JButton("Usuń");

        controlPanel.add(addBtn);
        controlPanel.add(removeBtn);

        addBtn.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(this, "Nazwa zadania:");
            if (name != null && !name.isEmpty()) {
                model.addTask(new Task(name, false, "Normalny"));
            }
        });

        removeBtn.addActionListener(e -> {
            int selected = table.getSelectedRow();
            if (selected != -1) model.removeTask(selected);
        });

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                controlPanel, new JScrollPane(table));
        split.setDividerLocation(150);

        add(split);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    static class TaskTableModel extends AbstractTableModel {
        private final String[] columnNames = {
                "Nazwa",
                "Status",
                "Priorytet"
        };
        private final List < Task > tasks = new ArrayList < > ();

        @Override
        public int getRowCount() {
            return tasks.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int row, int col) {
            Task t = tasks.get(row);
            switch (col) {
                case 0:
                    return t.name;
                case 1:
                    return t.completed;
                case 2:
                    return t.priority;
            }
            return null;
        }

        @Override
        public void setValueAt(Object value, int row, int col) {
            Task t = tasks.get(row);
            switch (col) {
                case 0:
                    t.name = value.toString();
                    break;
                case 1:
                    t.completed = (boolean) value;
                    break;
                case 2:
                    t.priority = value.toString();
                    break;
            }
            fireTableRowsUpdated(row, row);
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            return col != 0 || col == 1 || col == 2;
        }

        @Override
        public Class < ? > getColumnClass(int col) {
            if (col == 1) return Boolean.class;
            return String.class;
        }

        public void addTask(Task t) {
            tasks.add(t);
            fireTableRowsInserted(tasks.size() - 1, tasks.size() - 1);
        }

        public void removeTask(int row) {
            tasks.remove(row);
            fireTableRowsDeleted(row, row);
        }
    }

    static class Task {
        String name;
        boolean completed;
        String priority;

        Task(String name, boolean completed, String priority) {
            this.name = name;
            this.completed = completed;
            this.priority = priority;
        }
    }

    static class StatusRenderer extends JCheckBox implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            setSelected((Boolean) value);
            setHorizontalAlignment(CENTER);

            if (isSelected) {
                setBackground(table.getSelectionBackground());
            } else {
                setBackground(Color.WHITE);
            }
            return this;
        }
    }

    static class StatusEditor extends DefaultCellEditor {

        public StatusEditor() {
            super(new JCheckBox());
            JCheckBox box = (JCheckBox) getComponent();
            box.setHorizontalAlignment(SwingConstants.CENTER);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoListManager::new);
    }
}