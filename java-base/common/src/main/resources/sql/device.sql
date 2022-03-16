CREATE TABLE `device` (
                          `index_code` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '设备编码',
                          `ip` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '设备ip',
                          `port` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '设备端口',
                          `name` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '设备名称',
                          `capability` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '设备能力',
                          `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                          `version` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '乐观锁编码',
                          PRIMARY KEY (`index_code`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
