package sit707_tasks;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilTest {

    // ================================
    // 1. Student Details
    // ================================
    @Test
    public void testStudentIdentity() {
        String studentId = "s224796976";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Mohit";
        Assert.assertNotNull("Student name is null", studentName);
    }

    // ================================
    // 2. January Boundary Tests (WITH PRINT)
    // ================================

    @Test
    public void testMinJanuary1ShouldIncrementToJanuary2() {
        DateUtil date = new DateUtil(1, 1, 2024);

        System.out.println("=== Increment Test ===");
        System.out.println("Before: " + date);

        date.increment();

        System.out.println("After: " + date);

        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testMinJanuary1ShouldDecrementToDecember31() {
        DateUtil date = new DateUtil(1, 1, 2024);

        System.out.println("=== Decrement Test ===");
        System.out.println("Before: " + date);

        date.decrement();

        System.out.println("After: " + date);

        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    @Test
    public void testMaxJanuary31ShouldIncrementToFebruary1() {
        DateUtil date = new DateUtil(31, 1, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testMaxJanuary31ShouldDecrementToJanuary30() {
        DateUtil date = new DateUtil(31, 1, 2024);
        date.decrement();
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testNominalJanuary() {
        DateUtil date = new DateUtil(15, 1, 2024);
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    // ================================
    // 3. Table A (Previous)
    // ================================

    @Test public void testPrevious1() { checkPrevious(1,6,1994,31,5,1994); }
    @Test public void testPrevious2() { checkPrevious(2,6,1994,1,6,1994); }
    @Test public void testPrevious3() { checkPrevious(15,6,1994,14,6,1994); }
    @Test public void testPrevious4() { checkPrevious(30,6,1994,29,6,1994); }
    @Test public void testPrevious6() { checkPrevious(15,1,1994,14,1,1994); }
    @Test public void testPrevious7() { checkPrevious(15,2,1994,14,2,1994); }
    @Test public void testPrevious8() { checkPrevious(15,11,1994,14,11,1994); }
    @Test public void testPrevious9() { checkPrevious(15,12,1994,14,12,1994); }
    @Test public void testPrevious10() { checkPrevious(15,6,1700,14,6,1700); }
    @Test public void testPrevious11() { checkPrevious(15,6,1701,14,6,1701); }
    @Test public void testPrevious12() { checkPrevious(15,6,2023,14,6,2023); }
    @Test public void testPrevious13() { checkPrevious(15,6,2024,14,6,2024); }

    private void checkPrevious(int d, int m, int y, int ed, int em, int ey) {
        DateUtil date = new DateUtil(d, m, y);
        date.decrement();
        Assert.assertEquals(ed, date.getDay());
        Assert.assertEquals(em, date.getMonth());
        Assert.assertEquals(ey, date.getYear());
    }

    // ================================
    // 4. Table B (Next)
    // ================================

    @Test public void testNext1() { checkNext(1,6,1994,2,6,1994); }
    @Test public void testNext2() { checkNext(2,6,1994,3,6,1994); }
    @Test public void testNext3() { checkNext(15,6,1994,16,6,1994); }
    @Test public void testNext4() { checkNext(30,6,1994,1,7,1994); }
    @Test public void testNext6() { checkNext(15,1,1994,16,1,1994); }
    @Test public void testNext7() { checkNext(15,2,1994,16,2,1994); }
    @Test public void testNext8() { checkNext(15,11,1994,16,11,1994); }
    @Test public void testNext9() { checkNext(15,12,1994,16,12,1994); }
    @Test public void testNext10() { checkNext(15,6,1700,16,6,1700); }
    @Test public void testNext11() { checkNext(15,6,1701,16,6,1701); }
    @Test public void testNext12() { checkNext(15,6,2023,16,6,2023); }
    @Test public void testNext13() { checkNext(15,6,2024,16,6,2024); }

    private void checkNext(int d, int m, int y, int ed, int em, int ey) {
        DateUtil date = new DateUtil(d, m, y);
        date.increment();
        Assert.assertEquals(ed, date.getDay());
        Assert.assertEquals(em, date.getMonth());
        Assert.assertEquals(ey, date.getYear());
    }

    // ================================
    // 5. Leap Year Tests (WITH PRINT)
    // ================================

    @Test
    public void testLeapYearFeb28ToFeb29() {
        DateUtil date = new DateUtil(28, 2, 2024);

        System.out.println("=== Leap Year Test ===");
        System.out.println("Before: " + date);

        date.increment();

        System.out.println("After: " + date);

        Assert.assertEquals(29, date.getDay());
    }

    @Test
    public void testLeapYearFeb29ToMarch1() {
        DateUtil date = new DateUtil(29, 2, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
    }

    @Test
    public void testMarch1ToFeb29() {
        DateUtil date = new DateUtil(1, 3, 2024);
        date.decrement();
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(2, date.getMonth());
    }

    @Test
    public void testLeapYearFeb29ToFeb28() {
        DateUtil date = new DateUtil(29, 2, 2024);
        date.decrement();
        Assert.assertEquals(28, date.getDay());
        Assert.assertEquals(2, date.getMonth());
    }
}