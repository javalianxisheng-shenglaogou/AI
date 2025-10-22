# ***\*后端本地部署运行\****

**准备环境**

• [AI模拟面试应用源码](https://codeup.aliyun.com/60fadd729187b7df39056384/training_camp/java-ai-interview-agent)

• Java 版本 >= 22

**下载代码**

源码地址：https://codeup.aliyun.com/60fadd729187b7df39056384/training_camp/java-ai-interview-agent

可以使用 Git 或者直接下载 zip 压缩包的形式

1、使用 zip 压缩包下载

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps1.jpg) 

2、使用 Git 下载

需要提前安装 Git

1）找到想要下载源码的路径

2）右键 选择 在终端打开

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps2.jpg) 

3）或者在相关目录上面输出 cmd 回车

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps3.jpg) 

4）设置云效克隆账户和密码 ⁠         ‍         ‍           

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps4.jpg) 

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps5.jpg) 

4）输下面命令

Plain Text git clone https://codeup.aliyun.com/60fadd729187b7df39056384/training_camp/java-ai-interview-agent.git

**安装 PostgreSQL 环境**

**阿里云官方**

官方 [链接��](https://www.aliyun.com/product/rds/postgresql)

1、授权 「SLR 授权」

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps6.jpg) 

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps7.jpg) 

最后授权完成之后

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps8.jpg) 

2、选择配置

**注意⚠️**

如果选择了 自动启停 选择了的话一定要尽快创建⁠本地可以正常链接的账号 + 创建数据库确保本地可以链接上

3、支付成功

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps9.jpg) 

5、设置账户相关配置方便本地链接

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps10.jpg) 

6、创建数据库

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps11.jpg) 

7、安装 vector 插件

可以找到已经安装的 vector 插件

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps12.jpg) 

8、允许远程链接

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps13.jpg) 

9、本地 IDEA 链接 线上 DB

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps14.jpg) 

• 外网地址：pgm-aaazzzxxx.rwlb.rds.aliyuncs.com

• 外网端口:  5432

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps15.jpg) 

同时这里的 database 需要写值否者无法连上，可以写 postgres

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps16.jpg) 

10、创建对应的表

可以看到在网页端创建的表

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps17.jpg) 

右键选择 New  ->  Query Console

Plain Text -- 1. 开启 pgvector 扩展 (如果尚未开启)  CREATE EXTENSION IF NOT EXISTS vector;     -- 2. 创建存储向量的表  CREATE TABLE IF NOT EXISTS public.vector_store   (     id     UUID PRIMARY KEY DEFAULT gen_random_uuid(),     content  TEXT,     metadata  JSONB,     embedding VECTOR(1536)   ); 

选择你创建好的这个数据库

Ctrl + A 全选 SQL 右键 Execute

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps18.jpg) 

执行成功的截图

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps19.jpg) 

**navicat连接**

1）创建数据库链接

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps20.jpg) 

2）输入服务器链接地址和设置好的用户名密码

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps21.jpg) 

3）可以通过查询语句创建表

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps22.jpg) 

Plain Text -- 1. 开启 pgvector 扩展 (如果尚未开启)  CREATE EXTENSION IF NOT EXISTS vector;     -- 2. 创建存储向量的表  CREATE TABLE IF NOT EXISTS public.vector_store   (     id     UUID PRIMARY KEY DEFAULT gen_random_uuid(),     content  TEXT,     metadata  JSONB,     embedding VECTOR(1536)   ); 

**释放实例**

如果不再使用阿里云的 PostgreSQL 需⁠要进行进行释放实例

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps23.jpg) 

**非阿里云**

**线上 Docker**

下载的这个 PostgreSQL 默认已经安装了 pgvector 插件，不需要再单独安装

1、首先需要有一台服务器

2、其次需要安装好 Docker 可以参考官方文档 https://docs.docker.com/engine/install/ubuntu/ + 国内下载镜像 https://mirrors.aliyun.com/docker-ce/linux/

3、执行相关命令

1） 下载 ankane/pgvector

Plain Text docker pull ankane/pgvector

 

Plain Text docker run            \  -e POSTGRES_USER=登录用户名     \ -e POSTGRES_PASSWORD=登录用户密码  \ -e POSTGRES_DB=创建的 db 的名字   \    --name my_postgres        \ -p 5432:5432           \ -d                \ ankane/pgvector

2）如果出现 docker pull 报错，可以试试这样⁠           ‍           ‍          

Plain Text docker pull docker.1panel.live/ankane/pgvector

那么最后 run 的语句就变成

Plain Text docker run            \  -e POSTGRES_USER=登录用户名     \ -e POSTGRES_PASSWORD=登录用户密码  \ -e POSTGRES_DB=创建的 db 的名字   \    --name my_postgres        \ -p 5432:5432           \ -d                \ docker.1panel.live/ankane/pgvector

4、校验是否创建成功9miz/FEjxr3m0C0B2Ht5uGhchaW4wLg3P2BJhxjxO0c=

Plain Text docker ps

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps24.jpg) 

5、本地尝试连接A47lphkkDDkxdCS/rQHpdWHGIqT1c+f0rRj5gEHvdTo=

**防火墙也一定要打开 5432  如果有宝塔对应的安全组也要打开**

PS  这个不用修改 PostgreSQL 配置文件设置账号「允许远程连接」也可以直接进行链接的

同时这里的 database 需要写值否者无法连上，可以写 postgresAKPc6M4iKSkEWXIgF/ZKtg3S6/WaUaechyq91VoRDuw=

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps25.jpg) 

**本地 Docker**

Windows 参考 [官方文档](https://docs.docker.com/desktop/setup/install/windows-install/)Mac 参考 [官方文档](https://docs.docker.com/desktop/setup/install/mac-install/)

从官网 [https://www.docker.com](https://www.docker.com/) 下载对应自己系统版本的 Docker Desktop

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps26.jpg) 

双击下载下来的 Docker Desktop Installer.exe  ->  点击 OK 之后就安装成功

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps27.jpg) 

打开 Terminal

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps28.jpg) 

执行相关命令 docker pull

Plain Text docker pull docker.1panel.live/ankane/pgvector

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps29.jpg) 

执行 docker run 的语句就变成

Plain Text docker run -e POSTGRES_USER=leikooo -e POSTGRES_PASSWORD=mypassword -e POSTGRES_DB=mydb --name postgresql -p 5432:5432 -d docker.1panel.live/ankane/pgvector

yh8l81YUMMJFQGQoG4HMmbCaxvVRDX9Kw4gh1XBA/Bo=

校验是否创建成功

Plain Text docker ps

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps30.jpg) 

yh8l81YUMMJFQGQoG4HMmbCaxvVRDX9Kw4gh1XBA/Bo=

**创建 dayu-ai-agent 数据库**

这里使用 IDEA 自带的工具，其他工具同理

1、在对应的 Data Source 里面找到刚才链接好的 ⁠postgresql ，右键选择 New 选择 Query Console

2、在创建好的 Query Console 里输入

Plain Text CREATE DATABASE "dayu_ai_agent";

3、选择左上角的 Execute 执行相关 SQL

4、判断是否执行成功，如果对应 SQL 左侧有⁠ √ 那么表示执行成功

5、查看执行成功后的 dayu_ai_agent

3、执行建表语句

Plain Text -- 1. 开启 pgvector 扩展 (如果尚未开启)  CREATE EXTENSION IF NOT EXISTS vector;     -- 2. 创建存储向量的表  CREATE TABLE IF NOT EXISTS public.vector_store   (     id     UUID PRIMARY KEY DEFAULT gen_random_uuid(),     content  TEXT,     metadata  JSONB,     embedding VECTOR(1536)   ); 

选择 dayu_ai_agent 这个数据库

Ctrl + A 全选 SQL 右键 Execute

执行成功的截图

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps31.jpg) 

**Ollama 本地**

官方下载链接 [https://ollama.com](https://ollama.com/)

**注意**：如果本地 GPU 不是很强还是建议使用 阿里云 的

**切换下载 model 的盘符**

在系统设置 -> 高级系统设置 ->  环境变量

新增加一个 OLLAMA_MODELS 路径设置到非 C 盘的目录下

最后点击两次 确认 即可

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps32.jpg) 

**安装 gemma3**

1、可以直接通过  win + r 输入 cmd 出现的黑窗口输入下面命令

Plain Text ollama run gemma3:1b

2、使用 gemma3

Plain Text ollama run gemma3:1b

测试功能是否正常

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps33.jpg) 

**阿里云**

阿里云百炼  [https://bailian.console.aliyun.com](https://bailian.console.aliyun.com/)

刚开始需要实名进行认证 [账号中心控制台](https://myaccount.console.aliyun.com/cert-info)

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps34.jpg) 

获取 API Key

[https://bailian.console.aliyun.com](https://bailian.console.aliyun.com/)

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps35.jpg) 

打开 「API Key 管理」相关页面 https://bailian.console.aliyun.com/?tab=model#/api-key

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps36.jpg) 

创建归属空间选择为 「默认业务空间」即可，选择⁠成功之后选择「确认」即可

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps37.jpg) 

复制创建的 key，**注意一定不要泄露，如果不慎泄露那么一定要及时删除 API Key**

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps38.jpg) 

**查看调用情况**

对应地址 https://bailian.console.aliyun.com/?tab=model#/model-telemetry

要注意有延迟不能立刻看到调用的次数！

**工具调用相关**

**searchapi**

官网注册账号获取 API  [官网](https://www.searchapi.io/)

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps39.jpg) 

配置文件对应的位置，这里的 key 就是

Plain Text # searchAPI   search-api:    api-key: 你的 API Key

**MCP 服务**

**高德地图**

1、[高德地图官网](https://lbs.amap.com/) 进行注册、个人认证

2、对应的 key 的地址 https://console.amap.com/dev/key/app

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps40.jpg) 

3、添加 key

4、可以查看对应的 key

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps41.jpg) 

**查看用量**

官网链接 https://console.amap.com/dev/flow/detail

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps42.jpg) 

**测试 MCP 服务**

1、这里使用的这个 https://developers.cloudflare.com/agents/guides/test-remote-mcp-server/

Plain Text npx @modelcontextprotocol/inspector@0.14.0

输入 y 即可继续安装

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps43.jpg) 

2、启动成功的页面，前端页面地址 [http://127.0.0.1:6274](http://127.0.0.1:6274/)

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps44.jpg) 

3、测试 key      ‍         ⁠         ‍        

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps45.jpg) 

添加一个 AMAP_MAPS_API_KEY 值就是上面获取的高德的 key

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps46.jpg) 

测试成功，有对应的返回值

如果是 Windows 注意 Command 是 npx.cmd

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps47.jpg) 

注意⚠️

如果是 Mac 或者 Linux 是 npx 注意没有最后的 .cmd 后缀

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps48.jpg) 

**替换 KEY**

具体位置 src/main/resources/mcp-servers.json 替换成自己的真实高德地图的 KEY

对应的 key 的地址 https://console.amap.com/dev/key/app

Mac 或者 Linux 系统一定要把后缀 .cmd 去掉即最后的 command 是 npx

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps49.jpg) 

**Pexels API**

1、对应的地址 https://www.pexels.com/api/key/ 需要提前注册一个账号

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps50.jpg) 

2、使用的位置

修改下面的 「改为你的 API Key」修改成⁠自己实际的 key

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps51.jpg) 

**进行 package**

找到  dayu-image-search-mcp-server Maven 侧边栏

package 成功

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps52.jpg) 

**测试 API**

1、找到对应的 ImageSearchToolTest

![img](file:///C:\Users\LITTLE~1\AppData\Local\Temp\ksohtml13680\wps53.jpg) 

2、测试 API 是否正常使用
