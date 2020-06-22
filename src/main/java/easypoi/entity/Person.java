package easypoi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 姓名
     */
    @Excel(name = "姓名", orderNum = "1", width = 15,height = 10,needMerge = true,isImportField = "true")
    private String name;
    @ExcelCollection(name="日常", orderNum = "2")
    private List<Life> life;


}
