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
    private static TranscriptsDAO transcriptsDAO=new TranscriptsDAO();
    public static void main(String[] args) {
        boolean run=true;
        do {
            helper.printMenu();
            int chose=helper.getInt(" ");
            switch(chose) {
                case 1:
                    int chose_1;
                    do {
                        chose_1 = helper.getInt("Nhập lựa chọn:\n"
                                + "[1] Thêm sinh viên.\n"
                                + "[2] Xem danh sách sinh viên.\n"
                                + "[3] Quay lại.\n"
                        );
                        if(chose_1>=1 && chose_1<=3){
                            break;
                        }
                        System.out.println("Bạn phải nhập số nguyên từ 1 đến 3");
                    } while(true);
                    if(chose_1==1){
                     studentController.getInputListEntity();
                    }else if(chose_1==2){
                       studentController.printListData();
                    }else if(chose_1==3){
                        break;
                    }
                    boolean checkContinue_1= helper.askYesNo();
                    if(checkContinue_1){
                        break;
                    } else{run=false;}
                    break;
                case 2:
                    int chose_2;
                    do {
                        chose_1 = helper.getInt("Nhập lựa chọn:\n"
                                + "[1] Thêm môn học.\n"
                                + "[2] Xem danh sách môn học.\n"
                                + "[3] Quay lại.\n"
                        );
                        if(chose_1>=1 && chose_1<=3){
                            break;
                        }
                        System.out.println("Bạn phải nhập số nguyên từ 1 đến 3");
                    } while(true);
                    if(chose_1==1){
                        subjectController.getInputListEntity();
                    }else if(chose_1==2){
                        subjectController.printListData();
                    }else if(chose_1==3){
                        break;
                    }
                    boolean checkContinue_2= helper.askYesNo();
                    if(checkContinue_2){
                        break;
                    } else{run=false;}
                break;
                case 3:
                    int chose_3;
                    do {
                        chose_1 = helper.getInt("Nhập lựa chọn:\n"
                                + "[1] Thêm bảng điểm.\n"
                                + "[2] Xem danh sách bảng điểm.\n"
                                + "[3] Quay lại.\n"
                        );
                        if(chose_1>=1 && chose_1<=3){
                            break;
                        }
                        System.out.println("Bạn phải nhập số nguyên từ 1 đến 3");
                    } while(true);
                    if(chose_1==1){
                        transcriptsController.getInputEntity();
                    }else if(chose_1==2){
                        transcriptsController.printListData();
                    }else if(chose_1==3){
                        break;
                    }
                    boolean checkContinue_3= helper.askYesNo();
                    if(checkContinue_3){
                        break;
                    } else{run=false;}
                    break;

                case 4:
                    int chose_4;
                    do {
                        chose_1 = helper.getInt("Nhập lựa chọn:\n"
                                + "[1] Xem danh sách sắp xếp theo tên học sinh.\n"
                                + "[2] Xem danh sách sắp xếp theo tên môn học.\n"
                                + "[3] Quay lại.\n"
                        );
                        if(chose_1>=1 && chose_1<=3){
                            break;
                        }
                        System.out.println("Bạn phải nhập số nguyên từ 1 đến 3");
                    } while(true);
                    if(chose_1==1){
                        transcriptsController.printListDataByStudentName();
                    }else if(chose_1==2){
                        transcriptsController.printListDataBySubjectName();
                    }else if(chose_1==3){
                        break;
                    }
                    boolean checkContinue_4= helper.askYesNo();
                    if(checkContinue_4){
                        break;
                    } else{run=false;}

                    break;
                case 5:
                    transcriptsController.printListStudentGPA();
                    boolean checkContinue_5= helper.askYesNo();
                    if(checkContinue_5){
                        break;
                    } else{run=false;}

                    break;

                case 6:
                    run=false;
                    break;
                default:
                    System.out.println("Bạn phải nhập số nguyên trong khoảng từ 1 đến 5");
            }
        }
        while (run);
        System.out.println("Đã thoát chương trình");
    }
}
