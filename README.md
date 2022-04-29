# 仓库说明
分析最佳实践技术

# 分支管理说明
master分支


# 分支管理说明
如果分支不做好管理，并行开发或者回滚的时候会造成非常大的麻烦因此定义以下几个分支管理策略
1. 所有新功能模块的开发应该基于master新建分支，新功能开发完成之后在gitlab远端发起合并请求
2. master分支不允许提交代码
3. 合并动作要在gitlab上做，由于都是基于master拉的新分支因此应该不会出现冲突，如果出现冲突也要在gitlab上解决
4. 每次提交开发了什么功能要描述清楚
5. 文档的重要性不比代码差
6. 冗余分支一个月可以清理一次


# 注意版本对应关系
https://github.com/alibaba/spring-cloud-alibaba/wiki/%E7%89%88%E6%9C%AC%E8%AF%B4%E6%98%8E

# 本项目中间件版本说明
| 软件                 | 版本号 |
|--------------------|---|
| mysql              | 5.6.51 |
| springboot         | 2.2.4.RELEASE |
| springcloud        | Hoxton.SR1 |
| springcloudalibaba | 2.2.0.RELEASE |
| nacos              | 单元格 |




