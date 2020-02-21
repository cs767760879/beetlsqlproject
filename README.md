1.该项目使用父控统一管理jar的版本，防止多个模块jar引用时产生冲突,且使用profiles的方式，管理dev，test，prod的配置文件问题
2.该工程使用SpringBoot2.2.4,集成了Swagger2,bettlsql,easyExcel等
3.整个工程计划应有统一的异常处理（根据业务抛出不同的异常）以及打印方法出参入参的切面,统一的request,response格式
4.CorsFilter.java为解决跨域问题，防止跨越问题出现
5.DataSourceConfig.java为数据源的一些配置
6.Swagger2为Swagger2的配置
对于百万数据的导出:
我个人认为首先应从选择的工具开始,应选择内存消耗率低的easyexcel框架,严禁使用poi！！！其次，使用分批导出的方式。