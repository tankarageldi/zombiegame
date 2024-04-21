package model;

public class Location {
    private int row;
    private int col;

    public Location(int row,int col){
        this.row = row;
        this.col = col;
    }
    public int getRow(){
        return row;
    }
    public void setRow(int row){
        this.row = row;
    }
    public int getCol(){
        return col;
    }
    public void setCol(int col){
        this.col = col;
    }
    public void incrementRow(int dx){
        this.row = row + dx;
    }
    public void incrementCol(int dy){
        this.col = col + dy;
    }
    public void move(int row, int col){
        incrementCol(col);
        incrementRow(row);
    }
    @Override
    public String toString() {
        return "(" + row + ", " + col + ")";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Location location = (Location) obj;
        return row == location.row && col == location.col;
    }

    
}
