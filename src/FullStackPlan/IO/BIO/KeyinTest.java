package FullStackPlan.IO.BIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyinTest {
    public static void main(String[] args) {
        try (InputStreamReader reader = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(reader)
        ) {
            String buffer = null;
            while ((buffer = br.readLine()) != null) {
                if (buffer.equals("exit")) {
                    System.exit(1);
                }
                System.out.println(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
