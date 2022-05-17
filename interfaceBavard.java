
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class interfaceBavard {

    public interfaceBavard(Bavard bavard) {
        JFrame frame = new JFrame("Bavardage");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 500);
        frame.setLayout(null);
        JMenuBar menuBar = settingMenuBar(bavard);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
        // JTextArea textArea = new JTextArea(20, 20);
        // JButton but = new JButton("text");  
        // JScrollPane scrollableTextArea = new JScrollPane(but);
        // //scrollableTextArea.add(but);   
        // scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
  
        // frame.getContentPane().add(scrollableTextArea);  
    }

    public JMenuBar settingMenuBar(Bavard bavard){
        JMenuBar menuBar = new JMenuBar();
        JMenu menu=new JMenu("Topics");
        for(Concierge concierge : bavard.getConcierges()){
            JMenuItem conciergeMenu=new JMenuItem(concierge.getName());  
            menu.add(conciergeMenu);
        } 
        menuBar.add(menu);
        return menuBar;
    }
    
}
