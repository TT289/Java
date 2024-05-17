package buoi2;
import javax.swing.*;
import java.awt.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class ClockPanel extends JPanel implements Runnable {
    private ZoneId zoneId;
    private JLabel clockLabel;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public ClockPanel(String zoneId) {
        this.zoneId = ZoneId.of(zoneId);
        clockLabel = new JLabel();
        clockLabel.setFont(new Font("Arial", Font.PLAIN, 48));
        this.add(clockLabel);
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            ZonedDateTime now = ZonedDateTime.now(zoneId);
            clockLabel.setText(now.format(formatter));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 100);
    }
}
