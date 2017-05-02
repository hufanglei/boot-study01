
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


6.Springboot 之 JPA对Mysql数据库的基本的 增删改查

7.使用自定义方式对数据库进行修改、删除和查询。  Springboot 之 JPA数据库操作进阶篇
都需要以findBy开头，且方法中的字段名必须与实体类中的属性名一致，并遵循驼峰式代码编写风格
And：等价于SQL中的and关键字，比如：findByUserNameAndPassword(String username, String pwd)；
Or：等价于SQL中的or关键字，比如：findByUserNameOrEmail(String username, String email)；
Between：等价于between关键字（介于两者之间），比如：findByAgeBetween(int max, int min)（获取age在max和min之间的数据）；
LessThan：等价于<，比如：findByAgeLessThan(int val)（获取age小于val的数据）；
GreaterThan:等价于>，比如：findByAgeGreaterThan(int val)（获取age大于val的数据）；
IsNull：等价于is null，比如：findByEmailIsNull()（获取email为空的数据）；
IsNotNull：等价于is not null，比如：findByEmailIsNotNull()（获取email不为空的数据）；
NotNull：等价于IsNotNull；
Like：等价于like，比如：findByUserNameLike(String val)（获取userName中包含val的数据，在传入val的时候可以在首尾处加上%）；
NotLike：等价于not like，比如：findByUserNameNotLike(String val)（获取userName中不包含val的数据，在传入val的时候也可以在首尾处加上%）；
Not：等价于!=，比如：findByUserNameNot(String val)（获取userName不等于val的数据）；
In：等价于in，比如：findByUserNameIn(Collection<String> vals)或findByUserNameIn(String... vals)（获取userName在集合vals中的数据，参数类型可以是集合，也可以是数组，或不指定长度的数组）
NotIn：等价于not in，，比如：findByUserNameNotIn(Collection<String> vals)或findByUserNameNotIn(String... vals)（获取userName不在集合vals中的数据，参数类型可以是集合，也可以是数组，或不指定长度的数组）
OrderBy：等价于order by，比如：findByUserNameOrderByIdAsc(String userName)（Asc也可以换成Desc来更换排序方式）；

以HQL方式获取数据
①参数传递以一种有序的方式传递的，另外还有一种更为直观的方式来传递参数，下面举个例子说明：
②以HQL方式获取数据

8.Springboot 之 使用JPA对数据进行排序

排序
//单排序封装
注意： 当继承JpaRepository之后，IUserService拥有了几个findAll()的重载方法，其中一个可以传Sort对象，该方法则是排序的方法。
Sort sort = new Sort(Sort.Direction.DESC, "id");：表示通过id进行降序排序，将DESC换成ASC则表示升序，将id换成其他User对象的属性后，则通过其他字段排序。
//多排序封装


9. Springboot 之 使用JPA进行分页操作
继承了JpaRepository后的IUserService拥有了findAll的重载方法，当传入参数为Pageable时，返回传则是一个分页的对象Page。


10.Springboot 之 使用JPA做数据筛选
筛选功能需要继承于JpaSpecificationExecutor接口
封装筛选对象
多条件筛选

11. Springboot 之 使用Scheduled做定时任务
在程序入口的类上加上注释@EnableScheduling即可开启定时任务。
编写定时任务类

@Component
public class MyTimer {
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    @Scheduled(fixedRate = 3000)
    public void timerRate() {
        System.out.println(sdf.format(new Date()));
    }
}

@Scheduled(fixedRate=3000)：上一次开始执行时间点后3秒再次执行；

@Scheduled(fixedDelay=3000)：上一次执行完毕时间点后3秒再次执行；

@Scheduled(initialDelay=1000, fixedDelay=3000)：第一次延迟1秒执行，然后在上一次执行完毕时间点后3秒再次执行；

@Scheduled(cron="* * * * * ?")：按cron规则执行。


12. Springboot 之 JavaMailSender发送电子邮件

13. Springboot 之 JPA对Mysql数据库的增删改查

14.Springboot 之 使用JPA对数据进行排序

15. Springboot 之 使用JPA进行分页操作

16. Springboot 之 使用JPA做数据筛选

17. Springboot 之 使用Scheduled做定时任务

18.Springboot 之 JavaMailSender发送电子邮件

19.Springboot 之 静态资源路径配置c
在Springboot中默认的静态资源路径有：classpath:/META-INF/resources/，classpath:/resources/，classpath:/static/，classpath:/public/，
从这里可以看出这里的静态资源路径都是在classpath中（也就是在项目路径下指定的这几个文件夹）
application.properties配置文件如下：
server.port=1122

web.upload-path=D:/temp/study13/

spring.mvc.static-path-pattern=/**
spring.resources.static-locations=classpath:/META-INF/resources/,classpath:/resources/,\
  classpath:/static/,classpath:/public/,file:${web.upload-path}

注意：web.upload-path这个属于自定义的属性，指定了一个路径，注意要以/结尾；

spring.mvc.static-path-pattern=/**表示所有的访问都经过静态资源路径；

spring.resources.static-locations在这里配置静态资源路径，前面说了这里的配置是覆盖默认配置，所以需要将默认的也加上否则static、public等这些路径将不能被当作静态资源路径，
在这个最末尾的file:${web.upload-path}之所有要加file:是因为指定的是一个具体的硬盘路径，其他的使用classpath指的是系统环境变量

20.Thymeleaf 之 简要概述   Thymeleaf 之 HelloWorld
Thymeleaf是一个页面模板，类似于Freemarker、Velocity等，但Thymeleaf可以在服务器环境和静态环境下都能正常运行的页面模板，深受前后端分离开发的团队人员的青睐。
Thymeleaf的数据展现全部通过以th:开头的html自定义标签来完成。当运行在服务器环境时将会按规则替换th:对应的地方显示出服务器上的数据，当运行在静态环境时，html会自动过虑th:开头的属性，
显示默认的数据，从而达到两者都能正常运行。

21. Thymeleaf 之 使用devtools热启动、热部署
http://blog.csdn.net/zsl129/article/details/52916890


①spring.thymeleaf.cache=false方式

在application.properties中加入配置：spring.thymeleaf.cache=false；

运行入口函数：启动RootApplication里的main函数，启动成功后再停止（这步只需要执行一次即可，如果直接执行第三步将无法热启动）；

使用maven方式启动：mvn spring-boot:run。

测试结果： ctrl + f9 热部署编译java源文件
          ctrl + shift + f9  热部署编辑html


22. Springboot 之 POI导出Word文件
     http://blog.csdn.net/zsl129/article/details/52957896

     关键的依赖是poi的jar包：
     <dependency>
         <groupId>org.apache.poi</groupId>
         <artifactId>poi</artifactId>
         <version>3.15</version>
     </dependency>
     <dependency>
         <groupId>org.apache.poi</groupId>
         <artifactId>poi-scratchpad</artifactId>
         <version>3.15</version>
     </dependency>

     关键的方法:
     tmpFile： 模板文件
     contentMap：数据模型，包含具体数据的map对象
     exportFile：需要保存导出文件的路径
     private void build(File tmpFile, Map<String, String> contentMap, String exportFile) throws Exception {
         FileInputStream tempFileInputStream = new FileInputStream(tmpFile);
         HWPFDocument document = new HWPFDocument(tempFileInputStream);
         // 读取文本内容
         Range bodyRange = document.getRange();
         // 替换内容
         for (Map.Entry<String, String> entry : contentMap.entrySet()) {
             bodyRange.replaceText("${" + entry.getKey() + "}", entry.getValue());
         }

         //导出到文件
         ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
         document.write(byteArrayOutputStream);
         OutputStream outputStream = new FileOutputStream(exportFile);
         outputStream.write(byteArrayOutputStream.toByteArray());
         outputStream.close();
     }

      测试结果: WORD2003可行  word2007 不可以
