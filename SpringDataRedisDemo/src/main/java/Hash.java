import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-redis.xml"})
public class Hash {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void setHsh() {
        redisTemplate.boundHashOps("map").put("name", "张三");
        redisTemplate.boundHashOps("map").put("age", "23");
        redisTemplate.boundHashOps("map").put("address","北京");
    }
    @Test
    public void getValue(){
//        Set keys = redisTemplate.boundHashOps("map").keys();
//        for (Object key : keys) {
//            System.out.println(key);
//        }
//        List values = redisTemplate.boundHashOps("map").values();
//        for (Object value : values) {
//                System.out.println(value);
//            }
        Map <String,String>entries = redisTemplate.boundHashOps("map").entries();
        Set<Map.Entry<String, String>> entries1 = entries.entrySet();
        for (Map.Entry<String, String> stringStringEntry : entries1) {
            String key = stringStringEntry.getKey();
            String value = stringStringEntry.getValue();
            System.out.println(key+":"+value);
        }
    }
        
    }

