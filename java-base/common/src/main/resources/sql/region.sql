drop table region;
CREATE TABLE `region` (
                          `index_code` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '设备编码',
                          `region_name` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '区域名称',
                          `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                          `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                          `version` INT  DEFAULT NULL COMMENT '乐观锁编码',
                          PRIMARY KEY (`index_code`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
