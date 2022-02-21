package src.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class bj_8979 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt(); // 국가의 수
        int K = scan.nextInt(); // 등수를 알고 싶은 국가 번호

        int[][] countries = new int[N][3];

        List<Medal> medals = new ArrayList<>();

        for(int i=0; i<N; i++){
            int index=scan.nextInt();
            int g=scan.nextInt();
            int s=scan.nextInt();
            int b=scan.nextInt();

            medals.add(new Medal(index,g,s,b));
        }

        for (Medal medal : medals) {
            System.out.println(medal.toString());
        }

        Collections.sort(medals);

        medals.get(0).setRank(1);

        for (int i = 1; i < medals.size(); i++) {
            Medal prev = medals.get(i - 1);
            Medal present = medals.get(i);

            if (prev.getGold() == present.getGold() && prev.getSilver() == present.getSilver()
                    && prev.getBronze() == present.getBronze()) {
                present.setRank(prev.getRank());
            } else {
                present.setRank(i+1);
            }

            if (medals.get(i).getIndex() == K) {
                System.out.println("rank = " + present.getRank());
                break;
            }

        }
    }

}


class Medal implements Comparable<Medal>{
    int index;
    int gold;
    int silver;
    int bronze;
    int rank;

    public Medal(int index, int gold, int silver, int bronze){
        this.index = index;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    @Override
    public int compareTo(Medal o) {
        if (this.gold == o.gold && this.silver == o.silver) {
            return Integer.compare(o.bronze, this.bronze);
        }

        if (this.gold == o.gold) {
            return Integer.compare(o.silver, this.silver);
        }

        return Integer.compare(o.gold, this.gold);
    }

    @Override
    public String toString() {
        return "Medal{" +
                "index=" + index +
                ", gold=" + gold +
                ", silver=" + silver +
                ", bronze=" + bronze +
                '}';
    }

    public int getIndex() {
        return index;
    }

    public int getGold() {
        return gold;
    }

    public int getSilver() {
        return silver;
    }

    public int getBronze() {
        return bronze;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}