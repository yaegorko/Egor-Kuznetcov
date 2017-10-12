package ru.job4j.mergearrays;

/**
 * Класс слияния 2х отсортированных по возрастанию массивов в один сортированный по возрастанию.
 */
public class MergeSortedArray {
    /**
     * Метод слияния 2х отсортированных по возрастанию массивов в один сортированный по возрастанию.
     * @param sortedOne первый массив.
     * @param sortedTwo второй массив.
     * @return большой массив.
     */
    public int[] merge(int[] sortedOne, int[] sortedTwo) {

        int indexOne = 0;
        int indexTwo = 0;
        int[] sorter = new int[sortedOne.length + sortedTwo.length];

        for (int i = 0; i < sorter.length; i++) {

            sorter[i] = sortedOne[indexOne] <= sortedTwo[indexTwo] ? sortedOne[indexOne++] : sortedTwo[indexTwo++];

            if (indexOne == sortedOne.length) {
               while (indexOne + indexTwo < sorter.length) {
                   sorter[indexOne + indexTwo] = sortedTwo[indexTwo++];
               }
               break;
            }

            if (indexTwo == sortedTwo.length) {
                while (indexTwo + indexOne < sorter.length) {
                    sorter[indexTwo + indexOne] = sortedOne[indexOne++];
                }
                break;
            }
        }
        return sorter;
    }

}
