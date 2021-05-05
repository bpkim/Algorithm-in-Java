package com.bp.restart.testdome;

public class UserInput {

    public static class TextInput {
        protected String result = "";
        void add(char c){
            System.out.println("aaaa");
                result+=c;
        }

        String getValue(){
            return result;
        }
    }

    public static class NumericInput extends TextInput{
        @Override
        void add(char c){
            int asccode = (int)c;
            System.out.println("bbbb");
            if(asccode >= 48 && asccode <= 57){
                result+=c;
            }
        }

        String getValue(){
            return result;
        }
    }

    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        input.add('~');
        System.out.println(input.getValue());

        TextInput input2 = new TextInput();
        input2.add('1');
        input2.add('a');
        input2.add('0');
        input2.add('~');
        System.out.println(input2.getValue());


        NumericInput input3 = new NumericInput();
        input3.add('1');
        input3.add('a');
        input3.add('0');
        input3.add('~');
        System.out.println(input3.getValue());

    }
}
