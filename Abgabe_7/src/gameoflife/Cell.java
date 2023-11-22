package gameoflife;

class Cell {
    private boolean alive;
    private int livingNeighbors;
    private Cell[] neighbors;


    //Konstruktor
    Cell(double probabilityToLive) {
        alive = Math.random() < probabilityToLive;
        neighbors = new Cell[8];
    }

    //Zell-Methoden
    void addNeighbor(Cell cell) {
        for (int i = 0; i < neighbors.length; i++) {
            if (neighbors[i] == null) {
                neighbors[i] = cell;
                break;
            }
        }
    }

    void countLivingNeighbors() {
        livingNeighbors = 0;
        for (int i = 0; i < neighbors.length; i++) {
            if (neighbors[i] == null) {
                continue;
            } else if (neighbors[i].alive) {
                livingNeighbors++;
            }
        }
    }

    void applyRules() {
        if (livingNeighbors == 3 && !alive) {
            alive = true;
        } else if (livingNeighbors > 3 && alive) {
            alive = false;
        } else if (livingNeighbors < 2 && alive) {
            alive = false;
        }
    }

    String asString() {
        if (alive) {
            return "X ";
        } else {
            return "  ";
        }
    }

}
