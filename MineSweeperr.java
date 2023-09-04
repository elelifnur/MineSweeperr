package MathVeMetotlar;
import java.util.Random;
import java.util.Scanner;
public class MineSweeperr {
    Scanner input = new Scanner(System.in);
    Random randomNumber = new Random();
    int row;
    int column;
    String[][] map;
    String[][] frame;
    int number;

    public void run(){
        System.out.println("Mayın Tarlası Oyuna Hoşgeldiniz !");
        System.out.print("Satır Sayısı\t:\t");
        row= input.nextInt();
        System.out.print("Sütun Sayısı\t:\t");
        column = input.nextInt();

        number = (row*column)/4;

        map=new String[row][column];
        frame=new String[row][column];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                frame[i][j]="-";
                map[i][j]="-";
            }
        }
        while (number > 0){
            int rowNumber= randomNumber.nextInt(row);
            int columnNumber=randomNumber.nextInt(column);

            if(map[rowNumber][columnNumber].equals("-")){
                map[rowNumber][columnNumber]="*";
                number--;
            }
        }
        printFrame();
        playCheck();
    }
    public void playCheck(){
        boolean finish=false;
        while (!finish){
            System.out.print("Satır Giriniz: ");
            int selectedRow= input.nextInt();
            System.out.print("Sütun Giriniz: ");
            int selectedColumn= input.nextInt();

            int number=0;

            if (selectedRow < row && selectedColumn < column){
                if((map[selectedRow][selectedColumn].equals("-")) && (frame[selectedRow][selectedColumn].equals("-"))) {
                    for (int i = selectedRow - 1; i < selectedRow + 2; i++) {
                        for (int j = selectedColumn - 1; j < selectedColumn + 2; j++) {
                            if ((i >= 0) && (j >= 0) && (i < row) && (j < column) && (map[selectedRow][selectedColumn].equals("-"))) {
                                number++;
                                frame[selectedRow][selectedColumn] = Integer.toString(number);
                            } else {
                                frame[selectedRow][selectedColumn] = Integer.toString(number);
                            }
                        }
                    }
                    printFrame();
                    if (!checkWin()) {
                        System.out.println("Oyunu Kazandınız ! :");
                        printMap();
                        finish = true;

                    }
                } else if (map[selectedRow][selectedColumn].equals("*")) {
                    System.out.println("Game Over!!");
                    printMap();
                    finish=true;
                }else if (!frame[selectedRow][selectedColumn].equals("-")){
                    System.out.println("Daha önce girdiniz. Farklı bir hücre giriniz!");
                }
            }else{
                System.out.println("Yanlış girdiniz. Belirttiğiniz aralıklarda bir sayı girininiz");
            }
        }
    }
    public void printFrame(){
        for(String[] row: frame ){
            for (String column: row){
                System.out.print(column+" ");
            }
            System.out.println();
        }
        System.out.println("===========");
    }
    public void printMap(){
        for (String[] row: map){
            for (String column: row){
                System.out.print(column+" ");
            }
            System.out.println();
        }
        System.out.println("===========");

    }
    boolean checkWin(){
        int emptyCell=0;
        int minedCell = 0;
        for(int i =0; i < frame.length;i++){
            for (int j = 0; j < frame[i].length; j++){
                if(frame[i][j].equals("-")){
                    emptyCell++;
                }
                if(map[i][j].equals("*")){
                    minedCell++;
                }
            }
        }
        if(emptyCell==minedCell){
            return false;
        }
            return true;
    }
}
