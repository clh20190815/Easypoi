package easypoi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class Parameter implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * NG标准
     */
    @Excel(name = "NG标准", orderNum = "1", width = 15,isImportField = "true")
    private String NGStandard;

    /**
     * 备注
     */
    @Excel(name = "备注", orderNum = "2", width = 15,isImportField = "true")
    private String tips;

    /**
     * 参考图片
     */
    @Excel(name = "参考图片", orderNum = "3", width = 30, height = 10, type = 2,imageType = 1,savePath = "C:/Users/QC/Desktop/Easypoi/static/img",isImportField = "true")
    private String image;
}
