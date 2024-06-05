import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private final String bunName;
    private final float bunPrice;

    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters()
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Булочка", 100.000000000F},
                {" Булочка", 100.000000000F},
                {"Булочка ", 100.000000000F},
                {" ", 100.000000000F},
                {"Bulochka", 100.000000000F},
                {"%^*$!@", 100.000000000F},
                {"1234", 100.000000000F},
                {"", 100.000000000F},
                {null, 100.000000000F},
                {"Булочка", 0.000000000F},
                {"Булочка", -100.000000000F},
                {"Булочка", Float.MIN_VALUE},
                {"Булочка", Float.MAX_VALUE}
        };
    }

    @Test
    public void getBunNameTest() {
        Bun bun = new Bun(bunName, bunPrice);
        Assert.assertEquals("Имя булочки не соответствует ожидаемому!", bunName, bun.getName());
    }

    @Test
    public void getBunPriceTest() {
        Bun bun = new Bun(bunName, bunPrice);
        Assert.assertEquals("Цена булочки не соответствует ожидаемой!", bunPrice, bun.getPrice(), 0.0F);
    }


}
