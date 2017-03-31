import com.benoitparmentier.AppConfig;
import com.benoitparmentier.MyService;
import com.benoitparmentier.MyService2;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by PC on 31/03/2017.
 */
public class ProxyTest {

    @Test
    public void test(){
        ConfigurableApplicationContext run = SpringApplication.run(AppConfig.class);
        MyService myService = run.getBean(MyService.class);
        myService.doSomething();
        MyService2 myService2 = run.getBean(MyService2.class);
        myService2.doSomething();
    }

}
