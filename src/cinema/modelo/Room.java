package cinema.modelo;

import java.util.Arrays;
import java.util.Scanner;

public class Room {
    private int rows;
    private int columns;
    private Seat[][] asientos;
    private int vendidos;
    private int currentIncome;
    private int totalIncome;

    public Room() {
     }

    public Room(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        inicializar();
    }
    public void inicializar(){
        asientos= new Seat[this.rows][this.columns];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if(this.rows * this.columns > 60
                    && i >= (this.rows/2)
                ){
                    asientos[i][j]= new Seat(i,j,8,"S");
                    totalIncome += 8;
                }else{
                    asientos[i][j]= new Seat(i,j,10,"S");
                    totalIncome += 10;
                }
            }
        }
    }

    public void showSeats(){
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= columns; i++) {
            System.out.print(" "+i);
        }
        System.out.println();
        for( int i=0 ; i < rows ; i++ ){
            System.out.print((i+1)+"");
            for( int j= 0 ; j <columns;j++ ){
                System.out.print(" " + asientos[i][j].getEstado());
            }
            System.out.println();
        }
        System.out.println("");
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public Seat[][] getAsientos() {
        return asientos;
    }

    public void setAsientos(Seat[][] asientos) {
        this.asientos = asientos;
    }

    public int getVendidos() {
        return vendidos;
    }

    public void setVendidos(int vendidos) {
        this.vendidos = vendidos;
    }

    public int getCurrentIncome() {
        return currentIncome;
    }

    public void setCurrentIncome(int currentIncome) {
        this.currentIncome = currentIncome;
    }

    public int getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(int totalIncome) {
        this.totalIncome = totalIncome;
    }

    @Override
    public String toString() {
        return "Room{" +
                "rows=" + rows +
                ", columns=" + columns +
                ", asientos=" + Arrays.toString(asientos) +
                ", vendidos=" + vendidos +
                ", currentIncome=" + currentIncome +
                ", totalIncome=" + totalIncome +
                '}';
    }

    public void showStatics(){
        float porcentaje = vendidos==0.0f ? 0.0f:  ((float)vendidos)*100.0f / ((float)rows*(float)columns)  ;
        System.out.println("Number of purchased tickets: "+vendidos);
        System.out.printf("Percentage: %.2f", porcentaje);
        System.out.println("%");
        System.out.println("Current income: $"+currentIncome);
        System.out.println("Total income: $"+totalIncome);
        System.out.println("");
    }

    public void vender( int ren , int col ){
        Scanner teclado= new Scanner(System.in);
        int rosSelect=0;
        int colSelect=0;
        ren--;
        col--;
        if(asientos[ren][col].getEstado().equals("S")){
            asientos[ren][col].setEstado("B");
            this.vendidos++;
            this.currentIncome +=asientos[ren][col].getPrice();
            System.out.println("Ticket price: $"+asientos[ren][col].getPrice());
        }else{
            System.out.println("That ticket has already been purchased!");
            do{
                System.out.print("Enter a row number:");
                rosSelect = teclado.nextInt();
                System.out.print("Enter a seat number in that row:");
                colSelect = teclado.nextInt();
                if(rosSelect>= rows  || colSelect > columns  || rosSelect < 0  || colSelect < 0){
                    System.out.println("Wrong input!");
                }
            }while( rosSelect> rows  || colSelect > columns  || rosSelect < 0  || colSelect < 0 );
            asientos[rosSelect-1][colSelect-1].setEstado("B");
            vendidos++;
            this.currentIncome +=asientos[rosSelect-1][colSelect-1].getPrice();
            System.out.println("Ticket price: $"+asientos[rosSelect-1][colSelect-1].getPrice());
        }

    }
}
