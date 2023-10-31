工程结构目录:
    -com.glanz.bloomfilter
        -redisconfig : 包含了redis配置解析相关类
        -service : 包含了bloomFilter具体实现


类解析：
    (interface)BloomFilterUtil: 有计算hash值,计算占位,加入新值, 检查存在等方法 -> 面向抽象编程
    (class)BloomFilterUtils: BloomFilterUtil 的实现类
    (class)BloomFilterInit: 初始化bloomFilter, 类似线程池的设计, 自动匹配相应的构造器
