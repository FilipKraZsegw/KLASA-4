import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ToDoList extends JFrame{
    private JPanel panel1;
    private JPanel panelInput;
    private JTextField itemInput;
    private JPanel panelList;
    private JPanel panelDelete;
    private JButton deleteButton;
    private JPanel panelCounter;
    private JLabel Counter;
    private JPanel panelAdd;
    private JButton addButton;
    private JList ItemList;
    private void updateCounter(){
        Counter.setText("Liczba zadań: " + listModel.getSize());
    }

    private DefaultListModel<String> listModel;
    public ToDoList() {
        setContentPane(panel1);
        setTitle("Lista zadań");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setVisible(true);
        listModel = new DefaultListModel<>();
        ItemList.setModel(listModel);
        ItemList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() >= 2 && ItemList.getSelectedIndex() != -1) {
                    listModel.remove(ItemList.getSelectedIndex());
                    updateCounter();
                }
            }
        });
        deleteButton.addActionListener(e -> {
            listModel.remove(ItemList.getSelectedIndex());
            updateCounter();
        });

        addButton.addActionListener(e -> {
            String text = itemInput.getText();
            Counter.setText("Liczna zadań: ");
            if (!text.isEmpty()) {
                listModel.addElement(text);
                itemInput.setText("");
            }
            updateCounter();
        });
    }
    public static void main(String[] args){
        new ToDoList();
    }
}