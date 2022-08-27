# 特殊字符处理

## 背景
测试提出特殊字符处理
like 查询 字符中加入%

如下所示当输入% _ 的时候能查出所有！
期待把%当做普通字符
```sql
: ==>  Preparing: SELECT index_code,ip,port,device_name,place_code,region_code,capability,create_time,update_time,version FROM device WHERE (device_name LIKE ?)
: ==> Parameters: %%%(String)
: <==      Total: 101
```

