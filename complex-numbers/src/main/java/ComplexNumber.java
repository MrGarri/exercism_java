public class ComplexNumber {

    private double real;
    private double imag;

    ComplexNumber(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    ComplexNumber times(ComplexNumber cn) {
        return new ComplexNumber(
                this.getReal() * cn.getReal() - this.getImag() * cn.getImag(),
                this.getImag() * cn.getReal() + this.getReal() * cn.getImag()
        );
    }

    ComplexNumber add(ComplexNumber cn) {
        return new ComplexNumber(
                this.real + cn.getReal(),
                this.imag + cn.getImag()
        );
    }

    ComplexNumber minus(ComplexNumber cn) {
        return new ComplexNumber(
                this.getReal() - cn.getReal(),
                this.getImag() - cn.getImag()
        );
    }

    ComplexNumber div(ComplexNumber cn) {
        double cnSquare = Math.pow(cn.getReal(), 2) + Math.pow(cn.getImag(), 2);
        return new ComplexNumber(
                (this.getReal() * cn.getReal() + this.getImag() * cn.getImag()) / cnSquare,
                (this.getImag() * cn.getReal() - this.getReal() * cn.getImag()) / cnSquare
        );
    }

    double abs() {
        return Math.sqrt(Math.pow(this.getReal(), 2) + Math.pow(this.getImag(), 2));
    }

    ComplexNumber conjugate() {
        return new ComplexNumber(this.getReal(), -this.getImag());
    }

    ComplexNumber exponentialOf() {
        return new ComplexNumber(
                Math.exp(this.getReal()) * Math.cos(this.getImag()),
                Math.exp(this.getReal()) * Math.sin(this.getImag())
        );
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ComplexNumber) {
            ComplexNumber cn = (ComplexNumber) o;
            return this.getReal() == cn.getReal() && this.getImag() == cn.getImag();
        } else {
            return false;
        }
    }

}
