package easypoi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.handler.inter.IExcelDataModel;
import cn.afterturn.easypoi.handler.inter.IExcelModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class Entity implements Serializable,IExcelDataModel,IExcelModel {

    private static final long serialVersionUID = 1L;

    /**
     * 错误行数
     */
    private Integer rowNum;

    /**
     * 错误消息
     */
    private String errorMsg;

    /**
     * 瑕疵类型
     */
    @Excel(name = "瑕疵类型", orderNum = "1", width = 15,isImportField = "true",needMerge = true)
    @NotBlank(message = "[瑕疵类型]不能为空")
    private String type;

    @ExcelCollection(name="参数", orderNum = "2")
    private List<Parameter>	parameter;

}
