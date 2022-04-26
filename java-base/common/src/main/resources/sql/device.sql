drop table if exists device;
CREATE TABLE `device` (
                          `index_code` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '设备编码',
                          `ip` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '设备ip',
                          `port` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '设备端口',
                          `device_name` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '设备名称',
                          `place_code` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '地区名字',
                          `region_code` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '区域名字',
                          `capability` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '设备能力',
                          `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                          `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                          `version` INT  DEFAULT NULL COMMENT '乐观锁编码',
                          PRIMARY KEY (`index_code`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
