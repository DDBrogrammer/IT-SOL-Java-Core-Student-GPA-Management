package controller;

import entity.Student;
import entity.Subject;
import entity.Transcripts;
import helper.Helper;
import helper.ValidateStudent;
import helper.ValidateTranscripts;
import repository.StudentDAO;
import repository.SubjectDAO;
import repository.TranscriptsDAO;

public class TranscriptsController {
      private  StudentController studentController=new StudentController();
      private  SubjectController subjectController=new SubjectController();
      private  SubjectDAO subjectDAO=new SubjectDAO();
      private  StudentDAO studentDAO=new StudentDAO();
      private TranscriptsDAO transcriptsDAO=new TranscriptsDAO();
      private  Helper helper=new Helper();
      private ValidateStudent validateStudent=new ValidateStudent();
      private ValidateTranscripts validateTranscripts=new ValidateTranscripts();
    public void getInputEntity() {
       Student student=new Student("","","",0,"");
       studentController.printListData();
        System.out.println("Chọn học sinh từ danh sách đã cho");
        do{int studentId=helper.getInt("Nhập Id học sinh từ danh sách:");
             if(
                     studentDAO.getById(studentId).getId()==0
             ){
                 System.out.println("Không tìm thấy học sinh vừa chọn");
             }else{
                 student=new Student(studentDAO.getById(studentId).getName(),
                         studentDAO.getById(studentId).getAddress(),
                         studentDAO.getById(studentId).getPhone(),
                         studentDAO.getById(studentId).getId(),
                         studentDAO.getById(studentId).getCollegeClass());
                 System.out.println("Đã chọn học sinh: "+ student.toString());
                 break;
             }

        }while(true);
        int numberOfSubject;
        subjectController.printListData();
        do{
            numberOfSubject=helper.getInt("Nhập số lượng môn học của sinh viên");
            if(numberOfSubject>subjectDAO.getAll().length){
                System.out.println("Vượt quá số lượng môn học hiện có");
            }else{
                break;
            }
        }while(true);
        Subject [] subjectList=new Subject[numberOfSubject];
        for(int i = 0;i<subjectList.length;i++){
            subjectList[i]=new Subject(0,"","",0);
        }
        int [] markList=new int[numberOfSubject];
        for(int i=0;i<numberOfSubject;i++){
            do{
                int subjectId=helper.getInt("Nhập id môn học trong danh sách");
                if(!validateTranscripts.validateChosenSubject(subjectList,subjectId) &&
                        subjectDAO.getById(subjectId).getId()!=0){
                    System.out.println("Đã chọn môn học: " +subjectDAO.getById(subjectId).toString());
                    subjectList[i].setName(subjectDAO.getById(subjectId).getName());
                    subjectList[i].setId(subjectDAO.getById(subjectId).getId());
                    subjectList[i].setType(subjectDAO.getById(subjectId).getType());
                    subjectList[i].setTotalUnit(subjectDAO.getById(subjectId).getTotalUnit());
                    break;
                }else{
                    System.out.println("Môn học vừa chọn không khả dụng");
                }
            }while(true);
            do{
                int subjectMark=helper.getInt("Nhập điểm của môn học");
                if(subjectMark >= 0 && subjectMark<=10 ){
                    markList[i]=subjectMark;
                    break;
                }else{
                    System.out.println("Điểm môn học phải lớn hơn 0 và nhỏ hơn 10");
                }
            }while(true);
        }
        Transcripts transcripts=new Transcripts(student,subjectList,markList);
        transcriptsDAO.save(transcripts);

    }
    public void printListData(){
        Transcripts[] transcripts= transcriptsDAO.getAll();
        for (int i=0;i<transcripts.length;i++){
            System.out.println("                            ");
            System.out.println(transcripts[i].getStudent().toString());
            for(int j=0;j<transcripts[i].getSubjectList().length;j++){
                System.out.println("Môn học: "+transcripts[i].getSubjectList()[j]+" Điểm số: "+transcripts[i].getMarkList()[j]);
            }
            System.out.println("                            ");
        }
    }
}
