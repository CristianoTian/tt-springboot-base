springBoot 集成 https步骤

1.进入到 %JAVVA_HOME%\bin 目录下，执行如下命令生成一个数字证书：

keytool -genkey -alias tomcathttps -keyalg RSA -keysize 2048  -keystore D:\javaboy.p12 -validity 365

命令含义如下：

genkey 表示要创建一个新的密钥。
alias 表示 keystore 的别名。
keyalg 表示使用的加密算法是 RSA ，一种非对称加密算法。
keysize 表示密钥的长度。
keystore 表示生成的密钥存放位置。
validity 表示密钥的有效时间，单位为天。



将生成的.p12文件放入当前工程的 resources下 并在application.properties中配置
server.ssl.key-store=classpath:javaboy.p12
server.ssl.key-alias=tomcathttps
server.ssl.key-store-password=*********