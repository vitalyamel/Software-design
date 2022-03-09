package passverification;
import org.junit.*;

public class AssertTest {
    private static Verification Ver;

    @BeforeClass
    public static void setUpClass() {
        Ver = new Verification("Pa$$w0rd", "Pa$$w0rd");
    }

    @Test //проверка пароля пользователя на NotNull
    public void InputPassword_NOT_NULL() {
        String expected = Ver.newPassword;
        Assert.assertNotNull(expected);
    }
    @Test //тестирование метода для одинаковых паролях
    public void PasswordsVerificationTest() {
        Assert.assertEquals(Ver.password, Ver.newPassword);
    }
    @Test //тестирование метода для разных паролей
    public void InvalidPasswordTest() {
        Assert.assertNotEquals(Ver.password, Ver.newPassword);
    };
}
