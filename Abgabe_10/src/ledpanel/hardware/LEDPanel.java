package ledpanel.hardware;

/**
 * This class represents LED panel. The panel consists of 5 LED matrices. Each matrix has 8 * 8 LEDs.
 */
public class LEDPanel {

    /**
     * Use this byte[] to access the matrix 0. A bit that is set, will directly lead to a LED that is switched on.
     */
    public final byte[] matrix0;
    /**
     *
     * Use this byte[] to access the matrix 1. A bit that is set, will directly lead to a LED that is switched on.
     */
    public final byte[] matrix1;
    /**
     * Use this byte[] to access the matrix 2. A bit that is set, will directly lead to a LED that is switched on.
     */
    public final byte[] matrix2;
    /**
     * Use this byte[] to access the matrix 3. A bit that is set, will directly lead to a LED that is switched on.
     */
    public final byte[] matrix3;
    /**
     * Use this byte[] to access the matrix 4. A bit that is set, will directly lead to a LED that is switched on.
     */
    public final byte[] matrix4;


    private final Simulator.LEDPanel simulator;

    /**
     * Shows a simulated LED panel.
     */
    public LEDPanel() {
        simulator = new Simulator.LEDPanel();
        matrix0 = simulator.getMatrix0();
        matrix1 = simulator.getMatrix1();
        matrix2 = simulator.getMatrix2();
        matrix3 = simulator.getMatrix3();
        matrix4 = simulator.getMatrix4();
        simulator.startSimulation();
    }

    private void stopSimulation() {
        simulator.closeWindow();
    }
}

