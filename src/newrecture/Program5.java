package newrecture;

import com.newlecture.app.console.NoticeConsole;

import java.sql.SQLException;

public class Program5 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException,NullPointerException{
        NoticeConsole console = new NoticeConsole();
       //int page;
       EXIT : while (true) {
            console.printNoticeList();

            int menu = console.inputNoticeMenu();

            switch (menu) {
                case 1:
                    break;
                case 2: //이전
                    //page--;
                    console.movePrevList();
                    break;
                case 3: //다음
                    console.moveNextList();
                    //page++;
                    break;
                case 4:
                    break;
                case 5:
                    console.inputSearchWord();
                    break;


                    case 6:
                    System.out.println("끝");
                    break EXIT;

                default:
                    System.out.println("다시입력하세요");
                    break;
            }
        }
    }
}
