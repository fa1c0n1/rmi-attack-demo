# rmi-attack-demo
在学习Java反序列化漏洞的过程中，用来理解Java RMI程序的执行流程，演示如何攻击Java RMI程序的几个示例。

#### 示例1：

1、运行RMI服务端 `src/me/mole/javarmi/RMIServer.java`<br>
2、运行RMI客户端 `src/me/mole/javarmi/RMIClient.java`

#### 示例2：

1、先在远程类ExportObject `rmi-attack-demo/out/production/remote-class` 目录下，通过Python开启一个Http服务：
`python -m http.server 8000`<br>
2、运行RMI服务端 `src/me/mole/javarmi/RMIServer1.java`<br>
3、运行RMI客户端 `src/me/mole/javarmi/RMIClient1.java`<br>

#### 示例3：

1、先在远程类ExportObject1 `rmi-attack-demo/out/production/remote-class` 目录下，通过Python开启一个Http服务：
`python -m http.server 8000`<br>
2、运行RMI服务端 `src/me/mole/javarmi/RMIServer2.java`<br>
3、运行RMI客户端 `src/me/mole/javarmi/RMIClient2.java`<br>

