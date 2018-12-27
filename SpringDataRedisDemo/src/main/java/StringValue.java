import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-redis.xml"})
public class StringValue {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void setValue(){
        redisTemplate.boundValueOps("name").set("LwQ");
    }
    @Test
    public void getValue(){
        Object name = redisTemplate.boundValueOps("name").get();
        System.out.println(name);
    }
    @Test
    public void setValue1(){
        redisTemplate.boundValueOps("name").set("李伟琦");
    }
    @Test
    public void delete(){
        redisTemplate.delete("name");
    }
}
