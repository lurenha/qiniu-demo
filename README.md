# qiniu-demo
SpringBoot整合七牛云使用对象存储的Demo

## 项目介绍
#### 上手指南
1. 克隆项目到本地 `git clone https://github.com/lurenha/qiniu-demo.git`
1. 在IntelliJ IDEA中运行本项目，启动项目
1. 使用PostMan工具 访问http://localhost:8080/admin/create （file为要上传的文件）进行上传文件
1. 使用PostMan工具 访问http://localhost:8080/admin/delete （key为要删除的文件名）进行删除文件

#### 说明
1. 可以在配置文件中application.yml中修改文件存储方式 active: local 或者 active: qiniu
1. 前者会将文件存放在服务器本地 storage 文件夹下
1. 后者上传到七牛云服务器 （请在application.yml中自行更改七牛云对象存储配置信息）
1. PostMan以及七牛云配置相关截图可参考src/main/resources/imgs文件

##### 七牛云配置信息相关
![配置信息1](http://q4nw146g8.bkt.clouddn.com/qiniuapplication.png)

![配置信息2](http://q4nw146g8.bkt.clouddn.com/qiniuapplicationkey.png)
            
------------

### 鸣谢
#### 该项目参考了 https://github.com/linlinjava/litemall
