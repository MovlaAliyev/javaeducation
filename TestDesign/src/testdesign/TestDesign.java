/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdesign;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestDesign extends JPanel {

    JTextArea output;

    JScrollPane scrollPane;

    static final private String PREVIOUS = "previous";
    static final private String UP = "up";

    public TestDesign() {
        super(new BorderLayout());

    }

    public JPanel getToolBar() {
        JPanel jPanel = new JPanel(new BorderLayout());

        JToolBar bar = new JToolBar("Tool bar");
        addButtons(bar);
        //jPanel.setPreferredSize(new Dimension(450, 130));
        jPanel.add(bar);

        return jPanel;
    }

    protected void addButtons(JToolBar bar) {
        JButton button = null;
        button = makeNavigationbutton("C:\\Users\\Pc-2\\Downloads\\1495461098_10.Folder.png", PREVIOUS, "Back to previous something-or-other", "Previous");
        bar.add(button);
        bar.addSeparator();

        button = makeNavigationbutton("C:\\Users\\Pc-2\\Downloads\\1495458708_ic_save_48px.png", UP, "Back to previous something-or-other", "Previous");
        bar.add(button);
    }

    protected JButton makeNavigationbutton(String image, String actionCommande, String toolTipText, String altText) {
        String imgLocation = image;

        JButton button = new JButton();
        Image img;
        try {
            img = ImageIO.read(new File(imgLocation));
            Image newimg = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(newimg));
        } catch (IOException ex) {
            Logger.getLogger(TestDesign.class.getName()).log(Level.SEVERE, null, ex);
            button.setText("Zaaa");
        }

        button.setActionCommand(actionCommande);
        //button.setText(actionCommande);

        return button;
    }

    public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;

        menuBar = new JMenuBar();

        menu = new JMenu("A Menu");
        menu.setMnemonic(KeyEvent.VK_A);
        //menu.getAccessibleContext().setAccessibleDescription("The only menu in this program has menu items");
        menuBar.add(menu);

        menuItem = new JMenuItem("A text only menu item", KeyEvent.VK_T);
        //menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        //menuItem.getAccessibleContext().setAccessibleDescription("This doesnt really do anything");
        menu.add(menuItem);

        menu.addSeparator();

        ButtonGroup group = new ButtonGroup();

        rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
        rbMenuItem.setSelected(true);
        rbMenuItem.setMnemonic(KeyEvent.VK_R);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);

        rbMenuItem = new JRadioButtonMenuItem("Another one");
        rbMenuItem.setSelected(true);
        rbMenuItem.setMnemonic(KeyEvent.VK_R);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);

        menu.addSeparator();

        cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
        cbMenuItem.setMnemonic(KeyEvent.VK_C);
        menu.add(cbMenuItem);

        cbMenuItem = new JCheckBoxMenuItem("Another one");
        cbMenuItem.setMnemonic(KeyEvent.VK_H);
        menu.add(cbMenuItem);

        menu.addSeparator();

        submenu = new JMenu("submenu");
        submenu.setMnemonic(KeyEvent.VK_S);

        menuItem = new JMenuItem("An item in the seubmenu");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_2, ActionEvent.ALT_MASK));
        submenu.add(menuItem);

        menuItem = new JMenuItem("Another item");
        submenu.add(menuItem);
        menu.add(submenu);

        menu = new JMenu("Another Menu");
        menu.setMnemonic(KeyEvent.VK_N);
        menu.getAccessibleContext().setAccessibleDescription(
                "This menu does nothing");
        menuBar.add(menu);

        return menuBar;
    }

    public Container createContentPane() {
        GridBagLayout bagLayout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        Editor contentPane = new Editor();

        UPane p = new UPane();

        JPanel buttonPane = new JPanel();
        JPanel leftPane = new JPanel(new BorderLayout());
        JButton b1 = new JButton("Press b1");
        JButton b2 = new JButton("Press b2");
        JButton b3 = new JButton("Press b3");
        JButton b4 = new JButton("Press b4");
        JButton b5 = new JButton("Press b5");
        JButton b6 = new JButton("Press b6");
        JButton b7 = new JButton("Press b7");
        JButton b8 = new JButton("Press b8");
        JButton b9 = new JButton("Press b9");

        buttonPane.setLayout(bagLayout);
        c.gridheight = GridBagConstraints.RELATIVE;

        c.gridx = 0;
        c.gridy = 0;

        buttonPane.add(b1, c);
        c.gridx = 1;
        buttonPane.add(b2, c);
        c.gridx = 2;
        buttonPane.add(b3, c);

        c.gridx = 0;
        c.gridy = 1;

        buttonPane.add(b4, c);
        c.gridx = 1;
        buttonPane.add(b5, c);
        c.gridx = 2;
        buttonPane.add(b6, c);

        c.gridx = 0;
        c.gridy = 2;
        
        buttonPane.add(b7, c);
        c.gridx = 1;
        buttonPane.add(b8, c);
        c.gridx = 2;
        buttonPane.add(b9, c);

        buttonPane.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Buttons"),
                        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        leftPane.add(buttonPane, BorderLayout.PAGE_START);

        p.setOpaque(true);
        p.setBackground(Color.red);

        p.add(leftPane, BorderLayout.WEST);
        contentPane.addMouseListener(contentPane);

        //p.add(contentPane);
        return p;
    }

    /**
     * Returns an ImageIcon, or null if the path was invalid.
     */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = TestDesign.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    private static void createAndShowGUI() {

        JFrame frame = new JFrame("MenuLookDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TestDesign demo = new TestDesign();

        frame.setJMenuBar(demo.createMenuBar());

        frame.setContentPane(demo.createContentPane());

        frame.setSize(450, 260);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    createAndShowGUI();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TestDesign.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(TestDesign.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(TestDesign.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(TestDesign.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
