package Fundation.Collection;

import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created：Jeffrey
 * date   ：2021/8/20 8:00
 */
public class TestIterator001 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        ConsumerRecords consumerRecords=new ConsumerRecords(null);
        consumerRecords.iterator();



        Iterator iterator1 = list.iterator();
        while (iterator1.hasNext()){
            iterator1.next();
        }

        Iterator iterator = new Iterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };

    }
}
