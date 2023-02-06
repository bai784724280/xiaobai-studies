# 小白学习

#### 介绍
学习、温习、常规性需求、集成各种中间件、各种处理策略、算法基础、设计模式基础、测试等的代码库.

#### 软件架构
springboot 2.5.2 + mybatis 3.4.6 + redis


#### 配置文件application.yml说明

1.  多数据源配置
2.  redis配置
3.  rabbitmq配置(暂时关闭,需连接自己部署好的rabbitmq消息中间件)
4.  mybatis配置
5.  swagger配置
6.  Flyway
7.  .....

#### 学习及测试内容

1.  常规springboot项目的搭建
2.  AOP自定义日志格式打印
3.  AOP参数判空配置
4.  单表批量插入性能测试
5.  各种工具类编写、收集、完善、测试: json数据消除转义工具类、MAC地址获取工具类、生成token工具类、解析Token工具类、调用其他接口工具类、数据库连接工具类、
                  读取Excel工具类,解析和生成二维码图片工具类等等...
6.  redis缓存管理器: 缓存失效时间和缓存的key自定义
7.  自定义注解
8.  常规增删改查、批量插入等
9.  集成redis、rabbitmq等配置
10. JDBC连接池,连接工具学习
11. 构建者模式构建JDBC数据库连接对象
12. AES加解密功能:加密返回数据和解密参数
13. 延时双删机制
14. 温习自定义异常,自定义注解,自定义redis配置文件等
15. 文件上传,支持多文件上传
16. 自定义定时任务功能,Springboot自带定时任务注解等    
17. 熟悉学习基础算法,收集网络上大佬们的算法:
        一. 递归算法及其案例: 文件递归搜索
        二. 冒泡排序
        三. 分页算法(未测试)
18. 模拟数据结构: 堆栈数据结构
19. 集成Flyway,及其配置类 自动升级数据库脚本
20. 集成swagger,及其配置类
21. Java爬虫,爬取页面(完成一半)
22. 新增Sm2非对称加密工具类
23. 流式查询读取400万数据量,分析异常数据,写入25万异常数据    
24. java多线程基础温习
25. 温习单例模式
26. 学习镜像部署   
27. 新增字段脱敏显示功能
28. 根据定制好的简单PDF模板生成输出单页pdf文件    
29.  多线程分片处理,提高并发性探索    
30. .................................

#### 说明
仅供小白学习使用! 盗用必究!

#### 总结
不成体系的信息输出，叫经验，叫语录，叫微博，而难以叫知识：因为不成体系的信息即使被验证是正确的，
也由于搞不清楚为什么他是正确的而很难让他作为地基去发展和推衍新的知识，也不清楚验证是否全面。
换而言之，这样的信息输出是一次性受益的，无法激发人深入思考的，只能把它记录于“收藏夹”或“史书”，难以进一步的去发展和深入。
不成体系的信息输出，是容易被遗忘、篡改和失传的.