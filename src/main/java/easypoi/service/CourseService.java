package easypoi.service;

import com.google.common.collect.Lists;
import easypoi.entity.CourseEntity;
import easypoi.entity.PersonExportVo;
import easypoi.entity.TeacherEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    public List<CourseEntity> findAll() {
        List<CourseEntity> clist = Lists.newArrayList();
        CourseEntity courseEntity=new CourseEntity();
        List<PersonExportVo> plist = Lists.newArrayList();

        for (int i = 0; i < 5; i++) {
            PersonExportVo personVo = new PersonExportVo();
            personVo.setName("张三" + i);
            personVo.setUsername("张三" + i);
            personVo.setPhoneNumber("18888888888");

            personVo.setImageUrl("static/img/"+(i+1)+".jpg");
            plist.add(personVo);
        }
        TeacherEntity teacherEntity=new TeacherEntity();
        teacherEntity.setName("dwcnb");

        courseEntity.setName("语文");
        courseEntity.setStudents(plist);
        courseEntity.setTeacher(teacherEntity);
        clist.add(courseEntity);
        return clist;
    }
}
