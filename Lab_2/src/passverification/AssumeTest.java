package passverification;
import org.junit.*;

public class AssumeTest {
        private static Verification Ver;

        @BeforeClass
        public static void setUpClass() {
            Ver = new Verification("Pa$$w0rd", "Pa$$w0rd");
        }

        @Test //проверка пароля на NotNull
        public void InputPassword_NOT_NULL() {
            String expected = Ver.newPassword;
            Assume.assumeNotNull(expected);
        }
        @Test //тестирование метода для сравнения паролей
        public void PasswordsVerificationTest() {
            //если пароли одинаковые, то тест не будет игнорироваться
            Assume.assumeTrue(Ver.password.equals(Ver.newPassword));
        }
    @Test //тестирование методя для сравнения паролей (разные пароли)
    public void InvalidPasswordTest() {
        //если пароли разные, то тест не будет игнорироваться
        Assume.assumeFalse(Ver.password.equals(Ver.newPassword));
    }
    }


