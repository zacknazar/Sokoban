import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Controller implements ActionListener, KeyListener{

    Model model;
    private byte[][] desktop;
    Controller(Viewer viewer){
        model = new Model(viewer);
    }

    public Model getModel(){
        return model;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if(command.equals("Level1")) {
            model.setCurrentLevel(1);
        }else if (command.equals("Level2")){
            model.setCurrentLevel(2);
        }else if(command.equals("Level3")){
            model.setCurrentLevel(3);
        }
    }
    public void keyTyped(KeyEvent e){

    }
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == 37){

            model.west();
        }else if(e.getKeyCode() == 38){

            model.north();
        }else if(e.getKeyCode() == 39){

            model.east();
        }else if(e.getKeyCode() == 40){

            model.south();
        }

        model.finish();



    }
    public void keyReleased(KeyEvent e){
    }

    public void setNextLevel(){
        model.setNextLevel();
    }

}