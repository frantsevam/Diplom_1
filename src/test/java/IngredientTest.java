import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;
@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters()
    public static Object[][] getTestData() {
        return new Object[][]{
                {SAUCE, "Кетчуп", Float.MIN_VALUE},
                {SAUCE, "Ketchup", 100.000000000F},
                {SAUCE, null, 100.000000000F},
                {null, null, 0},
                {SAUCE, "%*^@$", 100.000000000F},
                {SAUCE, "Кетчуп", -100.000000000F},
                {FILLING, "Котлета", Float.MAX_VALUE},
                {FILLING, "", 100.000000000F},
                {FILLING, "1234", 100.000000000F},
                {FILLING, "Булка", 0.000000000F},

        };
    }
    @Test
    public void getTypeReturnTrueType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Тип не соответствует ожидаемому!", type, ingredient.getType());
    }
    @Test
    public void getNameReturnTrueName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Ингредиент не соответствует ожидаемому!", name, ingredient.getName());
    }
    @Test
    public void getPriceReturnTruePrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Цена не соответствует ожидаемой!", price, ingredient.getPrice(), 0);
    }
}
