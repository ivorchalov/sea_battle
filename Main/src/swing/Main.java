import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    public static int[][] allyField = new int[12][12];
    public static int[][] enemyField = new int[10][10];

    public static ArrayList<Cell> allyCellList = new ArrayList<>();
    public static ArrayList<Cell> enemyCellList = new ArrayList<>();
    public static ArrayList<Ship> ships = new ArrayList<>();

    public static Group group = new Group();
    public static Scene scene = new Scene(group, 1280, 960);

    public static void main(String[] args){ Application.launch(args); }

    @Override
    public void start(Stage primaryStage){

        primaryStage.setTitle("Sea battle");
        primaryStage.setScene(scene);
        primaryStage.show();

        drawFields(group);
        drawShips(group);

        Enemy enemy = new Enemy();
        enemyField = enemy.setField();
    }

    public static void drawFields(Group group){

        int x = 100;
        int y = 50;

        for(int i = 1; i < allyField.length - 1; i++){
            for(int j = 1; j < allyField.length - 1; j++){
                Cell cell = new Cell();
                cell.drawCell(group, x,y, true);
                cell.setI(i);
                cell.setJ(j);
                cell.setX(x);
                cell.setY(y);
                cell.setCurrentMatrixValue(allyField[i][j]);
                allyCellList.add(cell);
                x += 50;
            }
            x = 100;
            y += 50;
        }

        x = 700;
        y = 50;

        for(int i = 0; i < enemyField.length; i++){
            for(int j = 0; j < enemyField.length; j++){
                Cell cell = new Cell();
                cell.drawCell(group, x,y, false);
                cell.setI(i);
                cell.setJ(j);
                cell.setX(x);
                cell.setY(y);
                cell.setCurrentMatrixValue(enemyField[i][j]);
                enemyCellList.add(cell);
                x += 50;
            }
            x = 700;
            y += 50;
        }

        int x1 = 60;
        int x2 = 660;
        int y1 = 82;
        int y2 = 82;

        for(char i = 'A'; i <= 'J'; i++){
            Text text1 = new Text(Character.toString(i));
            text1.setX(x1);
            text1.setY(y1);
            text1.setFont(Font.font(28));
            group.getChildren().add(text1);
            y1 += 50;

            Text text2 = new Text(Character.toString(i));
            text2.setX(x2);
            text2.setY(y2);
            text2.setFont(Font.font(28));
            group.getChildren().add(text2);
            y2 += 50;
        }

        x1 = 115;
        x2 = 715;
        y = 38;

        for(int i = 1; i <= 10; i++){
            Text text1 = new Text(Integer.toString(i));
            text1.setX(x1);
            text1.setY(y);
            text1.setFont(Font.font(28));
            group.getChildren().add(text1);
            if(i == 9){
                x1 += 45;
            } else {
                x1 += 50;
            }

            Text text2 = new Text(Integer.toString(i));
            text2.setX(x2);
            text2.setY(y);
            text2.setFont(Font.font(28));
            group.getChildren().add(text2);
            if(i == 9){
                x2 += 45;
            } else {
                x2 += 50;
            }
        }
    }

    public void drawShips(Group group){
        int x = 100;
        int y = 880;

        Ship sloop = new Ship(1,4);
        ships.add(sloop);
        sloop.drawShip(group, x, y);

        y -= 100;

        Ship destroyer = new Ship(2,3);
        ships.add(destroyer);
        destroyer.drawShip(group, x, y);

        y -= 100;

        Ship cruiser = new Ship(3,2);
        ships.add(cruiser);
        cruiser.drawShip(group, x, y);

        y -= 100;

        Ship battleship = new Ship(4,1);
        ships.add(battleship);
        battleship.drawShip(group, x, y);
    }
}

//    Line line2 = new Line(350,700,350,500);
//    line2.setStroke(Color.BLACK);
//    Rotate rotate2 = new Rotate();
//    rotate2.setAngle(-45);
//    rotate2.setPivotX(350);
//    rotate2.setPivotY(700);
//    line2.getTransforms().add(rotate2);

