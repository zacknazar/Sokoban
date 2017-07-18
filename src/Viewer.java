import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class Viewer {
    private Controller controller;
    private MyJPanel canvas;
    private JFrame f;

    Viewer(){
        controller = new Controller(this);
        Model model = controller.getModel();
        canvas = new MyJPanel(model);

        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("Уровни");
        menuBar.add(file);

        JMenuItem level1 = new JMenuItem("Уровень 1");
        level1.setActionCommand("Level1");
        level1.addActionListener(controller);
        file.add(level1);

        JMenuItem level2 = new JMenuItem("Уровень 2");
        level2.setActionCommand("Level2");
        level2.addActionListener(controller);
        file.add(level2);

        JMenuItem level3 = new JMenuItem("Уровень 3");
        level3.setActionCommand("Level3");
        level3.addActionListener(controller);
        file.add(level3);


        f = new JFrame("Sokoban");
        f.setSize(490, 500);
        f.setLocation(50,0);
        BorderLayout bl = new BorderLayout();
        f.setLayout(bl);
        f.setJMenuBar(menuBar);
        f.add("Center", canvas);
        f.addKeyListener(controller);

        f.setVisible(true);



    }

    public void update(){
        canvas.updateMe();
    }

    public void showNextLevelDialog() {

        Object[] options = {"Да", "Нет", "Отмена"};
        int n = JOptionPane.showOptionDialog(f,
                "Загрузить следующий уровень игры?",
                "Sokoban next level",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]);

        switch(n) {
            case 0:
                controller.setNextLevel();
                break;
            case 1:
                System.exit(0);

                break;
            case 2:
                break;
            case -1:
                break;

        }



    }

}