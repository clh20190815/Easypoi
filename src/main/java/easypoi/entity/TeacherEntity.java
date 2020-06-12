package easypoi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ExcelTarget("teacherEntity")
public class TeacherEntity implements java.io.Serializable {
    /** name */
    @Excel(name = "主讲老师_major,代课老师_absent", orderNum = "1", isImportField = "true_major,true_absent",needMerge = true)
    private String name;
}