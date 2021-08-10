package ec.com.jdc.picoyplaca;

import java.time.LocalDate;

public class App {
	public static void main(String[] args) {
        System.out.println(getLocalCurrentDate());
    }

    private static String getLocalCurrentDate() {

        

        LocalDate date = LocalDate.now();
        return date.toString();

    }
}
