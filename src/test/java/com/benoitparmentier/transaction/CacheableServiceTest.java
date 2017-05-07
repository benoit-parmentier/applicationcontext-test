package com.benoitparmentier.transaction;

import com.benoitparmentier.config.AppConfig;
import com.benoitparmentier.service.CacheableService;
import com.benoitparmentier.model.Actor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class CacheableServiceTest {

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private CacheableService cacheableService;

    @Test
    public void testCacheManager(){
        System.out.println("1)================================");
        System.out.println(cacheManager);
    }

    @Test
    public void testLoadAllCharacter() {
        cacheableService.loadAllCharacters();
        cacheableService.loadAllCharacters();
        System.out.println("================================");
        System.out.println(cacheManager.getCacheNames());
        assert cacheableService.COUNTALL == 1;
    }

    @Test
    public void testLoadCharacter() {
        Actor mb = new Actor("m", "b");
        cacheableService.loadActor(mb);
        cacheableService.loadActor(mb);
        Actor ap = new Actor("a", "p");
        cacheableService.loadActor(ap);
        cacheableService.loadActor(ap);
        assert cacheableService.COUNT == 2;
    }

}
