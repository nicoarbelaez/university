package theater;

public class Reserved {

    private int rowNumber = 20;
    private int colNumber = 20;
    private Seat[][] seats;

    /**
     * Constructor que inicializa las variables de instancia y crea la matriz de asientos.
     *
     * @param row número de filas de la matriz de asientos
     * @param col número de columnas de la matriz de asientos
     */
    public Reserved(int row, int col) {
        setRowNumber(row);
        setColNumber(col);
        setSeats(new Seat[getRowNumber()][getColNumber()]);

        assignSeats();
    }

    /**
     * Método que asigna los asientos a cada celda de la matriz.
     */
    private void assignSeats() {
        for (int i = 0; i < getRowNumber(); i++) {
            for (int j = 0; j < getColNumber(); j++) {
                seats[i][j] = new Seat((i + 1), (char) (65 + j));
            }
        }
    }

    /**
     * Método que busca un asiento por su número de asiento y devuelve el objeto.
     *
     * @param seatNumber el número de asiento del asiento buscado
     * @return el objeto de asiento correspondiente al número de asiento especificado, o null si no se encuentra
     */
    public Seat searchSeat(String seatNumber) {

        seatNumber = seatNumber.replace("-", "").toUpperCase();
        seatNumber = seatNumber.replaceAll("^0+", "");

        // ^[0-9]{1,2}[A-Z]$ -> 1-2 números y una letra (forma correcta)
        // ^[A-Z][0-9]{1,2}$ -> una letra y 1-2 números
        if (seatNumber.matches("^[A-Z][0-9]{1,2}$")) {
            seatNumber = seatNumber.substring(1) + seatNumber.charAt(0);
        }

        int longSeatNumber = seatNumber.length() - 1;

        int number = Integer.parseInt(seatNumber.substring(0, longSeatNumber)) - 1;
        int letter = seatNumber.charAt(longSeatNumber) - 65;

        System.out.println(seatNumber + " | Numero: " + number + " Letra: " + letter);

        if (number < 0 || number >= getRowNumber() || letter < 0 || letter >= getColNumber()) {
            System.out.println("\n((El asiento " + seatNumber + " no existe))");
            return null;
        }
        return seats[number][letter];
    }

    /**
     * Método que muestra la matriz de asientos y su estado de reserva.
     */
    public void displaySeatMatrix() {
        System.out.println("""
                \nEstado de las reservas:
                ==============================""");
        for (int i = 0; i < getRowNumber(); i++) {
            System.out.print((char) 9608 + "\t");
            for (int j = 0; j < getColNumber(); j++) {
                Seat currentSeat = seats[i][j];
                String seatString = currentSeat.getReserved() ? " // " : currentSeat.getSeatNumber();
                System.out.print("(" + seatString + ")");
            }
            System.out.println("");
        }
        System.out.println("==============================");
    }

    /**
     * Método que reserva un asiento especificado por su número de asiento.
     *
     * @param seatNumber el número de asiento del asiento que se desea reservar
     */
    public void reserveSeat(String seatNumber) {
        Seat seat = searchSeat(seatNumber);

        if (seat == null) {
            return;
        }

        if (seat.getReserved()) {
            System.out.println("\n((El asiento " + seatNumber + " ya está reservado))");
            return;
        } else {
            seat.reserve();
            System.out.println("\n((El asiento " + seatNumber + " ha sido reservado))");
        }
    }

    /**
     * Método que elimina la reserva de un asiento especificado por su número de asiento.
     *
     * @param seatNumber el número de asiento del asiento cuya reserva se desea eliminar
     */
    public void unreserveSeat(String seatNumber) {
        Seat seat = searchSeat(seatNumber);

        if (seat == null) {
            return;
        }

        if (!seat.getReserved()) {
            System.out.println("\n((El asiento " + seatNumber + " no está reservado))");
            return;
        } else {
            seat.unreserve();
            System.out.println("\n((El asiento " + seatNumber + " ha sido anulado))");
        }
    }

    // Métodos getters y setters
    public int getColNumber() {
        return colNumber;
    }

    public void setColNumber(int colNumber) {
        this.colNumber = colNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public Seat[][] getSeats() {
        return seats;
    }

    public void setSeats(Seat[][] seats) {
        this.seats = seats;
    }

}
