import javax.swing.*;

public class ShoppingListApp extends JFrame{
    private JPanel Panel1;
    private JTextField itemInput;
    private JButton deleteButton;
    private JList itemList;
    private JScrollPane Panel2;
    private JButton addButton;

    private DefaultListModel<String> listModel;
    public ShoppingListApp() {
        setContentPane(Panel1);
        setTitle("Lista zadań");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
        listModel = new DefaultListModel<>();
        itemList.setModel(listModel);
        deleteButton.addActionListener(e -> {
                    listModel.remove(itemList.getSelectedIndex());
                });

        addButton.addActionListener(e -> {
            String text = itemInput.getText();
            if (!text.isEmpty()) {
                listModel.addElement(text);
                itemInput.setText("");
            }
        });
    }
    public static void main(String[] args){
        new ShoppingListApp();
}
}