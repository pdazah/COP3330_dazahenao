public class Encrypter {
    public static String encrypt(String characters) {
        StringBuilder converted = new StringBuilder();

        int[] numbers = replaceNumbers(characters);
        int[] finalArray = swapNumbers(numbers);

        for(int i=0; i<4; i++){
            converted.append(finalArray[i]);
        }
        return converted.toString();
    }

    //Function to add, divide, and replace numbers with remainder of operation
    public static int[] replaceNumbers(String characters) {
        int[] array = new int[4];
        for (int i = 0; i < 4; i++) {
            array[i] = Character.getNumericValue(characters.charAt(i));
            array[i] = (array[i] + 7) % 10;
        }
        return array;
    }

    //Function to rearrange digits in array
    public static int[] swapNumbers(int... array){
        int temp;
        temp = array[0];
        array[0] = array[2];
        array[2] = temp;

        temp = array[1];
        array[1] = array[3];
        array[3] = temp;
        return array;
    }
}
