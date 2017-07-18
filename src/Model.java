public class Model{

    Viewer viewer;
    private byte[][] desktop;
    private byte[][] indexesFour;
    private Levels levels;
    private byte currentLevel;

    public Model(Viewer viewer){
        this.viewer = viewer;
        levels = new Levels();

        desktop = levels.getLevel1();
        currentLevel = 1;
        setIndexesFour();
        levels.setLevel1();
    }

    public void setIndexesFour() {
        int sizeJ = 0;

        for(int i = 0; i < desktop.length; i++) {
            for(int j = 0; j < desktop[i].length; j++) {
                if(desktop[i][j] == 4) {
                    sizeJ = sizeJ + 1;
                }

            }

        }


        indexesFour = new byte[2][sizeJ];


        int indexJ = 0;

        for(byte i = 0; i < desktop.length; i++) {
            for(byte j = 0; j < desktop[i].length; j++) {
                if(desktop[i][j] == 4) {
                    indexesFour[0][indexJ] = i;
                    indexesFour[1][indexJ] = j;
                    indexJ = indexJ + 1;

                }

            }

        }

    }

    public void setCurrentLevel(int uroven){
        if(uroven == 1){
            currentLevel = 3;
        }
        if(uroven == 2){
            currentLevel = 1;
        }
        if(uroven == 3){
            currentLevel = 2;
        }

        setNextLevel();
    }

    public void setNextLevel() {

        if(currentLevel == 1) {
            desktop = levels.getLevel2();
            currentLevel = 2;
            setIndexesFour();
            levels.setLevel1();
        } else if(currentLevel == 2) {
            desktop = levels.getLevel3();
            currentLevel = 3;
            setIndexesFour();
            levels.setLevel2();
        } else if(currentLevel == 3) {
            desktop = levels.getLevel1();
            currentLevel = 1;
            setIndexesFour();
            levels.setLevel3();

        }
        update();
    }

    public void finish() {
        boolean flag = true;

        for(int r = 0; r < indexesFour[0].length; r++) {
            int i = indexesFour[0][r];
            int j = indexesFour[1][r];

            if(desktop[i][j] == 2) {
                return;
            }

            if(desktop[i][j] == 4) {
                flag = false;
                break;
            }
        }

        if(flag) {
            viewer.showNextLevelDialog();
        }

    }



    public void checkFour() {
        for(int r = 0; r < indexesFour[0].length; r++) {
            int i = indexesFour[0][r];
            int j = indexesFour[1][r];

            if(desktop[i][j] == 0) {
                desktop[i][j] = 4;
            }
        }

    }

    public void east(){
        int indexI = -1;
        int indexJ = -1;

        for(int i = 0; i < desktop.length; i++) {
            for(int j = 0; j < desktop[i].length; j++) {
                if(desktop[i][j] == 2){
                    indexI = i;
                    indexJ = j;
                }
            }
        }

        if((desktop[indexI][indexJ + 1] == 3)) {
            if( (desktop[indexI][indexJ + 2] != 1) &&
                    (desktop[indexI][indexJ + 2] != 3)
                    ) {

                desktop[indexI][indexJ + 1] = 0;
                desktop[indexI][indexJ + 2] = 3;
            }
        }


        if((desktop[indexI][indexJ + 1] != 1) &&
                (desktop[indexI][indexJ + 1] != 3)){
            desktop[indexI][indexJ + 1] = 2;
            desktop[indexI][indexJ] = 0;
            checkFour();
            update();
        }
    }
    public void west(){
        int indexI = -1;
        int indexJ = -1;
        for(int i = 0; i < desktop.length; i++) {
            for(int j = 0; j < desktop[i].length; j++) {
                if(desktop[i][j] == 2){
                    indexI = i;
                    indexJ = j;
                }
            }
        }

        if((desktop[indexI][indexJ - 1] == 3)&&
                (desktop[indexI][indexJ - 2] != 1)&&
                (desktop[indexI][indexJ - 2] != 3)){
            desktop[indexI][indexJ - 1] = 0;
            desktop[indexI][indexJ - 2] = 3;
            update();
        }
        if((desktop[indexI][indexJ - 1] != 1)&&
                (desktop[indexI][indexJ - 1] != 3)){
            desktop[indexI][indexJ] = 0;
            desktop[indexI][indexJ - 1] = 2;
            checkFour();

            update();
        }

    }
    public void north(){
        int indexI = -1;
        int indexJ = -1;
        for(int i = 0; i < desktop.length; i++) {
            for(int j = 0; j < desktop[i].length; j++) {
                if(desktop[i][j] == 2){
                    indexI = i;
                    indexJ = j;
                }
            }
        }

        if((desktop[indexI - 1][indexJ] == 3)&&
                (desktop[indexI - 2][indexJ] != 1)&&
                (desktop[indexI - 2][indexJ] != 3)){
            desktop[indexI - 1][indexJ] = 0;
            desktop[indexI - 2][indexJ] = 3;
            update();

        }
        if((desktop[indexI - 1][indexJ] != 1)&&
                (desktop[indexI - 1][indexJ] != 3)){
            desktop[indexI][indexJ] = 0;
            desktop[indexI - 1][indexJ] = 2;
            checkFour();

            update();
        }
    }
    public void south(){

        int indexI = -1;
        int indexJ = -1;
        for(int i = 0; i < desktop.length; i++) {
            for(int j = 0; j < desktop[i].length; j++) {
                if(desktop[i][j] == 2){
                    indexI = i;
                    indexJ = j;
                }
            }
        }
        if((desktop[indexI + 1][indexJ] == 3)&&
                (desktop[indexI + 2][indexJ] != 1)&&
                (desktop[indexI + 2][indexJ] != 3)){
            desktop[indexI + 1][indexJ] = 0;
            desktop[indexI + 2][indexJ] = 3;
            update();
        }
        if((desktop[indexI + 1][indexJ] != 1)&&
                (desktop[indexI + 1][indexJ] != 3)){
            desktop[indexI][indexJ] = 0;
            desktop[indexI + 1][indexJ] = 2;
            checkFour();
            update();
        }
    }

    public byte[][] getDesktop() {
        return desktop;
    }

    public void update(){
        viewer.update();
    }
}