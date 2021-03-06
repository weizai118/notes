---------------------------
MYSQL-数据库备份与还原		|
----------------------------
	# 把当前已有的数据或者记录保留
	# 把已经保存的数据恢复到对应的表中



---------------------------
MYSQL-数据库备份			|
----------------------------
	# 数据表备份
		* 不需要通过SQL来备份.直接进入到数据库文件夹,复制对应的表结构和数据文件.还原的时候,直接把文件复制进去就OK
		* 并不推荐,因为会受到数据库存储引擎的限制.

	# 单表数据备份
		* 每次只能备份一张表,只能备份数据(表结构不能备份)
		* 通常都是把表中的数据导出到文件
		* 从表中选择一部分数据保存到外部的文件中
			SELECT [字段列表或者*] INTO OUTFILE [文件所在路径] FROM [数据源]
			
			select * outfile `d:/demo.txt` from sru;
		* 前提是,外部文件不存在.如果外部文件已经存在,则不会创建.导出失败
		* 高级备份- 自定义字段和行的处理方式
			SELECT [字段列表或者*] INTO OUTFILE [文件所在路径] fields [字段处理] lines [行处理] FROM [数据源]
			* 用的时候去百度吧... ...

		* 数据还原,表结构必须存在
			load data in file [文件所在的路径] into [表名](字段列表) fields [字段处理] lines [行处理];
			* 怎么备份的,怎么还原

	# SQL备份
		['常用,合理']
		* 备份的是SQL语句:系统会对表结构,以及数据进行处理变成SQL语句,进行备份,还原的时候就是执行SQL指令就OK了.主要是针对表结构
		# 备份数据
			* MySQL,没有提供备份指令.需要用到mysql提供的软件
			* mysqldump.exe
				mysqldump -u[用户名] -p[密码] [数据库名] [表1] [表2] ...>[生成的脚本文件路径];
				mysql -uroot -proot demo stu class > c:/mysql.sql		
				* 不写表名,就是默认备份整个数据库
				* 结尾不要打分号,不要登录mysql,直接在CMD下运行
				* 还原的时候,不管有没有相同的表结构,都不要('有就删除').都是自己新建
				* 生成的脚本文件中不包含create database语句
				* 支持把远程服务器的SQL文件备份到本地.
					mysqldump -h[ip] -P[端口] -u[用户密码] -p[密码] [数据库] [表1]... > [脚本文件路径]
		
		# 还原数据
			* 有两种还原方式
			1,使用mysql.exe客户端进行还原
				 mysql -u[用户名] -p[密码] [数据库]<[脚本文件路径]
				 * '不用登录MYSQL服务器'
				 * 会把已经存在的表给干掉
				 * 同样,也支持'远程服务器数据还原',把本地数据还原到远程服务器
				
			2,使用MYSQL的命令进行还原
				source SQL脚本路径
				source e:/demo.sql
				* 必须先登录MYSQL,选择一个数据库

	# 增量备份
		# 比较麻烦,不是针对数据或者SQL指令.是针对MYSQL服务器的日志文件进行备份
		# 所谓的增量:指定时间段开始备份(00:00:00-00:00:00),备份数据不会重复,不会浪费空间,而且所有的操作都会被记录(CRUD).
		# 大项目,都是用增量备份
		# 项目越大,备份的频率越高.














----催希凡
备份与恢复
1,数据库导出SQL脚本
   > mysqldump -u用户名 -p密码 数据库名>生成的脚本文件路径
   > 例如:mysql -uroot -proot demo>c:\mysql.sql (与mysql.exe和mysqlid.exe一样,都在bin目录下)
	--备份数据库内容,并不是备份数据库
   > 注意,结尾不要打分号,不要登录mysql,直接在CMD下运行
   > 注意,生成的脚本文件中不包含create database语句
2,执行SQL脚本
   第一种方式
   > mysql -u用户名 -p密码 数据库<脚本文件路径
   > 例如
     * 先删除demo数据库,再重新创建demo数据库
     * mysql -uroot -proot demo<c:\demo.sql
   > 注意,结尾不要打分号,不要登录mysql直接在CMD下运行
   第二种方式
   > 登录mysql
   > source SQL脚本路径
   > 例如:
      * 先删除demo数据库,再重新创建demo数据库
      * 切花到demo数据库
      * source c:\demmo.sql

数据库--->sql:备份
sql--->数据库:恢复
