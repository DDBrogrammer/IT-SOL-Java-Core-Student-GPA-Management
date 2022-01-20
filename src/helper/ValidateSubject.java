package helper;

public class ValidateSubject {
   private Helper helper = new Helper();
    public Boolean validateTotalUnit( int totalUnit){
        if(totalUnit == 0){
            System.out.println("Bạn chưa nhập số đơn vị học trình");
            return false;
        }else if(
                totalUnit < 0
        )  {
            System.out.println("Số đơn vị học trình không được âm");
            return  false;
        } else {
            return true;}
    }

    public Boolean validateType( String type){
        if(type.toUpperCase().equals("DC") ||
                type.toUpperCase().equals("CSN")||
                type.toUpperCase().equals("CN")
        ){
            return true;
        }   else {
            System.out.println("Chỉ được nhập các mã [DC] Đại cương,[CSN] Cơ sở ngành ,[CN] Chuyên ngành");
            return false;}
    }
    public Boolean validateName( String name){
        if(name.length() == 0){
            System.out.println("Bạn chưa nhập tên môn học");
            return false;
        }else if(
                name.length()>=100
        )  {
            System.out.println("Tên môn học quá dài");
            return  false;
        } else if(
                !helper.checkContainLetterAndNumberOnly(name)
        ){
            System.out.println("Tên môn học không phù hợp quy tắc chung");
            return false;
        } else {
            return true;}
    }
}
