package repository;

import entity.Student;

import java.io.*;


public class StudentDAO implements DataAccessible<Student,Integer> {
  private final File STUDENT_DATA_FILE= new File("StudentData.txt");
  public boolean save(Student student) {
        boolean checkSave = false;
        Student [] tempStudentList=new Student[1];
        tempStudentList[0]= new Student(student.getName(),student.getAddress(),student.getPhone(),10000,student.getCollegeClass());
        if(STUDENT_DATA_FILE.length()==0){
            try {
                FileOutputStream f = new FileOutputStream(STUDENT_DATA_FILE);
                ObjectOutputStream o = new ObjectOutputStream(f);
                o.writeObject(tempStudentList);
                o.flush();
                o.close();
                checkSave = true;
            } catch (EOFException eof) {
                // end of file reached, do nothing
            } catch (FileNotFoundException e) {
                checkSave = false;
                System.out.println("File not found");
            } catch (IOException e) {
                checkSave = false;
                System.out.println(e);
                System.out.println("Error initializing stream");
            } finally {
                return checkSave;
            }
        }else{
            try {
                FileInputStream fi = new FileInputStream(STUDENT_DATA_FILE);
                ObjectInputStream oi = new ObjectInputStream(fi);
                // Read objects
                Student[] fileStudentListData = (Student[]) oi.readObject();
                Student[] newInputStudentListData=new Student[fileStudentListData.length+1];
                for (int i=0;i<newInputStudentListData.length-1;i++){
                    newInputStudentListData[i]=new Student(
                            fileStudentListData[i].getName(),
                            fileStudentListData[i].getAddress(),
                            fileStudentListData[i].getPhone(),
                            10000+i,fileStudentListData[i].getCollegeClass());
                }
                newInputStudentListData[newInputStudentListData.length-1]=new Student(student.getName(),
                        student.getAddress(),
                        student.getPhone(),
                        newInputStudentListData.length+10000,
                        student.getCollegeClass());
                oi.close();
                fi.close();
                deleteAll();
                FileOutputStream f = new FileOutputStream(STUDENT_DATA_FILE);
                ObjectOutputStream o = new ObjectOutputStream(f);
                o.writeObject(newInputStudentListData);
                o.flush();
                o.close();
                checkSave = true;
            } catch (EOFException eof) {
                // end of file reached, do nothing
            } catch (FileNotFoundException e) {
                checkSave = false;
                System.out.println("File not found");
            } catch (IOException e) {
                checkSave = false;
                System.out.println(e);
                System.out.println("Error initializing stream");
            } finally {
                return checkSave;
            }
        }
    }
    public boolean deleteAll() {
        boolean ok = false;
        try {
            new FileOutputStream(STUDENT_DATA_FILE).close();
            ok=true;}
        catch (EOFException eof) {
            // end of file reached, do nothing
        } catch (FileNotFoundException e) {
            ok = false;
            System.out.println("File not found");
        } catch (IOException e) {
            ok = false;
            System.out.println(e);
            System.out.println("Error initializing stream");
        } finally {
            return ok;
        }

    }
    public Student[] getAll() {
        Student[] resultStudentList = new Student[1];
        if(STUDENT_DATA_FILE.length()!=0){
            try {
                FileInputStream fi = new FileInputStream(STUDENT_DATA_FILE);
                ObjectInputStream oi = new ObjectInputStream(fi);
                // Read objects
                Student[] fileStudentList = (Student[]) oi.readObject();
                 resultStudentList=new Student[fileStudentList.length];

                for(int i=0;i<resultStudentList.length;i++){
                    resultStudentList[i]=new Student(
                            fileStudentList[i].getName(),
                            fileStudentList[i].getAddress(),
                            fileStudentList[i].getPhone(),
                            fileStudentList[i].getId(),
                            fileStudentList[i].getCollegeClass());
                }
                oi.close();
                fi.close();
            }
            catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (EOFException e) {
            } catch (IOException e) {
                System.out.println("Error initializing stream");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }
        return resultStudentList;
}

   public Student getById(Integer id){
        Student[] students=getAll();
        Student student=new Student("","","",0,"");
        for(int i=0;i<students.length;i++){
            if(students[i].getId()==id){
                student=new Student(students[i].getName(),
                        students[i].getAddress(),
                        students[i].getPhone(),
                        students[i].getId(),
                        students[i].getCollegeClass());
            }
        }
        return student;
   }


}
