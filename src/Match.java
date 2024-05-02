public class Match {
    Fighter f1;
    Fighter f2;

    int minWeight;
    int maxWeight;

    Match (Fighter f1, Fighter f2, int minWeight,int maxWeight) {
         this.f1 = f1;
         this.f2 = f2;
         this.maxWeight = maxWeight;
         this.minWeight = minWeight;
    }


    void run() {
        if(isCheck()){

            Fighter firstFighter = (Math.random() < 0.5) ? f1 : f2;
            Fighter secondFighter = (firstFighter == f1) ? f2 : f1;

            System.out.println("Dövüş başlıyor! İlk hamleyi " + firstFighter.name + " yapıyor.");

            while (this.f1.health > 0 && this.f2.health > 0) {
                System.out.println("======YENİ ROUND=====");
                secondFighter.health -= firstFighter.hit(secondFighter);
                this.f2.health= this.f1.hit(this.f2);
                if(isWin()) {
                    break;
                }
                this.f1.health= this.f2.hit(this.f1);
                if(isWin()) {
                    break;
                }


                if (secondFighter.health <= 0) {
                    System.out.println(secondFighter.name + " yenildi! " + firstFighter.name + " kazandı!");
                }


                Fighter temp = firstFighter;
                firstFighter = secondFighter;
                secondFighter = temp;


                break;



            }

        } else {
            System.out.println("Sporcuların sikletleri uymuyor.");
        }
    }

    boolean isCheck(){
        return (this.f1.weight>= minWeight && this.f1.weight <= maxWeight ) && ( this.f2.weight>= minWeight && this.f2.weight <= maxWeight );
    }

    boolean isWin () {
        if (this.f1.health == 0) {
            System.out.println(f2.name + " kazandı!");
            return true;
        }

        if (this.f2.health ==0){
            System.out.println(this.f1.name + " Kazandı!");
            return true;
        }

        return false;
    }
}
