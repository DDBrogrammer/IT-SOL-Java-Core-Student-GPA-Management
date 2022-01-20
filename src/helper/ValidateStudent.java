package helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateStudent {
  /*  private  String NAME_REGEX="^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";*/
    private  String PHONE_NUMBER_REGEX="(84|0[3|5|7|8|9])+([0-9]{8})\\b";
    private Helper helper=new Helper();
    public Boolean validateName( String name){
        if(name.length() == 0){
            System.out.println("Bạn chưa nhập tên học sinh");
            return false;
        }else if(
                name.length()>=100
        )  {
            System.out.println("Tên học sinh quá dài");
            return  false;
        } else if(
                 !helper.checkContainLetterOnly(name)
        ){
            System.out.println("Tên học sinh không phù hợp quy tắc chung");
            return false;
        } else {
            return true;}
    }

   /* public  boolean checkName(String name){
        return ((!name.equals(""))
                && (name != null)
                && (name.matches(NAME_REGEX)));
    }
*/
    public Boolean validatePhone(String phone) {
        Pattern p = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher m = p.matcher(phone);
        boolean b = m.matches();
        if(phone.length() == 0){
            System.out.println("Bạn chưa nhập số điện thoại của học sinh");
            return false;
        }else if(
                phone.length()>11
        )  {
            System.out.println("Số điện thoại quá dài");
            return  false;
        } else if( !b){
            System.out.println("Số điện thoại không hợp lệ");
            return false;}
        else{
            return true;

        }    }

    public Boolean validateAddress( String address){
        if(address.length() == 0){
            System.out.println("Bạn chưa nhập địa chỉ ");
            return false;
        }else if(
                address.length()>=250
        )  {
            System.out.println("Địa chỉ quá dài ");
            return  false;
        } else {
            return true;}
    }

    public Boolean validateCollegeClass(String collegeClass){
        if(collegeClass.length() == 0){
            System.out.println("Bạn chưa nhập địa chỉ ");
            return false;
        }else if(
                collegeClass.length()>=250
        )  {
            System.out.println("Địa chỉ quá dài ");
            return  false;
        } else {
            return true;}
    }


}
