package com.benoitparmentier;

//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import com.benoitparmentier.config.transaction.JDBCConfig;
import com.benoitparmentier.config.transaction.TransactionConfig;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.*;

/**
 * Created by PC on 01/11/2016.
 */
@Configuration
@ComponentScan("com.benoitparmentier")
@PropertySource("classpath:/config/app.properties")
//@EnableAutoConfiguration
@Import({TransactionConfig.class, JDBCConfig.class})
@EnableCaching
public class AppConfig {

    @Bean
    public TotoBean1 totoBean1(){
        System.out.println("totoBean1()");
        return new TotoBean1();
    }

    @Bean
    public TotoBean1 totoBean2(){
        System.out.println("totoBean2()");
        return this.totoBean1();
    }

    @Bean
    public CacheManager concurrentMapCacheManager() {
        return new ConcurrentMapCacheManager("characters");
    }


}
