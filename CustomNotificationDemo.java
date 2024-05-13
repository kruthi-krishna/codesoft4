import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class CustomNotificationDemo {
    public static int PANEL_WIDTH = 400;
    public static int PANEL_HEIGHT = 500;
    public static int NOTIFICATION_WIDTH = 380;
    public static int NOTIFICATION_HEIGHT = 100;
    private static final int SPACING = 10;

    private JFrame notificationFrame;
    private JPanel notificationPanel;
    private List<Notification> notifications;

    public CustomNotificationDemo() {
        notifications = new ArrayList<>();

        notificationFrame = new JFrame();
        notificationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        notificationFrame.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        notificationFrame.setLocationRelativeTo(null); // Center the window

        notificationPanel = new JPanel();
        notificationPanel.setLayout(new BoxLayout(notificationPanel, BoxLayout.Y_AXIS));
        notificationPanel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        notificationPanel.setBackground(new Color(192, 228, 255)); // Gradient background color

        notificationFrame.add(notificationPanel);

        notificationFrame.setVisible(true);
    }

    public void addNotification(String title, String message, String iconPath) {
        Notification notification = new Notification(title, message, iconPath);
        notification.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Pop out the notification
                notification.setVisible(false);
                notificationFrame.pack();
            }
        });
        notifications.add(notification);
        notificationPanel.add(notification);
        notificationPanel.add(Box.createVerticalStrut(SPACING));
        notificationFrame.pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CustomNotificationDemo demo = new CustomNotificationDemo();
            demo.addNotification("New Email", "You have a new email from John Doe: 'Meeting Agenda'", "email_icon.png");
            demo.addNotification("New WhatsApp Message", "You have a new message from Mom: 'Don't forget to buy groceries'", "whatsapp_icon.png");
            demo.addNotification("New Facebook Message", "You have a new message from Sarah: 'Are you free for a call?'", "facebook_icon.png");
            demo.addNotification("New Telegram Message", "New message in 'Work Chat': 'Regarding tomorrow's presentation'", "telegram_icon.png");
            demo.addNotification("New Signal Message", "New message from Alice: 'Check out this article'", "signal_icon.png");
            demo.addNotification("New Instagram Notification", "You have a new follower: @username", "instagram_icon.png");
            demo.addNotification("New Twitter Notification", "Your tweet received 10 likes and 3 retweets", "twitter_icon.png");
            demo.addNotification("New Snapchat Notification", "New snap from Jenny: 'Check out my vacation photos!'", "snapchat_icon.png");
            demo.addNotification("New TikTok Notification", "Your video reached 1K views", "tiktok_icon.png");
            demo.addNotification("Reminder", "Dentist appointment tomorrow at 10:00 AM", "reminder_icon.png");
            demo.addNotification("Event", "Team meeting at 2:00 PM", "event_icon.png");
            demo.addNotification("Breaking News", "Breaking news: Earthquake hits region, stay safe", "news_icon.png");
            demo.addNotification("New YouTube Video", "New video from your favorite channel: '10 Tips for Productivity'", "youtube_icon.png");
            demo.addNotification("New Reddit Post", "New post in r/worldnews: 'Developments in Climate Change'", "reddit_icon.png");
        });
    }
}

class Notification extends JPanel {
    private JLabel titleLabel;
    private JLabel messageLabel;
    private JLabel iconLabel;

    public Notification(String title, String message, String iconPath) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(CustomNotificationDemo.NOTIFICATION_WIDTH, CustomNotificationDemo.NOTIFICATION_HEIGHT));
        setBackground(new Color(230, 245, 255)); // Light blue background color

        titleLabel = new JLabel(title);
        messageLabel = new JLabel(message);
        iconLabel = new JLabel(new ImageIcon(iconPath));

        // Customize appearance
        Font titleFont = new Font("Arial", Font.BOLD, 16);
        Font messageFont = new Font("Arial", Font.PLAIN, 14);
        titleLabel.setFont(titleFont);
        messageLabel.setFont(messageFont);

        add(iconLabel, BorderLayout.WEST);
        add(titleLabel, BorderLayout.CENTER);
        add(messageLabel, BorderLayout.SOUTH);
    }
}
