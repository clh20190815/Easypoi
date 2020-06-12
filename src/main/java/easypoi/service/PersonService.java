package easypoi.service;

import easypoi.entity.Life;
import easypoi.entity.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    List<Person> plist = new ArrayList();
    List<Life> lifeList=new ArrayList();

    List<String> timeList = new ArrayList();
    List<String> eatList = new ArrayList();

    public List<Person> findAll() {
        eatList.add("石磨肠粉");
        eatList.add("香菇滑鸡");
        eatList.add("番茄炒蛋");
        timeList.add("早上");
        timeList.add("中午");
        timeList.add("晚上");
        for (int i = 0; i < 3; i++) {
            Person person = new Person();
            person.setName("陈仔" + " " + i);

                Life life = new Life();
                life.setTime(timeList.get(i % 3));
                life.setDo_eat(eatList.get(i % 3));
                life.setDo_go((i % 2 == 1) ? "地铁" : "公交");
                life.setDo_work("打码");
                life.setDo_sleep("早睡早起");
                lifeList.add(life);
            person.setLife(lifeList);
            plist.add(person);

        }
        return plist;
    }
}

