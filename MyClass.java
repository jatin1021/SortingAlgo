import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
public class MyClass {
public static void main(String args[]) {
int[] val = new int[10];
for (int i = 0; i < val.length; i++) {
val[i] = new Random().nextInt(100);
}
System.out.println("Choose from the following algorithm");
System.out.println("1.Selection Sort");
System.out.println("2.Insertion Sort");
System.out.println("3.Merge Sort");
System.out.println("4.Quick Sort");
  
Scanner sc = new Scanner(System.in);
int num = sc.nextInt();
  
switch (num) {
case 1:
selectionSort(val);
break;
case 2:
insertionSort(val);
break;
case 3:
finalMergeSort(val,0,9);
break;
case 4:
finalQuickSort(val,0,9);
break;
default:
System.out.println("Please Choose Number between 1 to 4");
}
}
  
public static void selectionSort(int[] array) {
for (int i = 0; i < array.length; i++) {
int min = array[i];
int minId = i;
for (int j = i+1; j < array.length; j++) {
if (array[j] < min) {
min = array[j];
minId = j;
}
}
// swapping
int temp = array[i];
array[i] = min;
array[minId] = temp;
}
System.out.println(Arrays.toString(array));
}
public static void insertionSort(int[] array) {
for (int i = 1; i < array.length; i++) {
int current = array[i];
int j = i - 1;
while(j >= 0 && current < array[j]) {
array[j+1] = array[j];
j--;
}
// at this point we've exited, so j is either -1
// or it's at the first element where current >= a[j]
array[j+1] = current;
}
System.out.println(Arrays.toString(array));
}
public static void finalMergeSort(int[] array, int left, int right){
mergeSort(array,left,right);
System.out.println(Arrays.toString(array));
}
public static void mergeSort(int[] array, int left, int right) {
if (right <= left) return;
int mid = (left+right)/2;
mergeSort(array, left, mid);
mergeSort(array, mid+1, right);
merge(array, left, mid, right);
}
static void merge(int[] array, int left, int mid, int right) {
// calculating lengths
int lengthLeft = mid - left + 1;
int lengthRight = right - mid;
// creating temporary subarrays
int leftArray[] = new int [lengthLeft];
int rightArray[] = new int [lengthRight];
// copying our sorted subarrays into temporaries
for (int i = 0; i < lengthLeft; i++)
leftArray[i] = array[left+i];
for (int i = 0; i < lengthRight; i++)
rightArray[i] = array[mid+i+1];
// iterators containing current index of temp subarrays
int leftIndex = 0;
int rightIndex = 0;
// copying from leftArray and rightArray back into array
for (int i = left; i < right + 1; i++) {
// if there are still uncopied elements in R and L, copy minimum of the two
if (leftIndex < lengthLeft && rightIndex < lengthRight) {
if (leftArray[leftIndex] < rightArray[rightIndex]) {
array[i] = leftArray[leftIndex];
leftIndex++;
}
else {
array[i] = rightArray[rightIndex];
rightIndex++;
}
}
// if all the elements have been copied from rightArray, copy the rest of leftArray
else if (leftIndex < lengthLeft) {
array[i] = leftArray[leftIndex];
leftIndex++;
}
// if all the elements have been copied from leftArray, copy the rest of rightArray
else if (rightIndex < lengthRight) {
array[i] = rightArray[rightIndex];
rightIndex++;
}
}
}
static int partition(int[] array, int begin, int end) {
int pivot = end;
int counter = begin;
for (int i = begin; i < end; i++) {
if (array[i] < array[pivot]) {
int temp = array[counter];
array[counter] = array[i];
array[i] = temp;
counter++;
}
}
int temp = array[pivot];
array[pivot] = array[counter];
array[counter] = temp;
return counter;
}
public static void finalQuickSort(int[] array, int left, int right){
quickSort(array,left,right);
System.out.println(Arrays.toString(array));
}
public static void quickSort(int[] array, int begin, int end) {
if (end <= begin) return;
int pivot = partition(array, begin, end);
quickSort(array, begin, pivot-1);
quickSort(array, pivot+1, end);
}
}

