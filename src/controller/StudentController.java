package controller;

import entity.Student;
import helper.Helper;
import helper.ValidateStudent;
import repository.StudentDAO;

public class StudentController {
    private Helper helper=new Helper() ;
    private ValidateStudent validateStudent=new ValidateStudent();
    private StudentDAO studentDAO =new StudentDAO();
    public void getInputEntity() {
        String name, address,phone, collegeClass ;
        do {
            name= helper.getString("Nhập tên học sinh:");
            if (validateStudent.validateName(name)) {
                break;
            }
        } while (true);

        do {
            address = helper.getString("Nhập địa chỉ học sinh : ");
            if (validateStudent.validateAddress(address)) {
                break;
            }
        } while (true);

        do{ phone= helper.getString("Nhập số điện thoại học sinh: ");
            if(validateStudent.validatePhone(phone)){
                break;
            }
        }
        while(true);
        do{ collegeClass= helper.getString("Nhập lớp học sinh:");
            if(validateStudent.validateCollegeClass(collegeClass)){
                break;
            }
        }
        while(true);
        Student newStudent = new Student(helper.getNormalizedString(name),helper.getNormalizedString(address),phone,helper.getNormalizedString(collegeClass));
        if(studentDAO.save(newStudent)){
            System.out.println("Thêm học sinh mới thành công");
        }
        else{
            System.out.println("Đã xảy ra lỗi khi thêm học sinh");
        }
    }
    public  void getInputListEntity( ){
        int numberOfTeacher= helper.getInt("Nhập số lượng học sinh cần thêm: ");
        for (int i=0;i<=numberOfTeacher-1 ; i++){
             getInputEntity();
        }
    }
    public void printListData(){
       Student[] students= studentDAO.getAll();
       for (int i=0;i<students.length;i++){
           System.out.println(students[i].toString());
       }
    }
}
