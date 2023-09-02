package com.score.boot;

import com.github.pagehelper.PageInfo;
import com.score.bean.ResultObject;
import com.score.bean.TScore;
import com.score.bean.TStudent;
import com.score.bean.User;
import com.score.service.IScoreService;
import com.score.service.IUserService;
import com.score.service.TStudentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartApplication.class)
public class test01 {

    @Autowired
    private TStudentService studentService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IScoreService scoreService;

    @Test
    public void testLogin() {
        List<User> users = new ArrayList<User>();

        User user = new User();
        user.setUserName("admin");
        user.setPassword("123456");

        User user1 = new User();
        user.setUserName("admin5");
        user.setPassword("123456");

        User user2 = new User();
        user.setUserName("adminjiad");
        user.setPassword("1234565");

        users.add(user);
        users.add(user1);
        users.add(user2);
        for (User user3 : users) {
            List<User> userList = userService.getUser(user3);
            for (User user4 : userList) {
                System.out.println(user4);
            }
        }


    }

    @Test
    public void testQuery(){
        TStudent student = new TStudent();
        int limit = 1;
        int page = 5;
        PageInfo<TStudent> all = studentService.getAll(student, limit, page);
    }

    @Test
    public void testDel() {
        List<Integer> list = new ArrayList<Integer>();
        int NO1 = 20203946;
        int NO2 = 20203;
        int NO3 = 2025556666;
//        int NO1 = 20203946;
        list.add(NO1);
        list.add(NO2);
        list.add(NO3);
        for(int i = 0; i < 3; i++) {
            Integer deleteStudent = studentService.deleteStudent(list.get(i));
            System.out.println(deleteStudent);
        }

    }

    @Test
    public void addStu() {
        List<TStudent> students = new ArrayList<TStudent>();
        TStudent student = new TStudent();
        student.setStudentNo(20203946);
        student.setStudentName("贾硕航");
        student.setStudentSex("男");

        TStudent student1 = new TStudent();
        student.setStudentNo(202039465);
        student.setStudentName("贾硕航");
        student.setStudentSex("男");

        TStudent student2 = new TStudent();
        student.setStudentNo(20203946);
        student.setStudentName("#");
        student.setStudentSex("男");

        TStudent student3 = new TStudent();
        student.setStudentNo(20203946);
        student.setStudentName("贾硕航");
        student.setStudentSex("0");

        students.add(student);
        students.add(student1);
        students.add(student2);
        students.add(student3);

        for (TStudent tStudent : students) {
            Integer integer = studentService.addStudent(student);
        }

    }

    @Test
    public void testSCAddStu(){
        TScore score = new TScore();
        score.setScoreTypeName("习题");
        score.setScoreValue(98);
        score.setStudentName("贾硕航");
        ResultObject<Object> objectResultObject = scoreService.insertScore(score);

    }

    @Test
    public void testDelSCStu() {
        int sc_id = 6;
        Integer integer = scoreService.deleteScore(sc_id);

    }

    @Test
    public void testQuerySc() {
        String name = "贾硕航";
        TScore score = new TScore();
        score.setStudentName(name);
        int limit = 1;
        int page = 5;
        PageInfo<TScore> allScore = scoreService.getAllScore(score, limit, page);

    }

    @Test
    public void getScAll() {
        TStudent student = new TStudent();
        student.setStudentNo(1);
        student.setStudentName("贾硕航");
        student.setStudentSex("男");
        int limit = 1;
        int page = 5;
        PageInfo<TStudent> allFinalScore = scoreService.getAllFinalScore(student, limit, page);
    }


    @Test
    public void getAllMyScore() {
        TStudent student = new TStudent();
        student.setStudentName("贾硕航");
        int limit = 5;
        int page = 0;
        PageInfo<TStudent> allFinalScore = scoreService.getAllFinalScore(student, limit, page);
    }

    public void getMyScore() {
        TScore score = new TScore();
        score.setScoreId(1);
        int limit = 5;
        int page = 0;
        PageInfo<TScore> allScore = scoreService.getAllScore(score, limit, page);
    }
}
