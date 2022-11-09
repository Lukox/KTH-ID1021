package queues;

import java.util.Arrays;

public class QueueArray {
	static int i;
	static int k;
	static int arraySize;
    static private Integer[] queue;
	
	QueueArray(int size){
		k = 0;
		i = 0;
        arraySize = size;
        queue = new Integer[arraySize];
    }
	
	public void add(Integer value) {
		queue[k] = value;
		k++;
        if (k == arraySize) {
            k = 0;
        }
        if(k == i) {
        	Integer[] newQueue = new Integer[arraySize*2];
        	int counter = 0;
        	for(int j = i; j < arraySize; j++) {
        		newQueue[counter] = queue[j];
        		counter++;
        	}
        	i=0;
        	for(int j = 0; j < k; j++) {
        		newQueue[counter] = queue[j];
        		counter++;
        	}
        	k=arraySize;
        	arraySize=arraySize*2;
        	queue = newQueue;
        }
	}
	
	public Integer remove() {
		Integer value = queue[i];
		if (k == i) {
			return null;
		}else {
			i++;
			if(i == arraySize) {
				i = 0;
				queue[arraySize-1] = (Integer) null;
				return value;
			}else {
				queue[i-1] = null;
				return value;
			}
		}
	}

	public static void main(String[] args) {
		   QueueArray q = new QueueArray(4);
		   q.add(1);
		   q.add(2);
		   q.add(3);
		   System.out.println(q.remove());
		   System.out.println(q.remove());
		   q.add(9);
		   q.add(4);
		   System.out.println(q.remove());
		   System.out.println(q.remove());
		   System.out.println(q.remove());



		   //queueDisplay();
	}

}
