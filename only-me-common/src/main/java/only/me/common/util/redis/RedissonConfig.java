package only.me.common.util.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author peiqi
 */
@Configuration
public class RedissonConfig {
    @Resource
    private RedisProperties redisProperties;

    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://"+ redisProperties.getHost()+":"+redisProperties.getPort());
        config.useSingleServer().setDatabase(redisProperties.getDatabase());
        return Redisson.create(config);
    }
}
