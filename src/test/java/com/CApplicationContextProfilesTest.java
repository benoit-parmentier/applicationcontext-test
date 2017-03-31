import com.benoitparmentier.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by PC on 01/11/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class CApplicationContextProfilesTest {


    @Value("${java.version}")
    private String javaVersion;

    @Value("${db.user}")
    private String dbUser;

    @Test
    public void setup(){

        System.out.println("javaVersion : " + javaVersion);
        System.out.println("dbUser : " + dbUser);

    }
}
