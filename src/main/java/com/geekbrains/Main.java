package com.geekbrains;

public class Main {
    public static void main(String[] args)  throws  MyArrayDataException, MyArraySizeException{
        try{
            String[][] normalArray = {{"1", "1", "1", "1"}, {"1", "1", "1", "1" }, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};
            System.out.println("1. Суммируем двумерный массив из 16 единиц.");
            toIntAndSum(normalArray);
        } catch (MyArraySizeException e){
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e){
            System.out.println(e.getMessage());
        }
        try {
            String[][] wrongSizeArray = {{"1", "1", "1"}, {"1", "1", "1", "1" }, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};
            System.out.println("2. Суммируем массив из 15 единиц.");
            toIntAndSum(wrongSizeArray);
        } catch (MyArraySizeException e){
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e){
            System.out.println(e.getMessage());
        }
        try {
            String[][] wrongDataArray = {{"1", "1", "1", "1"}, {"1", "c", "1", "1" }, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};
            System.out.println("3. Суммируем массив, в котором есть буква.");
            toIntAndSum(wrongDataArray);
        }
        catch (MyArrayDataException e){
            System.out.println(e.getMessage());
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void toIntAndSum(String[][] arr) throws  MyArraySizeException, MyArrayDataException{
        int sum = 0;
        if (arr.length != 4 || arr[0].length != 4 || arr[1].length != 4 || arr[2].length != 4 || arr[3].length != 4) {
            throw new MyArraySizeException("Размер массива отличается от заданного 4 на 4!");
        } else {
            for(int i = 0; i <4; i++){
                for(int j = 0; j < 4; j++){
                    try{
                        int num = Integer.parseInt(String.valueOf(arr[i][j]));
                        sum = sum + num;
                    } catch (Exception ex) {
                        throw new MyArrayDataException("Невозможно преобразовать в число символ \"" + arr[i][j] + "\" в строке "+( i +1)+ ", ряд " + (j+1));
                    }
                }
            }
        }
        System.out.println("Сумма чисел в массиве = " + sum);
    }
}