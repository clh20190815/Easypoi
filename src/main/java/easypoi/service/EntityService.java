package easypoi.service;

import easypoi.entity.Entity;
import easypoi.entity.Parameter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntityService {
    List<Entity> entityList=new ArrayList<>();
    Entity entity1=new Entity();
    Entity entity2=new Entity();
    Entity entity3=new Entity();
    Parameter p1=new Parameter();
    Parameter p2=new Parameter();

    Parameter p3=new Parameter();


    public List<Entity> findAll(){
            entity1.setType("暗色点");
            List list=new ArrayList();
            p1.setNGStandard("0-0.3");
            p1.setTips("ok");
            p1.setImage("C:/Users/QC/Desktop/Easypoi/static/img/qd.png");
            list.add(p1);
            p2.setNGStandard("0.31-1.0");
            p2.setTips("很ok");
            p2.setImage("C:/Users/QC/Desktop/Easypoi/static/img/z.png");
            list.add(p2);
            p3.setNGStandard("1.01-2.5");
            p3.setTips("不ok");
            p3.setImage("C:/Users/QC/Desktop/Easypoi/static/img/zd.png");
            list.add(p3);
            entity1.setParameter(list);
            entityList.add(entity1);
        return entityList;
    }
}
