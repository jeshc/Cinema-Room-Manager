package cinema;

import cinema.modelo.Room;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Room sala ;
        Scanner teclado = new Scanner(System.in);
        int rows=0;
        int cols=0;
        int rosSelect=0;
        int colSelect=0;
        int opcion=0;
        do{
            System.out.print("Enter the number of rows:");
            rows = teclado.nextInt();
            System.out.print("Enter the number of seats in each row:");
            cols = teclado.nextInt();
            if(rows > 9 || cols >9 ||rows < 0 || cols < 0)
                System.out.println("Wrong input!");
        }while( rows > 9 || cols >9 ||rows < 0 || cols < 0 );
        sala = new Room(rows,cols);
        do {
            opcion = menu(teclado);
            switch (opcion){
                case 1:
                    sala.showSeats();
                    break;
                case 2:
                    do{
                        System.out.print("Enter a row number:");
                        rosSelect = teclado.nextInt();
                        System.out.print("Enter a seat number in that row:");
                        colSelect = teclado.nextInt();
                        if(rosSelect> rows  || colSelect > cols  || rosSelect < 0  || colSelect < 0){
                            System.out.println("Wrong input!");
                        }
                    }while( rosSelect> rows  || colSelect > cols  || rosSelect < 0  || colSelect < 0 );
                   sala.vender(rosSelect,colSelect);
                    break;
                case 3:
                    sala.showStatics();
                    break;
            }
        }while(opcion !=0 );



    }

    public static int menu(Scanner teclado){

        int opcion=0;
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        System.out.print("> ");
        opcion=teclado.nextInt();
        return opcion;
    }
}