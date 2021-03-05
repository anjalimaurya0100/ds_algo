package array;

import java.util.ArrayList;

public class StockBuySell {
    public static class Result {
        int buy;
        int sell;

        // constructor
        Result() {

        }
    }

    public static void main(String[] args) {
        ArrayList<Result> results = new ArrayList<>();
        int[] array = {98, 178, 250, 300, 40, 540, 30};
        int i = 0;
        while(i< array.length){
            Result result = new Result();
            while(i+1 < array.length && array[i]>array[i+1]) {
                i++;
            }
            if(i== array.length-1){
                System.out.println("abc");
                break;
            }
            result.buy = i;
            i++;
            while(i+1 < array.length && array[i]<array[i+1]){
                i++;
            }
            result.sell = i;
            results.add(result);
            i++;
        }

        for(i = 0; i< results.size(); i++){
            System.out.println(results.get(i).buy + " - " + results.get(i).sell);
        }

//        for (Result result: results) {
//            System.out.println(result.buy + " - " + result.sell);
//        }
    }
}

