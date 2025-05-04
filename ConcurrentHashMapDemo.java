package org.example;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) throws InterruptedException {

        /*
            1. ConcurrentHashMap provides high synchronization without locking entire map
            2. It locks map only for resizing and rehashing
            3. No Locking for read operation
            4. It used Compare and Swap method for write operation -- Fine Grained locking on Write
                        Thread will read the data from map, store it somewhere,
                        then when thread going to update with new value, it will again check form map whether the values get updated or not
                        Case 1. Value got updated on 2nd read -- take updated value and store it , retry after some time
                                Retry till stored value and current value of ele get same
                        Case 2. Value doesn't get updated with new Value on 2nd read , OK then just perform write operation Swap existing value with new Value
            5. No null values allowed
            6. No null key allowed

         */
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();

        concurrentHashMap.put("Software Developer",2025);
        concurrentHashMap.put("Java Developer", 2026);
        concurrentHashMap.put("Sr. Software Engineer", 2025);
        System.out.println(concurrentHashMap);


        //concurrentHashMap.put(null, 4); No null key allowed
       // concurrentHashMap.put("k", null); // No null value allowed

        concurrentHashMap.forEach((x,y)-> System.out.println(x+" : "+ y));
        System.out.println(concurrentHashMap.mappingCount());

        ConcurrentHashMap<String, Integer> concurrentHashMap1 = new ConcurrentHashMap<>();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {

                concurrentHashMap1.put(String.valueOf(i),i);
                System.out.print(concurrentHashMap1.get(String.valueOf(i)) + " ");
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 100; i < 200; i++) {
                concurrentHashMap1.put(String.valueOf(i),i);

                System.out.print(concurrentHashMap1.get(String.valueOf(i)) +" ");
            }
        });

        thread.start(); thread2.start();
        thread2.join();
        thread.join();

        //ConcurrentHashMap provides synchronization hence final map size will be 200 , but the output will be interleaved(random order)
        System.out.println(concurrentHashMap1); // Since threads run concurrently, the output will be interleaved (random order), but the final map size will always be 2000 — proving ConcurrentHashMap's thread safety.

        /*
        {110=110, 111=111, 112=112, 113=113, 114=114, 115=115,
         116=116, 117=117, 118=118, 119=119, 10=10, 11=11, 12=12,
         13=13, 14=14, 15=15, 16=16, 17=17, 18=18, 19=19, 120=120, 0=0,
         121=121, 1=1, 122=122, 2=2, 123=123, 3=3, 124=124, 4=4, 125=125, 5=5,
         126=126, 6=6, 127=127, 7=7, 128=128, 8=8, 129=129, 9=9, 20=20, 21=21
         , 22=22, 23=23, 24=24, 25=25, 26=26, 27=27, 28=28, 29=29, 130=130,
         131=131, 132=132, 133=133, 134=134, 135=135, 136=136, 137=137, 138=138,
          139=139, 30=30, 31=31, 32=32, 33=33, 34=34, 35=35, 36=36, 37=37, 38=38, 39=39,
           140=140, 141=141, 142=142, 143=143, 144=144, 145=145, 146=146, 147=147, 148=148,
            149=149, 40=40, 41=41, 42=42, 43=43, 44=44, 45=45, 46=46, 47=47, 48=48, 49=49,
            150=150, 151=151, 152=152, 153=153, 154=154, 155=155, 156=156, 157=157, 158=158, 159=159,
             50=50, 51=51, 52=52, 53=53, 54=54, 55=55, 56=56, 57=57, 58=58, 59=59, 160=160, 161=161,
             162=162, 163=163, 164=164, 165=165, 166=166, 167=167, 168=168, 169=169, 60=60, 61=61, 62=62,
              63=63, 64=64, 65=65, 66=66, 67=67, 68=68, 69=69, 170=170, 171=171, 172=172, 173=173, 174=174,
              175=175, 176=176, 177=177, 178=178, 179=179, 70=70, 71=71, 72=72, 73=73, 74=74, 75=75, 76=76,
              77=77, 78=78, 79=79, 180=180, 181=181, 182=182, 183=183, 184=184, 185=185, 186=186, 187=187,
              188=188, 189=189, 80=80, 81=81, 82=82, 83=83, 84=84, 85=85, 86=86, 87=87, 88=88, 89=89, 190=190,
              191=191, 192=192, 193=193, 194=194, 195=195, 196=196, 197=197, 198=198, 199=199, 90=90, 91=91, 92=92, 93=93, 94=94, 95=95, 96=96, 97=97, 98=98, 99=99, 100=100, 101=101, 102=102, 103=103, 104=104, 105=105, 106=106, 107=107, 108=108, 109=109}
         */





        System.out.println(concurrentHashMap1.mappingCount());

    }
}
