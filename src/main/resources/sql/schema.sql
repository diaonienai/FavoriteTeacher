CREATE DATABASE favorite_teacher;

#学院表
CREATE TABLE `institute` (
  `ins_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ins_name` varchar(20) NOT NULL COMMENT '学院名称',
  `ins_votes` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ins_no`),
  UNIQUE KEY `institute_ins_name_uindex` (`ins_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


#导师表
CREATE TABLE `teacher` (
  `teacher_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `teacher_name` varchar(20) NOT NULL COMMENT '教师名',
  `gender` enum('男','女') NOT NULL COMMENT '性别',
  `title` varchar(20) NOT NULL COMMENT '职称',
  `ins_no` int(11) NOT NULL COMMENT '学院号外键',
  `latest_update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `votes` int(11) NOT NULL DEFAULT '0',
  `introduction` varchar(1000) NOT NULL DEFAULT '' COMMENT '个人简介',
  `recommendation` varchar(1000) NOT NULL DEFAULT '' COMMENT '推荐语',
  `comment` varchar(1000) NOT NULL DEFAULT '' COMMENT '点评',
  PRIMARY KEY (`teacher_no`),
  KEY `ins_no` (`ins_no`),
  KEY `latest_update_time_index` (`latest_update_time`),
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`ins_no`) REFERENCES `institute` (`ins_no`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


#学生表
CREATE TABLE `student` (
  `stu_no` varchar(12) NOT NULL COMMENT '学生学号(主键)',
  `stu_pwd` varchar(20) NOT NULL COMMENT '学生密码',
  `stu_name` varchar(10) NOT NULL COMMENT '学生名字',
  `voted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已经投票',
  PRIMARY KEY (`stu_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#留言表
CREATE TABLE `message` (
  `message_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `content` varchar(300) NOT NULL COMMENT '留言内容',
  `teacher_no` int(11) NOT NULL COMMENT '导师外键',
  `stu_no` varchar(12) NOT NULL COMMENT '学生外键',
  `time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发表留言的时间',
  `anonymous` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`message_no`),
  UNIQUE KEY `message_teacher_no_stu_no_uindex` (`teacher_no`,`stu_no`),
  KEY `teacher_no` (`teacher_no`),
  KEY `stu_no` (`stu_no`),
  KEY `time` (`time`),
  FOREIGN KEY (`teacher_no`) REFERENCES `teacher` (`teacher_no`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`stu_no`) REFERENCES `student` (`stu_no`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

#投票表
CREATE TABLE `votes` (
  `vote_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `teacher_no` int(11) NOT NULL COMMENT '导师外键',
  `stu_no` varchar(12) NOT NULL COMMENT '学生外键',
  `vote_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '投票的时间',
  PRIMARY KEY (`vote_no`),
  UNIQUE KEY `teacher_no_2` (`teacher_no`,`stu_no`),
  KEY `teacher_no` (`teacher_no`),
  KEY `stu_no` (`stu_no`),
  KEY `vote_time` (`vote_time`),
  CONSTRAINT `votes_ibfk_1` FOREIGN KEY (`teacher_no`) REFERENCES `teacher` (`teacher_no`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `votes_ibfk_2` FOREIGN KEY (`stu_no`) REFERENCES `student` (`stu_no`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

#触发器
DELIMITER $$
CREATE TRIGGER votes_insert_after_trigger AFTER INSERT ON votes FOR EACH ROW
BEGIN
  UPDATE teacher SET votes = votes + 1 WHERE teacher_no = new.teacher_no;
  UPDATE institute SET ins_votes = ins_votes + 1
  WHERE ins_no = (SELECT ins_no FROM teacher WHERE teacher_no = new.teacher_no);
END;
$$
DELIMITER ;

#end

#记得增加/etc/my.cnf的stack_size为256,否则批量新增会出现问题
