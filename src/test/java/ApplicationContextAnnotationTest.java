import com.coco.AppConfig;
import com.coco.MyService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by PC on 01/11/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ApplicationContextAnnotationTest {

    @Autowired
    private MyService myService;

    @Test
    public void setup(){

        Assert.assertSame(myService.doSomething(), "youyou");

    }


}
