/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortlibrary;

/**
 *
 * @author Diego
 */
public class SortLibrary {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args){
        Integer[] intList  = new Integer[10];
        
        for(int i = 0; i < intList.length; i = i + 1){
            intList[i] = (int)(Math.random()*100);
        }
        
        
        
        for(int i = 0; i < intList.length; i = i + 1){
            System.out.print(intList[i] + " ");
        }System.out.println();
        
        
        SortLibrary.<Integer>quickSort(intList);
        
        for(int i = 0; i < intList.length; i = i + 1){
            System.out.print(intList[i] + " ");
        }System.out.println();
        
    }
    
    public static <E extends Comparable<E>> void quickSort(E[] list){
        quickSort(list, 0, list.length);
    }
    
    public static <E> void quickSort(E[] list, java.util.Comparator<E> comparator){
        quickSort(list, 0, list.length, comparator);
    }
    
    public static <E> void quickSort(E[] list, int lower, int upper, java.util.Comparator<E> comparator){
        
       if(lower >= upper){
           return;
       }
       
       if(upper - lower == 1){
           return;
       }
       
       if(upper - lower == 2){
           if(comparator.compare(list[lower], list[lower + 1]) > 0){
               E temp = list[lower];
               list[lower] = list[lower + 1];
               list[lower + 1] = temp;
           }
           return;
       }
       
       if(upper - lower == 3){
           if(comparator.compare( list[lower], list[lower + 1]) > 0){
               E temp = list[lower];
               list[lower] = list[lower + 1];
               list[lower + 1] = temp;
           }
           
           if(comparator.compare( list[lower + 1], list[lower + 2]) > 0){
               E temp = list[lower + 1];
               list[lower + 1] = list[lower + 2];
               list[lower + 2] = temp;
           }
           
           if(comparator.compare( list[lower], list[lower + 1]) > 0){
               E temp = list[lower];
               list[lower] = list[lower + 1];
               list[lower + 1] = temp;
           }
           
           return;
       }
       
       
       
       int left = lower + 1;
       int right = upper - 1;
       
       while( left < right){
           if( comparator.compare( list[lower], list[left]) > 0){
               left = left + 1;
           }else{if( comparator.compare( list[lower], list[right]) <= 0){
               right = right - 1;
           }else{
               E temp = list[left];
               list[left] = list[right];
               list[right] = temp;
           }
               
           }
       }
       
       //left == right and the set 
       
       if( left - lower == 1){
           if( comparator.compare( list[lower], list[left]) > 0 ){
               E temp = list[lower];
               list[lower] = list[left];
               list[left] = temp;
           }
           quickSort(list, left + 1, upper, comparator);
       }else{
           if(upper - left == 1){
               if(comparator.compare( list[lower], list[left]) <= 0){
                   E temp = list[left - 1];
                   list[left - 1] = list[lower];
                   list[lower] = temp;
                   quickSort(list, lower, left - 1, comparator);
               }else{
                   E temp = list[left];
                   list[left] = list[lower];
                   list[lower] = temp;
                   quickSort(list, lower, left, comparator);
               }
               return;
           }else{
               if(comparator.compare( list[lower], list[left]) <= 0){
                   E temp = list[left - 1];
                   list[left - 1] = list[lower];
                   list[lower] = temp;
                   quickSort(list, lower, left - 1, comparator);
                   quickSort(list, left, upper, comparator);
               }else{
                   E temp = list[left];
                   list[left] = list[lower];
                   list[lower] = temp;
                   quickSort(list, lower, left, comparator);
                   quickSort(list, left + 1, upper, comparator);
               }
           }
       }
       
       
    }
    
    public static <E extends Comparable<E>> void quickSort(E[] list, int lower, int upper){
        
       if(lower >= upper){
           return;
       }
       
       if(upper - lower == 1){
           return;
       }
       
       if(upper - lower == 2){
           if(list[lower].compareTo(list[lower + 1]) > 0){
               E temp = list[lower];
               list[lower] = list[lower + 1];
               list[lower + 1] = temp;
           }
           return;
       }
       
       if(upper - lower == 3){
           if(list[lower].compareTo(list[lower + 1]) > 0){
               E temp = list[lower];
               list[lower] = list[lower + 1];
               list[lower + 1] = temp;
           }
           
           if(list[lower + 1].compareTo(list[lower + 2]) > 0){
               E temp = list[lower + 1];
               list[lower + 1] = list[lower + 2];
               list[lower + 2] = temp;
           }
           
           if(list[lower].compareTo(list[lower + 1]) > 0){
               E temp = list[lower];
               list[lower] = list[lower + 1];
               list[lower + 1] = temp;
           }
           
           return;
       }
       
       int left = lower + 1;
       int right = upper - 1;
       
       while( left < right){
           if( list[lower].compareTo(list[left]) > 0){
               left = left + 1;
           }else{if(list[lower].compareTo(list[right]) <= 0){
               right = right - 1;
           }else{
               E temp = list[left];
               list[left] = list[right];
               list[right] = temp;
           }
               
           }
       }
       
       //left == right and the set 
       
       if( left - lower == 1){
           if( list[lower].compareTo(list[left]) > 0 ){
               E temp = list[lower];
               list[lower] = list[left];
               list[left] = temp;
           }
           quickSort(list, left + 1, upper);
       }else{
           if(upper - left == 1){
               if(list[lower].compareTo(list[left]) <= 0){
                   E temp = list[left - 1];
                   list[left - 1] = list[lower];
                   list[lower] = temp;
                   quickSort(list, lower, left - 1);
               }else{
                   E temp = list[left];
                   list[left] = list[lower];
                   list[lower] = temp;
                   quickSort(list, lower, left);
               }
               return;
           }else{
               if(list[lower].compareTo(list[left]) <= 0){
                   E temp = list[left - 1];
                   list[left - 1] = list[lower];
                   list[lower] = temp;
                   quickSort(list, lower, left - 1);
                   quickSort(list, left, upper);
               }else{
                   E temp = list[left];
                   list[left] = list[lower];
                   list[lower] = temp;
                   quickSort(list, lower, left);
                   quickSort(list, left + 1, upper);
               }
           }
       }
       
       
    }
    
    public static <E extends Comparable<E>> void mergeSort(E[] list){
        
        if(list.length <= 1){
            return;
        }
        
        int length1 = list.length / 2;
        int length2 = list.length - length1;
        E[] list1 = (E[])(new Comparable[length1]);
        E[] list2 = (E[])(new Comparable[length2]);
        
        System.arraycopy(list, 0, list1, 0 , length1);
        System.arraycopy(list, length1, list2, 0, length2);
        
        
        mergeSort(list1);
        mergeSort(list2);
        
        int index1 = 0;
        int index2 = 0;
        int listIndex = 0;
        while(index1 < length1 && index2 <length2){
            if( list1[index1].compareTo( list2[index2]) < 0){
                //list1[index1] < list2[index2]
                list[listIndex] = list1[index1];
                listIndex = listIndex + 1;
                index1 = index1 + 1;
            }else{
                list[listIndex] = list2[index2];
                listIndex = listIndex + 1;
                index2 = index2 + 1;
            }
        }
        
        while(index1 < length1){
            list[listIndex] = list1[index1];
            listIndex = listIndex + 1;
            index1 = index1 + 1;
        }
        
        while(index2 < length2){
            list[listIndex] = list2[index2];
            listIndex = listIndex + 1;
            index2 = index2 + 1;
        }
        
    }
    
    
    public static <E extends Comparable<E>> void mergeSortViaComparator(E[] list){
        SortLibrary.<E>mergeSort(list, new java.util.Comparator<E>(){
            public int compare(E obj1, E obj2){
                return obj1.compareTo(obj2);
            }
        });
    }
    
    public static <E> void mergeSort(E[] list, java.util.Comparator<E> comparator){
        
        if(list.length <= 1){
            return;
        }
        
        int length1 = list.length / 2;
        int length2 = list.length - length1;
        E[] list1 = (E[])(new Object[length1]);
        E[] list2 = (E[])(new Object[length2]);
        
        System.arraycopy(list, 0, list1, 0 , length1);
        System.arraycopy(list, length1, list2, 0, length2);
        
        
        mergeSort(list1, comparator);
        mergeSort(list2, comparator);
        
        int index1 = 0;
        int index2 = 0;
        int listIndex = 0;
        while(index1 < length1 && index2 <length2){
            if( comparator.compare(list1[index1], list2[index2]) < 0){
                //list1[index1] < list2[index2]
                list[listIndex] = list1[index1];
                listIndex = listIndex + 1;
                index1 = index1 + 1;
            }else{
                list[listIndex] = list2[index2];
                listIndex = listIndex + 1;
                index2 = index2 + 1;
            }
        }
        
        while(index1 < length1){
            list[listIndex] = list1[index1];
            listIndex = listIndex + 1;
            index1 = index1 + 1;
        }
        
        while(index2 < length2){
            list[listIndex] = list2[index2];
            listIndex = listIndex + 1;
            index2 = index2 + 1;
        }
        
    }

    
    public static <E> void bubbleSort(E[] list, java.util.Comparator<? super E> comparator){
        boolean needToSort = true;
        
        for(int i = 0; i < list.length && needToSort; i = i + 1){
            needToSort = false;
            for(int j = 0; j < list.length - 1 - i; j = j + 1){
                if(comparator.compare( list[j], list[ j + 1] ) > 0){
                    //list[j] < list[j + 1]
                    //sqap list[j], list[j + 1];
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    needToSort = true;
                }
            }
        }
    }
    
    public static <E extends Comparable<E>> void bubbleSort(E[] list){
        boolean needToSort = true;
        
        for(int i = 0; i < list.length && needToSort; i = i + 1){
            needToSort = false;
            for(int j = 0; j < list.length - 1 - i; j = j + 1){
                if(list[j].compareTo( list[ j + 1] ) > 0){
                    //list[j] < list[j + 1]
                    //sqap list[j], list[j + 1];
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    needToSort = true;
                }
            }
        }
    }
    
}
