package buoi2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JPanel clockPanelContainer;
    private JTextField timeZoneField;
    private JButton addButton;

    public MainFrame() {
        setTitle("World Clocks");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        clockPanelContainer = new JPanel();
        clockPanelContainer.setLayout(new BoxLayout(clockPanelContainer, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(clockPanelContainer);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        timeZoneField = new JTextField(20);
        addButton = new JButton("Add Clock");

        inputPanel.add(new JLabel("Enter Time Zone:"));
        inputPanel.add(timeZoneField);
        inputPanel.add(addButton);
        //Nhập Time Zone thì anh nhập Châu lục/Tỉnh nhé :)))

        getContentPane().add(inputPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String timeZone = timeZoneField.getText().trim();
                if (!timeZone.isEmpty()) {
                    ClockPanel clockPanel = new ClockPanel(timeZone);
                    clockPanelContainer.add(clockPanel);
                    clockPanelContainer.revalidate();
                }
            }
        });

        pack();
        setSize(357, 221);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame());
    }
}
