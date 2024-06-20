public class Students {

    private int roll;
    private String name;
    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {

        this.roll = roll;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void display() {


        System.out.println("Students Name: " + name);
        System.out.println("Roll No. " + roll);
    }

    public static void main(String[] args) {
        
        Students Mahasiswa = new Students();
        Mahasiswa.setName("Kiryu");
        Mahasiswa.setRoll(2022);
        Mahasiswa.display();
    }
}