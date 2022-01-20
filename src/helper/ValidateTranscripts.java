package helper;

import entity.Subject;

public class ValidateTranscripts {
    public boolean validateChosenSubject(Subject[] subjects,int id){
        boolean checkChosenSubject=false;
        for(int i = 0;i<subjects.length;i++){
            if(id==subjects[i].getId()){
                 checkChosenSubject= true;
            }
        }
        return checkChosenSubject;
    }
}
