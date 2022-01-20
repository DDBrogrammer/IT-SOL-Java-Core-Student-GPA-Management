package controller;

import entity.Student;
import entity.Subject;
import helper.Helper;
import helper.ValidateSubject;
import repository.SubjectDAO;

public class SubjectController {

    private Helper helper=new Helper();
    private ValidateSubject validateSubject = new ValidateSubject();
    private SubjectDAO subjectDAO=new SubjectDAO();


    public void getInputEntity() {
        String name, type ;
        int  totalUnit;
        do {
            name= helper.getString("Nhập tên môn học:");
            if (validateSubject.validateName(name)) {
                break;
            }
        } while (true);

        do {
            type = helper.getString("Nhập loại môn học:\n " +
                    "[DC]  Đại cương\n" +
                    "[CSN] Cơ sở ngành\n" +
                    "[CN]  Chuyên ngành");

            if (validateSubject.validateType(type)) {
                break;
            }
        } while (true);

        do{ totalUnit= helper.getInt("Nhập số tiết học: ");
            if(validateSubject.validateTotalUnit(totalUnit)){
                break;
            }
        }
        while(true);
        Subject subject= new Subject(helper.normalize(name), type.toUpperCase(),totalUnit);
        if(subjectDAO.save(subject)){
            System.out.println("Thêm môn học mới thành công");
        }
        else{
            System.out.println("Đã xảy ra lỗi khi thêm môn học");
        }
    }
    public  void getInputListEntity( ){
        int numberOfTeacher= helper.getInt("Nhập số lượng môn học cần thêm: ");
        for (int i=0;i<=numberOfTeacher-1 ; i++){
            getInputEntity();
        }
    }
    public void printListData(){
        Subject[] subjects= subjectDAO.getAll();
        for (int i=0;i<subjects.length;i++){
            System.out.println(subjects[i].toString());
        }
    }
}
