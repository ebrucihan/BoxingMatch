public class Main {
    public static void main(String[] args) {
        Fighter f1 = new Fighter("Ali Vural", 30,120,100,30 );
        Fighter f2 = new Fighter("Cenk Susmaz", 20,85,85,40);


        Match match = new Match(f1,f2,85,100);
        match.run();




    }
}