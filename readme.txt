工程结构目录:
    -com.glanz.bloomfilter
        -redisconfig : 包含了redis配置解析相关类
        -service : 包含了bloomFilter具体实现


类解析：
    (interface)BloomFilterUtil: 有计算hash值,计算占位,加入新值, 检查存在等方法 -> 面向抽象编程
    (class)BloomFilterUtils: BloomFilterUtil 的实现类
    (class)BloomFilterInit: 初始化bloomFilter, 类似线程池的设计, 自动匹配相应的构造器

hash函数采用了工具包中的, 可以自写hash32 或 hash64 或hash128等， 借鉴java中的高16位与低16位与来得到新的hash值, 也可以采用固定随机值

代码没有实现本地文件的读取与添加, 以及不支持多hash, 删除等操作，

想看实现这些功能的boolFilter 可以找到springboot中间件的仓库， 里面实现了一个黑白名单过滤器, 其中有一种方法是重写的bloomFilter
