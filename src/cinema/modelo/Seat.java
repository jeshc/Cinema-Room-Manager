package cinema.modelo;

public class Seat {
    private int row;
    private int column;
    private int price;
    private String estado;



    public Seat() {
    }

    public Seat(int row, int column, int price, String vendido) {
        this.row = row;
        this.column = column;
        this.price = price;
        this.estado = vendido;
    }

    public Seat(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "row=" + row +
                ", column=" + column +
                ", price=" + price +
                ", vendido=" + estado +
                '}';
    }
}
