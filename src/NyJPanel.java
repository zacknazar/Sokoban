import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.Font;
import java.io.File;

class MyJPanel extends JPanel{
    private Model model;
    private Image imageDuke;
    private Image imageYashik;
    private Image imageStena;
    private Image imagePol;
    private Image imageEndPoint;
    private byte[][] chessBoard;

    MyJPanel(Model model){
        this.model = model;
//        setBackground(Color.LIGHT_GRAY);

        try{
            imageDuke = ImageIO.read(new File("src/images/duke_dot.png"));
            imageYashik = ImageIO.read(new File("src/images/yashik.png"));
            imageStena = ImageIO.read(new File("src/images/stena.png"));
            imagePol = ImageIO.read(new File("src/images/pol.png"));
            imageEndPoint = ImageIO.read(new File("src/images/endpoint.png"));
        }catch(IOException ioe){
            System.out.println(ioe);
        }

        chessBoard = model.getDesktop();


    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);


        int x = 0;
        int y = 0;

        for(int i = 0; i < chessBoard.length; i++) {

            x = 0;

            for(int j = 0; j < chessBoard[i].length; j++) {

                if(chessBoard[i][j] == 0) {
//		   g.setColor(Color.gray);
                    g.fillRect(x, y, 53, 53);
                    g.drawImage(imagePol, x, y, 53, 53, null);
                }

                if(chessBoard[i][j] == 1) {
                    g.fillRect(x, y, 53, 53);
                    g.drawImage(imageStena, x, y, 53, 53, null);
//		   g.setColor(Color.white);
                }

                if(chessBoard[i][j] == 2) {
//		   g.fillRect(x, y, 53, 53);
                    g.drawImage(imagePol, x, y, 53, 53, null);
                    g.drawImage(imageDuke, x, y, 53, 53, null);
                }

                if(chessBoard[i][j] == 3) {
                    g.fillRect(x, y, 53, 53);
                    g.drawImage(imageYashik, x, y, 53, 53, null);
                }


                if(chessBoard[i][j] == 4) {
                    g.fillRect(x, y, 53, 53);
                    g.drawImage(imagePol, x, y, 53, 53, null);
                    g.drawImage(imageEndPoint, x + 15, y + 15, 25, 25, null);
                }


                x = x + 53;

            }

            y = y + 53;

        }


    }
    public void updateMe(){
        chessBoard = model.getDesktop();
        repaint();
    }
}