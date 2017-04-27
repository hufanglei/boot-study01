
入门地址:http://blog.csdn.net/zsl129/article/details/52880811


4.  Springboot 之 多配置文件
启动项目的方法一般有两种 ：
1）、 运行RootApplication中的main方法。
2）、 使用命令：mvn spring-boot:run
这两方法默认都是使用application.properties中的配置信息，如果有指定spring.profiles.active则使用指定的配置信息，这种方式一般用在产品运行时，
在开发和测试的时候则需要指定配置文件。

运行main可以在运行里的Config里面来配置，这个我基本没有使用过，我用的是第二种方法：

mvn spring-boot:run -Dspring.profiles.active=dev 即使用application-dev.properties中的配置信息，此时可以看到控制台显示系统使用的端口是dev中的2222

多配置文件这块我应用的较多的是在数据库的配置，开发过程中的数据库肯定是在本机，用户名和密码也是本机数据库的，而当项目部署到服务器时，数据库的地址、
用户名和密码就得修改，所以使用了多配置文件，只需要在启动项目的时候指定配置文件即可。\



5.Springboot 之 Hibernate自动建表（Mysql）

注意：最关键的是最后两个配置，spring.jpa.properties.hibernate.hbm2ddl.auto=update而不是hibernate.hbm2ddl.auto=update，使用了Jpa所以键名称需要有相应调整，否则不会自动建表
spring.jpa.properties.hibernate.hbm2ddl.auto有几种配置：

create：每次加载Hibernate时都会删除上一次生成的表，然后重新生成新表，即使两次没有任何修改也会这样执行，这就导致每次启动都是一个新的数据库，也是导致数据丢失的重要原因。

create-drop：每次加载Hibernate时都会生成表，但当SessionFactory关闭时，所生成的表将自动删除。

update：最常用的属性值，第一次加载Hibernate时创建数据表（前提是需要先有数据库），以后加载HIbernate时只会根据model更新，即使model已经删除了某些属性，数据表也不会随之删除字段。

validate：每次加载Hibernate时都会验证数据表结构，只会和已经存在的数据表进行比较，根据model修改表结构，但不会创建新表。


6. Springboot 之 JPA对Mysql数据库的增删改查