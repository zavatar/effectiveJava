import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EncrypDESTest {
    private EncrypDES encrypDES;

    @Before
    public void setUp() throws Exception {
        encrypDES = new EncrypDES();
    }

    @Test
    public void testMain() throws Exception {
        String msg ="message";
        byte[] encontent = encrypDES.Encryptor(msg);
        byte[] decontent = encrypDES.Decryptor(encontent);
        assertEquals(msg, new String(decontent));
    }
}