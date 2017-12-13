CREATE DATABASE favorite_teacher;

#学院表
CREATE TABLE IF NOT EXISTS institute(
  ins_no int PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
  ins_name VARCHAR(20) NOT NULL COMMENT '学院名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


#导师表
CREATE TABLE IF NOT EXISTS teacher(
  teacher_no int PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
  teacher_name VARCHAR(20) NOT NULL COMMENT '教师名',
  gender ENUM('M','F') NOT NULL COMMENT '性别',
  title VARCHAR(20) NOT NULL COMMENT '职称' ,
  ins_no int NOT NULL COMMENT '学院号外键' ,
  votes int NOT NULL DEFAULT 0,
  FOREIGN KEY (ins_no) REFERENCES institute(ins_no) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#导师扩展信息表
CREATE TABLE IF NOT EXISTS teacher_extra(
  te_no int PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
  teacher_no int NOT NULL COMMENT '教师号外键',
  introduction TEXT NOT NULL COMMENT '个人简介',
  recommendation TEXT NOT NULL COMMENT '推荐语',
  comment TEXT NOT NULL COMMENT '点评',
  FOREIGN KEY (teacher_no) REFERENCES teacher(teacher_no) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#end
