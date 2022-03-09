package passverification;
import org.junit.Assert;
import org.junit.Test;

public class TestSumMult {
    private int mass[] = new int[]{1,2,3,4,5};

    @Test
   public void TestGetSummMainMethod() {
        //Вызываем метод суммы чисел в массиве
        int expected = Main.getSumm(mass);
        int actual = 15;
        //метод тестирования
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestGetMultiMainMethod() {
        //Вызываем метод произведение чисел в массиве
        long expected = Main.getMulti(mass);
        long actual = 120;
        //метод тестирования
        Assert.assertEquals(expected, actual);
    }
}
