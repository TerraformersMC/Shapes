package com.cumulus.shapes.api;

/**
 * @author <Wtoll> Will Toll on 2020-06-08
 * @project Shapes
 */
public interface Quaternion {

    static Quaternion of(double ofW, double ofI, double ofJ, double ofK) {
        return new Quaternion() {
            private double w = ofW;
            private double i = ofI;
            private double j = ofJ;
            private double k = ofK;

            @Override
            public double getW() {
                return w;
            }

            @Override
            public double getI() {
                return i;
            }

            @Override
            public double getJ() {
                return j;
            }

            @Override
            public double getK() {
                return k;
            }

            @Override
            public void setW(double w) {
                this.w = w;
            }

            @Override
            public void setI(double i) {
                this.i = i;
            }

            @Override
            public void setJ(double j) {
                this.j = j;
            }

            @Override
            public void setK(double k) {
                this.k = k;
            }
        };
    }

    static Quaternion of(Quaternion q) {
        return of(q.getW(), q.getI(), q.getJ(), q.getK());
    }

    default Quaternion copy() {
        return Quaternion.of(this);
    }

    double getW();

    double getI();

    double getJ();

    double getK();

    void setW(double w);

    void setI(double i);

    void setJ(double j);

    void setK(double k);

    default Quaternion multiply(Quaternion multiplier) {
        double newW = (this.getW() * multiplier.getW()) - (this.getI() * multiplier.getI()) - (this.getJ() * multiplier.getJ()) - (this.getK() * multiplier.getK());
        double newI = (this.getW() * multiplier.getI()) + (this.getI() * multiplier.getW()) + (this.getJ() * multiplier.getK()) - (this.getK() * multiplier.getJ());
        double newJ = (this.getW() * multiplier.getJ()) - (this.getI() * multiplier.getK()) + (this.getJ() * multiplier.getW()) + (this.getK() * multiplier.getI());
        double newK = (this.getW() * multiplier.getK()) + (this.getI() * multiplier.getJ()) - (this.getJ() * multiplier.getI()) + (this.getK() * multiplier.getW());
        this.setW(newW);
        this.setI(newI);
        this.setJ(newJ);
        this.setK(newK);
        return this;
    }

    default Quaternion conjugate() {
        return Quaternion.of(this.getW(), -this.getI(), -this.getJ(), -this.getK());
    }

    default Position toPosition() {
        return Position.of(this.getI(), this.getJ(), this.getK());
    }

    static Quaternion of(Position pos) {
        return Quaternion.of(0, pos.getX(), pos.getY(), pos.getZ());
    }
}
