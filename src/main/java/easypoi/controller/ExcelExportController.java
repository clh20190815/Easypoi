package easypoi.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import easypoi.entity.PersonExportVo;
import easypoi.entity.User;
import easypoi.service.UserService;
import easypoi.util.ExcelUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/export")
public class ExcelExportController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/1", method = RequestMethod.GET)
    public void exportExcel(HttpServletResponse response) throws IOException {
        long start = System.currentTimeMillis();
        List<PersonExportVo> personList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            PersonExportVo personVo = new PersonExportVo();
            personVo.setName("张三" + i);
            personVo.setUsername("张三" + i);
            personVo.setPhoneNumber("18888888888");

            personVo.setImageUrl("static/img/"+(i+1)+".jpg");
            personList.add(personVo);
        }
            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), PersonExportVo.class, personList);
            FileOutputStream fos = new FileOutputStream("C:/Users/QC/Desktop/pp.xlsx");
            workbook.write(fos);
            fos.close();

        System.out.println("导出excel所花时间：" + (System.currentTimeMillis() - start));
        //ExcelUtils.exportExcel(personList, "员工信息表", "员工信息", PersonExportVo.class, "员工信息", response);
    }


        @RequestMapping(value = "/2", method = RequestMethod.GET)

        public void export(HttpServletResponse response) throws IOException {
            System.out.println(1);
            // 模拟从数据库获取需要导出的数据
            List<User> personList = userService.findAll();
            // 导出操作
            ExcelUtils.exportExcel(personList, "easypoi导出功能", "导出sheet1", User.class, "测试user.xls", response);
    }
}


