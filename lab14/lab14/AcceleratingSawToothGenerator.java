package lab14;

import lab14lib.Generator;

public class AcceleratingSawToothGenerator implements Generator {
    private int period;
    private int state;
    private double accelerate;
    private int stateRec;

    public AcceleratingSawToothGenerator(int period, double accelerate) {
        this.period = period;
        this.accelerate = accelerate;
        this.state = 0;
        this.stateRec = 0;
    }

    public double next() {
        state = (state + 1);
        double res = -1.0 + 2.0 / period * ((state-stateRec) % period);
        if (res == -1.0) {
            period = (int) (period * accelerate);
            stateRec = state;
        }
        return res;
    }


}
