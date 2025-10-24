/**
 *  #Leetcode1792 | https://leetcode.com/problems/maximum-average-pass-ratio
 */

public class MaximumAveragePassRatio {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<ClassRecord> pq = new PriorityQueue<>(new Compare());

        for (int[] cl : classes) pq.offer(new ClassRecord(cl));

        while (extraStudents-- > 0) {
            ClassRecord cl = pq.poll();
            cl.AddOneStudent();
            pq.offer(cl);
        }

        double sum = 0;

        while (!pq.isEmpty()) {
            ClassRecord cl = pq.poll();
            sum += (double) cl.pass / cl.total
        }

        return  sum / classes.length;
    }
}

public class ClassRecord {
    int pass;
    int total;
    double inc;

    ClassRecord (int[]arr) {
        this.pass = arr[0];
        this.total = arr[1];
        this.inc = getIncreament();
    }

    public void AddOneStudent() {
        pass++;
        total++;
        inc = getIncreament();
    }

    private double getIncreament () {
        return (pass + 1.0) / (total + 1.0) - (double) pass / total;
    }
}

public class Compare implements Comparator<ClassRecord> {
    public int compare (ClassRecord a, ClassRecord b) {
        return Double.compare(b.inc,a.inc);
    }
}