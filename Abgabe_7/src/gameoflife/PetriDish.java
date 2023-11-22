package gameoflife;

class PetriDish {
    private Cell[][] cells;
    private int lines;
    private int columns;
    private int generationNumber;

    PetriDish(int lines, int columns, double probabilityToLive) {
        this.lines = lines;
        this.columns = columns;
        cells = new Cell[lines][columns];
        createAllCells(probabilityToLive);
        addNeighborsToAllCells();
        generationNumber = 1;
    }

    private void createAllCells(double probabilityToLive) {
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                cells[i][j] = new Cell(probabilityToLive);
            }
        }
    }

    private void addNeighborsToAllCells() {
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                addNeighborsToCellIn(i, j);
            }
        }
    }

    private void addNeighborsToCellIn(int line, int column) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (withinBoundaries(line + i, column + j) && !(i == 0 && j == 0)) {
                    cells[line][column].addNeighbor(cells[line + i][column + j]);
                }
            }
        }
    }

    private boolean withinBoundaries(int line, int column) {
        return (line >= 0 && line < cells.length && column >= 0 && column < cells[line].length);
    }

    //Benutzung
    void nextGeneration() {
        countLivingNeighborsOfAllCells();
        applyRulesToAllCells();
        generationNumber++;
    }

    private void countLivingNeighborsOfAllCells() {
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                cells[i][j].countLivingNeighbors();
            }
        }
    }

    private void applyRulesToAllCells() {
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                cells[i][j].applyRules();
            }
        }
    }

    String asString(boolean showHeadline) {
        String generationXAsString = "";
        if (showHeadline) {
            generationXAsString = generationXAsString + "Generation: " + generationNumber + "\n";
        }
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                generationXAsString = generationXAsString + cells[i][j].asString();
            }
            generationXAsString = generationXAsString + "\n";
        }
        return generationXAsString;
    }

}
