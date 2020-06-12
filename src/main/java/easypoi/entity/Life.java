package easypoi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class Life implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 登录用户名
     */
    //@ExcelCollection(name = "时段", orderNum = "2")
    @Excel(name = "时段",/* replace = { "早上_1", "中午_2","晚上_3" },*/orderNum = "1", width = 15,height = 10,isImportField = "true")
    private String time;

    @Excel(name = "吃饭",orderNum = "2", width = 15,height = 10,isImportField = "true")
    private String do_eat;
    @Excel(name = "出行",orderNum = "3", width = 15,height = 10,isImportField = "true")
    private String do_go;
    @Excel(name = "工作",orderNum = "4", width = 15,height = 10,isImportField = "true")
    private String do_work;
    @Excel(name = "睡觉",orderNum = "5", width = 15,height = 10,isImportField = "true")
    private String do_sleep;
}
