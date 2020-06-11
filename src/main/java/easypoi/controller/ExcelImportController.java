package easypoi.controller;









import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import cn.afterturn.easypoi.util.PoiPublicUtil;
import easypoi.entity.PersonExportVo;
import easypoi.entity.User;
import easypoi.util.ExcelUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;



import com.alibaba.fastjson.JSONObject;






import cn.afterturn.easypoi.excel.ExcelImportUtil;

import cn.afterturn.easypoi.excel.entity.ImportParams;

import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;

import lombok.extern.slf4j.Slf4j;



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
		//String filePath = "C:/Users/QC/Desktop/user.xlsx";
		//解析excel，
		//List<PersonExportVo> personList = ExcelUtils.importExcel(filePath,1,1,PersonExportVo.class);
		//也可以使用MultipartFile,使用FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
		//System.out.println("导入数据一共【"+personList.size()+"】行");
		try {
			ImportParams params = new ImportParams();
			params.setSaveUrl("/static/img/");
			params.setNeedSave(true);
			List<PersonExportVo> result = ExcelImportUtil.importExcel(
					new File("C:/Users/QC/Desktop/pp.xlsx"),
					PersonExportVo.class, params);
			for (int i = 0; i < result.size(); i++) {
				System.out.println(ReflectionToStringBuilder.toString(result.get(i)));
			}
			//Assert.isTrue(result.size() == 4);
		} catch (Exception e) {
			e.printStackTrace();
		}

//		for (PersonExportVo User : personList) {
//			// System.out.println(User);
//			log.info("从Excel导入数据到数据库的详细为 ：{}", JSONObject.toJSONString(User));
//			//TODO 将导入的数据做保存数据库操作
//
//		}
	}
		@RequestMapping(value = "/import/2",method = RequestMethod.POST)
		public String importExcel2(@RequestParam("file") MultipartFile file) {
			ImportParams importParams = new ImportParams();
			// 数据处理
			importParams.setHeadRows(1);
			importParams.setTitleRows(1);
			// 需要验证
			importParams.setNeedVerify(false);
			try {

				ExcelImportResult<User> result =
						ExcelImportUtil.importExcelMore(file.getInputStream(), User.class, importParams);
				List<User> userList = result.getList();
				for (User User : userList) {
					// System.out.println(User);
					log.info("从Excel导入数据到数据库的详细为 ：{}", User.toString());
					//TODO 将导入的数据做保存数据库操作

				}

				log.info("从Excel导入数据一共 {} 行 ", userList.size());

			} catch (IOException e) {

				log.error("导入失败：{}", e.getMessage());

			} catch (Exception e1) {

				log.error("导入失败：{}", e1.getMessage());

			}

			return "导入成功";

		}

	}



