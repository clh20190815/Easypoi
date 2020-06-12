package easypoi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
@Data
@EqualsAndHashCode(callSuper = false)
@ExcelTarget("courseEntity")
 public class CourseEntity implements java.io.Serializable {
    /** 主键 */
    private String        id;
    /** 课程名称 */
    @Excel(name = "课程名称", orderNum = "1", width = 25,needMerge = true)
    private String        name;
    /** 老师主键 */
    @ExcelEntity(id = "absent")
    private TeacherEntity teacher;

    @ExcelCollection(name = "学生", orderNum = "3")
    private List<PersonExportVo> students;
 }