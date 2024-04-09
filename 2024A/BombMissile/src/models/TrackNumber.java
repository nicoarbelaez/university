package models;

import java.util.Arrays;

public class TrackNumber {
    private Integer[] digits;
    private int missiles;
    private int bombs;

    public TrackNumber(Integer[] digits) {
        this.digits = digits;
        this.missiles = 0;
        this.bombs = 0;
    }

    public TrackNumber(Integer[] digits, int missiles, int bombs) {
        this.digits = digits;
        this.missiles = 0;
        this.bombs = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TN[d=")
                .append(Arrays.toString(digits))
                .append(", b=")
                .append(bombs)
                .append(", m=")
                .append(missiles)
                .append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackNumber that = (TrackNumber) obj;
        return Arrays.equals(digits, that.digits);
    }

    public Integer[] getDigits() {
        return digits;
    }

    public void setDigits(Integer[] digits) {
        this.digits = digits;
    }

    public int getMissiles() {
        return missiles;
    }

    public void setMissiles(int missiles) {
        this.missiles = missiles;
    }

    public int getBombs() {
        return bombs;
    }

    public void setBombs(int bombs) {
        this.bombs = bombs;
    }
}