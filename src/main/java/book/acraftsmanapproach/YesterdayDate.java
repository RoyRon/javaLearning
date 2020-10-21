package book.acraftsmanapproach;

import java.util.Scanner;

public class YesterdayDate {

    public static void main(String[] arg) {
        YesterdayDate yesterdayDate = new YesterdayDate();
//       System.out.print(yesterdayDate.isLeapYear(16));
        int year = 0, month = 0, day = 0, yesterYear = 0, yesterMonth = 0, yesterDay = 0;
        do {
            System.out.print("请输入年月日(1812年-2018年之间的年份，分别输入年月日后都要点击回车）：");
            Scanner input = new Scanner(System.in);
            year = input.nextInt();
            month = input.nextInt();
            day = input.nextInt();
        } while ((year < 1812 || year > 2018) || (month < 1 || month > 12) || (day < 1 || day > 31));
        switch (month) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: {
                if (day > 1 && day <= 31) {
                    yesterDay = day - 1;
                    yesterMonth = month;
                    yesterYear = year;
                } else if (day == 1) {
                    if (month == 8) {//一开始漏加了这个判断，导致输入1999-8-1 输出错误结果1999-7-30   写程序真的太容易出bug了，一开始就要考虑到特殊情况
                        yesterDay = 31;
                    } else {
                        yesterDay = 30;
                    }
                    yesterMonth = month - 1;
                    yesterYear = year;
                } else System.out.print(year + "-" + month + "-" + day + "是无效日期");
            }
            break;
            case 4:
            case 6:
            case 9:
            case 11: {
                if (day > 1 && day <= 30) {
                    yesterDay = day - 1;
                    yesterMonth = month;
                    yesterYear = year;
                } else if (day == 1) {
                    yesterDay = 31;
                    yesterMonth = month - 1;
                    yesterYear = year;
                } else System.out.print(year + "-" + month + "-" + day + "是无效日期");
            }
            break;
            case 1: {
                if (day > 1 && day <= 31) {
                    yesterDay = day - 1;
                    yesterMonth = month;
                    yesterYear = year;
                } else if (day == 1) {
                    yesterDay = 31;
                    yesterMonth = 12;
                    yesterYear = year - 1;
                } else System.out.print(year + "-" + month + "-" + day + "是无效日期");
            }
            break;
            case 2: {
                if (day > 1 && day <= 28) {
                    yesterDay = day - 1;
                    yesterMonth = month;
                    yesterYear = year;
                } else if (day == 29) {
                    if (yesterdayDate.isLeapYear(year)) {
                        yesterDay = day - 1;
                        yesterMonth = month;
                        yesterYear = year;
                    } else System.out.print(year + "-" + month + "-" + day + "是无效日期");
                } else if (day == 1) {
                    yesterDay = 31;
                    yesterMonth = 1;
                    yesterYear = year;
                } else System.out.print(year + "-" + month + "-" + day + "是无效日期");
            }
            break;
            case 3: {
                if (day > 1 && day <= 31) {
                    yesterDay = day - 1;
                    yesterMonth = month;
                    yesterYear = year;
                } else if (day == 1) {
                    yesterMonth = month - 1;
                    yesterYear = year;
                    if (yesterdayDate.isLeapYear(year)) {
                        yesterDay = 29;
                    } else yesterDay = 28;
                } else System.out.print(year + "-" + month + "-" + day + "是无效日期");

            }
            break;
            default:
                System.out.print(year + "-" + month + "-" + day + "是无效日期");
                break;
        }
        if (yesterYear == 0 || yesterMonth == 0 || yesterDay == 0) {
        } else
            System.out.print("输入日期的前一天是：" + yesterYear + "-" + yesterMonth + "-" + yesterDay);
    }

    public boolean isLeapYear(int year) {
        if (year % 100 == 0) {
            if (year % 400 == 0) {
//                System.out.print("闰年");
                return true;
            } else return false;
        } else if (year % 4 == 0) {
//            System.out.print("闰年");
            return true;
        } else return false;
    }
}
