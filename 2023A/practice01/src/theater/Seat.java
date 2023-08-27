package theater;

public class Seat {
    private boolean reserved = false;
    private int rowNumber;
    private char columnLetter;

    public Seat(int rowNumber, char columnLetter) {
        this.rowNumber = rowNumber;
        this.columnLetter = columnLetter;
    }

    public String getSeatNumber() {
        String seatNumber = getRowNumber() < 10 ? "0" + getRowNumber() : "" + getRowNumber();
        return seatNumber + "-" + getColumnLetter();
    }

    public void unreserve() {
        setReserved(false);
    }

    public void reserve() {
        setReserved(true);
    }

    public boolean getReserved() {
        return reserved;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public char getColumnLetter() {
        return columnLetter;
    }

    private void setReserved(boolean isReserved) {
        this.reserved = isReserved;
    }
}
