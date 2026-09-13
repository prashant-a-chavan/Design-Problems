package practicedp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class PracticeDpApplicationTests {

    @Test
    void shouldRunMainWithoutThrowing() {
        assertDoesNotThrow(() -> PracticeDpApplication.main(new String[0]));
    }

}
