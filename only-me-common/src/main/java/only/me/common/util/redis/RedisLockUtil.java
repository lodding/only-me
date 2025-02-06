package only.me.common.util.redis;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * RedisSessionLock
 *
 * @author peiqi
 */
@Component
public class RedisLockUtil {
    private static final Logger log = LoggerFactory.getLogger(RedisLockUtil.class);
    private final RedissonClient redissonClient;
    private final int leaseTime;

    @Autowired
    public RedisLockUtil(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
        // 默认租约时间，可以根据需要修改
        this.leaseTime = 10;
    }

    /**
     * 获取锁 默认等待时间10s
     *
     * @param lockKey
     * @return
     */
    public boolean acquireLock(String lockKey) {
        RLock lock = redissonClient.getLock(lockKey);
        try {
            return lock.tryLock(0,leaseTime, TimeUnit.SECONDS);
        }catch (InterruptedException e){
            log.error("redis 释放锁失败", e);
            return false;
        }
    }

    /**
     * 获取锁
     *
     * @param lockKey  加锁key
     * @param waitTime 等待时间
     * @param unit     过期时间
     * @return
     */
    public boolean acquireLock(String lockKey, int waitTime, TimeUnit unit) {
        RLock lock = redissonClient.getLock(lockKey);
        try {
            return lock.tryLock(waitTime, leaseTime, unit);
        } catch (InterruptedException e) {
            log.error("redis 释放锁失败", e);
            return false;
        }
    }
    public boolean acquireLock(String lockKey, int waitTime, int leaseTime , TimeUnit unit) {
        RLock lock = redissonClient.getLock(lockKey);
        try {
            return lock.tryLock(waitTime, leaseTime, unit);
        } catch (InterruptedException e) {
            log.error("redis 释放锁失败", e);
            return false;
        }
    }

    /**
     * 释放锁
     *
     * @param lockKey
     */
    public void releaseLock(String lockKey) {
        RLock lock = redissonClient.getLock(lockKey);
        //检查当前线程是否持有锁
        if (lock.isHeldByCurrentThread()) {
            lock.unlock();
        }
    }
}
