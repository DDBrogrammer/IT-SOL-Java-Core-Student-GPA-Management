package repository;

import entity.Transcripts;
import entity.Transcripts;
import entity.Transcripts;
import entity.Transcripts;

import java.io.*;

public class TranscriptsDAO implements DataAccessible<Transcripts,Integer> {
    private final File TRANSCRIPTS_DATA_FILE= new File("TranscriptData.txt");
    @Override
    public boolean save(Transcripts transcripts) {
        boolean checkSave = false;
        Transcripts[] tempTranscriptList=new Transcripts[1];
        tempTranscriptList[0]= new Transcripts(transcripts.getStudent(),transcripts.getSubjectList(), transcripts.getMarkList());
        if(TRANSCRIPTS_DATA_FILE.length()==0){
            try {
                FileOutputStream f = new FileOutputStream(TRANSCRIPTS_DATA_FILE);
                ObjectOutputStream o = new ObjectOutputStream(f);
                o.writeObject(tempTranscriptList);
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
                FileInputStream fi = new FileInputStream(TRANSCRIPTS_DATA_FILE);
                ObjectInputStream oi = new ObjectInputStream(fi);
                // Read objects
                Transcripts[] fileTranscriptListData = (Transcripts[]) oi.readObject();
                if(getById(transcripts.getStudent().getId()).getStudent().getId()!=transcripts.getStudent().getId()){
                    Transcripts[] newInputStudentListData=new Transcripts[fileTranscriptListData.length+1];
                    for (int i=0;i<newInputStudentListData.length-1;i++){
                        newInputStudentListData[i]=new Transcripts(
                                fileTranscriptListData[i].getStudent(),
                                fileTranscriptListData[i].getSubjectList(),
                                fileTranscriptListData[i].getMarkList()
                        );
                    }
                    newInputStudentListData[newInputStudentListData.length-1]=new Transcripts(transcripts.getStudent(),
                            transcripts.getSubjectList(),
                            transcripts.getMarkList());
                    oi.close();
                    fi.close();
                    deleteAll();
                    FileOutputStream f = new FileOutputStream(TRANSCRIPTS_DATA_FILE);
                    ObjectOutputStream o = new ObjectOutputStream(f);
                    o.writeObject(newInputStudentListData);
                    o.flush();
                    o.close();
                    checkSave = true;
                }else{
                    for (int i=0;i<fileTranscriptListData.length-1;i++){
                        if(fileTranscriptListData[i].getStudent().getId()== transcripts.getStudent().getId()
                        ){
                            fileTranscriptListData[i]=new Transcripts(
                                    transcripts.getStudent(),
                                    transcripts.getSubjectList(),
                                    transcripts.getMarkList());
                        };
                    }
                    oi.close();
                    fi.close();
                    deleteAll();
                    FileOutputStream f = new FileOutputStream(TRANSCRIPTS_DATA_FILE);
                    ObjectOutputStream o = new ObjectOutputStream(f);
                    o.writeObject(fileTranscriptListData);
                    o.flush();
                    o.close();
                    checkSave = true;
                }

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
            new FileOutputStream(TRANSCRIPTS_DATA_FILE).close();
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
    public Transcripts[] getAll() {
        Transcripts[] resultSubjectList = new Transcripts[1];
        if(TRANSCRIPTS_DATA_FILE.length()!=0){
            try {
                FileInputStream fi = new FileInputStream(TRANSCRIPTS_DATA_FILE);
                ObjectInputStream oi = new ObjectInputStream(fi);
                // Read objects
                Transcripts[] fileStudentList = (Transcripts[]) oi.readObject();
                resultSubjectList=new Transcripts[fileStudentList.length];

                for(int i=0;i<resultSubjectList.length;i++){
                    resultSubjectList[i]=new Transcripts(
                            fileStudentList[i].getStudent(),
                            fileStudentList[i].getSubjectList(),
                            fileStudentList[i].getMarkList()
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
    public Transcripts getById(Integer id) {
        Transcripts[] transcripts=getAll();
        Transcripts transcripts1=new Transcripts();
        for(int i=0;i<transcripts.length;i++){
            if(transcripts[i].getStudent().getId()==id){
                transcripts1=new Transcripts(transcripts[i].getStudent(),
                        transcripts[i].getSubjectList(),
                        transcripts[i].getMarkList());
            }
        }
        return transcripts1;
    }
}
