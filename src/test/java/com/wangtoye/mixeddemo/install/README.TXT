1.解压后当前目录的neo4j安装包，选取的路径建议不包含空格或者中文。
2.设置环境变量NEO4J_HOME，并且把bin目录加入到环境变量path中。
3.命令行执行
neo4j install-service
neo4j uninstall-service
使neo4j服务变成一个windows服务，可以在任务管理器中查看开启或关闭。
4.命令行执行以下命令可以进行管理
neo4j start
neo4j stop
neo4j restart
neo4j status