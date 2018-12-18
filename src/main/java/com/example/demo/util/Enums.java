package com.example.demo.util;

public class Enums {

    public enum  UserStatus{
        Normal("正常",0),Terminate("注销",1),Locked("锁定",2);
        private String name;
        private int index;

        private UserStatus(String name, int index) {
            this.name = name;
            this.index = index;
        }

        public int getIndex() {
            return this.index;
        }

        public String getName() {
            return this.name;
        }
    }
    public enum AccountType{
        Normal("正常人", 1), UnNormal("非正常人", 2);
        private String name;
        private int index;

        private AccountType(String name, int index) {
            this.name = name;
            this.index = index;
        }

        public int getIndex() {
            return this.index;
        }

        public String getName() {
            return this.name;
        }

    }

    public enum State {
        Cancel("处理失败", -1), Wait("等待处理", 0), Complete("已处理", 1),Other("其他",2);
        private String name;
        private int index;

        private State(String name, int index) {
            this.name = name;
            this.index = index;
        }

        public int getIndex() {
            return this.index;
        }

        public String getName() {
            return this.name;
        }
    }
}
