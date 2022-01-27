import controller.StudentController;
import controller.SubjectController;
import controller.TranscriptsController;
import entity.Subject;
import entity.Transcripts;
import helper.Helper;
import repository.StudentDAO;
import repository.TranscriptsDAO;

public class Main {
    private static Helper helper = new Helper();
    private static StudentController studentController=new StudentController();
    private static SubjectController subjectController=new SubjectController();
    private static TranscriptsController transcriptsController=new TranscriptsController();
    public static void main(String[] args) {
        runMain();
    }
    private static void runMain() {
        boolean run=true;
        do {
            helper.printMenu();
            int chose=helper.getInt(" ");
            int choseFunction;
            switch(chose) {
                case 1:
                    choseFunction = studentController.studentAskChose();
                    if(choseFunction==1){
                        studentController.getInputListEntity();
                    }else if(choseFunction==2){
                        studentController.printListData();
                    }else if(choseFunction==3){
                        break;
                    }
                    boolean checkContinue_1= helper.askYesNo();
                    if(checkContinue_1){
                        break;
                    } else{run=false;}
                    break;
                case 2:
                    choseFunction= subjectController.subjectAskChose();
                    if(choseFunction==1){
                        subjectController.getInputListEntity();
                    }else if(choseFunction==2){
                        subjectController.printListData();
                    }else{
                        break;
                    }
                    boolean checkContinue_2= helper.askYesNo();
                    if(checkContinue_2){
                        break;
                    } else{run=false;}
                    break;
                case 3:
                    choseFunction=transcriptsController.transcriptsAskChose();
                    if(choseFunction==1){
                        transcriptsController.getInputEntity();
                    }else if(choseFunction==2){
                        transcriptsController.printListData();
                    }else {
                        break;
                    }
                    if(helper.askYesNo()){
                        break;
                    } else{run=false;}
                    break;
                case 4:
                    choseFunction=transcriptsController.sortStudentListAskChose();
                    if(choseFunction==1){
                        transcriptsController.printListDataByStudentName();
                    }else if(choseFunction==2){
                        transcriptsController.printListDataBySubjectName();
                    }else if(choseFunction==3){
                        break;
                    }
                    if(helper.askYesNo()){
                        break;
                    } else{run=false;}
                    break;
                case 5:
                    transcriptsController.printListStudentGPA();
                    if(helper.askYesNo()){
                        break;
                    } else{run=false;}
                    break;
                case 6:
                    run=false;
                    break;
                default:
                    System.out.println("Bạn phải nhập số nguyên trong khoảng từ 1 đến 6");
            }
        }
        while (run);
        System.out.println("Đã thoát chương trình");
    }

}
