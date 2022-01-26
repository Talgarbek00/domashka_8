package org.example;

import org.example.entity.Student;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        Student student = new Student("Aza","zamir uulu","java",21);
        Student student1 = new Student("Aza","nurbek uulu","java",22);
        Student student2 = new Student("Aza","zamir uulu","java",15);
        Student student3 = new Student("Aza","zamir uulu","java",15);
        Student student4 = new Student("Akyl","zamir uulu","java",20);
        Student student5 = new Student("aibek","zamir uulu","java",20);
//        create( student);
//        create( student1);
//        create( student2);
//        create( student3);
//        create( student4);
//        create( student5);
//        System.out.println(getById(1));
//        for (Student s:getAll()) {
//            System.out.println(s);
//        }
//        update(2,"erma","koposhov","java",21);
//        update(2,"Aza","koposhov","java",21);
//        delateAll();
        updateStudent();
        delateStudentByName();



    }
    public static int create(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
        System.out.println("Added saccassfully "+ student);
        return student.getId();
    }

    public static List<Student> getAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Student> list = session.createQuery("from Student where name like 'Aza' and age>20").getResultList();
        session.getTransaction().commit();
        System.out.println("All Students: "+list.size());
        return list;
    }
//    public static Student getById (int id){
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        Student student = session.get(Student.class,id);
//        session.getTransaction().commit();
//        session.close();
//        return student;
//    }
//
//    public  static void updateAge(int age1){
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        List<Student> list = session.createQuery("from Student").getResultList();
//        session.getTransaction().commit();
//        System.out.println("All Students: "+list.size());
//        for (int i=0; i<10; i++){
//            if (list.contains("Aza")){
//
//            }
//        }
//    }
//    public  static Student update (int id,String name,String surname,String cource,int age){
//    Session session = HibernateUtil.getSessionFactory().openSession();
//    session.beginTransaction();
//    Student student = session.get(Student.class,id);
//    student.setId(id);
//    student.setName(name);
//    student.setSurname(surname);
//    student.setCourse(cource);
//    student.setAge(age);
//    session.getTransaction().commit();
//    session.close();
//        System.out.println("update saccassfuly: "+ student);
//        return student;
//    }

//    public  static void delateByName (String name){
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        Query student = session.createQuery("from Student ");
//        if (Student.class){}
//            session.delete(student);
//        session.getTransaction().commit();
//        session.close();
//        System.out.println("delate saccassfuly: "+ student);
//    }
    public static void updateStudent() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String SQL = "update Student set  age=18 where name = 'Aza'";
        int kutubek = session.createQuery(SQL).executeUpdate();

        session.getTransaction().commit();
        session.close();
        System.out.println("---------2---------\nUpdate Аткарылды: "+kutubek);
    }
    public static void delateStudentByName() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("DELETE FROM Student where name = 'Aza'");
        query.executeUpdate();

        session.getTransaction().commit();
        session.close();
        System.out.println("---------3---------\nАйтылган Жумушчулар очурулду");
    }

//    public static void delateAll(){
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        Query query = session.createQuery("delete from Student ");
//        query.executeUpdate();
//        session.getTransaction();
//        session.close();
//        System.out.println("delete all  ");
//    }
}
