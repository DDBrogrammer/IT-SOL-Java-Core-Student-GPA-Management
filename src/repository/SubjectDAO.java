package repository;

import entity.Subject;
import entity.Subject;
import entity.Subject;
import entity.Subject;

import java.io.*;

public class SubjectDAO implements DataAccessible<Subject,Integer> {
    private final File SUBJECT_DATA_FILE= new File("SubjectData.txt");
    @Override
    public boolean save(Subject subject) {
        boolean checkSave = false;
        Subject[] tempSubjectList=new Subject[1];
        tempSubjectList[0]= new Subject(10000,subject.getName(),subject.getType(),subject.getTotalUnit());
        if(SUBJECT_DATA_FILE.length()==0){
            try {
                FileOutputStream f = new FileOutputStream(SUBJECT_DATA_FILE);
                ObjectOutputStream o = new ObjectOutputStream(f);
                o.writeObject(tempSubjectList);
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
                FileInputStream fi = new FileInputStream(SUBJECT_DATA_FILE);
                ObjectInputStream oi = new ObjectInputStream(fi);
                // Read objects
                Subject[] fileStudentListData = (Subject[]) oi.readObject();
                Subject[] newInputStudentListData=new Subject[fileStudentListData.length+1];
                for (int i=0;i<newInputStudentListData.length-1;i++){
                    newInputStudentListData[i]=new Subject(
                            i+10000,
                           fileStudentListData[i].getName(),
                            fileStudentListData[i].getType(),fileStudentListData[i].getTotalUnit()
                            );
                }
                newInputStudentListData[newInputStudentListData.length-1]=new Subject(newInputStudentListData.length-1+10000,
                        subject.getName(),
                        subject.getType(),
                        subject.getTotalUnit());
                oi.close();
                fi.close();
                deleteAll();
                FileOutputStream f = new FileOutputStream(SUBJECT_DATA_FILE);
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

    @Override
    public boolean deleteAll() {
        boolean checkDelete = false;
        try {
            new FileOutputStream(SUBJECT_DATA_FILE).close();
            checkDelete=true;}
        catch (EOFException eof) {
            // end of file reached, do nothing
        } catch (FileNotFoundException e) {
            checkDelete = false;
            System.out.println("File not found");
        } catch (IOException e) {
            checkDelete = false;
            System.out.println(e);
            System.out.println("Error initializing stream");
        } finally {
            return checkDelete;
        }
    }

    @Override
    public Subject[] getAll() {
        Subject[] resultSubjectList = new Subject[1];
        if(SUBJECT_DATA_FILE.length()!=0){
            try {
                FileInputStream fi = new FileInputStream(SUBJECT_DATA_FILE);
                ObjectInputStream oi = new ObjectInputStream(fi);
                // Read objects
                Subject[] fileStudentList = (Subject[]) oi.readObject();
                resultSubjectList=new Subject[fileStudentList.length];

                for(int i=0;i<resultSubjectList.length;i++){
                    resultSubjectList[i]=new Subject(
                            fileStudentList[i].getId(),
                            fileStudentList[i].getName(),
                            fileStudentList[i].getType(),
                            fileStudentList[i].getTotalUnit()
                            );
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
        return resultSubjectList;
    }

    @Override
    public Subject getById(Integer id) {
        Subject[] subjects=getAll();
        Subject student=new Subject(0,"","",0);
        for(int i=0;i<subjects.length;i++){
            if(subjects[i].getId()==id){
                student=new Subject(subjects[i].getId(),subjects[i].getName(),subjects[i].getType(),subjects[i].getTotalUnit());
            }
        }
        return student;
    }
}
