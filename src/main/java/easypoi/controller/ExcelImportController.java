package easypoi.controller;


import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.alibaba.fastjson.JSONObject;
import easypoi.entity.CourseEntity;
import easypoi.entity.Person;
import easypoi.entity.PersonExportVo;
import easypoi.entity.User;
import easypoi.util.ExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;



/**

 * <pre>

 * &#64;author cao_wencao

 * &#64;date 2018年12月13日 下午6:17:10

 * </pre>

 */

@RestController
@Slf4j
public class ExcelImportController {
	@RequestMapping(value = "/import/1",method = RequestMethod.POST)
	public void importExcel() throws Exception {
		String filePath = "C:/Users/QC/Desktop/puser.xlsx";
		//解析excel，
		List<User> personList = ExcelUtils.importExcel(filePath,1,1,User.class);
		//也可以使用MultipartFile,使用FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
		System.out.println("导入数据一共【"+personList.size()+"】行");
		for (User User : personList) {
			// System.out.println(User);
			log.info("从Excel导入数据到数据库的详细为 ：{}", JSONObject.toJSONString(User));
			//TODO 将导入的数据做保存数据库操作

		}
	}
		@RequestMapping(value = "/import/2",method = RequestMethod.POST)
		public String importExcel2(@RequestParam("file") MultipartFile file) {
			ImportParams importParams = new ImportParams();
			// 数据处理(没有表头和标题是要注释掉)
			//importParams.setHeadRows("0");
			//importParams.setTitleRows(0);
			importParams.setSaveUrl("C:/Users/QC/Desktop/Easypoi/static/");
			importParams.setNeedSave(true);
			// 需要验证
			importParams.setNeedVerify(false);
			try {

				ExcelImportResult<PersonExportVo> result =
						ExcelImportUtil.importExcelMore(file.getInputStream(),PersonExportVo.class, importParams);
				List<PersonExportVo> userList = result.getList();
				for (int i = 0; i < userList.size(); i++) {
					// System.out.println(User);
					log.info("从Excel导入数据到数据库的详细为 ：{}", ReflectionToStringBuilder.toString(userList.get(i)));
					//TODO 将导入的数据做保存数据库操作

				}

				log.info("从Excel导入数据一共 {} 行 ", userList.size());

			} catch (IOException e) {

				log.error("导入失败：{}", e.getMessage());

			} catch (Exception e) {
				log.error("导入失败：{}", e.getMessage());
			}

			return "导入成功";

		}
	@RequestMapping(value = "/import/3",method = RequestMethod.POST)
	public String importExcel3(@RequestParam("file") MultipartFile file) {
		ImportParams importParams = new ImportParams();
		// 数据处理(没有表头和标题是要注释掉)
		importParams.setHeadRows(2);
		importParams.setTitleRows(1);
		importParams.setSaveUrl("C:/Users/QC/Desktop/Easypoi/static/");
		importParams.setNeedSave(true);
		// 需要验证
		importParams.setNeedVerify(false);
		try {

			ExcelImportResult<CourseEntity> result =
					ExcelImportUtil.importExcelMore(file.getInputStream(),CourseEntity.class, importParams);
			List<CourseEntity> courseEntityList = result.getList();
			for (int i = 0; i < courseEntityList.size(); i++) {
				// System.out.println(User);
				log.info("从Excel导入数据到数据库的详细为 ：{}", ReflectionToStringBuilder.toString(courseEntityList.get(i)));
				//TODO 将导入的数据做保存数据库操作

			}

			log.info("从Excel导入数据一共 {} 行 ", courseEntityList.size());

		} catch (IOException e) {

			log.error("导入失败：{}", e.getMessage());

		} catch (Exception e) {
			log.error("导入失败：{}", e.getMessage());
		}

		return "导入成功";

	}
	@RequestMapping(value = "/import/4",method = RequestMethod.POST)
	public String importExcel4(@RequestParam("file") MultipartFile file) {
		ImportParams importParams = new ImportParams();
		// 数据处理(没有表头和标题是要注释掉)
		importParams.setHeadRows(2);
		importParams.setTitleRows(1);
		importParams.setSaveUrl("C:/Users/QC/Desktop/Easypoi/static/");
		importParams.setNeedSave(true);
		// 需要验证
		importParams.setNeedVerify(false);
		try {

			ExcelImportResult<Person> result =
					ExcelImportUtil.importExcelMore(file.getInputStream(), Person.class, importParams);
			List<Person> personList = result.getList();
			for (int i = 0; i < personList.size(); i++) {
				// System.out.println(User);
				log.info("从Excel导入数据到数据库的详细为 ：{}", ReflectionToStringBuilder.toString(personList.get(i)));
				//TODO 将导入的数据做保存数据库操作

			}

			log.info("从Excel导入数据一共 {} 行 ", personList.size());

		} catch (IOException e) {

			log.error("导入失败：{}", e.getMessage());

		} catch (Exception e) {
			log.error("导入失败：{}", e.getMessage());
		}

		return "导入成功";

	}
	}



