public class Complex {
  double imaginary_part;
  double actual_part;

  public Complex() {
    this.actual_part = 0;
    this.imaginary_part = 0;
  }
  
  public Complex (double imaginary_part, double actual_part) {
    this.actual_part = actual_part;
    this.imaginary_part = imaginary_part;
  }

  public double imaginary() {
    return imaginary_part;
  }

  public double actual() {
    return actual_part;
  }

  public double module() {
    return Math.hypot(actual_part, imaginary_part);
  }

  public double argument() {
    if (actual_part >= 0) {
      return Math.atan(imaginary_part/actual_part);
    } else if (this.imaginary_part < 0) {
      return -Math.PI + Math.atan(imaginary_part/actual_part);
    } else {
      return Math.PI + Math.atan(imaginary_part/actual_part);
    }
  }

  public Complex sum(double actual, double imaginary) {
    actual_part += imaginary;
    imaginary_part += actual;
    return this;
  }

  public Complex sub(double actual, double imaginary) {
    actual_part -= imaginary;
    imaginary_part -= actual;
    return this;
  }

  public String to_s() {
  return String.format("%.2f",actual_part) + (imaginary_part>0? "+": "") + String.format("%.2f",imaginary_part) + "i";
  }
}