package com.newlecture.app.console;

import com.newlecture.app.entity.Notice;
import com.newlecture.app.service.NoticeService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class NoticeConsole {

    private NoticeService service;
    private int page;
    private String searchWord;
    private String searchField;

    public NoticeConsole() {
        service = new NoticeService();
        page =1;
        searchWord ="";
        searchField="title";
    }
    public void printNoticeList() throws SQLException, ClassNotFoundException ,NullPointerException{
        List<Notice> list = service.getList(page,searchField,searchWord);
        int count= service.getCount();
        int lastpage = count/10;
        lastpage = count%10 == 0 ? lastpage:lastpage+1;
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        System.out.printf("<공지사항> 총 %d 게시글\n", count);
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        for(Notice n : list) {
            System.out.printf("%d. %s / %s /%s\n",
                    n.getId(),
                    n.getTitle(),
                    n.getWriterld(),
                    n.getRegDate());
        }
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        System.out.printf("             %d/%d pages\n",page, lastpage);


    }


    public int inputNoticeMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.printf("1.상세조회/ 2.이전/ 3.다음/ 4.글쓰기/5.검색 6.종료>");
        String menu_ = scan.nextLine();
        int menu = Integer.parseInt(menu_);
        return menu;

    }

    public void movePrevList() {
        if(page == 1) {
           System.out.println("이전페이지 존재 x");
           return;
        }
        page--;
    }

    public void moveNextList() throws SQLException, ClassNotFoundException {
        int count= service.getCount();
        int lastpage = count/10;
        lastpage = count%10 == 0 ? lastpage:lastpage+1;
        if(page == lastpage) {
            System.out.println("다음페이지 존재 x");
            return;
        }
        page++;
    }

    public void inputSearchWord() {
        Scanner scan = new Scanner(System.in);
        System.out.println("검색 범주 입력하시오");
        System.out.println(">");
        searchField = scan.nextLine();
        System.out.println("검색어");
        searchWord= scan.nextLine();

    }
}
