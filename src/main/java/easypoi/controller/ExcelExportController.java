package easypoi.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import easypoi.entity.CourseEntity;
import easypoi.entity.Person;
import easypoi.entity.PersonExportVo;
import easypoi.entity.User;
import easypoi.service.CourseService;
import easypoi.service.PersonService;
import easypoi.service.UserService;
import easypoi.util.ExcelUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/export")
public class ExcelExportController {
    @Autowired
    UserService userService;
    @Autowired
    CourseService courseService;
    @Autowired
    PersonService personService;

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
        public void exportUser(HttpServletResponse response) throws IOException {
            System.out.println(1);
            // 模拟从数据库获取需要导出的数据
            List<User> personList = userService.findAll();
            // 导出操作
            ExcelUtils.exportExcel(personList, "easypoi导出功能", "导出sheet1", User.class, "测试user.xls", response);
    }
    @RequestMapping(value = "/3", method = RequestMethod.GET)
    public void exportCourse(HttpServletResponse response) throws IOException {
        System.out.println(1);
        // 模拟从数据库获取需要导出的数据
        List<CourseEntity> course = courseService.findAll();
        // 导出操作
        ExcelUtils.exportExcel(course, "课程表", "课程", CourseEntity.class, "测试user.xls", response);
    }
    @RequestMapping(value = "/4", method = RequestMethod.GET)
    public void exportPerson(HttpServletResponse response) throws IOException {
        System.out.println(1);
        // 模拟从数据库获取需要导出的数据
        List<Person> person = personService.findAll();
        // 导出操作
        ExcelUtils.exportExcel(person, "日程表", "日程", Person.class, "person.xls", response);
    }

}


