import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();
    @Mock
    Bun bun;
    @Mock
    Ingredient firstIngredient;
    @Mock
    Ingredient secondIngredient;

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Assert.assertEquals("Булочки не соответствуют добавленным!", bun, burger.bun);
    }
    @Test
    public void addIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        Assert.assertEquals("Не все ингредиенты были добавлены!", 2, burger.ingredients.size());
    }
    @Test
    public void removeIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.removeIngredient(0);
        Assert.assertEquals("Ингредиент не был удалён!",0, burger.ingredients.size());
    }
    @Test
    public void moveIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0,1);
        Assert.assertEquals("Ингредиенты не были перемещены!", firstIngredient, burger.ingredients.get(1));
    }
    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(100F);

        burger.addIngredient(firstIngredient);
        Mockito.when(firstIngredient.getPrice()).thenReturn(200F);

        burger.addIngredient(secondIngredient);
        Mockito.when(secondIngredient.getPrice()).thenReturn(300F);

        float expectedPrice = bun.getPrice()*2 + firstIngredient.getPrice() + secondIngredient.getPrice();
        Assert.assertEquals("Цена не совпадает!", expectedPrice, burger.getPrice(), 0.0F);
    }
    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("Булочка");
        Mockito.when(bun.getPrice()).thenReturn(200F);

        burger.addIngredient(firstIngredient);
        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(firstIngredient.getName()).thenReturn("Котлета");
        Mockito.when(firstIngredient.getPrice()).thenReturn(300F);

        String actualReceipt = burger.getReceipt();
        String expectedReceipt = String.format("(==== Булочка ====)%n= filling Котлета =%n(==== Булочка ====)%n%nPrice: 700,000000%n");
        Assert.assertEquals("Данные не соответствуют ожидаемому результату!", expectedReceipt, actualReceipt);
    }
}
