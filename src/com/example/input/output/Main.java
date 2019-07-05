package com.example.input.output;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        String filename = "text.txt";

        writeToFile(filename);
        readFromFile(filename);

        System.out.println();
        readFromArray();

        System.out.println();
        writePrimitiveTypes(filename);
        readPrimitiveTypes(filename);

        System.out.println();
        writeWithFileWriter(filename);
        readFromFileReader(filename);

        //serialization of the object
        Person person = new Person("Someone",32);
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
            objectOutputStream.writeObject(person);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void writeWithFileWriter(String filename){

        //second parameter shows if the data should append to the end or should be overwritten
        //we can also use BufferedWriter writer =  BufferedWriter(new FileWriter(filename,false))
        try(FileWriter writer = new FileWriter(filename,false)) {

            String text = "Hello World #3";
            writer.write(text);
            //write by symbols
            writer.append("!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFromFileReader(String filename){

        try(FileReader reader = new FileReader(filename)) {

            int c;
            while ((c = reader.read()) != -1){
                System.out.print((char)c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void readPrimitiveTypes(String filename){

        try(DataInputStream inputStream = new DataInputStream(new FileInputStream(filename))) {

            System.out.println(inputStream.readUTF());
            System.out.println(inputStream.readInt());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void writePrimitiveTypes(String filename){

        try(DataOutputStream out = new DataOutputStream(new FileOutputStream(filename))) {

            out.writeUTF("Person");
            out.writeInt(21);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void readFromArray(){

        String text = "Hello World #2";
        byte[] bytes = text.getBytes();

        ByteArrayInputStream in = new ByteArrayInputStream(bytes);

        try(BufferedInputStream inputStream = new BufferedInputStream(in)) {

            int c;

            while ((c = inputStream.read()) != -1){

                System.out.print((char)c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFromFile(String filename){

        try(FileInputStream inputStream = new FileInputStream(filename)) {

            int i;

            while ((i = inputStream.read()) != -1){
                System.out.print((char)i);
            }

            byte[] array = new byte[inputStream.available()];
            inputStream.read(array,0,inputStream.available());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile(String filename){

        String text = "Hello World";

        try(FileOutputStream outputStream = new FileOutputStream( filename)) {

            //converting string into byte array
            byte [] array = text.getBytes();
            outputStream.write(array);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
