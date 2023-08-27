package point_eight;

public class Matriz {
  private int columns;
  private int rows;
  private int[][] matriz;

  /**
   * @param rows
   * @param columns
   */
  Matriz(int rows, int columns) {
    setRows(rows);
    setColumns(columns);
    setMatriz(new int[rows][columns]);
  }

  public String toString() {
    String result = "";

    for (int[] row : getMatriz()) {
      for (int element : row) {
        result += "(" + element + ")";
      }
      // System.out.println(row + "|" + getMatriz()[getMatriz().length - 1]);
      if(row != getMatriz()[getMatriz().length - 1]) {
        result += "\n";
      }
    }

    return result;
  }

  /**
   * Asigna un valor a la matriz en la posición indicada, si la posición no
   * existe, no se asigna
   * 
   * @param row
   * @param column
   * @param value
   * @return
   */
  public boolean setElement(int row, int column, int value) {
    if (row < 0 || row >= getRows() || column < 0 || column >= getColumns())
      return false;
    else {
      matriz[row][column] = value;
      return true;
    }
  }

  /**
   * Devuelve el elemento de la matriz en la posición indicada, si la posición no
   * existe, devuelve -1
   * 
   * @param row
   * @param column
   * @return
   */
  public int getElement(int row, int column) {
    if (row < 0 || row >= getRows() || column < 0 || column >= getColumns())
      return -1;
    else
      return matriz[row][column];
  }

  public int[][] getMatriz() {
    return matriz;
  }

  /**
   * Asigna una matriz a la matriz de la clase, si la matriz es nula, no se asigna
   * 
   * @param matriz
   * @return
   */
  public boolean setMatriz(int[][] matriz) {
    if (matriz == null)
      return false;
    else {
      this.matriz = matriz;
      return true;
    }
  }

  public int getColumns() {
    return columns;
  }

  public void setColumns(int columns) {
    this.columns = columns;
  }

  public int getRows() {
    return rows;
  }

  public void setRows(int rows) {
    this.rows = rows;
  }
}
