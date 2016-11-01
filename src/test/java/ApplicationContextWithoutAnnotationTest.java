import com.coco.AppConfig;
import com.coco.MyService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by PC on 01/11/2016.
 */
public class ApplicationContextWithoutAnnotationTest {

    @Autowired
    private MyService myService;

    @Test
    public void setup(){

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        com.coco.MyService myService = context.getBean(com.coco.MyService.class);
        Assert.assertSame(myService.doSomething(), "youyou");

    }

}
