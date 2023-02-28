# DDDML Criterion Support

## 上传 Maven 构件的说明

### 配置工程的 pom.xml 文件

示例：

```xml
<!--添加distributionManagement节点-->
<distributionManagement>
    <snapshotRepository>
        <id>maven-snapshots</id>
        <url>http://10.201.2.14:8081/repository/maven-snapshots/</url>
    </snapshotRepository>
    <repository>
        <id>maven-releases</id>
        <url>http://10.201.2.14:8081/repository/maven-releases/</url>
    </repository>
</distributionManagement>
```
配置了两个分发构件的仓库，snapshotRepository 表示快照版本的仓库，repository 表示 release 版本的仓库。它们包含两个子节点：`id` `url`，id 为仓库的标识，url 是私服的仓库地址。

### 配置 settings.xml 文件

示例：

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
            http://maven.apache.org/xsd/settings-1.0.0.xsd">
    <interactiveMode>true</interactiveMode>
    <usePluginRegistry>true</usePluginRegistry>
	<mirrors>
		<mirror>
			<id>nexus</id>
			<name>nexus</name>
			<mirrorOf>central</mirrorOf>
			<url>http://10.201.2.14:8081/repository/maven-public/</url>
		</mirror>
	</mirrors>
	<servers>
		<server>
			<id>maven-snapshots</id>
			<username>admin</username>
			<password>admin123</password>
			<filePermissions>755</filePermissions>
			<directoryPermissions>755</directoryPermissions>
		</server>
		<server>
			<id>maven-releases</id>
			<username>admin</username>
			<password>admin123</password>
			<filePermissions>755</filePermissions>
			<directoryPermissions>755</directoryPermissions>
		</server>
	</servers>
	<profiles>
		<profile>
			<activation>
				<activeByDefault>true</activeByDefault>
			</activation>
			<repositories>
				<repository>
					<id>maven-snapshots</id>
					<url>http://10.201.2.14:8081/repository/maven-snapshots</url>
					<snapshots>
						<updatePolicy>always</updatePolicy>
					</snapshots>
				</repository>
			</repositories>
		</profile>
	</profiles>

</settings>
```

` settings.xml` 中每一个 server 的 id 对应 `pom.xml` 中的 distributionManagement 中的 repository 的id。username 和 password 表示访问仓库的用户名和密码。

filePermissions 和 directoryPermissions 表示构件上传到仓库中，对构件文件和目录设置什么样的权限。另外 pom.xml 不支持配置用户名和密码的原因是由于 pom.xml 文件是需要对外发布的，而用户名密码这些信息较为敏感不适合发布在网络上，因此 pom.xml 并不支持配置 username 和 password 。

### Deploy

进入项目主目录，运行命令 `mvn clean deploy` 上传构件。

说明：release 版本的构件通常不支持同样一个版本部署多次，你如果想要再次部署必须要升级版本。因此如果工程代码还不稳定的时候不要把 SNAPSHOT 的版本后缀名去掉，否则 maven 会将其视为一个 release 版本。