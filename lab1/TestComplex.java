import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestComplex {
  @Test
  public void aFastTest() {
    Complex complex = new Complex(4, 3);
    assertEquals(5, complex.module(), 0);
  }

  @Test
  public void bFastTest() {
    Complex complex = new Complex();
    assertEquals(0, complex.module(), 0);
  }

  @Test
  public void cFastTest() {
    Complex complex = new Complex(4, 3);
    assertEquals(Math.atan(4.0/3.0), complex.argument(), 0);
    
    complex = new Complex(-4, -3);
    assertEquals(-Math.PI + Math.atan(-4.0/-3.0), complex.argument(), 0);
    
    complex = new Complex(4, -3);
    assertEquals(Math.PI + Math.atan(-4.0/3.0), complex.argument(), 0);
  }

  @Test
  public void dFastTest() {
    Complex complex = new Complex(4, 3);
    complex.sum(1,1);
    assertEquals(5.0, complex.imaginary_part, 0);
    assertEquals(4.0, complex.actual_part, 0);
  }

  @Test
  public void eFastTest() {
    Complex complex = new Complex(4, 3);
    complex.sub(1,1);
    assertEquals(3.0, complex.imaginary_part, 0);
    assertEquals(2.0, complex.actual_part, 0);
  }

  @Test
  public void fFastTest() {
    Complex complex = new Complex(4, 3);
    assertEquals("3.00+4.00i", complex.to_s());
  }
 
}
