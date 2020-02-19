package com.demo.project62.facade;

//makes the subsystem easier to use
enum DbType {
    ORACLE, MYSQL;
}

public class Main {
    public static void main(String[] args) {
        HelperFacade.generateReport(DbType.ORACLE);
        HelperFacade.generateReport(DbType.MYSQL);
    }
}

class MysqlHelper {

    public void mysqlReport() {
        System.out.println("Generating report in mysql");
    }
}

class OracleHelper {

    public void oracleReport() {
        System.out.println("Generating report in oracle");
    }

}

class HelperFacade {

    public static void generateReport(DbType db) {

        switch (db) {
            case ORACLE:
                OracleHelper ohelper = new OracleHelper();
                ohelper.oracleReport();
                break;
            case MYSQL:
                MysqlHelper mhelper = new MysqlHelper();
                mhelper.mysqlReport();
                break;
        }

    }
}
