public class InstanceMethodExamples {

    public static void main(String[] args) {
        
        InstanceMethodExamples obj = new InstanceMethodExamples();
        System.out.println("Hasil Perhitungan: " + obj.add(15, 20));
    }

    public int add(int a, int b) {

        int s;
        s = a + b;
        return s;
    }
}